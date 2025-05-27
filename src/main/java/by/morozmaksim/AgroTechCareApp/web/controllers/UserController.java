package by.morozmaksim.AgroTechCareApp.web.controllers;

import by.morozmaksim.AgroTechCareApp.domain.user.User;
import by.morozmaksim.AgroTechCareApp.service.UserService;
import by.morozmaksim.AgroTechCareApp.web.dto.UserDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping()
    public UserDto create(@RequestBody UserDto userDto){

        User user = userMapper.toEntity(userDto);

        User createdUser = userService.create(user);

        return userMapper.toDto(createdUser);

    }
}
