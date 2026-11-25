package by.morozmaksim.AgroTechCare.client;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private ClientType type;

    @Column(name = "name")
    private String name;

    @Column(name = "unp")
    private String unp;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client that)) return false;
        return id != null && id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Client.class.hashCode();
    }

    public Client(ClientType type, String name, String phone) {
        this.type = type;
        this.name = name;
        this.phone = phone;
    }
}
