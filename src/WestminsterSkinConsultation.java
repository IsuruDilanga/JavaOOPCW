import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class WestminsterSkinConsultation{

    // Static variable count Doctor
    static int count;

    // Main method
    public static void main(String[] args) throws IOException {

        count = 0;
        Scanner input = new Scanner(System.in);

        loadDetails();  // load Details from save text File

        boolean repeat = true; // Create boolean to run program continuously
        while (repeat) {

            System.out.println("""
                    \nSelect A: to add Doctor
                    Select D: to delete Doctor
                    Select V: to View Doctor
                    select S: to save 
                    select G: to open GUI
                    Select E: Exit\n""");

            // Crate Switch case
            switch (Character.toUpperCase(input.next().charAt(0))) {
                case 'A' -> addDoctor(Doctor.doctorList);
                case 'D' -> deleteDoctor(Doctor.doctorList);
                case 'V' -> viewDoctor(Doctor.doctorList);
                case 'S' -> saveDetails(Doctor.doctorList);
                case 'G' -> openGUI();
                case 'E' -> repeat = false;
                default -> System.out.println("Wrong input");
            }
        }

    }

    // Create Open GUI Method to open GUI
    public static void openGUI() {

        // Call  westminsterSkinConsultation class for start GUI main frame
        MainForm openMainFrame = new MainForm();
        System.out.println("GUI Open");
    }

    // Create loadDetails method to load details from text file
    public static void loadDetails() {
        // Use try catch
        try {
            File filelocation = new File("C:/Users/HP/Desktop/Folder/IIT/2nd_Year_1st_sem/NEW/OOP/CW/FinalCw/File/details.txt");
            Scanner fileReader = new Scanner(filelocation);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. ");
            e.printStackTrace();
        }
    }

    // Create check method to check if doctor already in the doctor list or not
    public static boolean check(ArrayList<Doctor> doctorList, int licence) {
        boolean checkCustomerName = true;   // Crete checkCustomerName boolean method true,
        for (int i = 0; i < doctorList.size(); i++) {

            // Check new doctor licence include doctorList or not
            if ((doctorList.get(i).getLicenceNumber() == licence) && checkCustomerName) {
                checkCustomerName = false;
            }
        }

        return checkCustomerName;   // return boolean doctor already in the list or not
    }

    // Create addDoctor method to add doctors to doctorList and pass doctorList
    public static void addDoctor(ArrayList<Doctor> doctorList) {

        Scanner input = new Scanner(System.in);
        Date dob = new Date();  // Create dob Date object

        // Check if doctor list exceed 10 doctors
        if (count < 10) {

            int licence = 0;
            // Use try catch and check InputMismatchException
            try {
                System.out.println("Enter Doctor licence number: ");
                licence = input.nextInt(); // Read doctor license number
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid licence number: ");
                addDoctor(doctorList);
            }

            // use check method and check the doctor already in the list or not
            if (check(doctorList, licence)) {

                System.out.println("Enter Doctor first name: ");
                String fName = input.next();    // Read doctor first name
                System.out.println("Enter Doctor last name: ");
                String lName = input.next();    // Read doctor last name

                System.out.println("Enter Doctor birth Year: ");
                int year = input.nextInt();     // Read doctor birth year
                System.out.println("Enter Doctor birth month: ");
                int month = input.nextInt();    // Read doctor birth month
                System.out.println("Enter Doctor birth date: ");
                int date = input.nextInt();     // Read doctor birth day

                dob.setYear(year);  // set doctor birth year
                dob.setMonth(month);    // set doctor birth month
                dob.setDate(date);  // set doctor birth day
                System.out.println("Enter Doctor mobile number: ");
                int mobile = input.nextInt();   // Read doctor mobile number
                System.out.println("Enter Doctor Specialization: ");
                String specialization = input.next();   // Read doctor specialization

                // Add doctor to doctorList
                doctorList.add(count, new Doctor(lName, fName, dob, mobile, licence, specialization + " dermatology"));
                System.out.println("Doctor added successfully");

                count++;

            } else {
                // If doctor already in the list showing below message
                System.out.println("The doctor " + licence + " number already in the list");
            }
        } else {
            System.out.println("10 Doctors already in the hospital");
        }
    }

    // Create saveDetails method to save added doctors
    public static void saveDetails(ArrayList<Doctor> doctorList) throws IOException {

        try (FileWriter f = new FileWriter("C:/Users/HP/Desktop/Folder/IIT/2nd_Year_1st_sem/NEW/OOP/CW/FinalCw/File/details.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            // save local date and time when save the doctorList
            p.println("\nDoctor Details on : " + LocalDateTime.now() + "\n");

            // Save doctor details as a table
            p.printf("%-15s%-15s%-15s%-15s%-15s%7s\n", "Last Name,", "First Name,", "Birth Day,", "Mobile No,", "Licence No,", "Specialisation");
            for (int i = 0; i < doctorList.size(); i++) {

                // Save all doctor details so text file
                p.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", doctorList.get(i).getSurname(),
                        doctorList.get(i).getName(),
                        doctorList.get(i).getDOB().getDate() + "-" + doctorList.get(i).getDOB().getMonth() + "-" + doctorList.get(i).getDOB().getYear(),
                        doctorList.get(i).getMobileNo(),
                        doctorList.get(i).getLicenceNumber(),
                        doctorList.get(i).getSpecialisation());

            }
            System.out.println("All details save!");
        }

    }

    // Create view doctor method to view doctors
    public static void viewDoctor(ArrayList<Doctor> doctorList) {

        //Sort doctorList according to the doctor surNames
        Collections.sort(doctorList, Doctor.surNameComparator);

        System.out.printf("%-15s%-15s%-15s%-15s%-15s%7s\n", "First Name,", "Last Name,", "Birth Day,", "Mobile No,", "Licence No,", "Specialisation");
        for (int i = 0; i < doctorList.size(); i++) {
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", doctorList.get(i).getName(), doctorList.get(i).getSurname(),
                    doctorList.get(i).getDOB().getDate() + "-" + doctorList.get(i).getDOB().getMonth() + "-" + doctorList.get(i).getDOB().getYear(),
                    (doctorList.get(i).getMobileNo()), (doctorList.get(i).getLicenceNumber()), (doctorList.get(i).getSpecialisation()));
        }

    }

    // Create deleteDoctor method to delete doctor from doctorList
    public static void deleteDoctor(ArrayList<Doctor> doctorList) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the doctor licence number: ");
        int licenceNumber = input.nextInt(); // Read doctor licence number

        for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).getLicenceNumber() == licenceNumber) { // Check doctor licence number in the doctorList
                System.out.println("Enter doctor last name: ");
                String sureName = input.next(); // Read doctor surName
                for (int j = 0; j < doctorList.size(); j++) {
                    if (doctorList.get(j).getSurname().equalsIgnoreCase(sureName)) {
                        System.out.println("removed doctor: " + doctorList.get(j).getName() + " " + doctorList.get(j).getSurname());
                        doctorList.remove(j); // Remove Doctor from doctor list
                        count--;    // Reduce count from doctorList
                    }
                }
            }
        }
    }

}
