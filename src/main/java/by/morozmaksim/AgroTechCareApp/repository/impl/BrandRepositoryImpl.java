package by.morozmaksim.AgroTechCareApp.repository.impl;

import by.morozmaksim.AgroTechCareApp.domain.brand.Brand;
import by.morozmaksim.AgroTechCareApp.repository.BrandRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandRepositoryImpl implements BrandRepository {

    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    @Override
    public Brand create(Brand brand) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(brand);
        session.getTransaction().commit();
        session.close();
        return brand;
    }

    @Override
    public Brand update(Brand brand) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(brand);
        session.getTransaction().commit();
        session.close();
        return brand;
    }

    @Override
    public Brand findById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Brand brand = session.get(Brand.class, id);
        session.getTransaction().commit();
        session.close();
        return brand;    }

    @Override
    public List<Brand> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Brand> brands = session.createQuery("from Brand", Brand.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return brands;
    }

    @Override
    public void delete(Brand brand) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(brand);
        session.getTransaction().commit();
        session.close();
    }
}
