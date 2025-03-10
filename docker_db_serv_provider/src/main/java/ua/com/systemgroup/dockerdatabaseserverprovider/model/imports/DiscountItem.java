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
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.DiscountItemPk;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_discount_item", schema = "pos")
@IdClass(DiscountItemPk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DiscountItem {

    @Id
    @Column(nullable = false)
    private Short idShop;
    @Id
    private Integer idDiscountItem;
    @Column(nullable = false)
    private Integer idDiscount;
    @Column(nullable = false)
    private Integer idItem;
    @Column(nullable = false)
    private Integer idValue;
    @Column(nullable = false)
    private Short dtype;
    @Column(nullable = false)
    private BigDecimal quantity;
    @Column(nullable = false)
    private BigDecimal price;
    private String memo;
}
