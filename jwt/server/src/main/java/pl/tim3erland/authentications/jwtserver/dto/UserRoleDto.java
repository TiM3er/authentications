package pl.tim3erland.authentications.jwtserver.dto;

import java.util.List;

/**
 * @author Piotr Witowski
 */
public class UserRoleDto extends UserDto {
    List<String> roles;
}
