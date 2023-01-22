import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ConsultationTableModel extends AbstractTableModel {

    // Set column name for table
    private String[] columnNames = {"Doctor SurName", "Patient First", "Patient ID", "Consultation Date and Time", "Fee", "Special notes"};
    public ArrayList<Consultation> consultationArrayList;

    // Create constructor as ConsultationTableModel and pass the arrayList
    public ConsultationTableModel(ArrayList<Consultation> consultationArrayList){
        this.consultationArrayList = consultationArrayList;
    }

    // Override the getRowCount method to return array size
    @Override
    public int getRowCount() {
        return this.consultationArrayList.size();
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
            temp = consultationArrayList.get(rowIndex).getDoctorSureName();
        } else if (columnIndex == 1){
            temp = consultationArrayList.get(rowIndex).getPatientFirstName();
        } else if (columnIndex == 2){
            temp = consultationArrayList.get(rowIndex).getPatientId();
        } else if (columnIndex == 3){
            temp = consultationArrayList.get(rowIndex).getDateAndTime().getDate() + "/" +
                    consultationArrayList.get(rowIndex).getDateAndTime().getMonth() + "/" +
                    consultationArrayList.get(rowIndex).getDateAndTime().getYear() + " " +
                    consultationArrayList.get(rowIndex).getDateAndTime().getHours() + ":" +
                    consultationArrayList.get(rowIndex).getDateAndTime().getMinutes();
        } else if (columnIndex == 4){
            temp = consultationArrayList.get(rowIndex).getCost();
        } else if (columnIndex == 5){
            temp = consultationArrayList.get(rowIndex).getNotes();
        }
        return temp;
    }

    // Override the gerColumnName method to return columnName to table
    @Override
    public String getColumnName(int col){
        return  columnNames[col];
    }
}
