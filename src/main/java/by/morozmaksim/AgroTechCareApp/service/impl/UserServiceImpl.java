package by.morozmaksim.AgroTechCareApp.service.impl;

import by.morozmaksim.AgroTechCareApp.dao.UserDao;
import by.morozmaksim.AgroTechCareApp.domain.user.User;
import by.morozmaksim.AgroTechCareApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public User create(User user) {
        return userDao.create(user);
    }
}
