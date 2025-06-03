package by.morozmaksim.AgroTechCareApp.domain.legalEntity;

import by.morozmaksim.AgroTechCareApp.domain.user.User;
import lombok.Data;

@Data
public class LegalEntity {

    private Long id;
    private String name;
    private String address;
    private String inn;
    private User user;

}
