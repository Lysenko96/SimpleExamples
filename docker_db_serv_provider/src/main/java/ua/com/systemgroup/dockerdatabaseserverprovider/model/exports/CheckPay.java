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
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.CheckPayPk;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_check_pay", schema = "pos")
@IdClass(CheckPayPk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CheckPay {

    @Id
    private Short idShop;
    @Id
    private Integer idWorkplace;
    @Id
    private Integer idCheck;
    @Id
    private Integer pos;
    private Integer idCurrency;
    private Integer idBank;
    private Short dtype;
    private BigDecimal sum;
    private BigDecimal sumRet;
    private String slipNumber;
    private BigDecimal receiveMoney;
    private String description;
    private String rrn;
    private BigDecimal sumNational;
    private BigDecimal receiveMoneyNational;
}
