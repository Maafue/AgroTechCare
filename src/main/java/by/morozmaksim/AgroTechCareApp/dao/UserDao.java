package by.morozmaksim.AgroTechCareApp.dao;

import by.morozmaksim.AgroTechCareApp.domain.user.User;

public interface UserDao {

    User create(User user);

    void delete(User user);

    User findById(Long id);

    User update(User user);
}
