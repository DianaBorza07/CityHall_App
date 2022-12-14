package view;

import controller.RegularUserController;
import dto.UserDTO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class AddressView {

    private JFrame frame;
    private RegularUserController regularUserController = new RegularUserController();
    private UserDTO userDTO;
    private JTable table;

    public AddressView() {
        initialize();
        initFrame();
    }
    public AddressView(UserDTO userDTO) {
        this.userDTO = userDTO;
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
            new RegularUserView(userDTO);
            frame.dispose();
        });
        frame.getContentPane().add(backButton);

        JLabel lblNewLabel_1 = new JLabel("back");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(20, 58, 51, 16);
        frame.getContentPane().add(lblNewLabel_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 92, 674, 317);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(250, 235, 215));
        table.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        scrollPane.setViewportView(table);
        table.setBounds(337, 285, 236, 100);
        table.setModel(new DefaultTableModel(
                new Object[30][30] ,
                new String[] {
                        "Street","Number"
                }
        ));

        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(),20));
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(35);


        JLabel lblNewLabel = new JLabel("My addresses");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 24));
        lblNewLabel.setBounds(158, 10, 385, 72);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(0, 0, 684, 409);
        Image img=new ImageIcon(this.getClass().getResource("/images/background2.jpg")).getImage();
        Image scaledImage=img.getScaledInstance(750, 400, Image.SCALE_DEFAULT);
        lblNewLabel_2.setIcon(new ImageIcon(scaledImage));
        frame.getContentPane().add(lblNewLabel_2);
    }

    private void initFrame(){
        frame.setBounds(100, 100, 694, 442);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table = regularUserController.listAddressesInTable(userDTO,table);
        frame.setVisible(true);
    }
}
