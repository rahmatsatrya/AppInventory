/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_chartBarangKeluar;

/**
 *
 * @author alams
 */
public interface service_chartBarangKeluar {
    void tambahData (model_chartBarangKeluar mod_barKel);
    void perbaruiData (model_chartBarangKeluar mod_barKel);
    void hapusData (model_chartBarangKeluar mod_barKel);
    
    model_chartBarangKeluar getByid (String id);
    
    List<model_chartBarangKeluar> getData();
}
