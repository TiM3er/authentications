package pl.tim3erland.authentications.jwtserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Piotr Witowski
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserTokenDto extends UserDto {
    private String token;
}
