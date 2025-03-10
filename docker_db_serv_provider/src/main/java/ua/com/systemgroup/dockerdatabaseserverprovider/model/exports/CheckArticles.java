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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.CheckArticlesPk;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_check_articles", schema = "pos")
@IdClass(CheckArticlesPk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CheckArticles {

    @Id
    private Short idShop;
    @Id
    private Integer idWorkplace;
    @Id
    private Integer idCheck;
    @Id
    private Integer pos;
    private Integer idMeasure;
    private Integer idArticle;
    private Integer idBarcode;
    private Integer idCheckReturn;
    private Integer idWorkplaceReturn;
    @JdbcTypeCode(SqlTypes.ARRAY)
    private Integer[] idDiscount;
    @JdbcTypeCode(SqlTypes.ARRAY)
    private Integer[] idActionCoupon;
    private String article;
    private String barcode;
    private BigDecimal quantity;
    private BigDecimal quantityRet;
    private BigDecimal cleanPrice;
    private BigDecimal price;
    private BigDecimal sum;
    private BigDecimal sumRet;
    private BigDecimal discountSum;
    private BigDecimal vat;
    private String vatGroup;
    private Short typeArticle;
    private Short dtype;
    private ZonedDateTime timeAdd;
    private ZonedDateTime timeOpen;
    private String uktzed;
    private String excise;
}
