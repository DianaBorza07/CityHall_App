package view;

import controller.RegularUserController;
import dto.UserDTO;
import entity.User;
import service.RegularUserService;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AddNewRequestView {

    private JFrame frame;
    private JTextField description;
    private JComboBox comboBox;
    private UserDTO userDTO;
    private RegularUserController userController= new RegularUserController();

    public AddNewRequestView() {
        initialize();
        initFrame();
    }
    public AddNewRequestView(UserDTO user) {
        this.userDTO = user;
        initialize();
        initFrame();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Create new request");
        lblTitle.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 31));
        lblTitle.setBounds(186, 10, 294, 64);
        frame.getContentPane().add(lblTitle);

        JLabel lblDescription = new JLabel("Insert request description");
        lblDescription.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        lblDescription.setBounds(54, 148, 242, 32);
        frame.getContentPane().add(lblDescription);

        JLabel lblDocType = new JLabel("Select document type");
        lblDocType.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        lblDocType.setBounds(56, 222, 220, 27);
        frame.getContentPane().add(lblDocType);

        description = new JTextField();
        description.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        description.setBounds(306, 148, 310, 31);
        frame.getContentPane().add(description);
        description.setColumns(10);

        comboBox = new JComboBox();
        comboBox.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        comboBox.setBounds(306, 222, 310, 29);
        frame.getContentPane().add(comboBox);

        Image buttonIcon1 = new ImageIcon(this.getClass().getResource("/images/ok.png")).getImage();
        Image scaledImg1=buttonIcon1.getScaledInstance(50, 50, Image.SCALE_DEFAULT);

        JButton confirmButton = new JButton(new ImageIcon(scaledImg1));
        confirmButton.setBounds(324, 287, 85, 57);
        confirmButton.setBorder(BorderFactory.createEmptyBorder());
        confirmButton.setContentAreaFilled(false);
        confirmButton.addActionListener(a-> {
            try {
                userController.addRequest(userDTO,description.getText(),comboBox.getSelectedItem().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            description.setText("");
        });
        frame.getContentPane().add(confirmButton);

        JLabel lblOk = new JLabel("<html>Confirm selection</html>");
        lblOk.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        lblOk.setBounds(336, 339, 104, 40);
        frame.getContentPane().add(lblOk);

        Image buttonIcon = new ImageIcon(this.getClass().getResource("/images/back.png")).getImage();
        Image scaledImg=buttonIcon.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        JButton backButton = new JButton(new ImageIcon(scaledImg));
        backButton.setBounds(10, 350, 56, 57);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(a->{
            new RegularUserView(userDTO);
            frame.dispose();
        });
        frame.getContentPane().add(backButton);

        JLabel lblNewLabel_1 = new JLabel("back");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(20, 398, 51, 16);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("");
        Image img=new ImageIcon(this.getClass().getResource("/images/background4.jpg")).getImage();
        Image imgScaled = img.getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        lblNewLabel.setIcon(new ImageIcon(imgScaled));
        lblNewLabel.setBounds(0, 0, 654, 424);
        frame.getContentPane().add(lblNewLabel);
    }

    private void initFrame(){
        frame.setBounds(100, 100, 668, 461);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comboBox = userController.getDocumentsType(comboBox);
        frame.setVisible(true);
    }

}

