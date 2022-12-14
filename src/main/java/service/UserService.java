package service;

import dto.UserDTO;
import dto.UserDTORegister;
import entity.DocumentType;
import entity.User;
import entity.UserRole;
import repository.UserRepo;
import repository.UserRoleRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {
    private UserRepo userRepo = new UserRepo();
    private UserRoleRepo userRoleRepo = new UserRoleRepo();

    public Boolean login(String username, String password){

        User user = userRepo.findUserByCredentials(username,password);
        if(user == null) {
            System.err.println("User not found!");
            return  false;
        }
        else
            System.out.println("User logged in!");
        return true;
    }

    public Boolean register(UserDTORegister user){
        UserRole userRole = userRoleRepo.findUserRoleByName(user.getUserRole());
        User newUser = user.userDTOToUser();
        newUser.setUserRole(userRole);
        newUser.setId(UUID.randomUUID().toString());
        return userRepo.insertNewUser(newUser);
    }

    public Boolean isInAdminRole(UserDTO userDTO){
        User user = userRepo.findUserByEmail(userDTO.getEmail());
        if(user.getUserRole().getRoleName().equals("Administrator"))
            return true;
        return false;
    }

    public User findUserByUsername(String username){
        return userRepo.findUserByEmail(username);
    }

    public List<String> getAllDocumentsName(){
        List<DocumentType> documentTypes = userRepo.getAllDocuments();
        List<String> documentNameList = new ArrayList<>();
        documentTypes.stream().forEach(d->documentNameList.add(d.getDocumentType()));
        return  documentNameList;
    }
}
