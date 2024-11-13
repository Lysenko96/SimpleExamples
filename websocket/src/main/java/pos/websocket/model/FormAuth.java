package pos.websocket.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FormAuth {

    private String login;
    private String password;
    private String cardnumber;
}
