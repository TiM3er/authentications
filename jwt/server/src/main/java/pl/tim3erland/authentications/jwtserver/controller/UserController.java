package pl.tim3erland.authentications.jwtserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tim3erland.authentications.jwtserver.dto.UserCreateDto;
import pl.tim3erland.authentications.jwtserver.dto.UserDto;
import pl.tim3erland.authentications.jwtserver.dto.UserPasswordDto;
import pl.tim3erland.authentications.jwtserver.dto.UserRoleDto;
import pl.tim3erland.authentications.jwtserver.dto.UserTokenDto;
import pl.tim3erland.authentications.jwtserver.service.UserService;


/**
 * @author Piotr Witowski
 */
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping
    public ResponseEntity<UserTokenDto> registerNewUser(@RequestBody UserCreateDto userCreateDto) {
        UserPasswordDto userPasswordDto = userService.registerNewUser(userCreateDto);
        UserTokenDto userTokenDto = userService.loginUser(userPasswordDto);
        return new ResponseEntity<>(userTokenDto, HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<UserTokenDto> loginUser(@RequestBody UserPasswordDto userPasswordDto) {
        UserTokenDto userTokenDto = userService.loginUser(userPasswordDto);
        return new ResponseEntity<>(userTokenDto, HttpStatus.OK);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<UserRoleDto> getUserRoles(@PathVariable("uid") String uid) {
        UserRoleDto userRoleDto = userService.getUserRoles(uid);
        return new ResponseEntity<>(userRoleDto, HttpStatus.OK);

    }

    @DeleteMapping("/{uid}")
    public ResponseEntity deleteUser(@PathVariable("uid") String uid) {
        userService.deleteUser(uid);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
