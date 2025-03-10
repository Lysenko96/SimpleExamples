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
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.ArticlesGroupPk;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_articles_group", schema = "pos")
//@IdClass(ArticlesGroupPk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ArticlesGroup {

//    @Id
    @Column(nullable = false)
    private Short idShop;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArticlesGroup;
    private Integer idParentGroup;
    @Column(nullable = false)
    private String name;
    private Boolean signActivity;
}
