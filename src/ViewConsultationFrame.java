import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ViewConsultationFrame {

    ArrayList<Consultation> patientDetails = new ArrayList<>();  // Create patientDetails arrayList
    static ArrayList<Integer> patientIdArray = new ArrayList<>();   // Create Patient id ArrayList
    static ArrayList<File> images = new ArrayList<>();  // Create image file arrayList
    static int countId; // Create static variable count ID

    // Call the constructor of ViewConsultationFrame
    ViewConsultationFrame() {
        countId = 0;    // Set a static variable countId as 0

        JFrame frame = new JFrame(); // Create JFrame to open frame

        mainFrame(frame);   // Call the mainFrame method
        imageBookConsultation(frame);   // Call the imageBookConsultation method
        BackButton(frame);  // Call BackButton method
        header(frame);  // Call header method
        addedLabel(frame);  // Call addedLabel method

        JTextField patientName = new JTextField();  // Create JTextField to patientName
        JTextField patientID = new JTextField();    // Create JTextField to patientID
        addedText(frame, patientName, patientID);   // Call addedText method

        checkDetailsButton(frame, patientName, patientID); // Call the checkDetailsButton method

        frame.setVisible(true); // Create frame set visible true
    }

    // Create mainFrame JFrame to add table
    public static void mainFrame(JFrame frame) {
        ImageIcon img = new ImageIcon("C:\\Users\\HP\\Desktop\\Folder\\IIT\\2nd_Year_1st_Sem\\NEW\\OOP\\CW\\FinalCw\\Images\\icon30.png"); // Read the path of frame icon

        frame.setIconImage(img.getImage()); // Set icon image to frame
        frame.setSize(900, 600);    // Set size of frame
        frame.setTitle("Westminster Skin Consultation Center Scheduled Consultations"); // Set title for frame
        frame.setLocationRelativeTo(null);  // set location relative null in frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set Default Close Operation in frame
        frame.setLayout(null);  // set Layout null in frame
    }

    // Create imageBookConsultation to add image
    public static void imageBookConsultation(JFrame frame) {
        JLabel labelBookConsultation = new JLabel();    // Create JLabel to add image icon
        ImageIcon bookIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\Folder\\IIT\\2nd_Year_1st_Sem\\NEW\\OOP\\CW\\FinalCw\\Images\\bookR75.png");   // Read the path of image icon
        labelBookConsultation.setIcon(bookIcon);    // set icon to label
        labelBookConsultation.setBounds(50, 30, 100, 70); // set bounds to JLabel
        frame.add(labelBookConsultation);   // add JLabel to frame
    }

    // Create BackButton to move back frame
    public static void BackButton(JFrame frame) {
        JButton button = new JButton("Back");   // add back JButton to back
        button.setFont(new Font("Times new romes", Font.BOLD, 13)); // set font name and size
        button.setBounds(750, 470, 100, 35);   // set bounds to JButton
        button.setFocusable(false); // set false focusable
        button.setBackground(new Color(138, 207, 227, 150));    // set JButton background color
        frame.add(button);  // add JButton to frame

        // crete new action listener to back button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {
                    frame.dispose();
                    MainForm main = new MainForm();
                }
            }
        });
    }

    // Create header button
    public static void header(JFrame frame){
        JLabel label = new JLabel();    // Create JLabel for header
        label.setText("Scheduled Consultations");  // Set text to label
        label.setBounds(170,30,500,40);    // set bound to label
        label.setFont(new Font("Times new romes",Font.BOLD, 30));   // set font name and size
        label.setForeground(new Color(1, 21, 43));  // set font color
        frame.add(label);   // addJLabel to rame
    }

    // Create addedLabel method to decorate labels
    public static void addedLabel(JFrame frame) {
        JLabel fName = new JLabel("Enter Patient First Name");  // add JLabel to image
        JLabel id = new JLabel("Patient ID");   // add patient ID label

        fName.setBounds(50, 130, 200, 20);  // Set bound to frame
        labelDesign(fName); // Call load Design method

        id.setBounds(450, 130, 150, 20);    // id set bounds
        labelDesign(id);    // Call load Design method

        frame.add(fName);   // add fName to tabel
        frame.add(id);  // add id to frame
    }

    // Create labelDesign method to add design for label
    public static void labelDesign(JLabel label) {
        label.setFont(new Font("Times new romes", Font.BOLD, 16));  // set font name and size
        label.setForeground(new Color(1, 21, 43));  // set font color
    }

    // Create addedText method to set JTextField
    public static void addedText(JFrame frame, JTextField patientName, JTextField patientID) {
        patientName.setBounds(260, 130, 170, 25);   // set bounds JTextField
        patientName.setFont(new Font("Times new romes", Font.PLAIN, 14));   // Set font name and size
        frame.add(patientName); // add JTextField to frame

        patientID.setBounds(540, 130, 150, 25);     // set bounds JTextField
        patientID.setFont(new Font("Times new romes", Font.PLAIN, 14));     // Set font name and size
        frame.add(patientID);   // add JTextField to frame
    }

    // Create checkDetailsButton method check details of JTextField
    public void checkDetailsButton(JFrame frame, JTextField name, JTextField id) {

        JButton btnCheck = new JButton("Check Schedule Consultation");  // Create JButton and set the text
        btnCheck.setFont(new Font("Times new romes", Font.BOLD, 15));   // set font name and size
        btnCheck.setBounds(50, 180, 300, 35);  // set bounds JButton
        btnCheck.setFocusable(false);   // set focusable false JButton
        btnCheck.setBackground(new Color(138, 207, 227, 150));  // set background color of JButton
        frame.add(btnCheck);    // add frame to JButton

        JButton btnViewImage = new JButton("See Image You uploaded");   // Create JButton and set the text
        btnViewImage.setFont(new Font("Times new romes", Font.BOLD, 15));   // set font name and size
        btnViewImage.setBounds(390, 180, 300, 35);  // set bounds JButton
        btnViewImage.setFocusable(false);   // set focusable false JButton
        btnViewImage.setBackground(new Color(138, 207, 227, 150));  // set background color of JButton
        frame.add(btnViewImage);    // add frame to JButton

        // add action listener to show patient uploaded image
        btnViewImage.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Check the patient Details arrayList have patient or not
                if (patientDetails.size() > 0) {
                    // run through the patientDetails array
                    for (int i = 0; i < patientDetails.size(); i++) {
                        // if patient need to see uploaded photo asking encrypt password
                        int passcode = Integer.parseInt(JOptionPane.showInputDialog("Enter encrypted image " + (i + 1) + " password "));
                        // check to encrypt password equals enter password
                        if (passcode == patientDetails.get(i).getPassword()) {
                            // Call the encrypt method to decrypt photo
                            ecrypt(patientDetails.get(i).getSkinImage(), passcode);
                            Desktop d = Desktop.getDesktop();   // Create Desktop object
                            try {
                                d.open(patientDetails.get(i).getSkinImage());  // View the image from open the file path
                                // Asking from patient if they need to encrypt again uploaded image
                                int answer = JOptionPane.showConfirmDialog(null, "Do you want encrypt back your image?", "Request Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
//                                System.out.println(answer);
                                // Check the answer and if equal 0 encrypt again
                                if (answer == 0) {
                                    ecrypt(patientDetails.get(i).getSkinImage(), passcode);    // Call encrypt method to encrypt image
                                    System.out.println("Encrypt");
//                                    patientDetails.remove(i);
                                }
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
//                    setDefault(name, id);
                } else {
                    // Showing error message if the patient details wrong
                    JOptionPane.showMessageDialog(null, "Please Enter Patient First Name, ID and Click Schedule button First ", "Invalid Details", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        // add action listener to show patient details
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnCheck) {

                    String patientName = String.valueOf(name.getText());    // Create a variable patientName and read the JTextField
                    int patientId = Integer.parseInt(String.valueOf(id.getText())); // Create a variable patientId and read the JTextField

                    patientIdArray.add(patientId); //check will this use or not // Add patient ID to patientIDArray

                    // Check the patient name already in the consultation list calling checkPatientName method
                    if (checkPatientName(Consultation.consultationList, patientName)) {
                        //  Check the patient id already in the consultation list calling the checkPatientID method
                        if (checkPatientID(Consultation.consultationList, patientId)) {

                            // go through the consultation list
                            for (int i = 0; i < Consultation.consultationList.size(); i++) {
                                // Check the entered patient name and id equal to the consultationList
                                if (Consultation.consultationList.get(i).getPatientFirstName().equalsIgnoreCase(patientName) &&
                                        Consultation.consultationList.get(i).getPatientId() == patientId) {

                                    patientDetails.add(countId, new Consultation(Consultation.consultationList.get(i).getDoctorSureName(),
                                            Consultation.consultationList.get(i).getDoctorLicense(),
                                            Consultation.consultationList.get(i).getPatientFirstName(),
                                            Consultation.consultationList.get(i).getPatientId(),
                                            Consultation.consultationList.get(i).getDateAndTime(),
                                            Consultation.consultationList.get(i).getCost(),
                                            Consultation.consultationList.get(i).getNotes(),
                                            Consultation.consultationList.get(i).getPassword(),
                                            Consultation.consultationList.get(i).getSkinImage()));

//                                    patientDetails.add(i,Consultation.consultationList.get(i));
//                                    if (!Consultation.consultationList.contains(Consultation.consultationList.get(i).getDateAndTime())){
                                    // Check the countID greater than 0
//                                    if (countId > 0) {
//                                        // check the patient details not include entered patient details
//                                        if (!patientDetails.contains(patientDetails.get(i))) {
//
////                                            Consultation.patientDetails.addAll(Consultation.consultationList);
//                                            System.out.println("More than 0");
//                                            // Consultation added patientDetails to new consultation
//                                            patientDetails.add(countId, new Consultation(Consultation.consultationList.get(i).getDoctorSureName(),
//                                                    Consultation.consultationList.get(i).getDoctorLicense(),
//                                                    Consultation.consultationList.get(i).getPatientFirstName(),
//                                                    Consultation.consultationList.get(i).getPatientId(),
//                                                    Consultation.consultationList.get(i).getDateAndTime(),
//                                                    Consultation.consultationList.get(i).getCost(),
//                                                    Consultation.consultationList.get(i).getNotes(),
//                                                    Consultation.consultationList.get(i).getPassword(),
//                                                    Consultation.consultationList.get(i).getSkinImage()));
//
//                                            //  Create ConsultationTableModel and pass the patientDetails arrayList
//                                            ConsultationTableModel tableModel = new ConsultationTableModel(patientDetails);
//                                            JTable table = new JTable(tableModel);  //Crete JTable to add doctor list
//                                            table.setFont(new Font("Times new romes", Font.PLAIN, 12)); // set font name and size
//
//                                            JScrollPane pane = new JScrollPane(table);  // Create JScrollPane to add table
//                                            pane.setBounds(50, 250, 800, 200); //set bounds pane
//
//                                            countId++;  // added count id to one
//                                            frame.add(pane);    // add pane to frame
//                                            setDefault(name, id); // Call setDefault method to set JTextFiled empty
//                                            checkDetailsButton(frame, name, id); // call back to checkDetailsButton
//                                        }
//                                    } else {
//                                        System.out.println("equal 0");
////                                        Consultation.patientDetails.addAll(Consultation.consultationList);
//                                        // Consultation added patientDetails to new consultation
//                                        patientDetails.add(countId, new Consultation(Consultation.consultationList.get(i).getDoctorSureName(),
//                                                Consultation.consultationList.get(i).getDoctorLicense(),
//                                                Consultation.consultationList.get(i).getPatientFirstName(),
//                                                Consultation.consultationList.get(i).getPatientId(),
//                                                Consultation.consultationList.get(i).getDateAndTime(),
//                                                Consultation.consultationList.get(i).getCost(),
//                                                Consultation.consultationList.get(i).getNotes(),
//                                                Consultation.consultationList.get(i).getPassword(),
//                                                Consultation.consultationList.get(i).getSkinImage()));
//
//                                        //  Create ConsultationTableModel and pass the patientDetails arrayList
//                                        ConsultationTableModel tableModel = new ConsultationTableModel(patientDetails);
//                                        JTable table = new JTable(tableModel);  //Crete JTable to add doctor list
//                                        table.setFont(new Font("Times new romes", Font.PLAIN, 12)); // set font name and size
//
//                                        JScrollPane pane = new JScrollPane(table);  // Create JScrollPane to add table
//                                        pane.setBounds(50, 250, 800, 200); // set bounds pane
//
//                                        countId++;  // added count id to one
//                                        frame.add(pane);    // add pane to frame
//                                        setDefault(name, id);   // Call setDefault method to set JTextFiled empty
//                                        checkDetailsButton(frame, name, id); // call back to checkDetailsButton
//                                    }

                                }

                            }
                            ConsultationTableModel tableModel = new ConsultationTableModel(patientDetails);
                            JTable table = new JTable(tableModel);  //Crete JTable to add doctor list
                            table.setFont(new Font("Times new romes", Font.PLAIN, 12)); // set font name and size

                            JScrollPane pane = new JScrollPane(table);  // Create JScrollPane to add table
                            pane.setBounds(50, 250, 800, 200); //set bounds pane



                            countId++;  // added count id to one
                            frame.add(pane);    // add pane to frame
//
                            checkDetailsButton(frame, name, id); // call back to checkDetailsButton


                        } else {
                            // show error message when patient ID not equal
                            JOptionPane.showMessageDialog(null, "PLease Enter Patient ID ", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // Show error message when patient name not correct
                        JOptionPane.showMessageDialog(null, "PLease Enter Patient Name Correctly ", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        //  Create ConsultationTableModel and pass the patientDetails arrayList
        ConsultationTableModel tableModel = new ConsultationTableModel(patientDetails);
        JTable table = new JTable(tableModel);  // Crete JTable to add doctor list
        table.setFont(new Font("Times new romes", Font.PLAIN, 12)); // set font name and size

        JScrollPane pane = new JScrollPane(table);  // Create JScrollPane to add table
        pane.setBounds(50, 250, 800, 200); // set bounds pane

        frame.add(pane);    // add pane to frame
    }

    // Create setDefault method to set default JTextField
    public static void setDefault(JTextField patientName, JTextField patientId){
        patientName.setText("");
        patientId.setText("");
    }

    // Create ecrypt method to encrypt and decrypt updated photos
    public static void ecrypt(File file, int key) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);    // Read the file path as FileInputStream

            byte[] data = new byte[fileInputStream.available()];    // create a Byte array to fileInputStream available
            fileInputStream.read(data); // read data as fileInputStream
            int i = 0;  // set int i as 0
            // using for loop run the every bit through
            for (byte b : data) {
//                System.out.println(b);
                data[i] = (byte) (b ^ key);
                i++;
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file); // use FileOutputStream and pass file path
            fileOutputStream.write(data);   // write data fo fileOutputStream
            fileOutputStream.close();   // close fileOutputStream
            fileInputStream.close();    // close fileInputStream

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Create checkPatientID method to check patientID and return boolean
    public static boolean checkPatientID(ArrayList<Consultation> consultationArrayList, int id) {
        boolean checkPatienId = false;
        for (int i = 0; i < consultationArrayList.size(); i++) {
            if (consultationArrayList.get(i).getPatientId() == id) {
                checkPatienId = true;
            }
        }
        return checkPatienId;
    }

    // Create checkPatientName method to check patientName and return boolean
    public static boolean checkPatientName(ArrayList<Consultation> consultationArrayList, String name) {
        boolean checkPatientName = false;
        for (int i = 0; i < consultationArrayList.size(); i++) {
            if (consultationArrayList.get(i).getPatientFirstName().equalsIgnoreCase(name) && !checkPatientName) {
                checkPatientName = true;
            }
        }
        return checkPatientName;
    }

}
