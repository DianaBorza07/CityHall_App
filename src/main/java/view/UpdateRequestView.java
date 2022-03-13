package view;

import controller.RegularUserController;
import dto.UserDTO;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class UpdateRequestView {

    private JFrame frame;
    private JTextField description;
    private UserDTO userDTO;
    private JComboBox selectedDoc;
    private JComboBox documentTypes;
    private RegularUserController regularUserController= new RegularUserController();

    public UpdateRequestView() {
        initialize();
        initFrame();
    }

    public UpdateRequestView(UserDTO userDTO) {
        this.userDTO = userDTO;
        initialize();
        initFrame();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Modify request");
        lblTitle.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 25));
        lblTitle.setBounds(240, 20, 251, 48);
        frame.getContentPane().add(lblTitle);

        selectedDoc = new JComboBox();
        selectedDoc.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
        selectedDoc.setBounds(318, 111, 284, 36);
        frame.getContentPane().add(selectedDoc);

        JLabel lblSelect = new JLabel("<html>Select the document you want to change</html>");
        lblSelect.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        lblSelect.setBounds(110, 111, 198, 48);
        frame.getContentPane().add(lblSelect);

        description = new JTextField();
        description.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
        description.setBounds(318, 201, 284, 30);
        frame.getContentPane().add(description);
        description.setColumns(10);

        JLabel lblNewLabel = new JLabel("<html>Insert the new request name</html>");
        lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        lblNewLabel.setBounds(110, 201, 185, 42);
        frame.getContentPane().add(lblNewLabel);

        documentTypes = new JComboBox();
        documentTypes.setBounds(318, 293, 284, 30);
        documentTypes.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
        frame.getContentPane().add(documentTypes);

        JLabel lblNewLabel_1 = new JLabel("<html>Select the new document type</html>");
        lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(113, 282, 182, 48);
        frame.getContentPane().add(lblNewLabel_1);

        Image buttonIcon1 = new ImageIcon(this.getClass().getResource("/images/ok.png")).getImage();
        Image scaledImg1=buttonIcon1.getScaledInstance(50, 50, Image.SCALE_DEFAULT);

        JButton confirmButton = new JButton(new ImageIcon(scaledImg1));
        confirmButton.setBounds(344, 357, 85, 57);
        confirmButton.setBorder(BorderFactory.createEmptyBorder());
        confirmButton.setContentAreaFilled(false);
        confirmButton.addActionListener(a-> {
            regularUserController.updateRequest(selectedDoc.getSelectedItem().toString(), description.getText(), documentTypes.getSelectedItem().toString());
            description.setText("");
        });
        frame.getContentPane().add(confirmButton);

        Image buttonIcon = new ImageIcon(this.getClass().getResource("/images/back.png")).getImage();
        Image scaledImg=buttonIcon.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        JButton backButton = new JButton(new ImageIcon(scaledImg));
        backButton.setBounds(39, 392, 56, 57);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(a->{
            new RegularUserView(userDTO);
            frame.dispose();
        });
        frame.getContentPane().add(backButton);


        JLabel lblBack = new JLabel("back");
        lblBack.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblBack.setBounds(49, 440, 51, 16);
        frame.getContentPane().add(lblBack);

        JLabel lblOk = new JLabel("<html>Confirm selection</html>");
        lblOk.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
        lblOk.setBounds(356, 409, 104, 40);
        frame.getContentPane().add(lblOk);

        JLabel lbl = new JLabel("");
        Image img=new ImageIcon(this.getClass().getResource("/images/background5.jpg")).getImage();
        Image imgScaled = img.getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        lbl.setIcon(new ImageIcon(imgScaled));
        lbl.setBounds(0, 0, 690, 478);
        frame.getContentPane().add(lbl);
    }

    private void initFrame(){
        frame.setBounds(100, 100, 704, 515);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        documentTypes = regularUserController.getDocumentsType(documentTypes);
        selectedDoc = regularUserController.getRequestNames(selectedDoc,userDTO);
        frame.setVisible(true);
    }
}

