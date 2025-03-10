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
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.CashOperationPk;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_cash_operation", schema = "pos")
@IdClass(CashOperationPk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CashOperation {

    @Id
    private Short idShop;
    @Id
    private Integer idOperation;
    @Id
    private Integer idWorkplace;
    private Integer idUser;
    private ZonedDateTime dateOperation;
    private Short dtype;
    private BigDecimal sum;
    private String numberCashRegister;
}
