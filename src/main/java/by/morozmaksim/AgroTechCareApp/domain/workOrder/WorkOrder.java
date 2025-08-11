package by.morozmaksim.AgroTechCareApp.domain.workOrder;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "work_orders")
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "sum")
    private double sum;

    @Column(name = "reason")
    private String reason;

    @Column(name = "planned_work_date")
    private LocalDateTime plannedWorkDate;

    @Column(name = "work_type")
    private String workType;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "technique_id")
    private Technique technique;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "legal_entity_id")
    private LegalEntity legalEntity;

    @Column(name = "place_of_work")
    private String placeOfWork;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "contact_phone_number")
    private String contactPhoneNumber;

}
