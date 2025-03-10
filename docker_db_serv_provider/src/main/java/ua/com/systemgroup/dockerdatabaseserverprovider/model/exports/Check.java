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
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.CheckPk;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_check", schema = "pos")
@IdClass(CheckPk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Check {

    @Id
    private Short idShop;
    @Id
    private Integer idWorkplace;
    @Id
    private Integer idCheck;
    private Integer idUser;
    private Integer idCashRegisterReport;
    private Integer idClient;
    private Date dateOperation;
    private ZonedDateTime timeOpen;
    private ZonedDateTime timeClose;
    private Integer zetNumber;
    private Integer checkNumber;
    private BigDecimal sum;
    private BigDecimal discountSum;
    private BigDecimal roundsum;
    private String numberCashRegister;
    private String description;
    private Short dtype;
    private Short typeVat;
    private String memo;
    private Integer idOrder;
}
