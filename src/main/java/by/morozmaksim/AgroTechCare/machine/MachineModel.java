package by.morozmaksim.AgroTechCare.machine;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "machine_models")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MachineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MachineModel that)) return false;
        return id != null && id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public MachineModel(String name, Brand brand) {
        this.name = name;
        this.brand = brand;
    }
}
