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
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.AuditActionPk;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_audit_action", schema = "pos")
@IdClass(AuditActionPk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AuditAction {

    @Id
    private Short idShop;
    @Id
    private Integer idAuditAction;
    private Integer idEvent;
    @Id
    private Integer idWorkplace;
    private Integer idUser;
    private Integer idArticle;
    private Integer idMeasure;
    private Integer idClient;
    private Integer fragmentNumber;
    private Integer checkNumber;
    private BigDecimal quantity;
    private BigDecimal priceSale;
    private ZonedDateTime dateEvent;
    private Short statusTransfer;
    private String inputData;
    private Short exported;
    private String memo;
}
