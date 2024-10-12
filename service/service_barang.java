/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_barang;

// servis ini berguna untuk menghubungkan DAO

public interface service_barang {
    void tambahData (model_barang mod_bar);
    void perbaruiData (model_barang mod_bar);
    void hapusData (model_barang mod_bar);
    
    model_barang getByid (String id);
    
    List<model_barang> getDataByID();
    List<model_barang> getData();
    
    List<model_barang> pencarian(String id);
    List<model_barang> pencarian2(String id);
    
    String nomor();
    String nomor2();
}
