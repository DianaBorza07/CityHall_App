package dto;

import entity.User;

public class UserDTO {
    private String name;

    private String username;

    private String userRole;

    public UserDTO(String name, String username,String role){
        this.name = name;
        this.username = username;
        this.userRole = role;
    }

    public UserDTO() {}

    public UserDTO(String username){
        this.username = username;
    }

    public UserDTO(String name,String username){
        this.name = name;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        user.setUsername(this.username);
        return user;
    }

}
