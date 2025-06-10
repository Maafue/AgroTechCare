package by.morozmaksim.AgroTechCareApp.service;

import by.morozmaksim.AgroTechCareApp.domain.user.User;

public interface UserService {

    User create(User user);

    void delete(Long id);

    User findById(Long id);

    User update(User user);

}
