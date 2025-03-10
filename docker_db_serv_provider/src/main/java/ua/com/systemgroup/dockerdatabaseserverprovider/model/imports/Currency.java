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
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.CurrencyPk;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_currency", schema = "pos")
@IdClass(CurrencyPk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Currency {

    @Id
    @Column(nullable = false)
    private Short idShop;
    @Id
    @Column(nullable = false)
    private Short idCurrency;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String sname;
    @Column(nullable = false)
    private String symbol;
    @Column(nullable = false)
    private BigDecimal exchange;
    @Column(nullable = false)
    private Short digits;
    @Column(nullable = false)
    private Boolean isbase;
    @Column(nullable = false)
    private Boolean isnational;
}
