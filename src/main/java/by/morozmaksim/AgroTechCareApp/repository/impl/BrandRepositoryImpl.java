package by.morozmaksim.AgroTechCareApp.repository.impl;

import by.morozmaksim.AgroTechCareApp.domain.brand.Brand;
import by.morozmaksim.AgroTechCareApp.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BrandRepositoryImpl implements BrandRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Brand create(Brand brand) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(brand);
        session.getTransaction().commit();
        return brand;
    }

    @Override
    public Brand update(Brand brand) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(brand);
        session.getTransaction().commit();
        return brand;
    }

    @Override
    public Brand findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Brand brand = session.get(Brand.class, id);
        session.getTransaction().commit();
        return brand;
    }

    @Override
    public List<Brand> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Brand> brands = session.createQuery("from Brand", Brand.class).getResultList();
        session.getTransaction().commit();
        return brands;
    }

    @Override
    public void delete(Brand brand) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.remove(brand);
        session.getTransaction().commit();
    }
}
