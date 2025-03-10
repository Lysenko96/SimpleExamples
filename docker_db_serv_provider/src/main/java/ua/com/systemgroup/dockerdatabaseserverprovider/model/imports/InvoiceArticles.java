package ua.com.systemgroup.dockerdatabaseserverprovider.model.imports;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_invoice_articles", schema = "pos")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InvoiceArticles {

    @Id
    @Column(nullable = false)
    private Short idShop;
    @Column(nullable = false)
    private UUID invoiceGuid;
    private String article;
    private BigDecimal quantity;
    private String measure;

}
