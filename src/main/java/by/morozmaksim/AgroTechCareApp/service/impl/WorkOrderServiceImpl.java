package by.morozmaksim.AgroTechCareApp.service.impl;

import by.morozmaksim.AgroTechCareApp.domain.exception.ResourceNotFoundException;
import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.domain.workOrder.WorkOrder;
import by.morozmaksim.AgroTechCareApp.repository.WorkOrderRepository;
import by.morozmaksim.AgroTechCareApp.service.LegalEntityService;
import by.morozmaksim.AgroTechCareApp.service.TechniqueService;
import by.morozmaksim.AgroTechCareApp.service.WorkOrderService;
import by.morozmaksim.AgroTechCareApp.web.dto.WorkOrderDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WorkOrderServiceImpl implements WorkOrderService {

    private final WorkOrderRepository workOrderRepository;
    private final TechniqueService techniqueService;
    private final LegalEntityService legalEntityService;

    @Override
    public WorkOrder create(WorkOrder workOrder, Long techniqueId, Long legalEntityId) {
        Technique technique = techniqueService.findById(techniqueId);
        LegalEntity legalEntity = legalEntityService.findById(legalEntityId);
        workOrder.setTechnique(technique);
        workOrder.setLegalEntity(legalEntity);
        return workOrderRepository.save(workOrder);
    }

    @Override
    public WorkOrder update(WorkOrderDto workOrderDto) {
        WorkOrder excistingWorkOrder = findById(workOrderDto.getId());
        excistingWorkOrder.setNumber(workOrderDto.getNumber());
        excistingWorkOrder.setSum(workOrderDto.getSum());
        excistingWorkOrder.setReason(workOrderDto.getReason());
        excistingWorkOrder.setPlannedWorkDate(workOrderDto.getPlannedWorkDate());
        excistingWorkOrder.setWorkType(workOrderDto.getWorkType());
        excistingWorkOrder.setPlaceOfWork(workOrderDto.getPlaceOfWork());
        excistingWorkOrder.setContactPerson(workOrderDto.getContactPerson());
        excistingWorkOrder.setContactPhoneNumber(workOrderDto.getContactPhoneNumber());
        if (workOrderDto.getTechniqueId() != null) {
            Technique technique = techniqueService.findById(workOrderDto.getTechniqueId());
            excistingWorkOrder.setTechnique(technique);
        }
        if (workOrderDto.getLegalEntityId() != null) {
            LegalEntity legalEntity = legalEntityService.findById(workOrderDto.getLegalEntityId());
            excistingWorkOrder.setLegalEntity(legalEntity);
        }
        return workOrderRepository.save(excistingWorkOrder);
    }

    @Override
    public WorkOrder findById(Long id) {
        return workOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Work order not found with id " + id));
    }

    @Override
    public List<WorkOrder> findAll() {
        return workOrderRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        WorkOrder workOrder = findById(id);
        workOrderRepository.delete(workOrder);
    }
}
