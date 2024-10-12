/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_distributor;

/**
 *
 * @author alams
 */
public interface service_distributor {
    void tambahData (model_distributor mod_dis);
    void perbaruiData (model_distributor mod_dis);
    void hapusData (model_distributor mod_dis);
    
    model_distributor getByid (String id);
    
    List<model_distributor> getData();
    List<model_distributor> getData(int startIndex, int entriesPerPage); //mengambil data berdasarkan index
    
    List<model_distributor> pencarian(String id);
    
    String nomor();
    int getTotalEntries(); //menghitung total halaman
}
