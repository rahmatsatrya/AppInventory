/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_distributor;

/**
 *
 * @author alams
 */
public class TableMod_Distributor extends AbstractTableModel{
    private List<model_distributor> List = new ArrayList<>();
    
    public void tambahData(model_distributor mod_dis){
        List.add(mod_dis);
        fireTableRowsInserted(List.size()-1,List.size()-1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, model_distributor mod_dis){
        List.add(row, mod_dis);
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
    
    public void setData(List<model_distributor> list){
        clear();
        this.List.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData (int index, model_distributor mod_dis){
        List.set(index, mod_dis);
        fireTableRowsUpdated(index, index);
    }
    
    public model_distributor getData (int index){
        return List.get(index);
    }

    @Override
    public int getRowCount() {
        return List.size();
    }
    
    private final String[] columnNames = {"No","ID Distributor","Nama Distributor","No Telepon","Alamat"};

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return "   " + (rowIndex + 1);
        }else{
        switch (columnIndex -1 ) {
            case 0 : return List.get(rowIndex).getId_distributor();
            case 1 : return List.get(rowIndex).getNama_distributor();
            case 2 : return List.get(rowIndex).getTlp_distributor();
            case 3 : return List.get(rowIndex).getAlamat_distributor();

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
