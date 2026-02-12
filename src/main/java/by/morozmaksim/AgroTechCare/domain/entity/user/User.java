package by.morozmaksim.AgroTechCare.domain.entity.user;

import by.morozmaksim.AgroTechCare.domain.entity.contract.Contract;
import by.morozmaksim.AgroTechCare.domain.entity.legalEntity.LegalEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "password_confirmation")
    private String passwordConfirmation;

    @Column(name = "is_mechanic")
    private boolean isMechanic;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private LegalEntity legalEntity;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Contract> contracts;

    public void setLegalEntity(LegalEntity legalEntity) {
        this.legalEntity = legalEntity;
        if (legalEntity != null && legalEntity.getUser() != this) {
            legalEntity.setUser(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirmation='" + passwordConfirmation + '\'' +
                ", isMechanic=" + isMechanic +
                '}';
    }
}
