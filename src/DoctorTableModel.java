import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class DoctorTableModel extends AbstractTableModel {

    // Set column name for table
    private String[] columnNames = { "SurName", "First Name",  "Date of Birth", "Mobile Number", "License Number", "Specialisation"};
    public ArrayList<Doctor> doctorArrayList;   // Create doctorArrayList for add doctors to table

    // Create constructor as DoctorTableModel and pass the arrayList
    public DoctorTableModel(ArrayList<Doctor> doctorList){
        this.doctorArrayList = doctorList;
    }

    // Override the getRowCount method to return array size
    @Override
    public int getRowCount() {
        return this.doctorArrayList.size();
    }

    // Override the getColumnCount method to return columnNames length
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    // Override the getValueAt method to pass the details to table
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if (columnIndex == 0){
            temp = doctorArrayList.get(rowIndex).getSurname();
        }else if (columnIndex == 1){
            temp = doctorArrayList.get(rowIndex).getName();
        }else if (columnIndex == 2){
            temp = doctorArrayList.get(rowIndex).getDOB().getYear() + "/"
                    + doctorArrayList.get(rowIndex).getDOB().getMonth() + "/"
                    + doctorArrayList.get(rowIndex).getDOB().getDate();
        }else if (columnIndex == 3){
            temp = doctorArrayList.get(rowIndex).getMobileNo();
        } else if (columnIndex == 4){
            temp = doctorArrayList.get(rowIndex).getLicenceNumber();
        } else if (columnIndex == 5){
            temp = doctorArrayList.get(rowIndex).getSpecialisation();
        }
        return temp;
    }

    // Override the gerColumnName method to return columnName to table
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
}
