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
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.PaydiscountPk;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_paydiscount", schema = "pos")
@IdClass(PaydiscountPk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Paydiscount {

    @Id
    private Integer idPaydiscount;
    @Id
    private Short idKassa;
    private Integer dtype;
    private Integer checkNumber;
    private Integer checkPos;
    private BigDecimal summa;
    private BigDecimal percent;
    @Id
    private Integer idShop;
}
