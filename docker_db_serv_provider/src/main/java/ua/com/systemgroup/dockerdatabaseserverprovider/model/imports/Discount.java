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
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.DiscountPk;

import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_discount", schema = "pos")
@IdClass(DiscountPk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Discount {

    @Id
    @Column(nullable = false)
    private Short idShop;
    @Id
    private Integer idDiscount;
    private Integer idParentDiscount;
    private Date dateBegin;
    private Date dateEnd;
    private ZonedDateTime timeBegin;
    private ZonedDateTime timeEnd;
    private String description;
    @Column(nullable = false)
    private String name;
    private Short dtype;
}
