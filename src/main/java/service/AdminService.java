package service;

import dto.UserDTO;
import entity.Request;
import entity.User;
import repository.AdminRepo;

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
}