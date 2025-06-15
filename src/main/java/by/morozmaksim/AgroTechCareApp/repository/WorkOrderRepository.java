package by.morozmaksim.AgroTechCareApp.repository;

import by.morozmaksim.AgroTechCareApp.domain.workOrder.WorkOrder;

import java.util.List;

public interface WorkOrderRepository {
    WorkOrder create (WorkOrder workOrder);
    WorkOrder update (WorkOrder workOrder);
    WorkOrder findById(Long id);
    List<WorkOrder> findAll();
    void delete(WorkOrder workOrder);
}
