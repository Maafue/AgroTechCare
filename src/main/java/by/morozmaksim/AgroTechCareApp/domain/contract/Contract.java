package by.morozmaksim.AgroTechCareApp.domain.contract;

import by.morozmaksim.AgroTechCareApp.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number")
    private String number;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "prepayment")
    private double prepayment;

    @Column(name = "debt")
    private double debt;

    @Column(name = "overdue_debt")
    private double overdueDebt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Contract{" +
                "overdueDebt=" + overdueDebt +
                ", debt=" + debt +
                ", prepayment=" + prepayment +
                ", endDate=" + endDate +
                ", date=" + date +
                ", number='" + number + '\'' +
                ", id=" + id +
                '}';
    }
}
