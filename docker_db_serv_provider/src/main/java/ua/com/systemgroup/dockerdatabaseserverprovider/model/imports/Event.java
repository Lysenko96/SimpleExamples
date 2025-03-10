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
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.EventPk;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_event", schema = "pos")
@IdClass(EventPk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Event {

    @Id
    @Column(nullable = false)
    private Short idShop;
    @Id
    private Integer idEvent;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Boolean checkAccess;
    @Column(nullable = false)
    private Boolean keepAudit;
}
