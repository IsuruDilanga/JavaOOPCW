import java.util.ArrayList;
import java.util.Date;

public class Patient extends Person{

    private int patientUniqueId;    // Patient unique Instance Variable
    static ArrayList<Patient> patientsList = new ArrayList<>(); // Patient Detail Array List

    static int countPatient;    // Count patient static type

    // Create Patient Constructor
    public Patient(String name, String surName, Date DOB, int mobileNo, int patientUniqueId){
        super(name, surName, DOB, mobileNo);
        this.patientUniqueId = patientUniqueId;
    }

    // Create Get Patient unique ID method
    public int getPatientUniqueId() {
        return patientUniqueId;
    }

    // Create Set Patient Unique ID method
    public void setPatientUniqueId(int patientUniqueId) {
        this.patientUniqueId = patientUniqueId;
    }
}
