package view;

import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class WelcomeView {

    private JFrame frame;

    public WelcomeView() {
        initialize();
        initFrame();
    }
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        Image img=new ImageIcon(this.getClass().getResource("/images/hall2.png")).getImage();
        lblNewLabel_3.setIcon(new ImageIcon(img));
        lblNewLabel_3.setBounds(0, 125, 766, 610);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblTitle = new JLabel("CLUJ-NAPOCA CITY HALL");
        lblTitle.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 30));
        lblTitle.setBounds(218, 10, 374, 71);
        frame.getContentPane().add(lblTitle);


        Image buttonIcon = new ImageIcon(this.getClass().getResource("/images/login1.png")).getImage();
        JButton loginButton = new JButton(new ImageIcon(buttonIcon));
        loginButton.setBounds(52, 86, 108, 81);
        loginButton.setBorder(BorderFactory.createEmptyBorder());
        loginButton.setContentAreaFilled(false);
        loginButton.addActionListener(e->{
            new LoginView();
            frame.dispose();
        });
        frame.getContentPane().add(loginButton);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        lblNewLabel.setBounds(79, 70, 82, 27);
        frame.getContentPane().add(lblNewLabel);

        Image buttonIcon1 = new ImageIcon(this.getClass().getResource("/images/register.png")).getImage();
        JButton registerButton = new JButton(new ImageIcon(buttonIcon1));
        registerButton.setBounds(582, 94, 102, 58);
        registerButton.setBorder(BorderFactory.createEmptyBorder());
        registerButton.setContentAreaFilled(false);
        registerButton.addActionListener(e -> {
            new RegisterView();
            frame.dispose();
        });
        frame.getContentPane().add(registerButton);

        JLabel lblNewLabel_1 = new JLabel("Register");
        lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(602, 70, 87, 27);
        frame.getContentPane().add(lblNewLabel_1);

    }

    private void initFrame(){
        frame.setBounds(100, 100, 780, 782);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

