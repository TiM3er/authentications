package pl.tim3erland.authentications.jwtserver.service;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.tim3erland.authentications.jwtserver.dto.UserCreateDto;
import pl.tim3erland.authentications.jwtserver.dto.UserDto;
import pl.tim3erland.authentications.jwtserver.dto.UserPasswordDto;
import pl.tim3erland.authentications.jwtserver.dto.UserRoleDto;
import pl.tim3erland.authentications.jwtserver.dto.UserTokenDto;
import pl.tim3erland.authentications.jwtserver.jwt.JwtUtils;

/**
 * @author Piotr Witowski
 */
@Slf4j
@Service
public class UserService {
    public UserPasswordDto registerNewUser(UserCreateDto userCreateDto) {
        return new UserPasswordDto();
    }

    public UserTokenDto loginUser(UserPasswordDto userPasswordDto) {
        return UserTokenDto.builder()
            .token(JwtUtils.generateJwtToken("asdas", Arrays.asList("asda", "asda", "asdasd"))).build();
    }

    public UserRoleDto getUserRoles(String uid) {
        return null;
    }

    public void deleteUser(String uid) {

    }
}
