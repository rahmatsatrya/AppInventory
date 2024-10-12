/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_detPemesanan;

/**
 *
 * @author alams
 */
public class TableMod_detPesanan extends AbstractTableModel{
    private List<model_detPemesanan> List = new ArrayList<>();
    private Object list;
    
    public void tambahData(model_detPemesanan mod_detPesan){
        List.add(mod_detPesan);
        fireTableRowsInserted(List.size()-1,List.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_detPemesanan mod_detPesan){
        List.add(row, mod_detPesan);
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
    
    public void setData(List<model_detPemesanan> list){
        clear();
        this.List.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData (int index, model_detPemesanan mod_detPesan){
        List.set(index, mod_detPesan);
        fireTableRowsUpdated(index, index);
    }
    
    public model_detPemesanan getData (int index){
        return List.get(index);
    }

    @Override
    public int getRowCount() {
        return List.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return List.get(rowIndex).getNo_detPesan().getNo_pesan();
            case 1 : return List.get(rowIndex).getKode_barang().getKode_barang();
            case 2 : return List.get(rowIndex).getKode_barang().getNama_barang();
            case 3 : return List.get(rowIndex).getKode_barang().getHarga();
            case 4 : return List.get(rowIndex).getJml_pesan();
            case 5 : return List.get(rowIndex).getSubtotal_pesan();
            case 6 : return List.get(rowIndex).getStatus();
            
            default:return null;
        }
        
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0 : return "No Pesan";
            case 1 : return "Kode Barang";
            case 2 : return "Nama Barang";
            case 3 : return "Harga";
            case 4 : return "Jumlah Pesan";
            case 5 : return "Subtotal Pesan";
            case 6 : return "Status";
            
            default:return null;
        }
    }

}
