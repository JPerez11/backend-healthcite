package co.gov.heqc.healthcite.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "APPOINTMENT")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Column(name = "attention_date", nullable = false)
    private LocalDateTime attentionDate;
    @Column(name = "citation_date", nullable = false)
    private LocalDateTime citationDate;
    private String status;
    @Column(nullable = false)
    private String reason;
    @Column(nullable = false)
    private String symptoms;
    @ManyToOne
    @JoinColumn(name = "id_eps", nullable = false)
    private EpsEntity eps;
    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private PeopleEntity patient;
    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private PeopleEntity doctor;

}
