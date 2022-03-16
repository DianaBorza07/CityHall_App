package view;

import controller.RegularUserController;
import dto.UserDTO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RegularUserRequestsView {

    private JFrame frame;
    private UserDTO user;
    private JTable table;
    private JButton btnDelete;
    private RegularUserController regularUserController = new RegularUserController();

    public RegularUserRequestsView() {
        initialize();
        initFrame();
    }

    public RegularUserRequestsView(UserDTO user) {
        this.user = user;
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
        backButton.addActionListener(a->{
            new RegularUserView(user);
            frame.dispose();
        });
        frame.getContentPane().add(backButton);

        JLabel lblNewLabel_1 = new JLabel("back");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(20, 58, 51, 16);
        frame.getContentPane().add(lblNewLabel_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 92, 728, 317);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(250, 235, 215));
        table.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        scrollPane.setViewportView(table);
        table.setBounds(337, 285, 236, 100);
        table.setModel(new DefaultTableModel(
                new Object[30][30] ,
                new String[] {
                        "Description","Document type","Date","Approved","Address street","Address number"
                }
        ));

        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(40);
        table.getColumnModel().getColumn(2).setPreferredWidth(40);
        table.getColumnModel().getColumn(3).setPreferredWidth(40);
        table.getColumnModel().getColumn(4).setPreferredWidth(40);
        table.getColumnModel().getColumn(5).setPreferredWidth(40);
        table.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(),20));
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(35);


        JLabel lblNewLabel = new JLabel("My requests");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 24));
        lblNewLabel.setBounds(158, 10, 385, 72);
        frame.getContentPane().add(lblNewLabel);

        btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
        btnDelete.setBounds(553, 46, 113, 33);
        btnDelete.setVisible(false);
        btnDelete.addActionListener(a->{
            int selectedRow = table.getSelectedRow();
            if(selectedRow!=-1) {
                regularUserController.deleteRequest(table.getValueAt(selectedRow, 0).toString(), table.getValueAt(selectedRow, 2).toString());
                JOptionPane.showMessageDialog(null, "Request deleted ",
                        "SUCCESS", JOptionPane.PLAIN_MESSAGE);

            }
            else
                JOptionPane.showMessageDialog(null, "Please select one item ",
                        "ERROR", JOptionPane.WARNING_MESSAGE);
            clearTable();
            update();
        });
        frame.getContentPane().add(btnDelete);


        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(0, 0, 750, 409);
        Image img=new ImageIcon(this.getClass().getResource("/images/background2.jpg")).getImage();
        Image scaledImage=img.getScaledInstance(750, 400, Image.SCALE_DEFAULT);
        lblNewLabel_2.setIcon(new ImageIcon(scaledImage));
        frame.getContentPane().add(lblNewLabel_2);
    }

    private void initFrame(){
        frame.setBounds(100, 100, 762, 448);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        update();
        frame.setVisible(true);
    }

    private void update(){
        table = regularUserController.listRequests(user,table);
    }

    public void activateButton(){
        btnDelete.setVisible(true);
    }

    private void clearTable(){
        for(int row=table.getModel().getRowCount()-1; row>=0;row--)
        {
            table.setValueAt(null,row,0);
            table.setValueAt(null,row,1);
            table.setValueAt(null,row,2);
            table.setValueAt(null,row,3);
            table.setValueAt(null,row,4);
            table.setValueAt(null,row,5);
        }
    }

}

