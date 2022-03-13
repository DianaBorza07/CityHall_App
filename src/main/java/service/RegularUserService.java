package service;

import dto.UserDTO;
import entity.DocumentType;
import entity.Request;
import entity.User;
import repository.AdminRepo;
import repository.RegularUserRepo;

import java.math.BigInteger;
import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class RegularUserService {
    private RegularUserRepo regularUserRepo = new RegularUserRepo();

    public List<Request> getRequests(UserDTO user){
        return regularUserRepo.findRequests(user);
    }

    public Boolean addNewRequest(UserDTO userDTO, String description, String docName) throws ParseException {
        AdminRepo adminRepo = new AdminRepo();
        DocumentType documentType = adminRepo.findDocumentByName(docName);
        long millis=System.currentTimeMillis();
        //Date date = new Date(Calendar.getInstance().getTime().getTime());
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
}
