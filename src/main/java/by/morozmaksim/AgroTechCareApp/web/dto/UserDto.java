package by.morozmaksim.AgroTechCareApp.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "Поле firstName не может быть пустым.")
    private String firstName;

    @NotBlank(message = "Поле middleName не может быть пустым.")
    private String middleName;

    @NotBlank(message = "Поле lastName не может быть пустым.")
    private String lastName;

    @NotBlank(message = "Поле username не может быть пустым.")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordConfirmation;

    @JsonProperty("isMechanic")
    private boolean isMechanic;

    private LegalEntityDto legalEntity;

}
