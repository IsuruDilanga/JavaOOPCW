import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class DoctorFrame {

    public static int countList;    //

    // Create DoctorFrame to view DoctorList
    DoctorFrame() {
//        countList = 0;
        JFrame frame = new JFrame();    // Create JFrame to show doctor list
        JButton btnBack = new JButton("Back");  // Create JButton to go main frame

        BackButton(frame, btnBack);     // Call BackButton method
        btnBookConsultation(frame);     // Call btnBookConsultation method
        ViewDoctorFrame(frame);     // Call viewDoctor method
    }

    // Create BackButton method to create back button
    public static void BackButton(JFrame frame, JButton button) {
        button.setFont(new Font("Times new romes", Font.BOLD, 13)); // Set font name and color
        button.setBounds(700, 500, 100, 35);    // set bounds to button
        button.setFocusable(false); // Set false to button focusable
        button.setBackground(new Color(138, 207, 227, 150));    // Set background color
        frame.add(button);  // add button to frame

        // Create action listener to move to main menu
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

    // Create btnBookConsultation to create book consultation button
    public static void btnBookConsultation(JFrame frame) {
        JButton button = new JButton("Book Consultation");  // Create JButton to book consultation
        button.setFont(new Font("Times new romes", Font.BOLD, 13)); //Set font name and size
        button.setBounds(480, 500, 150, 35);    // set bound to button
        button.setFocusable(false); // sef false to JButton focusable
        button.setBackground(new Color(138, 207, 227, 150));    // Set background color
        frame.add(button);  // add JButton to frame

        // Create action listener to move book consultation frame
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {
                    frame.dispose();
                    BookConsultation bookConsultation = new BookConsultation();
                }
            }
        });
    }


    // Crate view Doctor Frame to view table of doctor list
    public static void ViewDoctorFrame(JFrame frame) {
        ArrayList<Doctor> doctors = new ArrayList<>();

        JButton btnAsc = new JButton("A - Z");  // Create to JButton to make Alphabetical order to doctor list
        btnAsc.setBounds(30, 500, 100, 35); // set bounds JButton
        btnAsc.setFocusable(false); // Set false JButton focusable
        btnAsc.setBackground(new Color(138, 207, 227, 150));    // Set background color
        frame.add(btnAsc);  // add JButton to frame

//        ArrayList<String> arrDetailsString = new ArrayList<>();
//        try {
//            File filelocation = new File("C:/Users/HP/Desktop/Folder/IIT/2nd_Year_1st_sem/NEW/OOP/CW/OopCwGui/File/details.txt");
//            Scanner fileReader = new Scanner(filelocation);
//            while (fileReader.hasNextLine()) {
//                arrDetailsString.add(fileReader.nextLine());
//
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred. ");
//            e.printStackTrace();
//        }
//
//        String fName = null;
//        String lName = null;
//        int lic = 0;
//        int mNo = 0;
//        String spe = null;
//
//        int day = 0;
//        int month = 0;
//        int year = 0;
//
//        String[] dataRow;
//        String[] date;
//        if (arrDetailsString.size() > 0) {
//            for (int i = 1; i < arrDetailsString.size(); i++) {
//                Date DOB = new Date();
//                dataRow = arrDetailsString.get(i).split("/");
//
//                for (int j = 0; j < dataRow.length; j++) {
//                    if (j == 0) {
//                        lName = dataRow[j].trim();
//                    } else if (j == 1) {
//                        fName = dataRow[j].trim();
//
//                    } else if (j == 2) {
//                        date = dataRow[j].split("-");
//                        for (int k = 0; k < date.length; k++) {
//                            if (k == 0) {
//                                day = Integer.parseInt(date[k].trim());
//                            } else if (k == 1) {
//                                month = Integer.parseInt(date[k].trim());
//                            } else if (k == 2) {
//                                year = Integer.parseInt(date[k].trim());
//                            }
//                        }
//                        DOB.setYear(year);
//                        DOB.setMonth(month);
//                        DOB.setDate(day);
//                    } else if (j == 3) {
//                        mNo = Integer.parseInt(dataRow[j].trim());
//                    } else if (j == 4) {
//                        lic = Integer.parseInt(dataRow[j].trim());
//                    } else if (j == 5) {
//                        spe = dataRow[j].trim();
//                    }
//
//                }
//                if (check(Doctor.doctorList, lic)) {
//                    Doctor.doctorList.add(countList, new Doctor(lName, fName, DOB, mNo, lic, spe));
//                    countList++;
//
//                    if (spe.equalsIgnoreCase("cosmetic dermatology")) {
//                        Doctor.cosmetic.add(new Doctor(lName, fName, DOB, mNo, lic, spe));
//                    } else if (spe.equalsIgnoreCase("medical dermatology")) {
//                        Doctor.medical.add(new Doctor(lName, fName, DOB, mNo, lic, spe));
//                    } else if (spe.equalsIgnoreCase("paediatric dermatology")) {
//                        Doctor.paediatric.add(new Doctor(lName, fName, DOB, mNo, lic, spe));
//                    }
////                    doctors.add(new Doctor(lName, fName,  DOB, mNo, lic, spe));
//                }
//
//            }
//        }

        // Go through the doctor list using for loop
        for (int i = 0; i < Doctor.doctorList.size(); i++){
            // Check the doctor specialization and add cosmetic arraylist
            if (Doctor.doctorList.get(i).getSpecialisation().equalsIgnoreCase("cosmetic dermatology")) {
                Doctor.cosmetic.add(new Doctor(Doctor.doctorList.get(i).getSurname() ,
                        Doctor.doctorList.get(i).getName(),
                        Doctor.doctorList.get(i).getDOB(),
                        Doctor.doctorList.get(i).getMobileNo(),
                        Doctor.doctorList.get(i).getLicenceNumber(),
                        Doctor.doctorList.get(i).getSpecialisation()));

                //  Check the doctor specialization and add medical arraylist
            } else if (Doctor.doctorList.get(i).getSpecialisation().equalsIgnoreCase("medical dermatology")) {
                Doctor.medical.add(new Doctor(Doctor.doctorList.get(i).getSurname() ,
                        Doctor.doctorList.get(i).getName(),
                        Doctor.doctorList.get(i).getDOB(),
                        Doctor.doctorList.get(i).getMobileNo(),
                        Doctor.doctorList.get(i).getLicenceNumber(),
                        Doctor.doctorList.get(i).getSpecialisation()));

                //Check the doctor specialization and add paediatric arraylist
            } else if (Doctor.doctorList.get(i).getSpecialisation().equalsIgnoreCase("paediatric dermatology")) {
                Doctor.paediatric.add(new Doctor(Doctor.doctorList.get(i).getSurname() ,
                        Doctor.doctorList.get(i).getName(),
                        Doctor.doctorList.get(i).getDOB(),
                        Doctor.doctorList.get(i).getMobileNo(),
                        Doctor.doctorList.get(i).getLicenceNumber(),
                        Doctor.doctorList.get(i).getSpecialisation()));
            }
        }

        //  Create DoctorTableModel and pass the doctorList arrayList
        DoctorTableModel tableModel = new DoctorTableModel(Doctor.doctorList);
        JTable table = new JTable(tableModel);  //Crete JTable to add doctor list
        table.setFont(new Font("Times new romes", Font.PLAIN, 13)); // set font name and size

        JScrollPane pane = new JScrollPane(table);  // Create JScrollPane to add table
        pane.setBounds(30, 150, 770, 300);  //set bounds pane

        // Create action listener to sort the doctor list
        btnAsc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnAsc) {
                    sortDetails(Doctor.doctorList, frame);  // Call the sort Details method to sort doctor list according to the surName
                }
            }
        });

        JLabel label = new JLabel("Doctor List"); // Create JLabel to add topic
        JLabel labelImage = new JLabel();   // Create JLabel to add image icon
        setLabel(label);    // Call setLabel method
        setImageDoctor(labelImage); // Call setImageDoctor method

        frame.add(labelImage);  // add image label to frame
        frame.add(label);   // add JLabel to frame
        frame.add(pane);    // add pane to frame

        setFrame(frame);    // Call setFrame method

    }

    //  Create check method to check ??
    public static boolean check(ArrayList<Doctor> doctorList, int licence) {
        boolean checkCustomerName = true;
        for (int i = 0; i < doctorList.size(); i++) {
            if ((doctorList.get(i).getLicenceNumber() == licence) && checkCustomerName) {
                checkCustomerName = false;
            }
        }

        return checkCustomerName;
    }

    // Create setImageDoctor method to crete image icon to frame
    public static void setImageDoctor(JLabel labelImage) {
        ImageIcon drIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\Folder\\IIT\\2nd_Year_1st_Sem\\NEW\\OOP\\CW\\FinalCw\\Images\\doctorR130.png"); // Read the path
        labelImage.setBounds(10, 10, 100, 100); // set bounds the JImage
        labelImage.setIcon(drIcon); // set icon to JImage
    }

    // Create setFrame method to set frame
    public static void setFrame(JFrame frame) {
        ImageIcon img = new ImageIcon("C:\\Users\\HP\\Desktop\\Folder\\IIT\\2nd_Year_1st_Sem\\NEW\\OOP\\CW\\FinalCw\\Images\\icon30.png"); // Read the path of frame icon

        frame.setIconImage(img.getImage()); // Set the image icon to frame
        frame.setTitle("Westminster Skin Consultation Doctor List");    // Set the title in the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set default close operation to frame
        frame.setSize(850, 600);    // set frame size width: 850 height: 600
        frame.setLayout(null);  // Set layout null
        frame.setLocationRelativeTo(null);  // Set location relative to fame null
        frame.setResizable(false);  // set resizable false
        frame.setVisible(true); // set frame visible true
    }

    // Create setLabel method to create label
    public static void setLabel(JLabel label) {
        label.setBounds(320, 20, 200, 50);  // set bounds JLabel
        label.setVerticalTextPosition(JLabel.TOP);  // set Vertical position to Top
        label.setHorizontalAlignment(JLabel.CENTER);    // set horizontal alignment center
        label.setFont(new Font("Times new romes", Font.BOLD, 30));  // set font name size
        label.setForeground(new Color(1, 21, 43));  // ser foreground color to label text
    }

    // Create sortDetails method to sort doctor list
    public static void sortDetails(ArrayList<Doctor> doctors, JFrame frame) {
        Collections.sort(doctors, Doctor.surNameComparator);    // Use collections.sort method to sort doctor surName
        ArrayList<Doctor> sortDoctors = new ArrayList<>(doctors);   // Create new arrayList to store sort arrayList

        DoctorTableModel sortTableModel = new DoctorTableModel(sortDoctors);    // Create DoctorTableModel to and pass sortDoctor parameter as a arrayList
        JTable sortTable = new JTable(sortTableModel);  // Create JTable

        JScrollPane sortPane = new JScrollPane(sortTable);  // Create JScrollPane
        sortPane.setBounds(30, 150, 770, 300);  // set bounds for JPane
        frame.add(sortPane);    // add pane to frame

//        System.out.println("Sort");
//        int index= (int)(Math.random() * Doctor.paediatric.size());
//        System.out.println("Random doctor: " + Doctor.paediatric.get(index).getSurname());

//        for (int i = 0; i < Doctor.paediatric.size(); i++){
//            System.out.println(Doctor.paediatric.get(i).getName());
//        }
    }
}
