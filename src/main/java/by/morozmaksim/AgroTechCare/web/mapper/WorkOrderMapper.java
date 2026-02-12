package by.morozmaksim.AgroTechCare.web.mapper;

import by.morozmaksim.AgroTechCare.domain.entity.workOrder.WorkOrder;
import by.morozmaksim.AgroTechCare.web.dto.WorkOrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkOrderMapper {

    WorkOrderDto toDto(WorkOrder workOrder);

    WorkOrder toEntity(WorkOrderDto workOrderDto);

    List<WorkOrderDto> toDtos(List<WorkOrder> workOrders);

}
