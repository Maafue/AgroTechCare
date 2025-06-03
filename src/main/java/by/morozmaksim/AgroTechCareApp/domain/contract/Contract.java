package by.morozmaksim.AgroTechCareApp.domain.contract;

import by.morozmaksim.AgroTechCareApp.domain.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Contract {

    private Long id;
    private String number;
    private LocalDateTime date;
    private LocalDateTime endDate;
    private double prepayment;
    private double debt;
    private double overdueDebt;
    private User user;

}
