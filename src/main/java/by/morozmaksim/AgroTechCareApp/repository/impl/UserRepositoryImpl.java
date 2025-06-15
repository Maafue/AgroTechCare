package by.morozmaksim.AgroTechCareApp.repository.impl;

import by.morozmaksim.AgroTechCareApp.repository.UserRepository;
import by.morozmaksim.AgroTechCareApp.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final SessionFactory sessionFactory;

    @Override
    public User create(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        session.persist(user);

        session.getTransaction().commit();
        session.close();

        return user;
    }

    @Override
    public User findById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        User user = session.find(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public User update(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        session.merge(user);

        session.getTransaction().commit();
        return user;
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        session.remove(user);
        session.getTransaction().commit();
    }
}
