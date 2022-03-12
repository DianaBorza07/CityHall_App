package start;

import dto.UserDTORegister;
import entity.User;
import entity.UserRole;
import repository.AdminRepo;
import repository.UserRepo;
import service.UserService;
import view.*;

import java.util.List;
import java.util.UUID;

public class ApplicationStart {

    public static void main(String[] args) {
        /*UserRepo ur = new UserRepo();
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("Diana");
        user.setUsername("dianacristina");
        user.setPassword("diana");
        ur.insertNewUser(user);*/

        new LoginView();
        //new RegisterView();
        //new WelcomeView();
        //new ListUsersView();
        //new ListRequestsView();
    }
}
