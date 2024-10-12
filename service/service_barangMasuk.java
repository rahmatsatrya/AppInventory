/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_barangMasuk;

/**
 *
 * @author alams
 */
public interface service_barangMasuk {
    void tambahData (model_barangMasuk mod_Masuk);
    void perbaruiStatus (String kode_barang);
    void hapusData (model_barangMasuk mod_Masuk);
    
    model_barangMasuk getByid (String id);
    List<model_barangMasuk> getData();
    List<model_barangMasuk> pencarian(String id);
    
    String nomor();
}
