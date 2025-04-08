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
public class MonoBasketItem {

    private String name;
    private int qty;
    private int sum;
    private int total;
    private String splitReceiverId;
    @Builder.Default
    private List<MonoDiscount> discounts = new ArrayList<>();

}
