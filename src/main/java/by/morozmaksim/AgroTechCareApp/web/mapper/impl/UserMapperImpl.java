package by.morozmaksim.AgroTechCareApp.web.mapper.impl;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.domain.user.User;
import by.morozmaksim.AgroTechCareApp.web.dto.LegalEntityDto;
import by.morozmaksim.AgroTechCareApp.web.dto.UserDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setMiddleName(user.getMiddleName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setPasswordConfirmation(user.getPasswordConfirmation());
        userDto.setMechanic(user.isMechanic());

        setLegalEntityDtoToUserDto(user, userDto);

        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        User user = new User();

        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setMiddleName(userDto.getMiddleName());
        user.setLastName(userDto.getLastName());
        user.setMechanic(userDto.isMechanic());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setPasswordConfirmation(userDto.getPasswordConfirmation());
        setLegalEntityDtoToUser(user, userDto);

        return user;
    }

    @Override
    public List<UserDto> toDtos(List<User> users) {
        if (users == null) {
            return null;
        }
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(toDto(user));
        }
        return userDtos;
    }

    void setLegalEntityDtoToUserDto(User user, UserDto userDto) {
        if (user.getLegalEntity() != null) {
            LegalEntityDto legalEntityDto = new LegalEntityDto();
            legalEntityDto.setId(user.getLegalEntity().getId());
            legalEntityDto.setName(user.getLegalEntity().getName());
            legalEntityDto.setAddress(user.getLegalEntity().getAddress());
            legalEntityDto.setInn(user.getLegalEntity().getInn());

            userDto.setLegalEntity(legalEntityDto);
        }
    }

    void setLegalEntityDtoToUser(User user, UserDto userDto) {
        if (userDto.getLegalEntity() != null) {
            LegalEntity legalEntity = new LegalEntity();
            legalEntity.setId(userDto.getLegalEntity().getId());
            legalEntity.setInn(userDto.getLegalEntity().getInn());
            legalEntity.setAddress(userDto.getLegalEntity().getAddress());
            legalEntity.setName(userDto.getLegalEntity().getName());
            user.setLegalEntity(legalEntity);
            legalEntity.setUser(user);
        }
    }
}
