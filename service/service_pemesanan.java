/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_pemesanan;

/**
 *
 * @author alams
 */
public interface service_pemesanan {
    void tambahData (model_pemesanan mod_pesan);
    void perbaruiData (model_pemesanan mod_pesan);
    void hapusData (model_pemesanan mod_pesan);
    
    model_pemesanan getByid (String id);
    
    List<model_pemesanan> getData();
    List<model_pemesanan> pencarian(String id);
    
    String nomor(); 
}
