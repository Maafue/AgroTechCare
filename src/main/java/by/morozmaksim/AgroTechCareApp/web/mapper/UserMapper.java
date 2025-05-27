package by.morozmaksim.AgroTechCareApp.web.mapper;

import by.morozmaksim.AgroTechCareApp.domain.user.User;
import by.morozmaksim.AgroTechCareApp.web.dto.UserDto;
//import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto dto);

}
