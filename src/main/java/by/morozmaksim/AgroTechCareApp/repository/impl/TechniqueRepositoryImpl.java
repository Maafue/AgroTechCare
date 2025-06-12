package by.morozmaksim.AgroTechCareApp.repository.impl;

import by.morozmaksim.AgroTechCareApp.domain.technique.Technique;
import by.morozmaksim.AgroTechCareApp.repository.TechniqueRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TechniqueRepositoryImpl implements TechniqueRepository {

    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    @Override
    public Technique create(Technique technique) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.persist(technique);

        session.getTransaction().commit();
        session.close();
        return technique;
    }

    @Override
    public Technique update(Technique technique) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.merge(technique);

        session.getTransaction().commit();
        session.close();
        return technique;
    }

    @Override
    public void delete(Technique technique) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.remove(technique);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Technique findById(Long id) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Technique technique = session.get(Technique.class, id);

        session.getTransaction().commit();
        session.close();
        return technique;
    }

    @Override
    public List<Technique> findAll() {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        List<Technique> techniques = session.createQuery("from Technique ", Technique.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return techniques;
    }
}
