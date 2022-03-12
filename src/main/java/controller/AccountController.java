package controller;

import dto.UserDTORegister;
import org.apache.commons.lang3.StringUtils;
import service.UserService;

import javax.swing.*;

public class AccountController {
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
    public void register(UserDTORegister userDTORegister){
        if(StringUtils.isEmpty(userDTORegister.getName())){
            JOptionPane.showMessageDialog(null, "Please insert your name",
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        else if(StringUtils.isEmpty(userDTORegister.getUsername())){
            JOptionPane.showMessageDialog(null, "Please insert username",
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        else if(StringUtils.isEmpty(userDTORegister.getPassword())){
            JOptionPane.showMessageDialog(null, "Please insert one password",
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        else if(StringUtils.isEmpty(userDTORegister.getUserRole())){
            JOptionPane.showMessageDialog(null, "Please select one role",
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        else
            userService.register(userDTORegister);
    }
}
