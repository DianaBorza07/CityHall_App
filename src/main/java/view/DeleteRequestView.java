package view;

import controller.AdminController;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DeleteRequestView {

    private JFrame frame;
    private JComboBox comboBox;
    private AdminController adminController = new AdminController();

    public DeleteRequestView() {
        initialize();
        initFrame();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Delete request");
        lblTitle.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 24));
        lblTitle.setBounds(126, 21, 214, 32);
        frame.getContentPane().add(lblTitle);

        JLabel lblSelect = new JLabel("Select request");
        lblSelect.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        lblSelect.setBounds(57, 105, 153, 24);
        frame.getContentPane().add(lblSelect);

        comboBox = new JComboBox();
        comboBox.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        comboBox.setBounds(196, 101, 214, 32);
        frame.getContentPane().add(comboBox);

        JLabel lblNewLabel_1 = new JLabel("back");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(10, 244, 51, 16);
        frame.getContentPane().add(lblNewLabel_1);

        Image buttonIcon = new ImageIcon(this.getClass().getResource("/images/back.png")).getImage();
        Image scaledImg=buttonIcon.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        frame.getContentPane().setLayout(null);

        JButton backButton = new JButton(new ImageIcon(scaledImg));
        backButton.setBounds(10, 203, 56, 57);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setContentAreaFilled(false);
        frame.getContentPane().add(backButton);


        JLabel lblNewLabel = new JLabel("");
        Image img=new ImageIcon(this.getClass().getResource("/images/background.png")).getImage();
        Image imgScaled = img.getScaledInstance(500, 300, Image.SCALE_DEFAULT);

        Image buttonIcon1 = new ImageIcon(this.getClass().getResource("/images/ok.png")).getImage();
        Image scaledImg1=buttonIcon1.getScaledInstance(50, 50, Image.SCALE_DEFAULT);

        JButton confirmButton = new JButton(new ImageIcon(scaledImg1));
        confirmButton.setBounds(236, 171, 85, 57);
        confirmButton.setBorder(BorderFactory.createEmptyBorder());
        confirmButton.setContentAreaFilled(false);
        confirmButton.addActionListener(a->{
            adminController.deleteRequest(comboBox.getSelectedItem().toString());
            comboBox.removeAllItems();
            comboBox = adminController.listRequestsInCombo(comboBox);
        });
        frame.getContentPane().add(confirmButton);

        JLabel lblOk = new JLabel("<html>Confirm selection</html>");
        lblOk.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        lblOk.setBounds(246, 213, 104, 40);
        frame.getContentPane().add(lblOk);

        lblNewLabel.setIcon(new ImageIcon(imgScaled));
        lblNewLabel.setBounds(0, 0, 436, 263);
        frame.getContentPane().add(lblNewLabel);
    }

    private void initFrame(){
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comboBox=adminController.listRequestsInCombo(comboBox);
        frame.setVisible(true);
    }

}

