package pl.tim3erland.authentications.jwtserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.tomcat.jni.User;

/**
 * @author Piotr Witowski
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserPasswordDto  extends UserDto {
    private String password;
}
