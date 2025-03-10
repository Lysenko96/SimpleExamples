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
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.BanArticlePk;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_ban_article", schema = "pos")
@IdClass(BanArticlePk.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BanArticle {

    @Id
    @Column(nullable = false)
    private Integer idWorkplace;
    @Id
    @Column(nullable = false)
    private Integer idParam;
    @Column(nullable = false)
    private Short dtype;
    @Id
    @Column(nullable = false)
    private Short idShop;
    private String action;
}
