package pos.websocket.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class FormSearchArticles {

    private String eventData;
    private int customerAge;
    private BigDecimal quantity;
    private String excise;
}
