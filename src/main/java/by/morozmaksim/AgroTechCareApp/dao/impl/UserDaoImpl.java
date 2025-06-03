package by.morozmaksim.AgroTechCareApp.dao.impl;

import by.morozmaksim.AgroTechCareApp.dao.UserDao;
import by.morozmaksim.AgroTechCareApp.domain.user.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public User create(User user) {


        return user;
    }
}
