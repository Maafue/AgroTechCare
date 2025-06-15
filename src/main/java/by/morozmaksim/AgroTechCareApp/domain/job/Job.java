package by.morozmaksim.AgroTechCareApp.domain.job;

import by.morozmaksim.AgroTechCareApp.domain.workOrder.WorkOrder;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double price;
    private int value;
    @ManyToMany
    @JoinTable(
            name = "work_orders_jobs",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "work_order_id")
    )
    private List<WorkOrder> workOrder;
}
