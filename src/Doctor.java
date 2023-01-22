import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Doctor extends Person{

    private int licenceNumber;  // Doctor licence Number Instance Variable
    private String specialisation;  // Doctor Specialisation Instance Variable
    static ArrayList<Doctor> doctorList = new ArrayList<>(10); // Create ArrayList for All Doctors
    static ArrayList<Doctor> cosmetic = new ArrayList<>();  // Create ArrayList for Cosmetic Dermatology Doctors
    static ArrayList<Doctor> medical = new ArrayList<>();   // Create ArrayList for Medical Dermatology Doctors
    static ArrayList<Doctor> paediatric = new ArrayList<>();    // Create ArrayList for Cosmetic Dermatology Doctors

    //  Create Constructor For Doctor
    public Doctor(String surName, String name, Date DOB, int mobileNo, int licenceNumber, String specialisation){
        super(surName, name, DOB, mobileNo); // Call super class
        this.licenceNumber = licenceNumber;
        this.specialisation = specialisation;
    }

    // Create Comparator method to compare Doctors surnames
    public static Comparator<Doctor> surNameComparator = new Comparator<Doctor>() {
        @Override
        public int compare(Doctor o1, Doctor o2) {  // Override compare method and compare Doctor surName
            String sureName1 = o1.getSurname();
            String sureName2 = o2.getSurname();
            return sureName1.compareTo(sureName2);
        }
    };

    // Create Get Licence Number method
    public int getLicenceNumber(){
        return licenceNumber;
    }

    // Create Get Specialization Method
    public String getSpecialisation(){
        return specialisation;
    }

    // Create Set Licence Number Method
    public void setLicenceNumber(int licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    // Create Set Specialization Method
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

}
