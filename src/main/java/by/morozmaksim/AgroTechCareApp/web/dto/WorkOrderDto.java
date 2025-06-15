package by.morozmaksim.AgroTechCareApp.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkOrderDto {
    private Long id;
    private String number;
    private double sum;
    private String reason;
    private LocalDateTime planned_work_date;
    private String work_type;
    private Long technique_id;
    private TechniqueDto technique;
    private Long legal_entity_id;
    private LegalEntityDto legal_entity;
    private String placeOfWork;
    private String contactPerson;
    private String contactPhoneNumber;
}
