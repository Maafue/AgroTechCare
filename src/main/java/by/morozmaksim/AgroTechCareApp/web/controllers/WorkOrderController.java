package by.morozmaksim.AgroTechCareApp.web.controllers;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.domain.workOrder.WorkOrder;
import by.morozmaksim.AgroTechCareApp.service.LegalEntityService;
import by.morozmaksim.AgroTechCareApp.service.TechniqueService;
import by.morozmaksim.AgroTechCareApp.service.WorkOrderService;
import by.morozmaksim.AgroTechCareApp.web.dto.WorkOrderDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.WorkOrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work_orders")
@RequiredArgsConstructor
public class WorkOrderController {

    private final WorkOrderService workOrderService;
    private final WorkOrderMapper workOrderMapper;
    private final LegalEntityService legalEntityService;
    private final TechniqueService techniqueService;

    @PostMapping
    public WorkOrderDto create(@RequestBody WorkOrderDto workOrderDto) {
        WorkOrder workOrder = workOrderMapper.toEntity(workOrderDto);
        WorkOrder createdWorkOrder = workOrderService.create(
                workOrder,
                workOrderDto.getTechnique_id(),
                workOrderDto.getLegal_entity_id());
        return workOrderMapper.toDto(createdWorkOrder);
    }
    @PutMapping
    public WorkOrderDto update(@RequestBody WorkOrderDto workOrderDto) {
        WorkOrder workOrder = workOrderMapper.toEntity(workOrderDto);
        WorkOrder updatedWorkOrder = workOrderService.update(
                workOrder,
                workOrderDto.getTechnique_id(),
                workOrderDto.getLegal_entity_id());
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
