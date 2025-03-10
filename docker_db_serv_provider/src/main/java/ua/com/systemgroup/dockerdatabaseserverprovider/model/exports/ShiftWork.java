package ua.com.systemgroup.dockerdatabaseserverprovider.model.exports;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.ShiftWorkPk;

import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_shift_work", schema = "pos")
@IdClass(ShiftWorkPk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShiftWork {

    @Id
    private Short idShop;
    @Id
    private Integer idShift;
    @Id
    private Integer idWorkplace;
    private Integer idUser;
    private ZonedDateTime dateShift;
    private Character typeAction;
}
