package by.morozmaksim.AgroTechCareApp.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String username;
    private String password;
    private String passwordConfirmation;
    @JsonProperty("isMechanic")
    private boolean isMechanic;
    private LegalEntityDto legalEntity;

}
