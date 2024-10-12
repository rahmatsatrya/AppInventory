/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_chartPesanan;

/**
 *
 * @author alams
 */
public interface service_chartPesanan {
    void tambahData (model_chartPesanan mod_pesanan);
    void perbaruiData (model_chartPesanan mod_pesanan);
    void hapusData (model_chartPesanan mod_pesanan);
    
    model_chartPesanan getByid (String id);
    
    List<model_chartPesanan> getData(); 
}
