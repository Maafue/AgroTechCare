package by.morozmaksim.AgroTechCareApp.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContractDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "Поле number не может быть пустым.")
    private String number;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime date;

    private LocalDateTime endDate;
    private double prepayment;
    private double debt;
    private double overdueDebt;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long userId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserDto user;
}
