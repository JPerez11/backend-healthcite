package co.gov.heqc.healthcite.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "EPS")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nit;
    @Column(name = "foundation_date")
    private LocalDate foundationDate;
    private String address;


}
