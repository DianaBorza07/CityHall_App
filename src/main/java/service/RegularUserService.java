package service;

import dto.UserDTO;
import entity.DocumentType;
import entity.Request;
import entity.User;
import repository.RegularUserRepo;

import javax.print.Doc;
import java.math.BigInteger;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

public class RegularUserService extends UserService{
    private RegularUserRepo regularUserRepo = new RegularUserRepo();

    public List<Request> getRequests(UserDTO user){
        return regularUserRepo.findRequests(user);
    }

    public Boolean addNewRequest(UserDTO userDTO, String description, String docName) throws ParseException {
        DocumentType documentType = regularUserRepo.findDocumentByName(docName);
        long millis=System.currentTimeMillis();
        Date date = new Date(millis);
        User user = regularUserRepo.findUserById(userDTO.getId());
        Request request = new Request();
        request.setApproved(false);
        request.setDocumentType(documentType);
        request.setDescription(description);
        request.setDate(date);
        request.setRequestUser(user);
        request.setId(UUID.randomUUID().toString());
        if(regularUserRepo.getNumberOfRequests(request).compareTo(BigInteger.valueOf(3))>=0)
            return false;
        regularUserRepo.insertNewRequest(request);
        return true;
    }

    public void deleteRequest(String description,Date date){
        Request request = regularUserRepo.findRequestByNameAndDate(description,date);
        regularUserRepo.deleteRequest(request);
    }

    public void updateRequest(String requestName, String newName, String documentType){
        DocumentType document = regularUserRepo.findDocumentByName(documentType);
        regularUserRepo.updateRequest(requestName,newName,document);
    }
}
