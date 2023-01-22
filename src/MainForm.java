import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {

    // Create WestminsterSkinConsultation constructor
    public MainForm(){
        JLabel label = new JLabel("Westminster Skin Consultation");     // Create JLabel for frame topic
        JFrame frame = new JFrame();    // Create a Main JFrame
        JPanel panel1ForHeader = new JPanel();  // Create a JPanel for add main topic
        JLabel labelForbgImage = new JLabel();  // Create a JLabel for add image
        JButton btnExit = new JButton("EXIT");  // Create a JButton for exit from frame
        JButton btnViewDoctors = new JButton("View Doctors");   // Create a JButton to move View Doctor Frame
        JButton btnBookConsultation = new JButton("Book Consultation"); // Create a JButton to move book Consultation Frame
        JButton viewBookConsultation = new JButton("View Book Consultation");   // Create a JButton to move view consultation frame

        mainHomeForm(frame); // main home frame
        labelBg(labelForbgImage); // background label
        headerPanel(panel1ForHeader, label); // panel for header
        labelHeader(label); // Westminster header
        exitButton(btnExit, frame); // exit button
        btnViewDoctors(btnViewDoctors, frame); // view doctor list
        viewDoctorsImage(frame); // doctor icon

        bookConsultation(btnBookConsultation, frame); // book consultation button
        imageBookConsultation(frame); // book consultation image

        viewBookConsultation(viewBookConsultation, frame); // View book consultation button
        imageViewBookConsultation(frame); // View book consultation image


        addFrame(frame, panel1ForHeader, labelForbgImage, btnExit); // add frame function

        frame.setVisible(true); // set visible
    }

    // Create mainHomeForm method to set frame attributes
    public static void mainHomeForm(JFrame frame){
        ImageIcon img = new ImageIcon("C:\\Users\\HP\\Desktop\\Folder\\IIT\\2nd_Year_1st_Sem\\NEW\\OOP\\CW\\FinalCw\\Images\\icon30.png"); // Read image icon for frame
        frame.setIconImage(img.getImage()); // Set icon for frame
        frame.setTitle("Westminster Skin Consultation");    // Set Title for frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Set default close operation for frame
        frame.setSize(600,600); // set frame size width 600, and height 600

        frame.setLayout(null);  // set frame layout null option
        frame.setLocationRelativeTo(null);  // set frame location relative null
        frame.setResizable(false);  // set false frame resizable
    }

    // Create labelBg method to add image to Main Frame
    public static void labelBg(JLabel labelbgImage){
        ImageIcon img1 = new ImageIcon("C:\\Users\\HP\\Desktop\\Folder\\IIT\\2nd_Year_1st_Sem\\NEW\\OOP\\CW\\FinalCw\\Images\\bgImage2R.png"); // Read image location
        labelbgImage.setIcon(img1); // set image to JLabel
        labelbgImage.setBounds(-190,160,400,400);   // Set bounds for image
    }

    // Create headerPanel method to insert JLabel
    public static void headerPanel(JPanel panel1ForHeader, JLabel label){
        panel1ForHeader.setBounds(50,20, 500,50);   // Set bounds JPanel
        panel1ForHeader.add(label); // Add JLabel to JPanel
    }

    // Create labelHeader method to align Main Topic
    public static void labelHeader(JLabel label){
        label.setVerticalTextPosition(JLabel.TOP);  // Set vertical text position Top in the label
        label.setHorizontalAlignment(JLabel.CENTER);    // Set horizontal alignment position center in the label
        label.setFont(new Font("Times new romes",Font.BOLD, 30));   // Set font name and size
        label.setForeground(new java.awt.Color(1, 21, 43)); // Set font colour
    }

    // Create exitButton method to set exit button in main frame
    public static void exitButton(JButton btnExit, JFrame frame){
        btnExit.setFont(new Font("Times new romes", Font.BOLD, 12));    // set font size and font name
        btnExit.setBounds(500,520,70,30);   // set bounds for the exit button
        btnExit.setFocusable(false);    // Set false focusable in exit button
        btnExit.setBackground(new java.awt.Color(138, 207, 227,150));   // Set background color for exit button

        // Create action listener to exit from the GUI
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // frame will dispose when click the exit button
            }
        });
    }

    // Create btnViewDoctors method to move view doctor frame
    public static void btnViewDoctors(JButton button, JFrame frame){
        button.setFont(new Font("Times new romes", Font.BOLD, 13));     // Set font name and size
        button.setBounds(240,120,200,35);   // set bounds for viewDoctor button
        button.setFocusable(false); // set false fot button focusable
        button.setBackground(new java.awt.Color(138, 207, 227,150));    // Set button background color
        frame.add(button);  // add view doctor button to main frame

        // Create action listener for move view doctor frame
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {
                    frame.dispose();
                    DoctorFrame doctorFrame = new DoctorFrame();
                }
            }
        });
    }

    // Create viewDoctorsImage method to add view doctor icon to frame
    public static void viewDoctorsImage(JFrame frame){
        JLabel label = new JLabel();    // Create JLabel to add Doctor icon
        ImageIcon drIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\Folder\\IIT\\2nd_Year_1st_Sem\\NEW\\OOP\\CW\\FinalCw\\Images\\doctorR130.png"); // Read Doctor icon
        label.setIcon(drIcon);  // Set icon to label
        label.setBounds(100,80,100,100);    // Set bounds to label
        frame.add(label);   // add label to frame
    }

    // Create bookConsultation method to add button to main frame
    public static void bookConsultation(JButton btnBookConsultation, JFrame frame){
        btnBookConsultation.setFont(new Font("Times new romes", Font.BOLD, 13));    // Set font name and size
        btnBookConsultation.setBounds(240, 225,200,35); // set bounds to book consultation button
        btnBookConsultation.setFocusable(false);    // set false book button focusable
        btnBookConsultation.setBackground(new java.awt.Color(138, 207, 227,150));   // set background color for button

        // Create action listener for move book consultation frame
        btnBookConsultation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnBookConsultation) {
                    frame.dispose();
                    BookConsultation bookConsultation = new BookConsultation();
                }
            }
        });
        frame.add(btnBookConsultation);
    }

    // Create imageBookConsultation method add book consultation image to main frame
    public static void imageBookConsultation(JFrame frame){
        JLabel labelBookConsultation = new JLabel();    // Create JLabel for add icon
        ImageIcon bookIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\Folder\\IIT\\2nd_Year_1st_Sem\\NEW\\OOP\\CW\\OopCwGui\\Images\\bookR75.png");   // Read bookIcon location
        labelBookConsultation.setIcon(bookIcon);    // set icon to JLabel
        labelBookConsultation.setBounds(128,200, 100,70);   // Set bounds JLabel
        frame.add(labelBookConsultation);   // add JLabel to frame
    }

    // Create viewBookConsultation method to move view consultation
    public static void viewBookConsultation(JButton btnViewConsultation, JFrame frame){
        btnViewConsultation.setFont(new Font("Times new romes", Font.BOLD, 13));    // Set Font name and size
        btnViewConsultation.setBounds(240, 330, 200, 35);   // set bounds JButton
        btnViewConsultation.setFocusable(false);    // Set false the focusable of JButton
        btnViewConsultation.setBackground(new java.awt.Color(138, 207, 227,150));   //Set background color for JButton
        frame.add(btnViewConsultation); // add JButton to frame

        // Create action Listener to move the view Consultation frame
        btnViewConsultation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnViewConsultation) {
                    frame.dispose();
                    ViewConsultationFrame viewConsultationFrame = new ViewConsultationFrame();
                }
            }
        });
    }

    // Create imageViewBookConsultation for add image icon for frame
    public static void imageViewBookConsultation(JFrame frame){
        JLabel labelImageViewConsultation = new JLabel();   // Create JLabel to add image icon
        ImageIcon viewBookIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\Folder\\IIT\\2nd_Year_1st_Sem\\NEW\\OOP\\CW\\FinalCw\\Images\\consultationR75.png");   // Read icon path
        labelImageViewConsultation.setIcon(viewBookIcon);   // set icon to JLabel
        labelImageViewConsultation.setBounds(128,310,100,70);   // Set bounds for JLabel
        frame.add(labelImageViewConsultation);  // add JLabel to frame
    }

    // Create addFrame method add JPanel, JLabel and JButton for Main Frame
    public static void addFrame(JFrame frame, JPanel panel1ForHeader, JLabel labelForbgImage, JButton btnExit){
        frame.add(panel1ForHeader); // add panel for frame
        frame.add(labelForbgImage); // add image for frame
        frame.add(btnExit); // add exit button for frame
    }

}
