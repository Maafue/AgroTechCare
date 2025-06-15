package by.morozmaksim.AgroTechCareApp.service;

import by.morozmaksim.AgroTechCareApp.domain.workOrder.WorkOrder;

import java.util.List;

public interface WorkOrderService {

    WorkOrder create(WorkOrder workOrder, Long techniqueId, Long legalEntityId);

    WorkOrder update(WorkOrder workOrder,  Long techniqueId, Long legalEntityId);

    WorkOrder findById(Long id);

    List<WorkOrder> findAll();

    void delete(Long id);

}
