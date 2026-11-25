package by.morozmaksim.AgroTechCare.contract;

import by.morozmaksim.AgroTechCare.client.Client;
import by.morozmaksim.AgroTechCare.machine.Machine;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contracts")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "number")
    private String number;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ContractType type;

    @Column(name = "signed_date")
    private LocalDate signedDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Setter(AccessLevel.NONE)
    @ManyToMany
    @JoinTable(
            name = "contract_machines",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "machine_id")
    )
    private Set<Machine> machines = new HashSet<>();

    public Contract(Client client, String number, ContractType type) {
        this.client = client;
        this.number = number;
        this.type = type;
    }

    public void addMachine(Machine machine){
        machines.add(machine);
    }
    public void removeMachine(Machine machine){
        machines.remove(machine);
    }

    public Set<Machine> getMachines() {
        return Collections.unmodifiableSet(machines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contract contract)) return false;
        return id != null && id.equals(contract.getId());
    }

    @Override
    public int hashCode() {
        return Contract.class.hashCode();
    }
}
