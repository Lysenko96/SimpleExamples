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
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.ProfilePk;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_profile", schema = "pos")
@IdClass(ProfilePk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Profile {

    @Id
    @Column(nullable = false)
    private Short idShop;
    @Id
    private Integer idProfile;
    @Column(nullable = false)
    private String name;
}
