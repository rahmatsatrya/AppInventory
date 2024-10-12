/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_pengguna;

/**
 *
 * @author alams
 */
public class TableMod_Pengguna extends AbstractTableModel{
        private List<model_pengguna> List = new ArrayList<>();
    
    public void tambahData(model_pengguna mod_pengguna){
        List.add(mod_pengguna);
        fireTableRowsInserted(List.size()-1,List.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_pengguna mod_pengguna){
        List.add(row, mod_pengguna);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil diperbarui");
    }
    
    public void hapusData (int index){
        List.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
    }
    
    public void clear(){
        List.clear();
        fireTableDataChanged();
    }
    
    public void setData(List<model_pengguna> list){
        clear();
        this.List.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData (int index, model_pengguna mod_pengguna){
        List.set(index, mod_pengguna);
        fireTableRowsUpdated(index, index);
    }
    
    public model_pengguna getData (int index){
        return List.get(index);
    }

    @Override
    public int getRowCount() {
        return List.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    private final String[] columnNames = {"No", "ID","Nama Pengguna", "Username","No Telepon","Alamat","level"};

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return "   " + (rowIndex + 1);
        }else{
        switch (columnIndex - 1) {
            case 0 : return List.get(rowIndex).getId_pengguna();
            case 1 : return List.get(rowIndex).getNama_pengguna();
            case 2 : return List.get(rowIndex).getUsername();
            case 3 : return List.get(rowIndex).getTlp_pengguna();
            case 4 : return List.get(rowIndex).getAlamat_pengguna();
            case 5 : return List.get(rowIndex).getLevel();
            
            default:return null;
            }
        }
        
    }
    
    public String getColumnName(int column){
        if(column == 0){
            return "   " + columnNames[column];
        }else{
            return columnNames[column];
        }
    }

}
