package controller;

import dto.UserDTO;
import entity.Request;
import service.AdminService;
import service.UserService;

import javax.swing.*;
import java.util.List;

public class AdminController {
    private AdminService adminService = new AdminService();

    private List<UserDTO> findUsers(){
        List<UserDTO> users = adminService.findAllUsers();
        if(users.isEmpty())
            JOptionPane.showMessageDialog(null, "There are no users registered",
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        return users;
    }

    public JTable listUsersInTable(JTable table){
        List<UserDTO> users = findUsers();
        int row = 0;
        for (UserDTO user:
             users ) {
             table.setValueAt(user.getName(),row,0);
             table.setValueAt(user.getUsername(),row,1);
             row++;
        }
        return table;
    }

    public JTable listRequestsInTable(JTable table){
        List<Request> results = adminService.findAllRequests();
        int row = 0;
        for (Request result:
                results ) {
            table.setValueAt(result.getDescription(),row,0);
            //table.setValueAt(result.getDocumentType().getDocumentType(),row,1);
            table.setValueAt(result.getDate(),row,2);
            table.setValueAt(result.getApproved(),row,3);
            //table.setValueAt(result.getRequestUser().getName(),row,4);
            row++;
        }
        return table;
    }

}
