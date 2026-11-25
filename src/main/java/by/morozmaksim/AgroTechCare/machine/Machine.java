package by.morozmaksim.AgroTechCare.machine;

import by.morozmaksim.AgroTechCare.client.Client;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "machines")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Machine {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    private MachineModel machineModel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_client_id", nullable = false)
    private Client client;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "manufacture_year")
    private Integer manufactureYear;

    @Column(name = "warranty_until")
    private LocalDate warrantyUntil;

    public Machine(MachineModel machineModel, Client client, String serialNumber) {
        this.machineModel = machineModel;
        this.client = client;
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Machine machine)) return false;
        return id != null && id.equals(machine.getId());
    }

    @Override
    public int hashCode() {
        return Machine.class.hashCode();
    }

}
