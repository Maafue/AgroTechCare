package by.morozmaksim.AgroTechCareApp.service;

import by.morozmaksim.AgroTechCareApp.domain.workOrder.WorkOrder;
import by.morozmaksim.AgroTechCareApp.web.dto.WorkOrderDto;

import java.util.List;

public interface WorkOrderService {

    WorkOrder create(WorkOrder workOrder, Long techniqueId, Long legalEntityId);

    WorkOrder update(WorkOrderDto workOrderDto);

    WorkOrder findById(Long id);

    List<WorkOrder> findAll();

    void delete(Long id);

}
