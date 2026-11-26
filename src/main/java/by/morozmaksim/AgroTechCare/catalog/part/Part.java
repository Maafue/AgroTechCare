package by.morozmaksim.AgroTechCare.catalog.part;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "parts")
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Part {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "article")
    private String article;

    @Column(name = "price")
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Part part)) return false;
        return (id != null) && id.equals(part.getId());
    }

    @Override
    public int hashCode() {
        return Part.class.hashCode();
    }

    public Part(String article, String name) {
        this.article = article;
        this.name = name;
    }
}
