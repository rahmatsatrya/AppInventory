/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_detBarangMasuk;

/**
 *
 * @author alams
 */
public interface service_detBarangMasuk {
    void tambahData (model_detBarangMasuk mod_detMasuk);
    void sumTotal (model_detBarangMasuk mod_detMasuk);
    void hapusSementara (model_detBarangMasuk mod_detMasuk);
    
    model_detBarangMasuk getByid (String id);
    List<model_detBarangMasuk> getData (String id);
}
