package by.morozmaksim.AgroTechCareApp.web.dto;

import by.morozmaksim.AgroTechCareApp.domain.user.User;
import lombok.Data;

@Data
public class LegalEntityDto {

    private Long id;
    private String name;
    private String address;
    private String inn;

}
