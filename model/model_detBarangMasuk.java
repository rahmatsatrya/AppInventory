/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alams
 */
public class model_detBarangMasuk {
    
    private model_barangMasuk no_detBarMas;
    private model_barang kode_barang;
    private Long jml_masuk;
    private Long subtotal_masuk;

    public model_barangMasuk getNo_detBarMas() {
        return no_detBarMas;
    }

    public void setNo_detBarMas(model_barangMasuk no_detBarMas) {
        this.no_detBarMas = no_detBarMas;
    }

    public model_barang getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(model_barang kode_barang) {
        this.kode_barang = kode_barang;
    }

    public Long getJml_masuk() {
        return jml_masuk;
    }

    public void setJml_masuk(Long jml_masuk) {
        this.jml_masuk = jml_masuk;
    }

    public Long getSubtotal_masuk() {
        return subtotal_masuk;
    }

    public void setSubtotal_masuk(Long subtotal_masuk) {
        this.subtotal_masuk = subtotal_masuk;
    }

    

    
}
