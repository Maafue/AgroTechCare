package by.morozmaksim.AgroTechCare.service;

import by.morozmaksim.AgroTechCare.domain.entity.user.User;
import by.morozmaksim.AgroTechCare.web.dto.UserDto;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(Long id);

    User findById(Long id);

    User update(UserDto userDto, Long id);

    List<User> findAll();

}
