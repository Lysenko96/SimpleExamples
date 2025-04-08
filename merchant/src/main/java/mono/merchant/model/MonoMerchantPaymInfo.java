package mono.merchant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonoMerchantPaymInfo {

    private String reference;
    @Builder.Default
    private List<MonoDiscount> discounts = new ArrayList<>();
    @Builder.Default
    private List<MonoBasketItem> basketOrder = new ArrayList<>();
}
