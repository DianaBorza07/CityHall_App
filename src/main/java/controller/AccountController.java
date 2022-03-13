package controller;

import dto.UserDTO;
import dto.UserDTORegister;
import org.apache.commons.lang3.StringUtils;
import service.UserService;

import javax.swing.*;

public class AccountController {
    private UserService userService = new UserService();
    private StringBuilder errorMessage = new StringBuilder("Missing ");
    private StringBuilder insertMessage = new StringBuilder("Please insert ");
    public Boolean login(String username, String password){
        if(StringUtils.isEmpty(username))
            errorMessage.append("username");
        if(StringUtils.isEmpty(password))
            errorMessage.append(" password");
        if(errorMessage.equals("Missing "))
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
    public Boolean register(UserDTORegister userDTORegister){
        if(StringUtils.isEmpty(userDTORegister.getName()))
            insertMessage.append("name ");
        if(StringUtils.isEmpty(userDTORegister.getUsername()))
            insertMessage.append("username ");
        if(StringUtils.isEmpty(userDTORegister.getPassword()))
            insertMessage.append("password ");
        if(StringUtils.isEmpty(userDTORegister.getUserRole()))
            insertMessage.append("role ");
        if(!insertMessage.equals("Please insert ")) {
            if (userService.register(userDTORegister))
                return  true;
            else {
                JOptionPane.showMessageDialog(null, "Username already exists. Please insert new one",
                        "ERROR", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        else {
            JOptionPane.showMessageDialog(null, insertMessage,
                    "ERROR", JOptionPane.WARNING_MESSAGE);
            insertMessage.delete(0,insertMessage.length());
            insertMessage.append("Please insert ");
        }
        return false;
    }

    public Boolean isInAdminRole(UserDTO userDTO){
        return userService.isInAdminRole(userDTO);
    }
}
