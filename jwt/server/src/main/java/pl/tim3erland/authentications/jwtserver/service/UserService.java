package pl.tim3erland.authentications.jwtserver.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.tim3erland.authentications.jwtserver.dao.UsersDao;
import pl.tim3erland.authentications.jwtserver.dto.UserCreateDto;
import pl.tim3erland.authentications.jwtserver.dto.UserPasswordDto;
import pl.tim3erland.authentications.jwtserver.dto.UserRoleDto;
import pl.tim3erland.authentications.jwtserver.dto.UserTokenDto;
import pl.tim3erland.authentications.jwtserver.jwt.JwtUtils;
import pl.tim3erland.authentications.jwtserver.repository.UserRepository;

/**
 * @author Piotr Witowski
 */
@Slf4j
@Service
public class UserService {
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserPasswordDto registerNewUser(UserCreateDto userCreateDto) {
        return new UserPasswordDto();
    }

    private final UserRepository userRepository;


    public UserTokenDto loginUser(UserPasswordDto userPasswordDto) {
        UsersDao userByLoginAndPassword = userRepository.getUserByLoginAndPassword(userPasswordDto.getLogin(), userPasswordDto.getPassword());
        if (userByLoginAndPassword == null) {
            return null;
        }
        List<String> roles = userByLoginAndPassword.getUsersRolesByUsUid().stream().map(usersRolesDao -> {
            return usersRolesDao.getRolesByRoRoUid().getRoCode();
        }).collect(Collectors.toList());
        return UserTokenDto.builder()
                .login(userPasswordDto.getLogin())
                .token(JwtUtils.generateJwtToken(userPasswordDto.getLogin(), roles)).build();
    }

    public UserRoleDto getUserRoles(String uid) {
        return null;
    }

    public void deleteUser(String uid) {

    }
}
