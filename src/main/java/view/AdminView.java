package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminView {

    private JFrame frame;

    public AdminView() {
        initialize();
        initFrame();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);

        JLabel lbl = new JLabel("Choose an operation");
        lbl.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        lbl.setBounds(196, 40, 211, 32);
        frame.getContentPane().add(lbl);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
        btnLogout.setBounds(339, 308, 150, 50);
        btnLogout.addActionListener(e->{
            new WelcomeView();
            frame.dispose();
        });
        frame.getContentPane().add(btnLogout);

        JButton btnSearch = new JButton("Search request");
        btnSearch.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
        btnSearch.setBounds(91, 308, 150, 50);
        frame.getContentPane().add(btnSearch);

        JButton btnDeleteRequest = new JButton("Delete request");
        btnDeleteRequest.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
        btnDeleteRequest.setBounds(339, 238, 150, 50);
        frame.getContentPane().add(btnDeleteRequest);

        JButton btnApproveRequest = new JButton("Approve request");
        btnApproveRequest.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
        btnApproveRequest.setBounds(91, 238, 150, 50);
        frame.getContentPane().add(btnApproveRequest);

        JButton btnUsers = new JButton("View all users");
        btnUsers.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
        btnUsers.setBounds(91, 98, 150, 50);
        btnUsers.addActionListener(e->{
            new ListUsersView();
            frame.dispose();
        });
        frame.getContentPane().add(btnUsers);

        JButton btnViewRequests = new JButton("View all requests");
        btnViewRequests.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
        btnViewRequests.setBounds(339, 168, 150, 50);
        frame.getContentPane().add(btnViewRequests);

        JButton btnDeleteDoc = new JButton("<html>Delete document type</html>");
        btnDeleteDoc.setVerticalAlignment(SwingConstants.TOP);
        btnDeleteDoc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnDeleteDoc.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
        btnDeleteDoc.setBounds(91, 168, 150, 50);
        frame.getContentPane().add(btnDeleteDoc);

        JButton btnNewType = new JButton("<html>Add new document type</html>");
        btnNewType.setVerticalAlignment(SwingConstants.TOP);
        btnNewType.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
        btnNewType.setBounds(339, 98, 150, 50);
        frame.getContentPane().add(btnNewType);

        JLabel lblTitle = new JLabel("Welcome");
        lblTitle.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 30));
        lblTitle.setBounds(228, 10, 146, 32);
        frame.getContentPane().add(lblTitle);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, -11, 591, 422);
        Image img=new ImageIcon(this.getClass().getResource("/images/background3.png")).getImage();
        lblNewLabel.setIcon(new ImageIcon(img));
        frame.getContentPane().add(lblNewLabel);
    }

    private void initFrame(){
        frame.setBounds(100, 100, 592, 428);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
