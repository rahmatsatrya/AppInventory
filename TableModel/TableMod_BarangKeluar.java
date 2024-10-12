/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_barangKeluar;

/**
 *
 * @author alams
 */
public class TableMod_BarangKeluar extends AbstractTableModel{

private List<model_barangKeluar> List = new ArrayList<>();
    private Object list;
    
    public void tambahData(model_barangKeluar mod_Keluar){
        List.add(mod_Keluar);
        fireTableRowsInserted(List.size()-1,List.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_barangKeluar mod_Keluar){
        List.add(row, mod_Keluar);
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
    
    public void setData(List<model_barangKeluar> list){
        clear();
        this.List.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData (int index, model_barangKeluar mod_Keluar){
        List.set(index, mod_Keluar);
        fireTableRowsUpdated(index, index);
    }
    
    public model_barangKeluar getData (int index){
        return List.get(index);
    }

    @Override
    public int getRowCount() {
        return List.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return List.get(rowIndex).getNo_keluar();
            case 1 : return List.get(rowIndex).getTgl_keluar();
            case 2 : return List.get(rowIndex).getTotal_keluar();
            case 3 : return List.get(rowIndex).getMod_pengguna().getId_pengguna();
            
            default:return null;
        }
        
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0 : return "Nomor Keluar";
            case 1 : return "Tanggal Keluar";
            case 2 : return "Total Keluar";
            case 3 : return "ID Pengguna";
            
            default:return null;
        }
    }
    
}
