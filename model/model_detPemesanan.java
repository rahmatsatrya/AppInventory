/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alams
 */
public class model_detPemesanan {


    private model_pemesanan no_detPesan;
    private model_barang kode_barang;
    private Long jml_pesan;
    private Long subtotal_pesan;
    private String status;
    
    public model_pemesanan getNo_detPesan() {
        return no_detPesan;
    }

    public void setNo_detPesan(model_pemesanan no_detPesan) {
        this.no_detPesan = no_detPesan;
    }    


    public model_barang getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(model_barang kode_barang) {
        this.kode_barang = kode_barang;
    }

    public long getJml_pesan() {
        return jml_pesan;
    }

    public void setJml_pesan(Long jml_pesan) {
        this.jml_pesan = jml_pesan;
    }

    public Long getSubtotal_pesan() {
        return subtotal_pesan;
    }

    public void setSubtotal_pesan(Long subtotal_pesan) {
        this.subtotal_pesan = subtotal_pesan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
}
