package by.morozmaksim.AgroTechCareApp.web.dto;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.domain.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
