package by.morozmaksim.AgroTechCareApp.web.mapper.impl;

import by.morozmaksim.AgroTechCareApp.domain.legalEntity.LegalEntity;
import by.morozmaksim.AgroTechCareApp.domain.user.User;
import by.morozmaksim.AgroTechCareApp.web.dto.LegalEntityDto;
import by.morozmaksim.AgroTechCareApp.web.dto.UserDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.UserMapper;
import org.springframework.stereotype.Component;

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
        userDto.setMechanic(user.isMechanic());

        LegalEntityDto legalEntityDto = new LegalEntityDto();
        legalEntityDto.setId(user.getLegalEntity().getId());
        legalEntityDto.setName(user.getLegalEntity().getName());
        legalEntityDto.setAddress(user.getLegalEntity().getAddress());
        legalEntityDto.setInn(user.getLegalEntity().getInn());

        userDto.setLegalEntityDto(legalEntityDto);

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

        LegalEntity legalEntity = new LegalEntity();
        legalEntity.setId(userDto.getLegalEntityDto().getId());
        legalEntity.setInn(userDto.getLegalEntityDto().getInn());
        legalEntity.setAddress(userDto.getLegalEntityDto().getAddress());
        legalEntity.setName(userDto.getLegalEntityDto().getName());
//        legalEntity.setUser(user);
        user.setLegalEntity(legalEntity);
        return user;
    }
}
