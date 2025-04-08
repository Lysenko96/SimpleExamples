package mono.merchant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonoSubmerchant {

    private String code;
    private String edrpou;
    private String iban;
    private String owner;
}
