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
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.ArticlePk;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_article", schema = "pos")
//@IdClass(ArticlePk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Article {

//    @Id
    @Column(nullable = false)
    private Short idShop;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArticle;
    @Column(nullable = false)
    private Integer idArticlesGroup;
    @Column(nullable = false)
    private Integer idMaker;
    @Column(nullable = false)
    private Integer idDepartment;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String sname;
    @Column(nullable = false)
    private Short dtype;
    @Column(nullable = false)
    private String vatGroup;
    @Column(nullable = false)
    private Boolean saleInTara;
    @Column(nullable = false)
    private Boolean active;
    @Column(nullable = false)
    private Boolean fiscal;
    @Column(nullable = false)
    private Boolean local;
    @Column(nullable = false)
    private String article;
    private String memo;
    @Column(nullable = false)
    private Integer printer;
    private String articleBeforeStr;
    private String articleAfterStr;
    private String uktzed;
    @Column(nullable = false)
    private Integer isExcise;

}
