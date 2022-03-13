package controller;

import dto.UserDTO;
import entity.Request;
import org.apache.commons.lang3.StringUtils;
import service.RegularUserService;

import javax.swing.*;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

public class RegularUserController {
    private RegularUserService regularUserService = new RegularUserService();
    private StringBuilder message = new StringBuilder("Please select ");

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
        List<String> documentTypes = regularUserService.getAllDocumentsName();
        documentTypes.stream().forEach(d->combo.addItem(d));
        return combo;
    }

    public void deleteRequest(String description, String date){
        regularUserService.deleteRequest(description, Date.valueOf(date));
    }

    public JComboBox getRequestNames(JComboBox combo ,UserDTO userDTO){
        List<Request> requests = regularUserService.getRequests(userDTO);
        requests.stream().forEach(d->combo.addItem(d.getDescription()));
        return combo;
    }

    public void updateRequest(String requestName, String newName, String documentType){
        if(StringUtils.isEmpty(requestName))
            message.append("document name ");
        if(StringUtils.isEmpty(newName))
            message.append("new document name");
        if(StringUtils.isEmpty(documentType))
            message.append("document type ");
        if(message.compareTo(new StringBuilder("Please select "))==0)
        {
            regularUserService.updateRequest(requestName,newName,documentType);
            JOptionPane.showMessageDialog(null, "Request updated successfully",
                "SUCCESS", JOptionPane.PLAIN_MESSAGE);
            message.delete(0,message.length());
            message.append("Please select ");
        }
        else {
            JOptionPane.showMessageDialog(null, message,
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        }

    }
}
