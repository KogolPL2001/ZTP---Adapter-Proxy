package pl.wipb.ztp.ps4;

import javax.swing.table.AbstractTableModel;

public class Adapter extends AbstractTableModel {
    private String[] columns={"Index","Value"};
    private Data data=null;
    public Adapter(){
    }
    @Override
    public int getRowCount() {
        return data==null ? 0 : data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return columnIndex==0 ? rowIndex : data.get(rowIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex,int columnIndex){
        return columnIndex==0 ? false : true;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        data.set(rowIndex, Integer.valueOf((String) aValue));
        fireTableCellUpdated(rowIndex, columnIndex);
    } 
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        return columns[columnIndex].getClass();
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return columnIndex==0 ? columns[0] : columns[1];
    }

    public void newData(Data data) {
        this.data=data;
        fireTableStructureChanged();
    }
}
