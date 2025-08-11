package by.morozmaksim.AgroTechCareApp.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TechniqueDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String name;
    private String vin;
    private LocalDateTime guarantee;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long brandId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BrandDto brand;

}
