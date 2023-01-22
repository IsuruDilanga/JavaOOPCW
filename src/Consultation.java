import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Consultation {

    static ArrayList<Consultation> consultationList = new ArrayList<>();    // Create consultationList arrayList to add consultation
    private String doctorSureName;  // Create doctorSureName instance variable
    private int doctorLicense;  // Create doctorSureName instance variable
    private String patientFirstName;    // Create doctorSureName instance variable
    private int patientId;  // Create doctorSureName instance variable
    private Date dateAndTime;   // Create doctorSureName instance variable
    private double cost;    // Create doctorSureName instance variable
    private String notes;   // Create doctorSureName instance variable
    private int password;   // Create doctorSureName instance variable
    private File skinImage; // Create doctorSureName instance variable

    static int countConsultation;

    // Create Consultation constructor
    public Consultation(String doctorSureName, int doctorLicense, String patientFirstName, int patientID, Date dateAndTime, double cost, String notes, int password, File skinImage) {
        this.doctorSureName = doctorSureName;
        this.doctorLicense = doctorLicense;
        this.patientFirstName = patientFirstName;
        this.patientId = patientID;
        this.dateAndTime = dateAndTime;
        this.cost = cost;
        this.notes = notes;
        this.password = password;
        this.skinImage = skinImage;
    }

    // Get Doctor license from get method
    public int getDoctorLicense(){return this.doctorLicense;}

    // Set doctor license from set method
    public void setDoctorLicense(int doctorLicense){this.doctorLicense = doctorLicense;}

    // Get password from get method
    public int getPassword(){
        return this.password;
    }

    // Set password from set method
    public void setPassword(int password){
        this.password = password;
    }

    // Get file path of image from get method
    public File getSkinImage(){
        return this.skinImage;
    }

    // Set file path of image from set method
    public void setSkinImage(File skinImage){
        this.skinImage = skinImage;
    }
//
////    public static void deleteConsultation(ArrayList<Consultation> consultationList, ArrayList<Patient> patientList){
////        Scanner input = new Scanner(System.in);
////
////        System.out.println("Enter patient first name: ");
////        String pfName = input.next();
////        for (int i = 0; i < consultationList.size(); i++){
////            if(consultationList.get(i).getPatientFirstName().equalsIgnoreCase(pfName)){
////                System.out.println("Enter patient id: ");
////                int pid = input.nextInt();
////                if (consultationList.get(i).getPatientId() == pid){
////                    System.out.println("Consultation removed");
////                    consultationList.remove(i);
////                    patientList.remove(i);
////                }
////            }
////        }
////    }
//
////    public static void bookedConsultation(ArrayList<Consultation> consultationList, ArrayList<Patient> patientList) {
////        Scanner input = new Scanner(System.in);
////
////        ConsoleMain.viewDoctor(Doctor.doctorList);
////        System.out.println("Enter the Doctor sureName: ");
////        String doctorSureName = input.next();
////        for (int i = 0; i < Doctor.doctorList.size(); i++) {
////            if (Doctor.doctorList.get(i).getSurname().equalsIgnoreCase(doctorSureName)) {
////
////                addPatient(Patient.patientsList, doctorSureName);
////                countConsultation++;
////            }
////        }
////    }
//
//    public static void addPatient(ArrayList<Patient> patientList, String doctorSureName) {
//
//        Scanner input = new Scanner(System.in);
//        System.out.println("-------------: Requesting patient details :------------- ");
//
//        System.out.println("Enter patient first name: ");
//        String pfName = input.next();
//        System.out.println("Enter patient sure name: ");
//        String psName = input.next();
//
//        Date dob = new Date();
//        System.out.println("Enter patient birth Year");
//        int year = input.nextInt();
//        System.out.println("Enter patient birth month");
//        int month = input.nextInt();
//        System.out.println("Enter patient birth date");
//        int date = input.nextInt();
//        dob.setYear(year - 1900);
//        dob.setMonth(month - 1);
//        dob.setDate(date);
//
//        System.out.println("Enter patient mobile number: ");
//        int pMobile = input.nextInt();
//        System.out.println("Enter patient id: ");
//        int pID = input.nextInt();
//
//        patientList.add(countConsultation, new Patient(pfName, psName, dob, pMobile, pID));
//
//        addConsultation(consultationList, doctorSureName, pfName, pID);
//    }
//
//    public static void addConsultation(ArrayList<Consultation> consultationList, String doctorSureName, String pfName, int pID) {
//        Scanner input = new Scanner(System.in);
//
//        Date cDate = new Date();
//        System.out.println("-------------: Enter consultation details :------------- ");
//        System.out.println("Enter consultation year: ");
//        int cYear = input.nextInt();
//        System.out.println("Enter consultation month: ");
//        int cMonth = input.nextInt();
//        System.out.println("Enter consultation date: ");
//        int cDay = input.nextInt();
//        cDate.setYear(cYear);
//        cDate.setMonth(cMonth);
//        cDate.setDate(cDay);
//
//        System.out.println("Enter consultation time hour: ");
//        int cHour = input.nextInt();
//        System.out.println("Enter consultation time minute: ");
//        int cMin = input.nextInt();
//        cDate.setHours(cHour);
//        cDate.setMinutes(cMin);
//
//        System.out.println("Enter fee for consultation: ");
//        double cost = input.nextDouble();
//        System.out.println("Enter special notice: ");
//        String notes = input.next();
//
//        consultationList.add(countConsultation, new Consultation(doctorSureName, pfName, pID, cDate, cost, notes));
//    }
//
//    public static void viewConsultation(ArrayList<Consultation> consultationList) {
//
//        for (int i = 0; i < consultationList.size(); i++) {
//            System.out.println("Doctor sure name: " + consultationList.get(i).getDoctorSureName() +
//                    ", Patient name: " + consultationList.get(i).getPatientFirstName() +
//                    ", Patient ID: " + consultationList.get(i).getPatientId() +
//                    ", Consultation Date and Time: " + consultationList.get(i).getDateAndTime().getYear() + "/" + consultationList.get(i).getDateAndTime().getMonth() + "/"+
//                            consultationList.get(i).getDateAndTime().getDate() + " Time: " + consultationList.get(i).getDateAndTime().getHours()+ ":" + consultationList.get(i).getDateAndTime().getMinutes()+
//                    ", Fee paid: " + consultationList.get(i).getCost() +
//                    ", Special notes: " + consultationList.get(i).getNotes());
//        }
//    }
//
    // Get Doctor SurName from get method
    public String getDoctorSureName() {
        return doctorSureName;
    }

    // Set Doctor SurName from set method
    public String getPatientFirstName() {
        return patientFirstName;
    }

    // Get Date and time from get method
    public Date getDateAndTime() {
        return dateAndTime;
    }

    // Set Date and time from set method
    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    // Get cost from get method
    public double getCost() {
        return cost;
    }

    // get patientId from get method
    public int getPatientId() {
        return this.patientId;
    }

    // Set cost from set method
    public void setCost(double cost) {
        this.cost = cost;
    }

    // Get Note from get method
    public String getNotes() {
        return notes;
    }

    // Set Note from Set method
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
