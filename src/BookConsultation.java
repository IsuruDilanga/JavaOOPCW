import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class BookConsultation {

    static ArrayList<File> fileArrayList = new ArrayList<>();   // Create fileArrayList to add image location
    static int countConsultation; // Create countConsultation int to variable to count consultation

    // Create BookConsultation constructor
    public BookConsultation(){

        countConsultation = 0;  // make countConsultation = 0
        JFrame frame = new JFrame();    // Create JFrame object

        setFrame(frame);    // Call setFrame method
        mainTopLabel(frame);    // Call mainTopLabel method
        allLabel(frame);    // Call allLabel method

        JTextField fName = new JTextField();    // Create fName textField
        JTextField sName = new JTextField();    // Create sName textField
        JTextField mobile = new JTextField();   // Create mobile textField
        JTextField id = new JTextField();   // Create id textField
        JTextField password = new JTextField(); // Create password textField
        mainTextField(frame, fName, sName, mobile, id, password);   // Call mainTextField method

        JTextArea area = new JTextArea(5,5);    // Create a text area
        noteArea(frame,area);   // Call noteArea method

        JComboBox<Integer> dobDate = new JComboBox<>();     // Create dobDate Combo box
        JComboBox<Integer> dobMonth = new JComboBox<>();    // Create dobMonth Combo box
        JComboBox<Integer> dobYear = new JComboBox<>();     // Create dobYear Combo box
        JComboBox<Integer> cDate = new JComboBox<>();       // Create cDate Combo box
        JComboBox<Integer> cMonth = new JComboBox<>();      // Create cMonth Combo Box
        JComboBox<Integer> cYear = new JComboBox<>();       // Create cYear Combo Box
        JComboBox<Integer> cHour = new JComboBox<>();       // Create cHour Combo Box
        JComboBox<Integer> cMin = new JComboBox<>();        // Create cMin Combo Box
        JComboBox doclist = new JComboBox();        // Create docList Combo Box
        allComboBox(frame, dobDate, dobMonth, dobYear, cDate, cMonth, cYear, cHour, cMin, doclist);     // Call allComboBox method

        BookButton(frame, fName, sName, mobile, id, password, area, dobDate, dobMonth, dobYear, cDate, cMonth, cYear, cHour, cMin, doclist);    // Call BookButton method
        BackButton(frame);      // Call BackButton method
    }

    // Create setFrame Method to add Frame
    public static void setFrame(JFrame frame){
        ImageIcon img = new ImageIcon("C:\\Users\\HP\\Desktop\\Folder\\IIT\\2nd_Year_1st_Sem\\NEW\\OOP\\CW\\FinalCw\\Images\\icon30.png"); // Read the icon path
        frame.setIconImage(img.getImage()); // Set Icon image to frame
        frame.setTitle("Westminster Skin Consultation");    // Set Title to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Set default close operation to frame
        frame.setSize(650,650); // Set Size to frame
        frame.setLayout(null);  // Set layout null to frame
        frame.setLocationRelativeTo(null);  // Set Location Relative null to frame
        frame.setResizable(false);  // Set false of frame resizable
        frame.setVisible(true); // set visible frame
    }

    // Create mainTopLabel method to add frame
    public static void mainTopLabel(JFrame frame){
        JLabel label = new JLabel("Book Consultation"); // Create label for frame
        JLabel labelImage = new JLabel();   // Create JLabel to add image
        setLabel(label);    // Call setLabel method
        setImageDoctor(labelImage); // Call setImageDoctor method
        frame.add(labelImage);  // add labelImage to frame
        frame.add(label);   // add label to frame
    }

    // Create setLabel method to add frame
    public static void setLabel(JLabel label){
        label.setBounds(220,20,300,50); // Set bounds of label
        label.setVerticalTextPosition(JLabel.TOP);  // Set Vertical test position top to JLabel
        label.setHorizontalAlignment(JLabel.CENTER);    // Set Horizontal Alignment center to JLabel
        label.setFont(new Font("Times new romes",Font.BOLD, 30));   // Set Font name and size
        label.setForeground(new java.awt.Color(1, 21, 43)); // set label Foreground color
    }

    // Create setImageDoctor method to add image
    public static void setImageDoctor(JLabel labelImage){
        ImageIcon drIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\Folder\\IIT\\2nd_Year_1st_Sem\\NEW\\OOP\\CW\\FinalCw\\Images\\consultationR75.png"); // Read the image path
        labelImage.setBounds(50,-5,100,100);    // Set bounds to label
        labelImage.setIcon(drIcon); // set icon to image
    }

    public static void allLabel(JFrame frame){
        JLabel fName = new JLabel("Enter First Name");  // Create JLabel name fName
        JLabel sName = new JLabel("Enter Last Name");   // Create JLabel name sName
        JLabel dob = new JLabel("Date Of Birth");   // Create JLabel name dob
        JLabel mobile = new JLabel("Enter Mobile No");  // Create JLabel name mobile
        JLabel id = new JLabel("Patient ID");   // Create JLabel name id
        JLabel select = new JLabel("Select Doctor");    // Create JLabel name select
        JLabel consultationDate = new JLabel("Consultation Date");  // Create JLabel name consultationDate
        JLabel consultationTime = new JLabel("Time");   // Create JLabel name consultationTime
        JLabel specialNote = new JLabel("Special Note");    // Create JLabel name specialNote
        JLabel uploadImage = new JLabel("Upload Image and set password");   // Create JLabel name uploadImage

        fName.setBounds(57,120,150,10);     // Set bounds for fName Label
        labelDesign(fName); // Call labelDesign method

        sName.setBounds(57,160,150,10);     // Set bounds for sName Label
        labelDesign(sName); // Call labelDesign method

        dob.setBounds(57,200,150,10);       // Set bounds for dob Label
        labelDesign(dob);   // Call labelDesign method

        mobile.setBounds(57,240,150,10);    // Set bounds for mobile Label
        labelDesign(mobile);    // Call labelDesign method

        id.setBounds(57,280,150,10);        // Set bounds for id Label
        labelDesign(id);    // Call labelDesign method

        select.setBounds(57, 320, 150,10);  // Set bounds for select Label
        labelDesign(select);    // Call labelDesign method

        consultationDate.setBounds(57, 360,150,10); // Set bounds for consultationDate Label
        labelDesign(consultationDate);  // Call labelDesign method

        consultationTime.setBounds(420, 355,40,10); // Set bounds for consultationTime Label
        labelDesign(consultationTime);  // Call labelDesign method

        specialNote.setBounds(57, 400, 150,20); // Set bounds for specialNote Label
        labelDesign(specialNote);   // Call labelDesign method

        uploadImage.setBounds(57, 470, 250, 20);    // Set bounds for uploadImage Label
        labelDesign(uploadImage);   // Call labelDesign method

        frame.add(fName);   // fName Label add to frame
        frame.add(sName);   // sName Label add to frame
        frame.add(dob);     // dob Label add to frame
        frame.add(mobile);  // mobile Label add to frame
        frame.add(id);      // id Label add to frame
        frame.add(select);  // select Label add to frame
        frame.add(consultationDate);    // consultationDate Label add to frame
        frame.add(consultationTime);    // consultationTime Label add to frame
        frame.add(specialNote);         // specialNote Label add to frame
        frame.add(uploadImage);         // uploadImage Label add to frame
    }

    // Create labelDesign method to design all label
    public static void labelDesign(JLabel label){
        label.setFont(new Font("Times new romes",Font.BOLD, 13));   // Set label name and size
        label.setForeground(new java.awt.Color(1, 21, 43));     // Set label foreground color
    }

    // Create mainTextField method to set textField
    public static void  mainTextField(JFrame frame, JTextField fName, JTextField sName, JTextField mobile, JTextField id, JTextField password){
        fName.setBounds(220, 110, 360,25);  // Set bounds to fName
        fName.setFont(new Font("Times new romes",Font.PLAIN, 14));  // Set font name and size
        frame.add(fName);   // add fName to frame

        sName.setBounds(220,150,360,25);    // Set bounds to sName
        sName.setFont(new Font("Times new romes",Font.PLAIN, 14));  // Set font name and size
        frame.add(sName);   // add fName to frame

        mobile.setBounds(220,230,360,25);   // Set bounds to mobile
        mobile.setFont(new Font("Times new romes",Font.PLAIN, 14)); // Set font name and size
        frame.add(mobile);  // add fName to frame

        id.setBounds(220,270,360,25);   // Set bounds to id
        id.setFont(new Font("Times new romes",Font.PLAIN, 14));     // Set font name and size
        frame.add(id);  // add fName to frame

        password.setBounds(280, 465, 70,25);    // Set bounds to password
        password.setFont(new Font("Times new romes",Font.PLAIN, 14));   // Set font name and size
        frame.add(password);    // add fName to frame
    }

    // Create noteArea method to add note
    public static void noteArea(JFrame frame, JTextArea textArea){
        textArea.setBounds(220,390,360, 50);    // Set bounds to textArea
        frame.add(textArea);    // add textArea to frame
    }

    // Create allComboBox method to add all combo boxes
    public static void allComboBox(JFrame frame, JComboBox<Integer> date, JComboBox<Integer> month, JComboBox<Integer> year,
                                   JComboBox<Integer> cDate, JComboBox<Integer> cMonth, JComboBox<Integer> cYear, JComboBox<Integer> cHour, JComboBox<Integer> cMin, JComboBox doclist){

        // Run for loop and add date of birth and consultation dates 0-31
        for (int i = 0; i < 32; i++){
            date.addItem(i);    // add {i} for DOB date
            cDate.addItem(i);   // add {i} for consultation date
        }
        date.setBounds(220,190,50,20);  // set bounds DOB date
        frame.add(date);    // add DOB date to frame

        // Run for loop and add month of DOB and consultation 0 - 12
        for (int i = 0; i < 13; i++){
            month.addItem(i);   // add {i} for DOB month
            cMonth.addItem(i);  // add {i} for consultation month
        }
        month.setBounds(280,190,50,20); // Set bounds DOB month
        frame.add(month);   // add consultation month to frame

        // Run for loop and add year of DOB
        for (int i = 0; i < 101; i++){
            year.addItem(1922 + i); // add {i + 1922} for DOB year
        }
        year.setBounds(340,190,70,20);  // set bounds DOB year
        frame.add(year);    // add DOB year to frame

        cDate.setBounds(220,350,50,20); // Set bounds consultation date
        frame.add(cDate);   // add consultation date to frame

        cMonth.setBounds(280,350,50,20);    // set bounds consultation month
        frame.add(cMonth);  // add consultation month to frame

        cYear.addItem(2022);    // add 2022 year for consultation year
        cYear.addItem(2023);    // add 2023 year for consultation year
        cYear.addItem(2024);    // add 2024 year for consultation year
        cYear.setBounds(340,350,70,20); // set bounds consultation year
        frame.add(cYear);   // add consultation year to frame

        // Run for loop and add hours to consultation hour
        for (int i = 0; i < 25; i++){
            cHour.addItem(i);   // add {i} to consultation hour
        }
        cHour.setBounds(470, 350, 50,20);   // set bounds consultation hours
        frame.add(cHour);   // add consultation hour to frame

        cMin.addItem(00);   // add 0 minute to consultation minute
        cMin.setBounds(530, 350,50,20); // set bounds to consultation minutes
        frame.add(cMin);    // add consultation minute to frame


        if (Doctor.doctorList.size()>0){ // Check doctorList size more than 0
            // Run for loop and add doctorList details to doclist arrayList
            for (int i = 0; i < Doctor.doctorList.size(); i++){
                // add doclist to doctor surname, licence number, and specialisation
                doclist.addItem(Doctor.doctorList.get(i).getSurname() + " || " + Doctor.doctorList.get(i).getLicenceNumber() + " || " +Doctor.doctorList.get(i).getSpecialisation());
            }
            doclist.setBounds(220,310,260,25);  // set bounds doclist combo box
            frame.add(doclist); // add doclist combo box to frame
        }

//        if (DoctorFrame.docCombo.size()>0){
//            for (int i = 0; i < DoctorFrame.docCombo.size(); i++){
//                doclist.addItem(DoctorFrame.docCombo.get(i));
//            }
//            doclist.setBounds(250,420,350,30);
//            frame.add(doclist);
//        }
    }

    // Create book button to book consultation
    public static void BookButton(JFrame frame, JTextField fName, JTextField sName, JTextField mobile, JTextField id, JTextField password, JTextArea area, JComboBox<Integer> date, JComboBox<Integer> month, JComboBox<Integer> year,
                                  JComboBox<Integer> cDate, JComboBox<Integer> cMonth, JComboBox<Integer> cYear, JComboBox<Integer> cHour, JComboBox<Integer> cMin, JComboBox doclist){

        JButton btnBook = new JButton("Book Consultation"); // add JButton to book consultation
        btnBook.setFont(new Font("Times new romes", Font.BOLD, 13));    // set font name and size
        btnBook.setBounds(57,550,170,35);   // set bounds to JButton
        btnBook.setFocusable(false);    // set false focusable
        btnBook.setBackground(new Color(138, 207, 227,150));    // set JButton background color

        JButton uploadBtn = new JButton("Upload Image");    // set JButton to upload Image
        uploadBtn.setFont(new Font("Times new romes", Font.BOLD, 13));  // set font name and size
        uploadBtn.setBounds(370,465,150,25);    // set bounds to JButton
        uploadBtn.setFocusable(false);  // set false focusable
        uploadBtn.setBackground(new Color(138, 207, 227,150));  // set JButton background color

        // add action listener to upload button when click the button copy the image file from past to new path
        uploadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == uploadBtn){
                    JFileChooser fileChooser = new JFileChooser();  // Create JFileChooser object
                    int response = fileChooser.showOpenDialog(null);    // read response from show open dialog from file chooser
                    if (response == JFileChooser.APPROVE_OPTION){   // Check if file selected or not
                        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());  // get a absolute file path to File Object

                        FileInputStream in = null;  // set FileInputStream null
                        FileOutputStream ou = null; // Set FileOutputStream null

                        // use try catch method to avoid errors
                        try {
                            in = new FileInputStream(file); // pass the selected file location
                            ou = new FileOutputStream("C:\\Users\\HP\\Desktop\\Folder\\IIT\\2nd_Year_1st_Sem\\NEW\\OOP\\CW\\FinalCw\\SkinImages\\" + file.getName());  // pass the selected file location
                        } catch (Exception exe){
                            exe.printStackTrace();
                        }

                        BufferedInputStream bin = new BufferedInputStream(in);  // Create BufferedInputStream and pass the input file path
                        BufferedOutputStream bou = new BufferedOutputStream(ou);    // Create BufferedOutputStream and pass the output file path

                        int b = 0;  // assign int b variable = 0
                        // Use check b not equal -1
                        while (b!= -1){
                            try {
                                b = bin.read(); // read the BufferedInputStream
                                bou.write(b);   // write the BufferedOutputStream
                            }catch (IOException er){
                                er.printStackTrace();
                            }
                        }

                        try{
                            bin.close();    // close BufferedInputStream
                            bou.close();    // close BufferedOutputStream
                        } catch (IOException ee){
                            ee.printStackTrace();
                        }

                        // Set upload path
                        File uploadPath = new File("C:\\Users\\HP\\Desktop\\Folder\\IIT\\2nd_Year_1st_Sem\\NEW\\OOP\\CW\\FinalCw\\SkinImages\\" + file.getName());
                        fileArrayList.add(countConsultation, uploadPath);   // add fileArrayList to each uploaded paths
//                        System.out.println(file);
                    }
                }
            }
        });

        // add action listener to book consultation
        btnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnBook) {

                    String pFName = fName.getText();    // read the patient first name from textFiled
                    String pSName = sName.getText();    // read the patient first surname from textFiled

                    int pMobile = 0;    // set patient mobile number = 0
                    // use try catch to avoid miss match input
                    try{
                        pMobile = Integer.parseInt(String.valueOf(mobile.getText()));   // Read patient mobile number as an integer type
                    } catch (Exception er){
                        // if the patient mobile number miss match type showing message
                        JOptionPane.showMessageDialog(null, "Please Enter valid Mobile number: ", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                    }

                    int pId = 0;    // set patient ID = 0
                    // use try catch to avoid miss match input
                    try{
                        pId = Integer.parseInt(String.valueOf(id.getText()));   // Read patient ID as an integer type
                    }catch (Exception er){
                        // if the patient ID miss match type showing message
                        JOptionPane.showMessageDialog(null,"PLease Enter valid ID number: ", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                    }

                    Date dobPatient = new Date();   // Create Date object to patient DOB
                    int datePDOB = Integer.parseInt(String.valueOf(date.getSelectedItem()));    // Read selected patient DOB date from combo box
                    if (datePDOB > 0){  // Check the selected DOB date is valid
                        dobPatient.setDate(datePDOB);   // set DOB date to created patient DOB object
                    } else {
                        // show message if the patient DOB date not valid
                        JOptionPane.showMessageDialog(null,"PLease Select valid Patient Birth Date: ", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                    }

                    int monthPDOB = Integer.parseInt(String.valueOf(month.getSelectedItem()));  // Read selected patient DOB month from combo box
                    if (monthPDOB > 0){ // Check the selected DOB month is valid
                        dobPatient.setMonth(monthPDOB); // set DOB month to created patient DOB object
                    } else {
                        // show message if the patient DOB month not valid
                        JOptionPane.showMessageDialog(null,"PLease Select valid Patient Birth Month: ", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                    }

                    dobPatient.setYear(Integer.parseInt(String.valueOf(year.getSelectedItem())));   // set DOB year to created patient DOB object

                    //---------------------- Consultation Details --------------------------//

                    Date consultationDate = new Date(); // Create Date object to book consultation

                    int conDate = Integer.parseInt(String.valueOf(cDate.getSelectedItem()));    // Read selected consultation date from combo box
                    if (conDate > 0){   // Check the selected consultation date is valid
                        consultationDate.setDate(conDate);  // set consultation date to created consultationDate object
                    }else {
                        // show message if the consultation date not valid
                        JOptionPane.showMessageDialog(null,"PLease Select valid Consultation Date: ", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                    }

                    int conMonth = Integer.parseInt(String.valueOf(cMonth.getSelectedItem()));  // Read selected consultation month from combo box
                    if(conMonth > 0){   // Check the selected consultation month is valid
                        consultationDate.setMonth(conMonth);    // set consultation month to created consultationDate object
                    }else {
                        // show message if the consultation month not valid
                        JOptionPane.showMessageDialog(null,"PLease Select valid Consultation Month: ", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                    }

                    int conYear = Integer.parseInt(String.valueOf(cYear.getSelectedItem()));    // Read selected consultation year from combo box
                    int conHour = Integer.parseInt(String.valueOf(cHour.getSelectedItem()));    // Read selected consultation hour from combo box
                    int conMinute = Integer.parseInt(String.valueOf(cMin.getSelectedItem()));   // Read selected consultation minute from combo box

                    consultationDate.setYear(conYear);      // set consultation year to created consultationDate object
                    consultationDate.setHours(conHour);     // set consultation hours to created consultationDate object
                    consultationDate.setMinutes(conMinute); // set consultation minutes to created consultationDate object

                    String dfDet = String.valueOf(doclist.getSelectedItem());

                    int dfIndex = Integer.parseInt(String.valueOf(doclist.getSelectedIndex())); // Read combo box index from selected index

                    int dLicenseNumber = Doctor.doctorList.get(dfIndex).getLicenceNumber(); // identify the doctor license number from doctorList
                    String dSureName = Doctor.doctorList.get(dfIndex).getSurname(); // identify the doctor surname from the doctorList
                    String dSpecial = Doctor.doctorList.get(dfIndex).getSpecialisation();   // identify the doctor specialisation from the doctorList

                    int indexPaediatric= (int)(Math.random() * Doctor.paediatric.size());   // identify the index number of paediatric doctor from paediatric list
                    int indexMedical= (int)(Math.random() * Doctor.medical.size()); // identify the index number of medical doctor from medical list
                    int indexCosmetic= (int)(Math.random() * Doctor.cosmetic.size());   // identify the index number of cosmetic doctor from cosmetic list

                    String notes = area.getText();  // read the patient special notes from textFiled

                    int encryptPass = 0;  // set to encrypt password 0
                    try {
                        encryptPass = Integer.parseInt(String.valueOf(password.getText())); // Read encrypt password as an integer type from textField
                    } catch (Exception er){
                        // show message if encrypt password not valid
                        JOptionPane.showMessageDialog(null, "Please Enter valid password: ", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                    }

                    double cost;    // Create double variable as a cost

                    // Check if text field details are valid
                    if (pMobile > 0 && pId > 0 && datePDOB >0 && monthPDOB > 0 && conDate > 0 && conMonth >0 && encryptPass > 0){

                        // Check the patient already in the patient list or not, for that call checkPatient list
                        if (checkPatient(Patient.patientsList,Integer.parseInt(String.valueOf(pId)))){
//                            Patient.patientsList.add(new Patient(pFName, pSName, dobPatient, pMobile, pId)); // if entered patient not in the patient list add to patientsList

                            cost = 15.00;   // set cost for first time entered patient 15
                        } else {
                            cost = 25.00;   // set cost for more than one time visit patient
                        }

                        System.out.println("Cost " + cost);

                        //  Check the consultation already has consultation at the time
                        if (checkDoctorAvailable(Consultation.consultationList, consultationDate, dLicenseNumber)){

                            // ask confirmation from patient to book the consultation from JOptionPane
                            int answer = JOptionPane.showConfirmDialog(null, "Patient First Name: " + pFName + "\n"
                                            + "Patient Id: " + pId + "\n"
                                            + "Doctor Sure Name: " + dSureName + "\n"
                                            + "Consultation Date: " + consultationDate.getDate() + "/" + consultationDate.getMonth() +"/"+ consultationDate.getYear()
                                            + "  Time: " + consultationDate.getHours() + ":" + consultationDate.getMinutes() +"\n"
                                            + "Consultation Fee: " + cost + "\n"
                                    , "Request Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

                            // if answer equal yes then the booking consultation
                            if (answer == 0){
                                ecrypt(fileArrayList.get(countConsultation),encryptPass);   // encrypt the image from fileArrayList using encrypt password
                                System.out.println("Patient Added");
                                Patient.patientsList.add(new Patient(pFName, pSName, dobPatient, pMobile, pId)); // if entered patient not in the patient list add to patientsList
                                // add the consultation and add the details to consultation arrayList
                                Consultation.consultationList.add(countConsultation, new Consultation(dSureName, dLicenseNumber, pFName, pId, consultationDate, cost, notes, encryptPass, fileArrayList.get(countConsultation)));

                                System.out.println("Consultation added normally");
                                // Call setDefault method
                                setDefault(fName, sName, mobile, id, date, month, year,
                                        cDate, cMonth, cYear, cHour, cMin, doclist, area, password);
                                countConsultation++;    // add countConsultation to 1
                            }

                            // if consultation have already at that same time to same doctor then move with else part
                        } else {
                            // check the doctor specialization is cosmetic dermatology
                            if (dSpecial.equalsIgnoreCase("cosmetic dermatology")) {
                                System.out.println("Have another time");
                                // check the cosmetic dermatology doctor surname equals previous doctor surname
                                if (!Doctor.cosmetic.get(indexCosmetic).getSurname().equals(dSureName)){
                                    // show confirmation message to patient the selected doctor is busy and allocated to another doctor for booking

                                    int answer = JOptionPane.showConfirmDialog(null, "Doctor " + dSureName + " has another consultation at that time, so we added " +
                                            Doctor.cosmetic.get(indexCosmetic).getSurname() + " to your consultation, are you okay for that? ", "Request Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

                                    dSureName = Doctor.cosmetic.get(indexCosmetic).getSurname();
                                    dLicenseNumber = Doctor.cosmetic.get(indexCosmetic).getLicenceNumber();

                                    // if answer equal yes then the booking consultation
                                    if (answer == 0){
                                        // ask confirmation from patient to book the consultation from JOptionPane
                                        int answerCos = JOptionPane.showConfirmDialog(null, "Patient First Name: " + pFName + "\n"
                                                        + "Patient Id: " + pId + "\n"
                                                        + "Doctor Sure Name: " + dSureName + "\n"
                                                        + "Consultation Date: " + consultationDate.getDate() + "/" + consultationDate.getMonth() +"/"+ consultationDate.getYear()
                                                        + "  Time: " + consultationDate.getHours() + ":" + consultationDate.getMinutes() +"\n"
                                                        + "Consultation Fee: " + cost + "\n"
                                                , "Request Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
                                        // if answer equal yes then the booking consultation
                                        if (answerCos == 0){
                                            ecrypt(fileArrayList.get(countConsultation),encryptPass);   // encrypt the image from fileArrayList using encrypt password
                                            System.out.println("Patient Added");
                                            Patient.patientsList.add(new Patient(pFName, pSName, dobPatient, pMobile, pId)); // if entered patient not in the patient list add to patientsList
                                            // add the consultation and add the details to consultation arrayList
                                            Consultation.consultationList.add(countConsultation, new Consultation(dSureName, dLicenseNumber, pFName, pId, consultationDate, cost, notes, encryptPass, fileArrayList.get(countConsultation)));
                                            System.out.println("Consultation added randomly");
                                            // Call setDefault method
                                            setDefault(fName, sName, mobile, id, date, month, year,
                                                    cDate, cMonth, cYear, cHour, cMin, doclist, area, password);
                                            countConsultation++;    // add countConsultation to 1
                                        }
                                    } else {
                                        // if the patient not like to add to random doctor then showing message to choose different time
                                        JOptionPane.showMessageDialog(null," PLease Select another time ", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            } else if (dSpecial.equalsIgnoreCase("medical dermatology")) { // check the doctor specialization is medical dermatology
                                // check the medical dermatology doctor surname equals previous doctor surname
                                if (!Doctor.medical.get(indexMedical).getSurname().equals(dSureName)){
                                    // show confirmation message to patient the selected doctor is busy and allocated to another doctor for booking
                                    int answer = JOptionPane.showConfirmDialog(null, "Doctor " + dSureName + " has another consultation at that time, so we added " +
                                            Doctor.medical.get(indexCosmetic).getSurname() + " to your consultation, are you okay for that? ", "Request Confirmation", JOptionPane.YES_NO_OPTION);

                                    dSureName = Doctor.medical.get(indexCosmetic).getSurname();
                                    dLicenseNumber = Doctor.medical.get(indexCosmetic).getLicenceNumber();

                                    // if answer equal yes then the booking consultation
                                    if (answer == 0){
                                        // ask confirmation from patient to book the consultation from JOptionPane
                                        int answerMed = JOptionPane.showConfirmDialog(null, "Patient First Name: " + pFName + "\n"
                                                        + "Patient Id: " + pId + "\n"
                                                        + "Doctor Sure Name: " + dSureName + "\n"
                                                        + "Consultation Date: " + consultationDate.getDate() + "/" + consultationDate.getMonth() +"/"+ consultationDate.getYear()
                                                        + "  Time: " + consultationDate.getHours() + ":" + consultationDate.getMinutes() +"\n"
                                                        + "Consultation Fee: " + cost + "\n"
                                                , "Request Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

                                        // if answer equal yes then the booking consultation
                                        if (answerMed == 0){
                                            ecrypt(fileArrayList.get(countConsultation),encryptPass);   // encrypt the image from fileArrayList using encrypt password
                                            System.out.println("Patient Added");
                                            Patient.patientsList.add(new Patient(pFName, pSName, dobPatient, pMobile, pId)); // if entered patient not in the patient list add to patientsList
                                            // add the consultation and add the details to consultation arrayList
                                            Consultation.consultationList.add(countConsultation, new Consultation(dSureName, dLicenseNumber, pFName, pId, consultationDate, cost, notes, encryptPass, fileArrayList.get(countConsultation)));
                                            System.out.println("Consultation added randomly");
                                            // Call setDefault method
                                            setDefault(fName, sName, mobile, id, date, month, year,
                                                    cDate, cMonth, cYear, cHour, cMin, doclist, area, password);
                                            countConsultation++;
                                        }

                                    } else {
                                        // if the patient not like to add to random doctor then showing message to choose different time
                                        JOptionPane.showMessageDialog(null,"PLease Select another time ", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            } else if (dSpecial.equalsIgnoreCase("paediatric dermatology")) {   // check the doctor specialization is paediatric dermatology
                                // check the paediatric dermatology doctor surname equals previous doctor surname
                                if (!Doctor.paediatric.get(indexPaediatric).getSurname().equals(dSureName)){
                                    // show confirmation message to patient the selected doctor is busy and allocated to another doctor for booking
                                    int answer = JOptionPane.showConfirmDialog(null, "Doctor " + dSureName + " has another consultation at that time, so we added " +
                                            Doctor.paediatric.get(indexCosmetic).getSurname() + " to your consultation, are you okay for that? " , "Request Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

                                    dSureName = Doctor.paediatric.get(indexCosmetic).getSurname();
                                    dLicenseNumber = Doctor.paediatric.get(indexCosmetic).getLicenceNumber();

                                    // if answer equal yes then the booking consultation
                                    if (answer == 0){
                                        // ask confirmation from patient to book the consultation from JOptionPane
                                        int answerPae = JOptionPane.showConfirmDialog(null, "Patient First Name: " + pFName + "\n"
                                                        + "Patient Id: " + pId + "\n"
                                                        + "Doctor Sure Name: " + dSureName + "\n"
                                                        + "Consultation Date: " + consultationDate.getDate() + "/" + consultationDate.getMonth() +"/"+ consultationDate.getYear()
                                                        + "  Time: " + consultationDate.getHours() + ":" + consultationDate.getMinutes() +"\n"
                                                        + "Consultation Fee: " + cost + "\n"
                                                , "Request Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

                                        // if answer equal yes then the booking consultation
                                        if(answerPae == 0){
                                            ecrypt(fileArrayList.get(countConsultation),encryptPass);   // encrypt the image from fileArrayList using encrypt password
                                            System.out.println("Patient Added");
                                            Patient.patientsList.add(new Patient(pFName, pSName, dobPatient, pMobile, pId)); // if entered patient not in the patient list add to patientsList
                                            // add the consultation and add the details to consultation arrayList
                                            Consultation.consultationList.add(countConsultation, new Consultation(dSureName, dLicenseNumber, pFName, pId, consultationDate, cost, notes, encryptPass, fileArrayList.get(countConsultation)));
                                            System.out.println("Consultation added randomly");
                                            // Call setDefault method
                                            setDefault(fName, sName, mobile, id, date, month, year,
                                                    cDate, cMonth, cYear, cHour, cMin, doclist, area, password);
                                            countConsultation++;
                                        }

                                    } else {
                                        // if the patient not like to add to random doctor then showing message to choose different time
                                        JOptionPane.showMessageDialog(null,"PLease Select another time ", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }
                        }

                    } else {
                        System.out.println("Invalid");
                    }
                }
            }
        });

        if (Consultation.consultationList.size() > 0) {
            for (int i = 0; i < Consultation.consultationList.size(); i++) {
                System.out.println("Doctor Sname" + Consultation.consultationList.get(i).getDoctorSureName() + " Patient name:  " + Consultation.consultationList.get(i).getPatientFirstName() + " Patient ID: "
                        + Consultation.consultationList.get(i).getPatientId() + " Cost: " + Consultation.consultationList.get(i).getCost() + " Notes: " + Consultation.consultationList.get(i).getNotes() +
                        " password: " + Consultation.consultationList.get(i).getPassword() + " file path: " + Consultation.consultationList.get(i).getSkinImage());
            }
        }

        frame.add(uploadBtn);   // add upload image button to frame
        frame.add(btnBook);     // add book consultation button to frame
    }

    // Create ecrypt method to encrypt and decrypt updated photos
    public static void ecrypt(File file, int key){
        try{
            FileInputStream fileInputStream = new FileInputStream(file);    // Read the file path as FileInputStream

            byte [] data = new byte[fileInputStream.available()];   // create a Byte array to fileInputStream available
            fileInputStream.read(data); // read data as fileInputStream
            int i = 0;  // set int i as 0
            // using for loop run the every bit through
            for(byte b:data){
//                System.out.println(b);
                data[i] = (byte) (b ^ key);
                i++;
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file);     // use FileOutputStream and pass file path
            fileOutputStream.write(data);   // write data fo fileOutputStream
            fileOutputStream.close();   // close fileOutputStream
            fileInputStream.close();    // close fileInputStream

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // Create setDefault method to set all JTextField, JComboBox same as default
    public static void setDefault(JTextField fName, JTextField sName, JTextField mobile, JTextField id, JComboBox<Integer> date, JComboBox<Integer> month, JComboBox<Integer> year,
                                  JComboBox<Integer> cDate, JComboBox<Integer> cMonth, JComboBox<Integer> cYear, JComboBox<Integer> cHour, JComboBox<Integer> cMin, JComboBox doclist,
                                  JTextArea area, JTextField password){
        fName.setText("");
        sName.setText("");
        mobile.setText("");
        id.setText("");
        date.setSelectedItem(0);
        month.setSelectedItem(0);
        year.setSelectedItem(1922);
        cDate.setSelectedItem(0);
        cMonth.setSelectedItem(0);
        cYear.setSelectedItem(0);
        cHour.setSelectedItem(0);
        cMin.setSelectedItem(0);
        doclist.setSelectedIndex(0);
        area.setText("");
        password.setText("");
    }

    // Create checkPatient method to check if the patient already in the patient list or not
    public static boolean checkPatient(ArrayList<Patient> patientList, int pID){
        boolean checkPatientID = true;  // create boolean checkPatientID true
        // create for loop to go through the patientList
        for (int i = 0; i < patientList.size(); i++){
            // Check if the patient unique id equals
            if ((Patient.patientsList.get(i).getPatientUniqueId() == pID) && checkPatientID){
                checkPatientID = false; // if patient unique id is equal checkPatientID become a false and return
            }
        }
        return checkPatientID; // return checkPatientID
    }

    public static boolean checkDoctorAvailable(ArrayList<Consultation> consultationList, Date consultationDate, int dLicenseNumber){
        boolean checkDoctorTime = true; // create boolean checkDoctorTime true
        // Create for loop to go through the consultationList
        for (int i = 0; i < consultationList.size(); i++){
            // Check if the consultation date, time, and doctor license equals to added details
            if ((Consultation.consultationList.get(i).getDateAndTime().getHours() == consultationDate.getHours() &&
                    Consultation.consultationList.get(i).getDateAndTime().getDate() == consultationDate.getDate() &&
                    Consultation.consultationList.get(i).getDateAndTime().getMonth() == consultationDate.getMonth() &&
                    Consultation.consultationList.get(i).getDateAndTime().getYear() == consultationDate.getYear() &&
                    Consultation.consultationList.get(i).getDoctorLicense() == dLicenseNumber && checkDoctorTime)){

                checkDoctorTime = false;    // if consultation already have the same time to the doctor checkDoctorTime false and return
            }
        }
        return  checkDoctorTime;    // return checkDoctorTime
    }

    // Create BackButton method to set back button to frame
    public static void BackButton(JFrame frame){
        JButton button = new JButton("Back");   // add back JButton to back
        button.setFont(new Font("Times new romes", Font.BOLD, 13)); // set font name and size
        button.setBounds(480,550,100,30);   // set bounds to JButton
        button.setFocusable(false); // set false focusable
        button.setBackground(new java.awt.Color(138, 207, 227,150));    // set JButton background color
        frame.add(button);  // add back button to frame

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

}
