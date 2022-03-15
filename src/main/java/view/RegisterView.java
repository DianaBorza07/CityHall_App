package view;

import controller.AccountController;
import dto.UserDTO;
import dto.UserDTORegister;
import entity.User;

import java.awt.*;

import javax.swing.*;

public class RegisterView {

    private JFrame frame;
    private JTextField name;
    private JTextField email;
    private JPasswordField password;
    private AccountController accountController = new AccountController();

    public RegisterView() {
        initialize();
        initFrame();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255,216,255));
        frame.getContentPane().setLayout(null);

        Image buttonIcon = new ImageIcon(this.getClass().getResource("/images/back.png")).getImage();
        Image scaledImg=buttonIcon.getScaledInstance(50, 50, Image.SCALE_DEFAULT);

        JLabel lblNewLabel_1 = new JLabel("back");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(10, 443, 51, 16);
        frame.getContentPane().add(lblNewLabel_1);

        JButton backButton = new JButton(new ImageIcon(scaledImg));
        backButton.setBounds(10, 402, 56, 57);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(e->{
            new WelcomeView();
            frame.dispose();
        });
        frame.getContentPane().add(backButton);

        JLabel lblTitle = new JLabel("<html>Welcome to Cluj-Napoca city hall</html>");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Forte", Font.PLAIN, 27));
        lblTitle.setBounds(38, 0, 435, 72);
        frame.getContentPane().add(lblTitle);

        JLabel lblSubtitle = new JLabel("Create new account");
        lblSubtitle.setFont(new Font("Sitka Display", Font.ITALIC, 20));
        lblSubtitle.setBounds(160, 70, 162, 22);
        frame.getContentPane().add(lblSubtitle);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        lblName.setBounds(38, 135, 113, 32);
        frame.getContentPane().add(lblName);

        JLabel lblUsername = new JLabel("Email");
        lblUsername.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        lblUsername.setBounds(38, 200, 113, 22);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        lblPassword.setBounds(38, 265, 113, 22);
        frame.getContentPane().add(lblPassword);

        name = new JTextField();
        name.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        name.setBounds(197, 140, 278, 24);
        frame.getContentPane().add(name);
        name.setColumns(10);

        email = new JTextField();
        email.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        email.setBounds(197, 200, 276, 24);
        frame.getContentPane().add(email);
        email.setColumns(10);

        password = new JPasswordField();
        password.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        password.setBounds(197, 265, 276, 24);
        frame.getContentPane().add(password);
        password.setColumns(10);

        JLabel lblRole = new JLabel("Role");
        lblRole.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        lblRole.setBounds(38, 330, 113, 22);
        frame.getContentPane().add(lblRole);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Administrator");
        comboBox.addItem("Regular user");
        comboBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        comboBox.setBounds(197, 330, 276, 26);
        frame.getContentPane().add(comboBox);

        JButton btnRegister = new JButton("Register");
        btnRegister.setForeground(new Color(183, 176, 72));
        btnRegister.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
        btnRegister.setBounds(197, 402, 125, 43);
        btnRegister.addActionListener(a-> {
            UserDTORegister userDTO = new UserDTORegister(name.getText(), email.getText(), password.getText(),comboBox.getSelectedItem().toString());
            if(accountController.register(userDTO)) {
                Object[] options = {"OK"};
                int val = JOptionPane.showOptionDialog(null, "Account created successfully!", "", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (options[0].equals(val) && val >= 0) ;
                {
                    UserDTO userDTO1 = new UserDTO(userDTO.getName(), userDTO.getEmail(), userDTO.getUserRole());
                    name.setText("");
                    password.setText("");
                    email.setText("");
                    if (accountController.isInAdminRole(userDTO1)) {
                        new AdminView();
                        frame.dispose();
                    }
                    else {
                        User loggedUser = accountController.findUser(userDTO1.getEmail());
                        new RegularUserView(new UserDTO(loggedUser.getId(),loggedUser.getName(),loggedUser.getEmail(),loggedUser.getUserRole().getRoleName()));
                        frame.dispose();
                    }
                }
            }

        });
        frame.getContentPane().add(btnRegister);

        JLabel lblNewLabel = new JLabel("");
        Image img=new ImageIcon(this.getClass().getResource("/images/background.png")).getImage();
        lblNewLabel.setIcon(new ImageIcon(img));
        lblNewLabel.setBounds(-17, -13, 545, 494);
        frame.getContentPane().add(lblNewLabel);

    }

    private void initFrame(){
        frame.setBounds(100, 100, 525, 506);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
