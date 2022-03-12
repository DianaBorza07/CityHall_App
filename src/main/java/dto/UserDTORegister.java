package dto;

import entity.User;

public class UserDTORegister {

    private String name;

    private String username;

    private String password;

    private String userRole;

    public UserDTORegister(String name, String username, String password,String role){
        this.name = name;
        this.username = username;
        this.password = password;
        this.userRole = role;
    }

    public UserDTORegister() {}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public User userDTOToUser(){
        User user = new User();
        user.setName(this.name);
        user.setUsername(this.username);
        user.setPassword(this.password);
        return user;
    }

}
