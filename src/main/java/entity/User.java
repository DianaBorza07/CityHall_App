package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	private String id;
	
	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Address> addressList;

	@ManyToOne
	@JoinColumn(name = "user_role_id")
	private UserRole userRole;

	@OneToMany( mappedBy = "requestUser")
	private List<Request> requests;


	public User(String name) {
		this.name = name;
	}
	
	public User() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String username) {
		this.email = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public List<Request> getRequests() {
		return requests;
	}
}
