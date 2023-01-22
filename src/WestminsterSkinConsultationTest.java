import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.AssertJUnit.assertEquals;

public class WestminsterSkinConsultationTest {

    @Test
    void addDoctor() {

        Date date = new Date();
        date.setYear(1997);
        date.setMonth(01);
        date.setDate(23);
        Doctor.doctorList.add(0, new Doctor("Dissanayake", "Isuru", date, 715258410, 11111, "cosmetic"));

        assertEquals("Dissanayake", Doctor.doctorList.get(0).getSurname());
    }

    @Test
    void viewDoctor() {

        Date date1 = new Date();
        date1.setYear(1997);
        date1.setMonth(01);
        date1.setDate(23);
        Doctor.doctorList.add(0, new Doctor("Shamal", "Isuru", date1, 715258410, 11111, "cosmetic"));

        Date date2 = new Date();
        date2.setYear(1998);
        date2.setMonth(02);
        date2.setDate(24);
        Doctor.doctorList.add(1, new Doctor("Dissanayake", "Dilanga", date2, 112683768, 22222, "cosmetic"));

        WestminsterSkinConsultation.viewDoctor(Doctor.doctorList);

        assertEquals("Dissanayake", Doctor.doctorList.get(0).getSurname());

    }

    @Test
    void deleteDoctor() {

        Date date = new Date();
        date.setYear(1997);
        date.setMonth(01);
        date.setDate(23);
        Doctor.doctorList.add(0, new Doctor("Shamal", "Isuru", date, 715258410, 11111, "cosmetic"));

        Date date2 = new Date();
        date2.setYear(1998);
        date2.setMonth(02);
        date2.setDate(24);
        Doctor.doctorList.add(1, new Doctor("Dissanayake", "Dilanga", date2, 112683768, 22222, "cosmetic"));

        Doctor.doctorList.remove(0);

        assertEquals("Dissanayake", Doctor.doctorList.get(0).getSurname());

    }
}