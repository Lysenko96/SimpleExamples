package ua.com.systemgroup.dockerdatabaseserverprovider.model;

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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.ClientPk;

import java.math.BigDecimal;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_client", schema = "pos")
@IdClass(ClientPk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Client {

    @Id
    @Column(nullable = false)
    private Short idShop;
    @Id
    private Integer idClient;
    @JdbcTypeCode(SqlTypes.ARRAY)
    private Integer[] idDiscount;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private Boolean active;
    @Column(nullable = false)
    private BigDecimal discount;
    @JdbcTypeCode(SqlTypes.ARRAY)
    private BigDecimal[] sum;
    @Column(nullable = false)
    private Short dtype;
    private String description;
    private Date dateBegin;
    private Date dateEnd;
    private OffsetTime timeBegin;
    private OffsetTime timeEnd;
    private Date dateBirth;
    @Column(nullable = false)
    private Date dateReg;
    @Column(nullable = false)
    private Short dayWeek;
    @JdbcTypeCode(SqlTypes.ARRAY)
    private String[] cardnumber;


}
