/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_detPemesanan;

/**
 *
 * @author alams
 */
public interface service_detPemesanan {
    void tambahData (model_detPemesanan mod_detPesan);
    void sumTotal (model_detPemesanan mod_detPesan);
    void hapusSementara (model_detPemesanan mod_detPesan);
    
    model_detPemesanan getByid (String id);
    List<model_detPemesanan> getData (String id);
    List<model_detPemesanan> pencarian (String id);
}
