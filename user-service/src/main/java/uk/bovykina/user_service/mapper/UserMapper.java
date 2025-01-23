package uk.bovykina.user_service.mapper;

import org.mapstruct.Mapper;
import uk.bovykina.user_service.dto.UserDto;
import uk.bovykina.user_service.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}