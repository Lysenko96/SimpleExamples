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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.MeasurePk;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_measure", schema = "pos")
@IdClass(MeasurePk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Measure {

    @Id
    @Column(nullable = false)
    private Short idShop;
    @Id
    private Integer idMeasure;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String sname;
    @Column(nullable = false)
    private Boolean active;
    private String description;
    @Column(nullable = false)
    private Short digits;
    @JdbcTypeCode(SqlTypes.ARRAY)
    private BigDecimal[] enabledDivisional;
}
