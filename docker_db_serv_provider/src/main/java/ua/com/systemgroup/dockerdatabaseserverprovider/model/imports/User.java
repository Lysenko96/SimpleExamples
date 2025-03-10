package ua.com.systemgroup.dockerdatabaseserverprovider.model.imports;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.UserPk;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_user", schema = "pos")
@IdClass(UserPk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {

    @Id
    @Column(nullable = false)
    private Short idShop;
    @Id
    private Integer idUser;
    @Column(nullable = false)
    private Integer idProfile;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String pswd;
    @Column(nullable = false)
    private Short dtype;
    @Column(nullable = false)
    private Boolean active;
    @Column(nullable = false)
    private String fullName;
    private Date dateBegin;
    private Date dateEnd;
    private String cardnumber;
}
