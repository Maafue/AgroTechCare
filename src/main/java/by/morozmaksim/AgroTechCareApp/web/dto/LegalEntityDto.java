package by.morozmaksim.AgroTechCareApp.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LegalEntityDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "Поле name не может быть пустым.")
    private String name;

    private String address;
    private String inn;

}
