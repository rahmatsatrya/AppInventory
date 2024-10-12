/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_barangMasuk;

/**
 *
 * @author alams
 */
public class TableMod_BarangMasuk extends AbstractTableModel{
    private List<model_barangMasuk> List = new ArrayList<>();
    
    public void tambahData(model_barangMasuk mod_Masuk){
        List.add(mod_Masuk);
        fireTableRowsInserted(List.size()-1,List.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_barangMasuk mod_Masuk){
        List.add(row, mod_Masuk);
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
    
    public void setData(List<model_barangMasuk> list){
        clear();
        this.List.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData (int index, model_barangMasuk mod_Masuk){
        List.set(index, mod_Masuk);
        fireTableRowsUpdated(index, index);
    }
    
    public model_barangMasuk getData (int index){
        return List.get(index);
    }

    @Override
    public int getRowCount() {
        return List.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return List.get(rowIndex).getNo_masuk();
            case 1 : return List.get(rowIndex).getTgl_masuk();
            case 2 : return List.get(rowIndex).getTotal_masuk();
            case 3 : return List.get(rowIndex).getId_distributor().getId_distributor();
            case 4 : return List.get(rowIndex).getIdpengguna().getId_pengguna();
            
            default:return null;
        }
        
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0 : return "No Masuk";
            case 1 : return "Tanggal Masuk";
            case 2 : return "Total Masuk";
            case 3 : return "ID Distributor";
            case 4 : return "ID pengguna";
            
            default:return null;
        }
    }

    
}
