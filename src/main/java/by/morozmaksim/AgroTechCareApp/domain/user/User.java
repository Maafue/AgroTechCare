package by.morozmaksim.AgroTechCareApp.domain.user;

import by.morozmaksim.AgroTechCareApp.domain.contract.Contract;
import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;

import java.util.List;

public class User {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String username;
    private String password;
    private String passwordConfirmation;
    private boolean isMechanic;
    private LegalEntity legalEntity;
    private List<Contract> contracts;

}
