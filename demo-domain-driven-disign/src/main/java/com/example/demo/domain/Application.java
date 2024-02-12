package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "application", indexes =  {
        @Index(name = "application_applicant_id_idx", columnList = "applicant_id"),
        @Index(name = "application_advisor_id_idx", columnList = "advisor_id")
})
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amountUsd;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime assignedAt;
    @ManyToOne(optional = false)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;

    public enum Status {
        NEW, ASSIGNED, APPROVED, CANCELED, DECLINED
    }

    public void assignTo(Advisor advisor) {
        this.advisor = advisor;
        this.status = Status.ASSIGNED;
        this.assignedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Application)) return false;
        Application that = (Application) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
