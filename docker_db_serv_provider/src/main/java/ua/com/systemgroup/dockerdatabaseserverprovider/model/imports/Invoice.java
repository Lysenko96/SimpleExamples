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

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_invoice", schema = "pos")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Invoice {


    @Column(nullable = false)
    private Short idShop;
    @Id
    @Column(nullable = false)
    private UUID guid;
    private Date date;
    private Integer number;
    private String comments;
}
