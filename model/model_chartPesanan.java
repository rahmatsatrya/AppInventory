/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alams
 */
public class model_chartPesanan {

    public model_barang getMod_barang() {
        return mod_barang;
    }

    public void setMod_barang(model_barang mod_barang) {
        this.mod_barang = mod_barang;
    }

    public model_detPemesanan getMod_pesan() {
        return mod_pesan;
    }

    public void setMod_pesan(model_detPemesanan mod_pesan) {
        this.mod_pesan = mod_pesan;
    }
    private model_barang mod_barang;
    private model_detPemesanan mod_pesan;
    

    
}
