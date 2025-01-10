package com.planetakinoauth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
@NoArgsConstructor
public class OrderImportInputDto {

    public OrderImportInputDto(List<OrderProductLineItemInputDto> lineItems, String liqpayOrderId, String pkOrderId, Long customerId, Long cinemaId, @NonNull String appType, List<String> typeOfPayments, Long merchantId, Long pointOfSaleId, List<OrderDiscountApplicationInputDto> discountApplications, @NonNull SubtotalPrice subtotalPrice, @NonNull TotalPrice totalPrice, @NonNull TotalDiscounted totalDiscounted, @NonNull BonusesPrice bonusesPrice, @NonNull ServiceFee serviceFee, @NonNull ServiceFeeDiscounted serviceFeeDiscounted, @NonNull ServiceFeeTotalPrice serviceFeeTotalPrice, @NonNull ServiceFeeTotalTax serviceFeeTotalTax, @NonNull LineItemsTotalPrice lineItemsTotalPrice, @NonNull LineItemsTotalTax lineItemsTotalTax, @NonNull LineItemsDiscounted lineItemsDiscounted, @NonNull TotalRefunded totalRefunded, @NonNull String fiscalReceiptId, String fiscalizationError, Date fiscalizationErrorAt, @NonNull Date fiscalizedAt, Long cardId, Long staffId, @NonNull OrderImportDataInputDto importData) {
        this.lineItems = lineItems;
        this.liqpayOrderId = liqpayOrderId;
        this.pkOrderId = pkOrderId;
        this.customerId = customerId;
        this.cinemaId = cinemaId;
        this.appType = appType;
        this.typeOfPayments = typeOfPayments;
        this.merchantId = merchantId;
        this.pointOfSaleId = pointOfSaleId;
        this.discountApplications = discountApplications;
        this.subtotalPrice = subtotalPrice;
        this.totalPrice = totalPrice;
        this.totalDiscounted = totalDiscounted;
        this.bonusesPrice = bonusesPrice;
        this.serviceFee = serviceFee;
        this.serviceFeeDiscounted = serviceFeeDiscounted;
        this.serviceFeeTotalPrice = serviceFeeTotalPrice;
        this.serviceFeeTotalTax = serviceFeeTotalTax;
        this.lineItemsTotalPrice = lineItemsTotalPrice;
        this.lineItemsTotalTax = lineItemsTotalTax;
        this.lineItemsDiscounted = lineItemsDiscounted;
        this.totalRefunded = totalRefunded;
        this.fiscalReceiptId = fiscalReceiptId;
        this.fiscalizationError = fiscalizationError;
        this.fiscalizationErrorAt = fiscalizationErrorAt;
        this.fiscalizedAt = fiscalizedAt;
        this.cardId = cardId;
        this.staffId = staffId;
        this.importData = importData;
    }

    @Builder.Default
    private List<OrderProductLineItemInputDto> lineItems = new ArrayList<>();
    private String liqpayOrderId;
    private String pkOrderId;
    private Long customerId;
    private Long cinemaId;
    @NonNull
    private String appType;
    private List<String> typeOfPayments;
    private Long merchantId;
    private Long pointOfSaleId;
    @Builder.Default
    private List<OrderDiscountApplicationInputDto> discountApplications = new ArrayList<>();
    @NonNull
    private SubtotalPrice subtotalPrice;
    @NonNull
    private TotalPrice totalPrice;
    @NonNull
    private TotalDiscounted totalDiscounted;
    @NonNull
    private BonusesPrice bonusesPrice;
    @NonNull
    private ServiceFee serviceFee;
    @NonNull
    private ServiceFeeDiscounted serviceFeeDiscounted;
    @NonNull
    private ServiceFeeTotalPrice serviceFeeTotalPrice;
    @NonNull
    private ServiceFeeTotalTax serviceFeeTotalTax;
    @NonNull
    private LineItemsTotalPrice lineItemsTotalPrice;
    @NonNull
    private LineItemsTotalTax lineItemsTotalTax;
    @NonNull
    private LineItemsDiscounted lineItemsDiscounted;
    @NonNull
    private TotalRefunded totalRefunded;
    @NonNull
    private String fiscalReceiptId;
    private String fiscalizationError;
    private Date fiscalizationErrorAt;
    @NonNull
    private Date fiscalizedAt;
    private Long cardId;
    private Long staffId;
    @NonNull
    private OrderImportDataInputDto importData;
}

