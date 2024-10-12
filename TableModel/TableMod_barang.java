/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_barang;

/**
 *
 * @author alams
 */
public class TableMod_barang extends AbstractTableModel {
    
    private List<model_barang> List = new ArrayList<>();
    private Object list;
    
    public void tambahData(model_barang mod_bar){
        List.add(mod_bar);
        fireTableRowsInserted(List.size()-1,List.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_barang mod_bar){
        List.add(row, mod_bar);
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
    
    public void setData(List<model_barang> list){
        clear();
        this.List.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData (int index, model_barang mod_bar){
        List.set(index, mod_bar);
        fireTableRowsUpdated(index, index);
    }
    
    public model_barang getData (int index){
        return List.get(index);
    }

    @Override
    public int getRowCount() {
        return List.size();
    }
    
    private final String[] columnNames = {"No","Kode Barang","Kode Jenis","Nama Jenis","Nama Barang","Satuan","Harga","Stok"};

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return "   " + (rowIndex + 1);
        }else{
            switch (columnIndex - 1 ) {
            case 0 : return List.get(rowIndex).getKode_barang();
            case 1 : return List.get(rowIndex).getJenis_barang().getKode_jenis();
            case 2 : return List.get(rowIndex).getJenis_barang().getNama_jenis();
            case 3 : return List.get(rowIndex).getNama_barang();
            case 4 : return List.get(rowIndex).getSatuan();
            case 5 : return List.get(rowIndex).getHarga();
            case 6 : return List.get(rowIndex).getStok();
            
            default:return null;
        }
     }    
 }
    
    @Override
    public String getColumnName(int column){
        if (column == 0){
            return "   " + columnNames[column];
        }else{
            return columnNames[column];
        }
    }
  
}
