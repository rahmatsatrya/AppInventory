/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_detBarangMasuk;

/**
 *
 * @author alams
 */
public class TableMod_detBarangMasuk extends AbstractTableModel{
    private List<model_detBarangMasuk> List = new ArrayList<>();
    private Object list;
    
    public void tambahData(model_detBarangMasuk mod_detMasuk){
        List.add(mod_detMasuk);
        fireTableRowsInserted(List.size()-1,List.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_detBarangMasuk mod_detMasuk){
        List.add(row, mod_detMasuk);
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
    
    public void setData(List<model_detBarangMasuk> list){
        clear();
        this.List.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData (int index, model_detBarangMasuk mod_detMasuk){
        List.set(index, mod_detMasuk);
        fireTableRowsUpdated(index, index);
    }
    
    public model_detBarangMasuk getData (int index){
        return List.get(index);
    }

    @Override
    public int getRowCount() {
        return List.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return List.get(rowIndex).getNo_detBarMas().getNo_masuk();
            case 1 : return List.get(rowIndex).getKode_barang().getKode_barang();
            case 2 : return List.get(rowIndex).getKode_barang().getNama_barang();
            case 3 : return List.get(rowIndex).getKode_barang().getHarga();
            case 4 : return List.get(rowIndex).getJml_masuk();
            case 5 : return List.get(rowIndex).getSubtotal_masuk();
            
            default:return null;
        }
        
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0 : return "No Masuk";
            case 1 : return "Kode Barang";
            case 2 : return "Nama Barang";
            case 3 : return "Harga Barang";
            case 4 : return "Jumlah Masuk";
            case 5 : return "Subtotal Masuk";
            
            default:return null;
        }
    }
    
}
