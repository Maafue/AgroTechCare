package by.morozmaksim.AgroTechCareApp.repository;

import by.morozmaksim.AgroTechCareApp.domain.workOrder.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
}
