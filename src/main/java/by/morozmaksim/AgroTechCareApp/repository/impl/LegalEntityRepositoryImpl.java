package by.morozmaksim.AgroTechCareApp.repository.impl;

import by.morozmaksim.AgroTechCareApp.repository.LegalEntityRepository;
import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LegalEntityRepositoryImpl implements LegalEntityRepository {

    private final SessionFactory sessionFactory;

    @Override
    public LegalEntity update(LegalEntity legalEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(legalEntity);
        session.getTransaction().commit();
        return legalEntity;
    }

    @Override
    public void delete(LegalEntity legalEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.remove(legalEntity);
        session.getTransaction().commit();
    }

    @Override
    public LegalEntity findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        LegalEntity legalEntity = session.get(LegalEntity.class, id);
        session.getTransaction().commit();
        return legalEntity;
    }

}
