/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_pemesanan;

/**
 *
 * @author alams
 */
public class TableMod_Pesanan extends AbstractTableModel{
    private List<model_pemesanan> List = new ArrayList<>();
    private Object list;
    
    public void tambahData(model_pemesanan mod_pesan){
        List.add(mod_pesan);
        fireTableRowsInserted(List.size()-1,List.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_pemesanan mod_pesan){
        List.add(row, mod_pesan);
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
    
    public void setData(List<model_pemesanan> list){
        clear();
        this.List.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData (int index, model_pemesanan mod_pesan){
        List.set(index, mod_pesan);
        fireTableRowsUpdated(index, index);
    }
    
    public model_pemesanan getData (int index){
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
            case 0 : return List.get(rowIndex).getNo_pesan();
            case 1 : return List.get(rowIndex).getTgl_pesan();
            case 2 : return List.get(rowIndex).getTotal_pesan();
            case 3 : return List.get(rowIndex).getIdDistributor().getId_distributor();
            case 4 : return List.get(rowIndex).getIdPengguna().getId_pengguna();
            
            default:return null;
        }
        
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0 : return "No Pesan";
            case 1 : return "Tanggal Pesan";
            case 2 : return "Total Pesan";
            case 3 : return "ID Distributor";
            case 4 : return "ID Pengguna";
            
            default:return null;
        }
    }

}
