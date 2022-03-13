package start;

import dto.UserDTORegister;
import entity.User;
import entity.UserRole;
import repository.AdminRepo;
import repository.UserRepo;
import service.UserService;
import view.*;

import java.sql.Date;
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
        //new AddNewDocTypeView();
        long millis=System.currentTimeMillis();
        //Date date = new Date(Calendar.getInstance().getTime().getTime());
        Date date = new Date(millis);
        System.out.println(date);
    }
}
