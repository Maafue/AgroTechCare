package by.morozmaksim.AgroTechCareApp.web.mapper.impl;

import by.morozmaksim.AgroTechCareApp.domain.user.User;
import by.morozmaksim.AgroTechCareApp.web.dto.UserDto;
import by.morozmaksim.AgroTechCareApp.web.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
//    private Long id;
//    private String firstName;
//    private String middleName;
//    private String lastName;
//    //    private String username;
////    private String password;
////    private String passwordConfirmation;
//    private boolean isMechanic;
//    private Long legalEntity_id;
    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setFirstName( user.getFirstName());
        userDto.setMiddleName( user.getMiddleName() );
        userDto.setLastName( user.getLastName() );
        userDto.setMechanic( user.isMechanic());
        userDto.setLegalEntity( user.getLegalEntity());

        return userDto;

    }

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setFirstName( dto.getFirstName());
        user.setMiddleName( dto.getMiddleName() );
        user.setLastName( dto.getLastName() );
        user.setMechanic( dto.isMechanic());
        user.setLegalEntity(dto.getLegalEntity());

        return user;
    }
}
