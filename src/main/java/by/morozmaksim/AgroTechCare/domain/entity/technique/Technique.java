package by.morozmaksim.AgroTechCare.domain.entity.technique;

import by.morozmaksim.AgroTechCare.domain.entity.brand.Brand;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "techniques")
public class Technique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String vin;
    private LocalDateTime guarantee;

    @OneToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
