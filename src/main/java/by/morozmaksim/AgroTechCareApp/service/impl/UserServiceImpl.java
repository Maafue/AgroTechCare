package by.morozmaksim.AgroTechCareApp.service.impl;

import by.morozmaksim.AgroTechCareApp.domain.exception.ResourceNotFoundException;
import by.morozmaksim.AgroTechCareApp.domain.user.User;
import by.morozmaksim.AgroTechCareApp.repository.UserRepository;
import by.morozmaksim.AgroTechCareApp.service.UserService;
import by.morozmaksim.AgroTechCareApp.web.dto.UserDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public User update(UserDto userDto) {
        User excistingUser = findById(userDto.getId());
        excistingUser.setFirstName(userDto.getFirstName());
        excistingUser.setMiddleName(userDto.getMiddleName());
        excistingUser.setLastName(userDto.getLastName());
        excistingUser.setPassword(userDto.getPassword());
        excistingUser.setPasswordConfirmation(userDto.getPasswordConfirmation());
        return userRepository.save(excistingUser);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }

}
