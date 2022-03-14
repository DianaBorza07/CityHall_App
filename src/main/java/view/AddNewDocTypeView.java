package view;

import controller.AdminController;

import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddNewDocTypeView {

    private JFrame frame;
    private JTextField docName;
    private AdminController adminController= new AdminController();

    public AddNewDocTypeView() {
        initialize();
        initFrame();
    }

    private void initialize() {
        frame = new JFrame();

        docName = new JTextField();
        docName.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        docName.setBounds(213, 105, 179, 30);
        frame.getContentPane().add(docName);
        docName.setColumns(10);

        JLabel lblTitle = new JLabel("Add new document type");
        lblTitle.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 30));
        lblTitle.setBounds(55, 0, 337, 75);
        frame.getContentPane().add(lblTitle);

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
        backButton.addActionListener(a->{
            new AdminView();
            frame.dispose();
        });
        frame.getContentPane().add(backButton);


        JLabel lblNewLabel = new JLabel("");
        Image img=new ImageIcon(this.getClass().getResource("/images/background5.jpg")).getImage();
        Image imgScaled = img.getScaledInstance(500, 300, Image.SCALE_DEFAULT);

        JLabel lblText = new JLabel("Insert document name");
        lblText.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        lblText.setBounds(30, 100, 173, 40);
        frame.getContentPane().add(lblText);

        Image buttonIcon1 = new ImageIcon(this.getClass().getResource("/images/ok.png")).getImage();
        Image scaledImg1=buttonIcon1.getScaledInstance(50, 50, Image.SCALE_DEFAULT);

        JButton confirmButton = new JButton(new ImageIcon(scaledImg1));
        confirmButton.setBounds(236, 171, 85, 57);
        confirmButton.setBorder(BorderFactory.createEmptyBorder());
        confirmButton.setContentAreaFilled(false);
        confirmButton.addActionListener(a->{
            adminController.addNewDocType(docName.getText());
            docName.setText("");
        });
        frame.getContentPane().add(confirmButton);

        JLabel lblOk = new JLabel("OK");
        lblOk.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        lblOk.setBounds(264, 220, 45, 24);
        frame.getContentPane().add(lblOk);

        lblNewLabel.setIcon(new ImageIcon(imgScaled));
        lblNewLabel.setBounds(0, 0, 436, 263);
        frame.getContentPane().add(lblNewLabel);
    }

    private void initFrame(){
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
