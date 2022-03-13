package entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class UserRole {

    @Id
    private String id;

    @Column
    private String roleName;

    @OneToMany(mappedBy = "userRole")
    private List<User> users;

    public UserRole(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
