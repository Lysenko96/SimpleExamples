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
public class OrderDiscountApplicationInputDto {

    @NonNull
    private Boolean used;
    private Boolean appliedManualDiscount;
    @NonNull
    private Long discountId;
    @NonNull
    private String allocationMethod;
    @NonNull
    private String discountMethod;
    @NonNull
    private Value value;
    @NonNull
    private String tmpId;
}
