package controller;

import dto.UserDTO;
import entity.Request;
import org.apache.commons.lang3.StringUtils;
import service.AdminService;

import javax.swing.*;
import java.sql.Date;
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
             table.setValueAt(user.getEmail(),row,1);
             row++;
        }
        return table;
    }

    public JTable listRequestsInTable(JTable table, String document){
        List<Request> results;
        if(document == null) results = adminService.findAllRequests();
        else results = adminService.getRequestsByType(document);
        int row = 0;
        for (Request result:
                results ) {
            table.setValueAt(result.getDescription(),row,0);
            table.setValueAt(result.getDocumentType().getDocumentType(),row,1);
            table.setValueAt(result.getDate(),row,2);
            table.setValueAt(result.getApproved(),row,3);
            table.setValueAt(result.getAddress().getUser().getName(),row,4);
            table.setValueAt(result.getAddress().getStreet(),row,5);
            table.setValueAt(result.getAddress().getNumber(),row,6);
            row++;
        }
        return table;
    }

    public void addNewDocType(String doc){
        if(StringUtils.isEmpty(doc))
            JOptionPane.showMessageDialog(null, "Missing document type",
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        else {
            if(adminService.insertNewDocType(doc))
            JOptionPane.showMessageDialog(null, "Document added",
                "CONFIRM", JOptionPane.PLAIN_MESSAGE);
            else {
                JOptionPane.showMessageDialog(null, "Document already exists",
                        "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public JComboBox addDocuments(JComboBox comboBox){
        List<String> documents = adminService.getAllDocumentsName();
        documents.stream().forEach(d->comboBox.addItem(d));
        return comboBox;
    }

    public void deleteDocument(String docName){
        if(StringUtils.isEmpty(docName)){
            JOptionPane.showMessageDialog(null, "Please select one item ",
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        else {
            adminService.deleteSelectedDocument(docName);
            JOptionPane.showMessageDialog(null, "Document type deleted successfully",
                    "SUCCESS", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public JComboBox listRequestsInCombo(JComboBox comboBox){
        List<Request> requests = adminService.findAllRequests();
        requests.stream().forEach(d->comboBox.addItem(d.getDescription()));
        return comboBox;
    }

    public void deleteRequest(String request){
        if(StringUtils.isEmpty(request)){
            JOptionPane.showMessageDialog(null, "Please select one item ",
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        else {
            adminService.deleteSelectedRequest(request);
            JOptionPane.showMessageDialog(null, "Request deleted successfully",
                    "SUCCESS", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void approveRequest(JTable table){
        int row = table.getSelectedRow();
        String description = table.getValueAt(row,0).toString();
        String date = table.getValueAt(row,2).toString();
        Date date1 = Date.valueOf(date);
        System.out.println(date1);
        adminService.approveRequest(description,date1);
    }

}
