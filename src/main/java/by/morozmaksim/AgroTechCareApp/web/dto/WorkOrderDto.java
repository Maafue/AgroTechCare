package by.morozmaksim.AgroTechCareApp.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkOrderDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String number;
    private double sum;
    private String reason;
    private LocalDateTime plannedWorkDate;
    private String workType;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long techniqueId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private TechniqueDto technique;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long LegalEntityId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LegalEntityDto legalEntity;
    private String placeOfWork;
    private String contactPerson;
    private String contactPhoneNumber;
}
