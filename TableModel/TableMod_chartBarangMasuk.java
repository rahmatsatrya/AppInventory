/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_chartBarangMasuk;

/**
 *
 * @author alams
 */
public class TableMod_chartBarangMasuk extends AbstractTableModel{
    private List<model_chartBarangMasuk> List = new ArrayList<>();
    private Object list;
    
    public void tambahData(model_chartBarangMasuk mod_barMasuk){
        List.add(mod_barMasuk);
        fireTableRowsInserted(List.size()-1,List.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_chartBarangMasuk mod_barMasuk){
        List.add(row, mod_barMasuk);
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
    
    public void setData(List<model_chartBarangMasuk> list){
        clear();
        this.List.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData (int index, model_chartBarangMasuk mod_barMasuk){
        List.set(index, mod_barMasuk);
        fireTableRowsUpdated(index, index);
    }
    
    public model_chartBarangMasuk getData (int index){
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
            case 3 : return List.get(rowIndex).getMod_detMasuk().getJml_masuk();
            case 4 : return List.get(rowIndex).getMod_detMasuk().getSubtotal_masuk();
            
            default:return null;
        }
        
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0 : return "Kode Barang";
            case 1 : return "Nama Barang";
            case 2 : return "Harga";
            case 3 : return "Jumlah Masuk";
            case 4 : return "Subtotal Masuk";
            
            default:return null;
        }
    }

}
