package pl.tim3erland.authentications.jwtserver.dao;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users")
public class UsersDao {
    private String usUid;
    private String usLogin;
    private String usPassword;
    private Object usCreateDate;
    private Collection<UsersRolesDao> usersRolesByUsUid;

    @Id
    @Column(name = "us_uid")
    public String getUsUid() {
        return usUid;
    }

    public void setUsUid(String usUid) {
        this.usUid = usUid;
    }

    @Basic
    @Column(name = "us_login")
    public String getUsLogin() {
        return usLogin;
    }

    public void setUsLogin(String usLogin) {
        this.usLogin = usLogin;
    }

    @Basic
    @Column(name = "us_password")
    public String getUsPassword() {
        return usPassword;
    }

    public void setUsPassword(String usPassword) {
        this.usPassword = usPassword;
    }

    @Basic
    @Column(name = "us_create_date")
    public Object getUsCreateDate() {
        return usCreateDate;
    }

    public void setUsCreateDate(Object usCreateDate) {
        this.usCreateDate = usCreateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersDao usersDao = (UsersDao) o;
        return Objects.equals(usUid, usersDao.usUid) &&
                Objects.equals(usLogin, usersDao.usLogin) &&
                Objects.equals(usPassword, usersDao.usPassword) &&
                Objects.equals(usCreateDate, usersDao.usCreateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usUid, usLogin, usPassword, usCreateDate);
    }

    @OneToMany(mappedBy = "usersByUsUsUid")
    public Collection<UsersRolesDao> getUsersRolesByUsUid() {
        return usersRolesByUsUid;
    }

    public void setUsersRolesByUsUid(Collection<UsersRolesDao> usersRolesByUsUid) {
        this.usersRolesByUsUid = usersRolesByUsUid;
    }
}
