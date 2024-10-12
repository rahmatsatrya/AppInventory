/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_jenisBarang;

/**
 *
 * @author alams
 */
public class TableMod_JenisBarang extends AbstractTableModel{
    private List<model_jenisBarang> List = new ArrayList<>();
    private Object list;
    
    public void tambahData(model_jenisBarang mod_jenBar){
        List.add(mod_jenBar);
        fireTableRowsInserted(List.size()-1,List.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_jenisBarang mod_jenBar){
        List.add(row, mod_jenBar);
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
    
    public void setData(List<model_jenisBarang> list){
        clear();
        this.List.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData (int index, model_jenisBarang mod_jenBar){
        List.set(index, mod_jenBar);
        fireTableRowsUpdated(index, index);
    }
    
    public model_jenisBarang getData (int index){
        return List.get(index);
    }

    @Override
    public int getRowCount() {
        return List.size();
    }
    
    private final String[] columnNames = {"No","Kode Jenis","Nama Jenis"};

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return "   " + (rowIndex + 1);
        }else{
            switch (columnIndex -1) {
            case 0 : return List.get(rowIndex).getKode_jenis();
            case 1 : return List.get(rowIndex).getNama_jenis();
            
            default:return null;
            }
        }
    }
    
    public String getColumnName(int column){
        if (column == 0){
            return "   " + columnNames[column];
        }else{
            return columnNames[column];
        }
    }
}
