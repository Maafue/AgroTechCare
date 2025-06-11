package by.morozmaksim.AgroTechCareApp.repository;

import by.morozmaksim.AgroTechCareApp.domain.user.User;

public interface UserRepository {

    User create(User user);

    void delete(User user);

    User findById(Long id);

    User update(User user);

}
