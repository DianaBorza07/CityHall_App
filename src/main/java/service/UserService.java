package service;

import entity.User;
import repository.UserRepo;

public class UserService {
    private UserRepo userRepo = new UserRepo();

    public void login(String username, String password){

        User user = userRepo.findUserByCredentials(username,password);
        if(user == null) System.err.println("User not found!");
        else
            System.out.println("User logged in!");
    }
}
