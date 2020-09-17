package pl.tim3erland.authentications.jwtserver.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.RSAKeyProvider;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * @author Piotr Witowski
 */
public class JwtUtils {

    private static final String ROLES = "ROLES";
    private static final String UID = "UID";
    private static final String CREATE_DATE = "CREATED";


    public static String generateJwtToken(String username, List<String> roles) {
        return JWT
            .create()
            .withClaim(ROLES, roles)
            .withClaim(UID,username)
            .withClaim(CREATE_DATE,Calendar.getInstance().getTime())
            .withExpiresAt(new Date(Calendar.getInstance().getTime().getTime() + 10000))
            .sign(Algorithm.none());
    }
}
