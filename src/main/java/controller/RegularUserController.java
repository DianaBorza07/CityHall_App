package controller;

import dto.UserDTO;
import entity.Request;
import service.AdminService;
import service.RegularUserService;

import javax.swing.*;
import java.text.ParseException;
import java.util.List;

public class RegularUserController {
    private RegularUserService regularUserService = new RegularUserService();

    public JTable listRequests(UserDTO user ,JTable table){
        List<Request> requestList = regularUserService.getRequests(user);
        int row =0;
        for (Request re:
             requestList) {
            table.setValueAt(re.getDescription(),row,0);
            table.setValueAt(re.getDocumentType().getDocumentType(),row,1);
            table.setValueAt(re.getDate(),row,2);
            table.setValueAt(re.getApproved(),row,3);
            row++;
        }
        return table;
    }

    public void addRequest(UserDTO user, String description, String docType) throws ParseException {
        if(regularUserService.addNewRequest(user,description,docType))
            JOptionPane.showMessageDialog(null, "Request added",
                    "SUCCESS", JOptionPane.PLAIN_MESSAGE);
        else JOptionPane.showMessageDialog(null, "You cannot add more than three requests of same document type",
                "ERROR", JOptionPane.WARNING_MESSAGE);
    }

    public JComboBox getDocumentsType(JComboBox combo ){
        AdminService adminService = new AdminService();
        List<String> documentTypes = adminService.getAllDocumentsName();
        documentTypes.stream().forEach(d->combo.addItem(d));
        return combo;
    }
}
