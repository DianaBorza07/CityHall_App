package service;

import dto.UserDTO;
import entity.Address;
import entity.DocumentType;
import entity.Request;
import entity.User;
import repository.RegularUserRepo;

import java.math.BigInteger;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
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

    public void addNewAddress(UserDTO userDTO, String city, String street){
        User user = regularUserRepo.findUserById(userDTO.getId());
        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setUser(user);
        address.setCity(city);
        address.setStreet(street);
        regularUserRepo.addAddress(address);
    }

    public void deleteAddress(UserDTO userDTO, String city, String street){
        User user = regularUserRepo.findUserById(userDTO.getId());
        Address address = regularUserRepo.findAddress(user,city,street);
        regularUserRepo.deleteAddress(address);
    }

    public List<String> getAddressList(UserDTO userDTO){
        User user = regularUserRepo.findUserById(userDTO.getId());
        List<Address> addressList = regularUserRepo.getAllAddresses(user);
        List<String> addressAsString = new ArrayList<>();
        addressList.stream().forEach(a->addressAsString.add(a.getCity()+","+a.getStreet()));
        return addressAsString;
    }

    public List<Address> getAllAddresses(UserDTO userDTO){
        User user = regularUserRepo.findUserById(userDTO.getId());
        List<Address> addressList = regularUserRepo.getAllAddresses(user);
        return  addressList;
    }
}
