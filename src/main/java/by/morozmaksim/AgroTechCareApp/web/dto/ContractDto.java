package by.morozmaksim.AgroTechCareApp.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContractDto {

    private Long id;
    private String number;
    private LocalDateTime date;
    private LocalDateTime endDate;
    private double prepayment;
    private double debt;
    private double overdueDebt;
    private Long userId;

}
