package com.planetakinoauth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemDiscountAllocationInputDto {

    @NonNull
    private Long discountId;
    private String redeemCode;
    @NonNull
    private Boolean used;
    private Boolean appliedManualDiscount;
    @NonNull
    private AllocatedAmount allocatedAmount;
    @NonNull
    private String tmpDiscountApplicationId;
}
