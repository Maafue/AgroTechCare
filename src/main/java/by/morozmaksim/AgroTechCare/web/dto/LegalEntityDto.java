package by.morozmaksim.AgroTechCare.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LegalEntityDto {

    private Long id;

    @NotBlank(message = "Поле name не может быть пустым.")
    private String name;

    @NotBlank(message = "Поле address не может быть пустым.")
    private String address;

    @NotBlank(message = "Поле inn не может быть пустым.")
    private String inn;

}
