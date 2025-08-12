package by.morozmaksim.AgroTechCareApp.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkOrderDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "Поле number не может быть пустым.")
    private String number;

    private double sum;
    private String reason;
    private LocalDateTime plannedWorkDate;

    @NotBlank(message = "Поле work_type не может быть пустым.")
    private String workType;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long techniqueId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private TechniqueDto technique;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long legalEntityId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LegalEntityDto legalEntity;

    private String placeOfWork;

    @NotBlank(message = "Поле contactPerson не может быть пустым.")
    private String contactPerson;

    @NotBlank(message = "Поле contactPhoneNumber не может быть пустым.")
    private String contactPhoneNumber;
}
