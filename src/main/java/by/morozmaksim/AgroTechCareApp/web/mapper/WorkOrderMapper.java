package by.morozmaksim.AgroTechCareApp.web.mapper;

import by.morozmaksim.AgroTechCareApp.domain.workOrder.WorkOrder;
import by.morozmaksim.AgroTechCareApp.web.dto.WorkOrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkOrderMapper {

    WorkOrderDto toDto(WorkOrder workOrder);

    WorkOrder toEntity(WorkOrderDto workOrderDto);

    List<WorkOrderDto> toDtos(List<WorkOrder> workOrders);

}
