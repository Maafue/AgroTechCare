package by.morozmaksim.AgroTechCareApp.repository.impl;

import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.repository.TechniqueRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TechniqueRepositoryImpl implements TechniqueRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Technique create(Technique technique) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        session.persist(technique);

        session.getTransaction().commit();
        return technique;
    }

    @Override
    public Technique update(Technique technique) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        session.merge(technique);

        session.getTransaction().commit();
        return technique;
    }

    @Override
    public void delete(Technique technique) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        session.remove(technique);

        session.getTransaction().commit();
    }

    @Override
    public Technique findById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        Technique technique = session.get(Technique.class, id);

        session.getTransaction().commit();
        return technique;
    }

    @Override
    public List<Technique> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Technique> techniques = session.createQuery("from Technique ", Technique.class).getResultList();
        session.getTransaction().commit();
        return techniques;
    }
}
