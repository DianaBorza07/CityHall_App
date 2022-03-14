package view;


import controller.RegularUserController;
import dto.UserDTO;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

public class AddNewAddressView {

    private JFrame frame;
    private JTextField city;
    private JTextField street;
    private RegularUserController regularUserController= new RegularUserController();
    private UserDTO userDTO;

    public AddNewAddressView() {
        initialize();
        initFrame();
    }

    public AddNewAddressView(UserDTO userDTO) {
        this.userDTO = userDTO;
        initialize();
        initFrame();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Add new address");
        lblTitle.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 30));
        lblTitle.setBounds(144, 10, 254, 60);
        frame.getContentPane().add(lblTitle);

        JLabel lblCity = new JLabel("Insert city");
        lblCity.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        lblCity.setBounds(55, 124, 119, 34);
        frame.getContentPane().add(lblCity);

        city = new JTextField();
        city.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        city.setBounds(232, 124, 248, 30);
        frame.getContentPane().add(city);
        city.setColumns(10);

        JLabel lblStreet = new JLabel("Insert street name");
        lblStreet.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        lblStreet.setBounds(55, 230, 169, 24);
        frame.getContentPane().add(lblStreet);

        street = new JTextField();
        street.setBounds(232, 230, 254, 30);
        frame.getContentPane().add(street);
        street.setColumns(10);

        Image buttonIcon1 = new ImageIcon(this.getClass().getResource("/images/ok.png")).getImage();
        Image scaledImg1=buttonIcon1.getScaledInstance(50, 50, Image.SCALE_DEFAULT);

        JButton confirmButton = new JButton(new ImageIcon(scaledImg1));
        confirmButton.setBounds(370, 297, 85, 57);
        confirmButton.setBorder(BorderFactory.createEmptyBorder());
        confirmButton.setContentAreaFilled(false);
        confirmButton.addActionListener(a->{
            regularUserController.addAddress(userDTO,city.getText(),street.getText());
            city.setText("");
            street.setText("");
        });
        frame.getContentPane().add(confirmButton);

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

        JLabel lblOk = new JLabel("Confirm");
        lblOk.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        lblOk.setBounds(382, 349, 104, 40);
        frame.getContentPane().add(lblOk);

        JLabel lblNewLabel = new JLabel("");
        Image img=new ImageIcon(this.getClass().getResource("/images/background4.jpg")).getImage();
        Image imgScaled = img.getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        lblNewLabel.setIcon(new ImageIcon(imgScaled));
        lblNewLabel.setBounds(0, 0, 654, 424);
        frame.getContentPane().add(lblNewLabel);
    }

    private void initFrame(){
        frame.setBounds(100, 100, 533, 455);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
