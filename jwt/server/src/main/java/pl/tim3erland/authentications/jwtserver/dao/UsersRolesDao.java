package pl.tim3erland.authentications.jwtserver.dao;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_roles")
public class UsersRolesDao {
    private String urUid;
    private UsersDao usersByUsUsUid;
    private RolesDao rolesByRoRoUid;

    @Id
    @Column(name = "ur_uid")
    public String getUrUid() {
        return urUid;
    }

    public void setUrUid(String urUid) {
        this.urUid = urUid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersRolesDao that = (UsersRolesDao) o;
        return Objects.equals(urUid, that.urUid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(urUid);
    }

    @ManyToOne
    @JoinColumn(name = "us_us_uid", referencedColumnName = "us_uid", nullable = false)
    public UsersDao getUsersByUsUsUid() {
        return usersByUsUsUid;
    }

    public void setUsersByUsUsUid(UsersDao usersByUsUsUid) {
        this.usersByUsUsUid = usersByUsUsUid;
    }

    @ManyToOne
    @JoinColumn(name = "ro_ro_uid", referencedColumnName = "ro_uid", nullable = false)
    public RolesDao getRolesByRoRoUid() {
        return rolesByRoRoUid;
    }

    public void setRolesByRoRoUid(RolesDao rolesByRoRoUid) {
        this.rolesByRoRoUid = rolesByRoRoUid;
    }
}
