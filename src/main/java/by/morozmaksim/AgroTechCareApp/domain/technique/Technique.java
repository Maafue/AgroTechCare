package by.morozmaksim.AgroTechCareApp.domain.technique;

import by.morozmaksim.AgroTechCareApp.domain.brand.Brand;

import java.time.LocalDateTime;

public class Technique {

    private Long id;
    private String name;
    private String vin;
    private LocalDateTime guarantee;
    private Brand brand;

}
