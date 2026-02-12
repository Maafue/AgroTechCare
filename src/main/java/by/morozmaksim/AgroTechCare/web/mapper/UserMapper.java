package by.morozmaksim.AgroTechCare.web.mapper;

import by.morozmaksim.AgroTechCare.domain.entity.user.User;
import by.morozmaksim.AgroTechCare.web.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto dto);

    List<UserDto> toDtos(List<User> users);

}
