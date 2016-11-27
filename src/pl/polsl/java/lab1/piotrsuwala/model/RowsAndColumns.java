package pl.polsl.java.lab1.piotrsuwala.model;

/**
 * Creates an object with rows and colums
 * @version 1.0
 * @author Piotr
 */
public class RowsAndColumns {
    public Object[][] rowData;
    public Object[] columnsNames;
    
    /**
     * an object with rows and columns
     * @param rowData
     * @param columnsNames 
     */
    
    public RowsAndColumns(Object[][] rowData, Object[] columnsNames) {
        this.rowData = rowData;
        this.columnsNames = columnsNames;
    }
}
