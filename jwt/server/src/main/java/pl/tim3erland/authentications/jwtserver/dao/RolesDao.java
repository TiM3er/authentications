package pl.tim3erland.authentications.jwtserver.dao;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class RolesDao {
    private String roUid;
    private String roCode;
    private String roName;
    private String roDescription;
    private Collection<UsersRolesDao> usersRolesByRoUid;

    @Id
    @Column(name = "ro_uid")
    public String getRoUid() {
        return roUid;
    }

    public void setRoUid(String roUid) {
        this.roUid = roUid;
    }

    @Basic
    @Column(name = "ro_code")
    public String getRoCode() {
        return roCode;
    }

    public void setRoCode(String roCode) {
        this.roCode = roCode;
    }

    @Basic
    @Column(name = "ro_name")
    public String getRoName() {
        return roName;
    }

    public void setRoName(String roName) {
        this.roName = roName;
    }

    @Basic
    @Column(name = "ro_description")
    public String getRoDescription() {
        return roDescription;
    }

    public void setRoDescription(String roDescription) {
        this.roDescription = roDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolesDao rolesDao = (RolesDao) o;
        return Objects.equals(roUid, rolesDao.roUid) &&
                Objects.equals(roCode, rolesDao.roCode) &&
                Objects.equals(roName, rolesDao.roName) &&
                Objects.equals(roDescription, rolesDao.roDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roUid, roCode, roName, roDescription);
    }

    @OneToMany(mappedBy = "rolesByRoRoUid")
    public Collection<UsersRolesDao> getUsersRolesByRoUid() {
        return usersRolesByRoUid;
    }

    public void setUsersRolesByRoUid(Collection<UsersRolesDao> usersRolesByRoUid) {
        this.usersRolesByRoUid = usersRolesByRoUid;
    }
}
