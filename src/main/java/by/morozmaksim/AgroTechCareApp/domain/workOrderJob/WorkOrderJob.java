package by.morozmaksim.AgroTechCareApp.domain.workOrderJob;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "work_orders_jobs")
public class WorkOrderJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "work_order_id")
    private Long workOrderId;
    @Column(name = "job_id")
    private Long jobId;

}
