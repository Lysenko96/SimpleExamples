package ua.com.systemgroup.dockerdatabaseserverprovider.model.imports;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.BarcodePk;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_barcode", schema = "pos")
//@IdClass(BarcodePk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Barcode {

//    @Id
    @Column(nullable = false)
    private Short idShop;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBarcode;
    @Column(nullable = false)
    private Integer idArticle;
    @Column(nullable = false)
    private Integer idMeasure;
    @Column(nullable = false)
    private String barcode;
    @Column(nullable = false)
    private Short signFindBarcode;
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.ARRAY)
    private BigDecimal[] price;
    private Short dtype;
    @JdbcTypeCode(SqlTypes.ARRAY)
    private BigDecimal[] addField;
    @JdbcTypeCode(SqlTypes.ARRAY)
    private Date[] expirationDates;
}
