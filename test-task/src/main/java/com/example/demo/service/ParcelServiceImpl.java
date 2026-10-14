package com.example.demo.service;

import com.example.demo.dto.CreateParcelRequest;
import com.example.demo.dto.ParcelSearchParams;
import com.example.demo.dto.ParcelStatistic;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.DeliveryType;
import com.example.demo.model.Parcel;
import com.example.demo.model.ParcelStatus;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.parcel.price.DefaultDeliveryPriceCalculator;
import com.example.demo.service.parcel.price.EconomDeliveryPriceCalculator;
import com.example.demo.service.parcel.price.ExpressDeliveryPriceCalculator;
import com.example.demo.util.CommonGenerator;
import com.example.demo.util.SpecificationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;
    private final CommonGenerator generator;
    private final DefaultDeliveryPriceCalculator defaultDeliveryPriceCalculator;
    private final ExpressDeliveryPriceCalculator expressDeliveryPriceCalculator;
    private final EconomDeliveryPriceCalculator economDeliveryPriceCalculator;

    @Override
    @Transactional(readOnly = true)
    public Parcel getByTrackingNumber(String trackingNumber) {
        return getParcelByTrackingNumber(trackingNumber);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Parcel> findAll(ParcelSearchParams params, Pageable pageable) {
        Specification<Parcel> spec = getParcelSpecification(params);
        return parcelRepository.findAll(spec, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public ParcelStatistic buildStatistic(ParcelSearchParams params) {
        Specification<Parcel> spec = getParcelSpecification(params);
        List<Parcel> parcels = parcelRepository.findAll(spec);
        if (parcels.isEmpty()) {
            return new ParcelStatistic(
                    0L, 0.0, 0.0,
                    Map.of(ParcelStatus.IN_TRANSIT, 0L, ParcelStatus.DELIVERED, 0L, ParcelStatus.CREATED, 0L),
                    Map.of(DeliveryType.ECONOM, 0L, DeliveryType.DEFAULT, 0L, DeliveryType.EXPRESS, 0L),
                    null, null, null, null
            );
        }
        Map<ParcelStatus, Long> parcelsCountByStatus = Arrays.stream(ParcelStatus.values()).collect(Collectors.toMap(
                Function.identity(),
                status -> parcels.stream().filter(p -> p.getStatus() == status).count()
        ));
        if (parcelsCountByStatus.isEmpty()) {
            parcelsCountByStatus = Map.of(ParcelStatus.IN_TRANSIT, 0L, ParcelStatus.DELIVERED, 0L, ParcelStatus.CREATED, 0L);
        }
        Map<DeliveryType, Long> parcelsCountByDeliveryType = Arrays.stream(DeliveryType.values()).collect(Collectors.toMap(
                Function.identity(),
                type -> parcels.stream().filter(p -> p.getDeliveryType() == type).count()
        ));
        if (parcelsCountByDeliveryType.isEmpty()) {
            parcelsCountByDeliveryType = Map.of(DeliveryType.ECONOM, 0L, DeliveryType.DEFAULT, 0L, DeliveryType.EXPRESS, 0L);
        }
        return new ParcelStatistic(
                parcels.size(),
                parcels.stream().mapToDouble(Parcel::getWeight).average().orElse(0.0),
                parcels.stream().mapToDouble(Parcel::getPrice).average().orElse(0.0),
                parcelsCountByStatus,
                parcelsCountByDeliveryType,
                parcels.stream().max(Comparator.comparing(Parcel::getPrice)).orElse(null),
                parcels.stream().min(Comparator.comparing(Parcel::getPrice)).orElse(null),
                parcels.stream().max(Comparator.comparing(Parcel::getWeight)).orElse(null),
                parcels.stream().min(Comparator.comparing(Parcel::getWeight)).orElse(null)
        );
    }

    private static Specification<Parcel> getParcelSpecification(ParcelSearchParams params) {
        return Specification.allOf(
                SpecificationUtils.iLike(Parcel.Fields.sender, params.getSender()),
                SpecificationUtils.iLike(Parcel.Fields.trackingNumber, params.getTrackingNumber()),
                SpecificationUtils.iLike(Parcel.Fields.recipient, params.getRecipient()),
                SpecificationUtils.gte(Parcel.Fields.weight, params.getFromWeight()),
                SpecificationUtils.lte(Parcel.Fields.weight, params.getToWeight()),
                SpecificationUtils.gte(Parcel.Fields.price, params.getFromPrice()),
                SpecificationUtils.lte(Parcel.Fields.price, params.getToPrice()),
                SpecificationUtils.in(Parcel.Fields.status, params.getStatuses()),
                SpecificationUtils.in(Parcel.Fields.deliveryType, params.getDeliveryTypes())
        );
    }

    @Override
    public Parcel create(CreateParcelRequest request) {
        Parcel parcel = new Parcel();
        parcel.setTrackingNumber(generator.uuid());
        parcel.setSender(request.getSender());
        parcel.setRecipient(request.getRecipient());
        parcel.setWeight(request.getWeight());
        parcel.setStatus(ParcelStatus.CREATED);
        parcel.setDeliveryType(request.getDeliveryType());

        if (request.getDeliveryType() == DeliveryType.ECONOM) {
            parcel.setPrice(economDeliveryPriceCalculator.calculatePrice(request));
        } else if (request.getDeliveryType() == DeliveryType.EXPRESS) {
            parcel.setPrice(expressDeliveryPriceCalculator.calculatePrice(request));
        } else if (request.getDeliveryType() == DeliveryType.DEFAULT) {
            parcel.setPrice(defaultDeliveryPriceCalculator.calculatePrice(request));
        } else {
            throw new NotFoundException();
        }
        return parcelRepository.save(parcel);
    }

    @Override
    public Parcel updateStatus(String trackingNumber, ParcelStatus status) {
        Parcel parcel = getParcelByTrackingNumber(trackingNumber);
        parcel.setStatus(status);
        return parcelRepository.save(parcel);
    }

    private Parcel getParcelByTrackingNumber(String trackingNumber) {
        return parcelRepository.findByTrackingNumber(trackingNumber).orElseThrow(
                () -> new NotFoundException("Parcel with tracking number " + trackingNumber + " not found"));
    }

}
