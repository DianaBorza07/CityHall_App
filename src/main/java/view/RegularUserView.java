package view;

import dto.UserDTO;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RegularUserView {

    private JFrame frame;
    private UserDTO userDTO;

    public RegularUserView() {
        initialize();
        initFrame();
    }

    public RegularUserView(UserDTO user){
        userDTO = user;
        initialize();
        initFrame();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Welcome");
        lblTitle.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 30));
        lblTitle.setBounds(279, 10, 146, 32);
        frame.getContentPane().add(lblTitle);

        JLabel lbl = new JLabel("Choose an operation");
        lbl.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        lbl.setBounds(254, 35, 181, 48);
        frame.getContentPane().add(lbl);

        JButton btnAddAddress = new JButton("Add new building");
        btnAddAddress.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        btnAddAddress.setBounds(139, 110, 170, 35);
        btnAddAddress.addActionListener(a->{
            new AddNewAddressView(userDTO);
            frame.dispose();
        });
        frame.getContentPane().add(btnAddAddress);

        JButton btnDeleteAddress = new JButton("Remove building");
        btnDeleteAddress.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        btnDeleteAddress.setBounds(394, 110, 170, 35);
        btnDeleteAddress.addActionListener(a->{
            new DeleteAddressView(userDTO);
            frame.dispose();
        });
        frame.getContentPane().add(btnDeleteAddress);

        JButton btnView = new JButton("View my requests");
        btnView.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        btnView.setBounds(139, 170, 170, 35);
        btnView.addActionListener(a->{
            new RegularUserRequestsView(userDTO);
            frame.dispose();
        });
        frame.getContentPane().add(btnView);

        JButton btnAdd = new JButton("Add new request");
        btnAdd.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        btnAdd.setBounds(394, 170, 170, 35);
        btnAdd.addActionListener(a->{
            new AddNewRequestView(userDTO);
            frame.dispose();
        });
        frame.getContentPane().add(btnAdd);

        JButton btnUpdate = new JButton("Modify request");
        btnUpdate.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        btnUpdate.setBounds(139, 240, 170, 35);
        btnUpdate.addActionListener(a->{
            new UpdateRequestView(userDTO);
            frame.dispose();
        });
        frame.getContentPane().add(btnUpdate);

        JButton btnDelete = new JButton("Delete request");
        btnDelete.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        btnDelete.setBounds(394, 240, 170, 35);
        btnDelete.addActionListener(a->{
            RegularUserRequestsView view = new RegularUserRequestsView(userDTO);
            view.activateButton();
            frame.dispose();
        });
        frame.getContentPane().add(btnDelete);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        btnLogout.setBounds(394, 308, 170, 35);
        btnLogout.addActionListener(a->{
            new WelcomeView();
            frame.dispose();
        });
        frame.getContentPane().add(btnLogout);

        JButton btnAddress = new JButton("View my addresses");
        btnAddress.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        btnAddress.setBounds(139, 308, 170, 35);
        btnAddress.addActionListener(a->{
            new AddressView(userDTO);
            frame.dispose();
        });
        frame.getContentPane().add(btnAddress);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, -11, 693, 422);
        Image img=new ImageIcon(this.getClass().getResource("/images/background3.png")).getImage();
        Image imgScaled = img.getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        lblNewLabel.setIcon(new ImageIcon(imgScaled));
        frame.getContentPane().add(lblNewLabel);

    }

    private void initFrame(){
        frame.setBounds(100, 100, 717, 453);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
