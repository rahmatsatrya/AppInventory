/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_detBarangKeluar;

/**
 *
 * @author alams
 */
public interface service_detBarangKeluar {
    void tambahData (model_detBarangKeluar mod_detKeluar);
    void sumTotal (model_detBarangKeluar mod_detKeluar);
    void hapusSementara (model_detBarangKeluar mod_detKeluar);
    
    model_detBarangKeluar getByid (String id);
    List<model_detBarangKeluar> getData (String id);
    List<model_detBarangKeluar> pencarian (String id);
    
    boolean validasiStok (model_detBarangKeluar mod_detKeluar);
}
