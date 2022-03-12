package entity;
import javax.persistence.*;

@Entity
@Table
public class UserRole {

    @Id
    private String id;

    @Column
    private String roleName;

    @OneToOne(mappedBy = "userRole")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
