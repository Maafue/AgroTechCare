package by.morozmaksim.AgroTechCareApp.domain.legalEntity;

import by.morozmaksim.AgroTechCareApp.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.Mapping;

@Data
@Entity
@Table(name = "legal_entities")
public class LegalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "inn")
    private String inn;
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Override
    public String toString() {
        return "LegalEntity{" +
                "inn='" + inn + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
