package by.morozmaksim.AgroTechCareApp.service.impl;

import by.morozmaksim.AgroTechCareApp.repository.UserRepository;
import by.morozmaksim.AgroTechCareApp.domain.user.User;
import by.morozmaksim.AgroTechCareApp.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }

}
