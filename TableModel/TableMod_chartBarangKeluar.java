/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_chartBarangKeluar;

/**
 *
 * @author alams
 */
public class TableMod_chartBarangKeluar extends AbstractTableModel{
    private List<model_chartBarangKeluar> List = new ArrayList<>();
    private Object list;
    
    public void tambahData(model_chartBarangKeluar mod_barKel){
        List.add(mod_barKel);
        fireTableRowsInserted(List.size()-1,List.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_chartBarangKeluar mod_barKel){
        List.add(row, mod_barKel);
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
    
    public void setData(List<model_chartBarangKeluar> list){
        clear();
        this.List.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData (int index, model_chartBarangKeluar mod_barKel){
        List.set(index, mod_barKel);
        fireTableRowsUpdated(index, index);
    }
    
    public model_chartBarangKeluar getData (int index){
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
            case 0 : return List.get(rowIndex).getMod_barang().getKode_barang();
            case 1 : return List.get(rowIndex).getMod_barang().getNama_barang();
            case 2 : return List.get(rowIndex).getMod_barang().getHarga();
            case 3 : return List.get(rowIndex).getMod_detKeluar().getJml_keluar();
            case 4 : return List.get(rowIndex).getMod_detKeluar().getSubtotal_keluar();
            
            default:return null;
        }
        
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0 : return "Kode Barang";
            case 1 : return "Nama Barang";
            case 2 : return "Harga";
            case 3 : return "Jumlah Keluar";
            case 4 : return "Subtotal Keluar";
            
            default:return null;
        }
    }

}
