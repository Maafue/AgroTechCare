package by.morozmaksim.AgroTechCareApp.web.dto;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
//    private String username;
//    private String password;
//    private String passwordConfirmation;
    private boolean isMechanic;
    private LegalEntity legalEntity;
}
