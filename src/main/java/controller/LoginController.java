package controller;

import service.UserService;

public class LoginController {
    private UserService userService = new UserService();
    public void login(String username, String password){
        userService.login(username,password);
    }
}
