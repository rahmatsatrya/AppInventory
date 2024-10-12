/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import javax.swing.JLabel;
import model.model_pengguna;

/**
 *
 * @author alams
 */
public interface service_pengguna {
    void tambahData (model_pengguna mod_pengguna);
    void perbaruiData (model_pengguna mod_pengguna);
    void hapusData (model_pengguna mod_pengguna);
    void tampilGambar (JLabel lb_gambar, String id);
    
    model_pengguna getByid (String id);
    
    List<model_pengguna> getData();
    List<model_pengguna> pencarian(String id);
    
    String nomor(); 
    boolean validateOldPassword(String username, String oldPassword);
    boolean changePassword(String username, String oldPassword, String newPassword);
}
