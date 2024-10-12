/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_chartBarangMasuk;

/**
 *
 * @author alams
 */
public interface service_chartBarangMasuk {
    void tambahData (model_chartBarangMasuk mod_barMasuk);
    void perbaruiData (model_chartBarangMasuk mod_barMasuk);
    void hapusData (model_chartBarangMasuk mod_barMasuk);
    
    model_chartBarangMasuk getByid (String id);
    
    List<model_chartBarangMasuk> getData();
}
