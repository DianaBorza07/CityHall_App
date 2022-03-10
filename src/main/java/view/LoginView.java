package view;

import controller.LoginController;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class LoginView {

    private JFrame frame;
    private JTextField username;
    private JTextField password;
    private LoginController loginController = new LoginController();

    /**
     * Create the application.
     */
    public LoginView() {
        initialize();
        initFrame();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Login");
        frame.getContentPane().setBackground(new Color(230, 230, 250));
        frame.getContentPane().setLayout(null);

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
        btnLogin.addActionListener(a -> loginController.login(username.getText().toString(),password.getText().toString()));
        frame.getContentPane().add(btnLogin);
    }

    private void initFrame(){

        frame.setBounds(100, 100, 450, 307);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
