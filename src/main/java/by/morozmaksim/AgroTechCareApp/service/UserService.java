package by.morozmaksim.AgroTechCareApp.service;

import by.morozmaksim.AgroTechCareApp.domain.user.User;
import by.morozmaksim.AgroTechCareApp.web.dto.UserDto;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(Long id);

    User findById(Long id);

    User update(UserDto userDto);

    List<User> findAll();

}
