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

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonoItem {

    private String productId;
    private String productName;
    @Builder.Default
    private BigDecimal price = BigDecimal.ZERO;
    @Builder.Default
    private BigDecimal quantity = BigDecimal.ZERO;
    private String quantityUnit;
    @Builder.Default
    private BigDecimal discount = BigDecimal.ZERO;
}
