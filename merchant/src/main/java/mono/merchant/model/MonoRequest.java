package mono.merchant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonoRequest {


    private String merchantReceiptId;
    private String loyaltyIdentifier;
    @Builder.Default
    private BigDecimal paidSum = BigDecimal.ZERO;
    @Builder.Default
    private BigDecimal discountSum = BigDecimal.ZERO;
    @Builder.Default
    private List<MonoItem> items = new ArrayList<>();
    private MonoPayment payment;
    private MonoFiscal fiscal;
}
