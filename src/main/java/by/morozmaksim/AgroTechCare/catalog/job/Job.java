package by.morozmaksim.AgroTechCare.catalog.job;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "jobs")
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Job {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "norm_hours")
    private BigDecimal normHours;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job job)) return false;
        return id != null && id.equals(job.getId());
    }

    @Override
    public int hashCode() {
        return Job.class.hashCode();
    }

    public Job(String name) {
        this.name = name;
    }
}