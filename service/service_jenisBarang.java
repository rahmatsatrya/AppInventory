/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_jenisBarang;

/**
 *
 * @author alams
 */
public interface service_jenisBarang {
    void tambahData (model_jenisBarang mod_jenbar);
    void perbaruiData (model_jenisBarang mod_jenbar);
    void hapusData (model_jenisBarang mod_jenbar);
    
    model_jenisBarang getByid (String id);
    
    List<model_jenisBarang> getData();
    List<model_jenisBarang> pencarian(String id);
    
    String nomor(); 
    
    boolean validasiNamaJenisBarang (model_jenisBarang mod_jenbar);
    List<model_jenisBarang> getData(int startIndex, int entriesPerPage); //mengambil data berdasarkan index
    int getTotalHalaman(); //menghitung total halaman
}
