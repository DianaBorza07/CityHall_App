package controller;

import dto.UserDTO;
import dto.UserDTORegister;
import org.apache.commons.lang3.StringUtils;
import service.UserService;

import javax.swing.*;

public class AccountController {
    private UserService userService = new UserService();
    private StringBuilder errorMessage = new StringBuilder("Missing ");
    public Boolean login(String username, String password){
        if(StringUtils.isEmpty(username))
            errorMessage.append("username");
        if(StringUtils.isEmpty(password))
            errorMessage.append(" password");
        if(!errorMessage.equals("Missing "))
        {
            JOptionPane.showMessageDialog(null, errorMessage,
                    "ERROR", JOptionPane.WARNING_MESSAGE);
            errorMessage.delete(0,errorMessage.length());
            errorMessage.append("Missing ");
            return false;
        }
        userService.login(username,password);
        return true;
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

    public Boolean isInAdminRole(UserDTO userDTO){
        return userService.isInAdminRole(userDTO);
    }
}
