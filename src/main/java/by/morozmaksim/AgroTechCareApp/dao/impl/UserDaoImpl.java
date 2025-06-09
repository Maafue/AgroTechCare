package by.morozmaksim.AgroTechCareApp.dao.impl;

import by.morozmaksim.AgroTechCareApp.dao.UserDao;
import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.domain.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .addAnnotatedClass(LegalEntity.class)
            .buildSessionFactory();

    @Override
    public User create(User user) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.persist(user);

        session.getTransaction().commit();
        session.close();

        return user;
    }

    @Override
    public User findById(Long id) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        User user = session.find(User.class, id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User update(User user) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.merge(user);

        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.remove(user);
        session.getTransaction().commit();
        session.close();
    }
}
