package controller;

import org.apache.commons.lang3.StringUtils;
import service.UserService;

import javax.swing.*;

public class LoginController {
    private UserService userService = new UserService();
    public void login(String username, String password){
        if(StringUtils.isEmpty(username)){
            JOptionPane.showMessageDialog(null, "Please insert username",
                    "ERROR", JOptionPane.WARNING_MESSAGE); //
        }
        else
            if(StringUtils.isEmpty(password)){
            JOptionPane.showMessageDialog(null, "Please insert password",
                    "ERROR", JOptionPane.WARNING_MESSAGE); //
            }
            else userService.login(username,password);
    }
}
