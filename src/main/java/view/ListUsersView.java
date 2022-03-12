package view;

import controller.AdminController;
import dto.UserDTO;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.util.List;

public class ListUsersView {

    private JFrame frame;
    private JTable table;
    private AdminController adminController = new AdminController();

    public ListUsersView() {
        initialize();
        initFrame();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);

        Image buttonIcon = new ImageIcon(this.getClass().getResource("/images/back.png")).getImage();
        Image scaledImg=buttonIcon.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        JButton backButton = new JButton(new ImageIcon(scaledImg));
        backButton.setBounds(10, 10, 56, 57);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(e->{
            new AdminView();
            frame.dispose();
        });
        frame.getContentPane().add(backButton);

        JLabel lblNewLabel_1 = new JLabel("back");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(20, 58, 51, 16);
        frame.getContentPane().add(lblNewLabel_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 92, 560, 317);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(250, 235, 215));
        table.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        scrollPane.setViewportView(table);
        table.setBounds(337, 285, 236, 100);
        table.setModel(new DefaultTableModel(
                new Object[30][30] ,
                new String[] {
                        "Name", "Username"
                }
        ));

        table.getColumnModel().getColumn(0).setPreferredWidth(90);
        table.getColumnModel().getColumn(1).setPreferredWidth(90);
        table.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(),20));
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(35);


        JLabel lblNewLabel = new JLabel("All users of the city hall application");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 24));
        lblNewLabel.setBounds(76, 22, 453, 38);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(0, 0, 570, 409);
        Image img=new ImageIcon(this.getClass().getResource("/images/background2.jpg")).getImage();
        lblNewLabel_2.setIcon(new ImageIcon(img));
        frame.getContentPane().add(lblNewLabel_2);;


    }

    private void initFrame(){
        frame.setBounds(100, 100, 594, 456);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table = adminController.listUsersInTable(table);
        frame.setVisible(true);
    }

}
