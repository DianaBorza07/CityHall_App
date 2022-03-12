package service;

import dto.UserDTORegister;
import entity.User;
import entity.UserRole;
import repository.UserRepo;
import repository.UserRoleRepo;
import java.util.UUID;

public class UserService {
    private UserRepo userRepo = new UserRepo();
    private UserRoleRepo userRoleRepo = new UserRoleRepo();

    public void login(String username, String password){

        User user = userRepo.findUserByCredentials(username,password);
        if(user == null) System.err.println("User not found!");
        else
            System.out.println("User logged in!");
    }

    public void register(UserDTORegister user){
        UserRole userRole = userRoleRepo.findUserRoleByName(user.getUserRole());
        System.out.println("User Role:"+userRole.getRoleName());
        User newUser = user.userDTOToUser();
        newUser.setUserRole(userRole);
        newUser.setId(UUID.randomUUID().toString());
        userRepo.insertNewUser(newUser);
    }
}
