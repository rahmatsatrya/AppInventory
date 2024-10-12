/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alams
 */
public class model_detBarangKeluar {
    private model_barangKeluar no_keluar;
    private model_barang kode_barang;
    private Integer jml_keluar;
    private Long subtotal_keluar;
    
    public model_barangKeluar getNo_keluar() {
        return no_keluar;
    }

    public void setNo_keluar(model_barangKeluar no_keluar) {
        this.no_keluar = no_keluar;
    }

    public model_barang getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(model_barang kode_barang) {
        this.kode_barang = kode_barang;
    }

    public Integer getJml_keluar() {
        return jml_keluar;
    }

    public void setJml_keluar(Integer jml_keluar) {
        this.jml_keluar = jml_keluar;
    }

    public Long getSubtotal_keluar() {
        return subtotal_keluar;
    }

    public void setSubtotal_keluar(Long subtotal_keluar) {
        this.subtotal_keluar = subtotal_keluar;
    }
    
    
     
    
}
