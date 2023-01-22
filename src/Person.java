import java.util.Date;

public class Person {

    private String name;    // Person Name Instance Variable
    private String surname; // Person SurName Instance Variable
    private Date DOB;   // Person DOB Instance Variable
    private int mobileNo;   // Person mobile No Instance Variable

    //  Create constructor For Person
    public Person(String surname, String name, Date DOB, int mobileNo){
        this.name = name;
        this.surname = surname;
        this.DOB = DOB;
        this.mobileNo = mobileNo;
    }

    // Create  Get Person Name method
    public String getName() {
        return name;
    }

    // Create Get SurName method
    public String getSurname() {
        return surname;
    }

    // Create get DOB method
    public Date getDOB() {
        return DOB;
    }

    // Create get mobile No
    public int getMobileNo() {
        return mobileNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }
}
