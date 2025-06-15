package by.morozmaksim.AgroTechCareApp.web.mapper;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.domain.workOrder.WorkOrder;
import by.morozmaksim.AgroTechCareApp.web.dto.WorkOrderDto;

import java.util.List;

public interface WorkOrderMapper {
    WorkOrderDto toDto(WorkOrder workOrder);
    WorkOrder toEntity(WorkOrderDto workOrderDto);
    List<WorkOrderDto> toDtos(List<WorkOrder> workOrders);
}
