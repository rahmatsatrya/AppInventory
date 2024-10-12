/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alams
 */
public class model_pemesanan {
    private String no_pesan;
    private String tgl_pesan;
    private Long total_pesan;
    private model_distributor idDistributor;
    private model_pengguna idPengguna;
    
    public String getNo_pesan() {
        return no_pesan;
    }

    public void setNo_pesan(String no_pesan) {
        this.no_pesan = no_pesan;
    }

    public String getTgl_pesan() {
        return tgl_pesan;
    }

    public void setTgl_pesan(String tgl_pesan) {
        this.tgl_pesan = tgl_pesan;
    }

    public Long getTotal_pesan() {
        return total_pesan;
    }

    public void setTotal_pesan(Long total_pesan) {
        this.total_pesan = total_pesan;
    }

    public model_distributor getIdDistributor() {
        return idDistributor;
    }

    public void setIdDistributor(model_distributor idDistributor) {
        this.idDistributor = idDistributor;
    }

    public model_pengguna getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(model_pengguna idPengguna) {
        this.idPengguna = idPengguna;
    }

    
    
}
