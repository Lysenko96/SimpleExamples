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
public class Client {

    private String firstname;
    private String lastname;
    private String phone;
    private String gender;
    private String anketa;
    private String sourceofregistration;
    private String dob;
    private String email;
    private String virtualcard;
    private String plasticcard;
    private String category;
    private String categoryname;
    private String password;
    private String emailConfirmed;
    private String phoneConfirmed;
    private String isClubMember;
    private String subscribe;
    private String bonuses;
    private String availableBonuses;
}
