package by.morozmaksim.AgroTechCareApp.dao.impl;

import by.morozmaksim.AgroTechCareApp.dao.LegalEntityDao;
import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class LegalEntityDaoImpl implements LegalEntityDao {

    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    @Override
    public LegalEntity update(LegalEntity legalEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(legalEntity);
        session.getTransaction().commit();
        session.close();
        return legalEntity;
    }

    @Override
    public void delete(LegalEntity legalEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(legalEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public LegalEntity findById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        LegalEntity legalEntity = session.get(LegalEntity.class, id);
        session.getTransaction().commit();
        session.close();
        return legalEntity;
    }
}
