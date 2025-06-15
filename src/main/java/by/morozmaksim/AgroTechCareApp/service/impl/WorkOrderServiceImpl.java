package by.morozmaksim.AgroTechCareApp.service.impl;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.domain.workOrder.WorkOrder;
import by.morozmaksim.AgroTechCareApp.repository.LegalEntityRepository;
import by.morozmaksim.AgroTechCareApp.repository.TechniqueRepository;
import by.morozmaksim.AgroTechCareApp.repository.WorkOrderRepository;
import by.morozmaksim.AgroTechCareApp.service.WorkOrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WorkOrderServiceImpl implements WorkOrderService {

    private final WorkOrderRepository workOrderRepository;
    private final TechniqueRepository techniqueRepository;
    private final LegalEntityRepository legalEntityRepository;

    @Override
    public WorkOrder create(WorkOrder workOrder, Long techniqueId, Long legalEntityId) {
        Technique technique = techniqueRepository.findById(techniqueId);
        LegalEntity legalEntity = legalEntityRepository.findById(legalEntityId);
        workOrder.setTechnique(technique);
        workOrder.setLegalEntity(legalEntity);
        return workOrderRepository.create(workOrder);
    }

    @Override
    public WorkOrder update(WorkOrder workOrder, Long techniqueId, Long legalEntityId) {
        Technique technique = techniqueRepository.findById(techniqueId);
        LegalEntity legalEntity = legalEntityRepository.findById(legalEntityId);
        workOrder.setTechnique(technique);
        workOrder.setLegalEntity(legalEntity);
        return workOrderRepository.update(workOrder);
    }

    @Override
    public WorkOrder findById(Long id) {
        return workOrderRepository.findById(id);
    }

    @Override
    public List<WorkOrder> findAll() {
        return workOrderRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        WorkOrder workOrder = findById(id);
        workOrder.setJobs(new ArrayList<>());
        workOrderRepository.delete(workOrder);
    }
}
