package by.morozmaksim.AgroTechCare;

import by.morozmaksim.AgroTechCare.catalog.job.Job;
import by.morozmaksim.AgroTechCare.catalog.job.JobRepository;
import by.morozmaksim.AgroTechCare.catalog.part.Part;
import by.morozmaksim.AgroTechCare.catalog.part.PartRepository;
import by.morozmaksim.AgroTechCare.config.TestConfig;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@Import(TestConfig.class)
public class CatalogRepositoryTest {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldSaveAndReloadPartAndJob() {

        Part part = new Part("article", "part");
        part.setPrice(BigDecimal.valueOf(1.15));

        Job job = new Job("job");
        job.setPrice(BigDecimal.valueOf(3.33));
        job.setNormHours(BigDecimal.valueOf(2.11));

        partRepository.saveAndFlush(part);
        jobRepository.saveAndFlush(job);

        entityManager.clear();

        Part reloadedPart = partRepository.findById(part.getId()).orElseThrow();
        Job reloadedJob = jobRepository.findById(job.getId()).orElseThrow();

        assertThat(reloadedPart.equals(part)).isTrue();
        assertThat(reloadedPart.getArticle().equals(part.getArticle())).isTrue();
        assertThat(reloadedPart.getName().equals(part.getName())).isTrue();
        assertThat(reloadedPart.getPrice()).isEqualByComparingTo(part.getPrice());

        assertThat(reloadedJob.equals(job)).isTrue();
        assertThat(reloadedJob.getNormHours()).isEqualByComparingTo(job.getNormHours());
        assertThat(reloadedJob.getName().equals(job.getName())).isTrue();
        assertThat(reloadedJob.getPrice()).isEqualByComparingTo(job.getPrice());
    }

    @Test
    void shouldSaveJobWithoutPriceAndNormHours(){
        Job job = new Job("job");
        jobRepository.saveAndFlush(job);

        entityManager.clear();

        Job reloadedJob = jobRepository.findById(job.getId()).orElseThrow();

        assertThat(reloadedJob.equals(job)).isTrue();
        assertThat(reloadedJob.getNormHours() == null).isTrue();
        assertThat(reloadedJob.getName().equals(job.getName())).isTrue();
        assertThat(reloadedJob.getPrice() == null).isTrue();
    }

    @Test
    void shouldNotSavePartWithDuplicateArticle() {
        Part part = new Part("article", "part");
        partRepository.saveAndFlush(part);

        Part partWithDuplicateArticle = new Part("article", "part");

        assertThatThrownBy(() -> {
            partRepository.saveAndFlush(partWithDuplicateArticle);
        })
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("uq_parts_article");
    }
    @Test
    void shouldRejectPartWithNegativePrice(){
        Part part = new Part("article", "part");
        part.setPrice(BigDecimal.valueOf(-1.00));

        assertThatThrownBy(() -> {
            partRepository.saveAndFlush(part);
        })
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("chk_parts_price");
    }
    @Test
    void shouldRejectJobWithNegativePrice(){
        Job job = new Job("job");
        job.setPrice(BigDecimal.valueOf(-1.00));

        assertThatThrownBy(() -> {
            jobRepository.saveAndFlush(job);
        })
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("chk_jobs_price");
    }
    @Test
    void shouldRejectJobWithNegativeNormHours(){
        Job job = new Job("job");
        job.setNormHours(BigDecimal.valueOf(-1.00));

        assertThatThrownBy(() -> {
            jobRepository.saveAndFlush(job);
        })
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("chk_jobs_norm_hours");
    }
}
