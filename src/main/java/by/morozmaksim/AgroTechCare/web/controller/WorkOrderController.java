package by.morozmaksim.AgroTechCare.web.controller;

import by.morozmaksim.AgroTechCare.domain.entity.workOrder.WorkOrder;
import by.morozmaksim.AgroTechCare.service.WorkOrderService;
import by.morozmaksim.AgroTechCare.web.dto.WorkOrderDto;
import by.morozmaksim.AgroTechCare.web.mapper.WorkOrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work_orders")
@RequiredArgsConstructor
public class WorkOrderController {

    private final WorkOrderService workOrderService;
    private final WorkOrderMapper workOrderMapper;

    @PostMapping
    public WorkOrderDto create(@Validated @RequestBody WorkOrderDto workOrderDto) {
        WorkOrder workOrder = workOrderMapper.toEntity(workOrderDto);
        WorkOrder createdWorkOrder = workOrderService.create(
                workOrder,
                workOrderDto.getTechniqueId(),
                workOrderDto.getLegalEntityId());
        return workOrderMapper.toDto(createdWorkOrder);
    }

    @PutMapping("/{id}")
    public WorkOrderDto update(@PathVariable Long id,
                               @Validated @RequestBody WorkOrderDto workOrderDto) {
        WorkOrder updatedWorkOrder = workOrderService.update(
                workOrderDto,
                id
        );
        return workOrderMapper.toDto(updatedWorkOrder);
    }

    @GetMapping("/{id}")
    public WorkOrderDto findById(@PathVariable Long id) {
        WorkOrder workOrder = workOrderService.findById(id);
        return workOrderMapper.toDto(workOrder);
    }

    @GetMapping
    public List<WorkOrderDto> findAll() {
        List<WorkOrder> workOrders = workOrderService.findAll();
        return workOrderMapper.toDtos(workOrders);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        workOrderService.delete(id);
    }
}
