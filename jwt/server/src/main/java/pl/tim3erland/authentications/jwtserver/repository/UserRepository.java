package pl.tim3erland.authentications.jwtserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.tim3erland.authentications.jwtserver.dao.UsersDao;

@Repository
public interface UserRepository extends JpaRepository<UsersDao, String> {

    @Query("select ud from UsersDao ud left join ud.usersRolesByUsUid ur left join ur.rolesByRoRoUid rr where ud.usLogin like :login and ud.usPassword like :password")
    UsersDao getUserByLoginAndPassword(@Param("login") String login, @Param("password") String passowd);
}
