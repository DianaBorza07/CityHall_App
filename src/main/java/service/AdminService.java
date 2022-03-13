package service;

import dto.UserDTO;
import entity.DocumentType;
import entity.Request;
import entity.User;
import repository.AdminRepo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AdminService {
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

    public List<String> getAllDocumentsName(){
        List<DocumentType> documentTypes = adminRepo.getAllDocuments();
        List<String> documentNameList = new ArrayList<>();
        documentTypes.stream().forEach(d->documentNameList.add(d.getDocumentType()));
        return  documentNameList;
    }

    public void deleteSelectedDocument(String doc){
        adminRepo.deleteDocument(doc);
    }

    public void deleteSelectedRequest(String request){adminRepo.deleteRequest(request);}

    public void approveRequest(String description, Date date){ adminRepo.approveRequest(description,date); }
}
