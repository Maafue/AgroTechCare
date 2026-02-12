package by.morozmaksim.AgroTechCare.service;

import by.morozmaksim.AgroTechCare.domain.entity.workOrder.WorkOrder;
import by.morozmaksim.AgroTechCare.web.dto.WorkOrderDto;

import java.util.List;

public interface WorkOrderService {

    WorkOrder create(WorkOrder workOrder, Long techniqueId, Long legalEntityId);

    WorkOrder update(WorkOrderDto workOrderDto, Long id);

    WorkOrder findById(Long id);

    List<WorkOrder> findAll();

    void delete(Long id);

}
