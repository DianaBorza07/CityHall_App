package service;

import dto.UserDTO;
import entity.DocumentType;
import entity.Request;
import entity.User;
import repository.AdminRepo;

import javax.print.Doc;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AdminService extends UserService{
    private AdminRepo adminRepo = new AdminRepo();

    public List<UserDTO> findAllUsers(){
        List<User> users = adminRepo.findAllUsers();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user :
             users) {
            UserDTO newUser = new UserDTO(user.getName(),user.getUsername());
            userDTOList.add(newUser);
        }
        return userDTOList;
    }

    public List<Request> findAllRequests(){
        List<Request> requests = adminRepo.getAllRequests();
        return requests;
    }

    public Boolean insertNewDocType(String doc){
        return adminRepo.createNewDocumentType(doc);
    }


    public void deleteSelectedDocument(String doc){
        adminRepo.deleteDocument(doc);
    }

    public void deleteSelectedRequest(String request){adminRepo.deleteRequest(request);}

    public void approveRequest(String description, Date date){ adminRepo.approveRequest(description,date); }

    public List<Request> getRequestsByType(String documentName){
        DocumentType documentType = adminRepo.findDocumentByName(documentName);
        return adminRepo.getRequestsByType(documentType);
    }
}
