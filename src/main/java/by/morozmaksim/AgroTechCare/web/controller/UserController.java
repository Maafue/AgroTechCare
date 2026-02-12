package by.morozmaksim.AgroTechCare.web.controller;

import by.morozmaksim.AgroTechCare.domain.entity.user.User;
import by.morozmaksim.AgroTechCare.service.UserService;
import by.morozmaksim.AgroTechCare.web.dto.UserDto;
import by.morozmaksim.AgroTechCare.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

//    для каждого контроллера добавить обработку исключений, добавить валидацию в dto
//    кэширование

    @PostMapping
    public UserDto create(@Validated @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @Validated @RequestBody UserDto userDto) {
        User updatedUser = userService.update(userDto, id);
        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.findById(id);
        return userMapper.toDto(user);
    }

    @GetMapping
    public List<UserDto> getAll() {
        List<User> users = userService.findAll();
        return userMapper.toDtos(users);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
