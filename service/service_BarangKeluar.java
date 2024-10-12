/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_barangKeluar;

/**
 *
 * @author alams
 */
public interface service_BarangKeluar {
    void tambahData (model_barangKeluar mod_Keluar);
    void hapusData (model_barangKeluar mod_Keluar);
    
    model_barangKeluar getByid (String id);
    List<model_barangKeluar> getData();
    List<model_barangKeluar> pencarian(String id);
    
    String nomor();
}
