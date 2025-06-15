package by.morozmaksim.AgroTechCareApp.web.mapper.impl;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.domain.workOrder.WorkOrder;
import by.morozmaksim.AgroTechCareApp.web.dto.BrandDto;
import by.morozmaksim.AgroTechCareApp.web.dto.LegalEntityDto;
import by.morozmaksim.AgroTechCareApp.web.dto.TechniqueDto;
import by.morozmaksim.AgroTechCareApp.web.dto.WorkOrderDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.WorkOrderMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkOrderMapperImpl implements WorkOrderMapper {
    @Override
    public WorkOrderDto toDto(WorkOrder workOrder) {
        if (workOrder == null) return null;

        WorkOrderDto workOrderDto = new WorkOrderDto();
        workOrderDto.setId(workOrder.getId());
        workOrderDto.setNumber(workOrder.getNumber());
        workOrderDto.setSum(workOrder.getSum());
        workOrderDto.setReason(workOrder.getReason());
        workOrderDto.setPlanned_work_date(workOrder.getPlannedWorkDate());
        workOrderDto.setWork_type(workOrder.getWorkType());

        if (workOrder.getTechnique() != null) {
            workOrderDto.setTechnique_id(workOrder.getTechnique().getId());
            TechniqueDto techniqueDto = new TechniqueDto();
            techniqueDto.setId(workOrder.getTechnique().getId());
            techniqueDto.setGuarantee(workOrder.getTechnique().getGuarantee());
            techniqueDto.setName(workOrder.getTechnique().getName());
            techniqueDto.setVin(workOrder.getTechnique().getVin());
            if (workOrder.getTechnique().getBrand() != null) {
                BrandDto brandDto = new BrandDto();
                brandDto.setId(workOrder.getTechnique().getBrand().getId());
                brandDto.setName(workOrder.getTechnique().getBrand().getName());
                techniqueDto.setBrand(brandDto);
            }
            workOrderDto.setTechnique(techniqueDto);
        }

        if (workOrder.getLegalEntity() != null) {
            LegalEntityDto legalEntityDto = new LegalEntityDto();
            legalEntityDto.setId(workOrder.getLegalEntity().getId());
            legalEntityDto.setName(workOrder.getLegalEntity().getName());
            legalEntityDto.setAddress(workOrder.getLegalEntity().getAddress());
            legalEntityDto.setInn(workOrder.getLegalEntity().getInn());
            workOrderDto.setLegal_entity(legalEntityDto);
        }
        workOrderDto.setPlaceOfWork(workOrder.getPlaceOfWork());
        workOrderDto.setContactPerson(workOrder.getContactPerson());
        workOrderDto.setContactPhoneNumber(workOrder.getContactPhoneNumber());
        return workOrderDto;
    }

    @Override
    public WorkOrder toEntity(WorkOrderDto workOrderDto) {
        if (workOrderDto == null) return null;
        WorkOrder workOrder = new WorkOrder();
        workOrder.setId(workOrderDto.getId());
        workOrder.setNumber(workOrderDto.getNumber());
        workOrder.setSum(workOrderDto.getSum());
        workOrder.setReason(workOrderDto.getReason());
        workOrder.setPlannedWorkDate(workOrderDto.getPlanned_work_date());
        workOrder.setWorkType(workOrderDto.getWork_type());
        workOrder.setPlaceOfWork(workOrderDto.getPlaceOfWork());
        workOrder.setContactPerson(workOrderDto.getContactPerson());
        workOrder.setContactPhoneNumber(workOrderDto.getContactPhoneNumber());
        return workOrder;

    }

    @Override
    public List<WorkOrderDto> toDtos(List<WorkOrder> workOrders) {
        if (workOrders == null) return null;
        List<WorkOrderDto> workOrderDtos = new ArrayList<>();
        for (WorkOrder workOrder : workOrders) {
            WorkOrderDto workOrderDto = new WorkOrderDto();
            workOrderDtos.add(toDto(workOrder));
        }
        return workOrderDtos;
    }
}
