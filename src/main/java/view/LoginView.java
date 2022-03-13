package view;

import controller.AccountController;
import dto.UserDTO;
import entity.User;

import javax.swing.*;
import java.awt.*;

public class LoginView {

    private JFrame frame;
    private JTextField username;
    private JTextField password;
    private AccountController accountController = new AccountController();

    public LoginView() {
        initialize();
        initFrame();
    }

    private void initialize() {
        frame = new JFrame("Login");
        frame.getContentPane().setBackground(new Color(230, 230, 250));
        frame.getContentPane().setLayout(null);

        Image buttonIcon = new ImageIcon(this.getClass().getResource("/images/back.png")).getImage();
        Image scaledImg=buttonIcon.getScaledInstance(50, 50, Image.SCALE_DEFAULT);

        JLabel lblNewLabel_1 = new JLabel("back");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(10, 244, 51, 16);
        frame.getContentPane().add(lblNewLabel_1);

        JButton backButton = new JButton(new ImageIcon(scaledImg));
        backButton.setBounds(10, 203, 56, 57);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(e->{
            new WelcomeView();
            frame.dispose();
        });
        frame.getContentPane().add(backButton);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 13));
        username.setBounds(206, 60, 186, 29);
        frame.getContentPane().add(username);
        username.setColumns(10);

        password = new JTextField();
        password.setFont(new Font("Tahoma", Font.PLAIN, 13));
        password.setBounds(206, 115, 186, 29);
        frame.getContentPane().add(password);
        password.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblUsername.setBounds(49, 65, 117, 16);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPassword.setBounds(49, 122, 95, 13);
        frame.getContentPane().add(lblPassword);

        JLabel lblTitle = new JLabel("Log In");
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitle.setBounds(159, 10, 103, 29);
        frame.getContentPane().add(lblTitle);

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnLogin.setBounds(150, 179, 97, 29);
        btnLogin.addActionListener(a ->{
            if(accountController.login(username.getText().toString(),password.getText().toString()))
                if(accountController.isInAdminRole(new UserDTO(username.getText()))){
                    new AdminView();
                    frame.dispose();
                }
            else {
                User loggedUser = accountController.findUser(username.getText());
                new RegularUserView(new UserDTO(loggedUser.getId(),loggedUser.getName(),loggedUser.getUsername(),loggedUser.getUserRole().getRoleName()));
                frame.dispose();
                }

        });
        frame.getContentPane().add(btnLogin);

        JLabel lblNewLabel = new JLabel("");
        Image img=new ImageIcon(this.getClass().getResource("/images/background.png")).getImage();
        Image newImage=img.getScaledInstance(450, 300, Image.SCALE_DEFAULT);
        lblNewLabel.setIcon(new ImageIcon(newImage));
        lblNewLabel.setBounds(-17, -13, 470, 308);
        frame.getContentPane().add(lblNewLabel);
    }

    private void initFrame(){

        frame.setBounds(100, 100, 450, 307);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
