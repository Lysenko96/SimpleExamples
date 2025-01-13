package pos.planetakino;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement(name = "response")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseSellBonus {

    private String code;
    private String message;
    private String responseDatetime;
    private String version;
    private String minVersion;
}
