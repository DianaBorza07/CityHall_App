package dto;

import entity.User;

public class UserDTO {

    private String id;

    private String name;

    private String email;

    private String userRole;

    public UserDTO(String name, String email, String role){
        this.name = name;
        this.email = email;
        this.userRole = role;
    }

    public UserDTO(String id, String name, String email, String role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.userRole = role;
    }

    public UserDTO() {}

    public UserDTO(String email){
        this.email = email;
    }

    public UserDTO(String name,String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public User dtoToUser(){
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setId(id);
        return user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
