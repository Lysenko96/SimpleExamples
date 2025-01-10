package com.planetakinoauth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.planetakinoauth.model.ProductLineItemType.PRODUCT;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductLineItemInputDto {

    @Builder.Default
    private String type = PRODUCT.name();
    private Boolean hasAccruedBonuses;
    @Builder.Default
    private List<OrderLineItemDiscountAllocationInputDto> discountAllocations = new ArrayList<>();
    @NonNull
    private TotalRefunded totalRefunded;
    private Boolean payWithBonuses;
    @NonNull
    private Boolean canPayWithBonuses;
    private Boolean appliedManualDiscount;
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
    private String serviceFreeTaxType;
    @NonNull
    private BigDecimal serviceFeeTaxRate;
    @NonNull
    private LineItemUnitPrice lineItemUnitPrice;
    @NonNull
    private LineItemSubtotalPrice lineItemSubtotalPrice;
    @NonNull
    private LineItemsTotalPrice lineItemTotalPrice;
    @NonNull
    private LineItemsTotalTax lineItemTotalTax;
    @NonNull
    private LineItemsDiscounted lineItemDiscounted;
    @NonNull
    private String lineItemTaxType;
    @NonNull
    private BigDecimal lineItemTaxRate;
    @NonNull
    private OrderImportDataInputDto importData;
    @NonNull
    private Long cinemaHallId;
    @NonNull
    private Long cinemaId;
    @NonNull
    private Long movieId;
    @NonNull
    private BigDecimal quantity;
    @NonNull
    private Long sessionId;
    @NonNull
    private String productSku;
}
