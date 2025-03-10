package ua.com.systemgroup.dockerdatabaseserverprovider.model.loyal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "sertificates", schema = "loyalty")
public class Sertificates {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "barcode", nullable = false)
    private String barcode;
    @Column(name = "nominal_sum", nullable = false)
    private BigDecimal nominalSum;
    @Column(name = "prepay_sum", nullable = false)
    private BigDecimal prepaySum;
    @Column(name = "discount_sum", nullable = false)
    private BigDecimal discountSum;
    @Column(name = "status", nullable = false)
    private Integer status;
    @Column(name = "date_creation", columnDefinition = "default now()", nullable = false)
    private LocalDateTime dateCreation;
    private LocalDateTime dateActivation;
    private LocalDateTime dateExpiration;
    private String edrpou;
    private String memo;
    private Long tradepointId;
    private Long cashboxId;
    private Long billNumber;
    private Long position;
}
