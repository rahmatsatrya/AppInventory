/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import javax.swing.JPanel;

/**
 *
 * @author alams
 */
public interface service_laporan {
    void suratJalanPemesanan        (String no);
    void transaksiBarangMasuk       (String no);
    void transaksiBarangKeluar      (String no);
    
    void lapDataBarang              (JPanel jp);
    void lapTransaksiBarang         (JPanel jp);
    
    void lapPemesananPerTransaksi   (JPanel jp, String no);
    void lapPemesananPerPeriode (JPanel jp, String tgl1, String tgl2);
    void lapPemesananPerBulan     (JPanel jp, String dt1, int dt2);
    void lapPemesananPerDistributor      (JPanel jp, String id);
    
    void lapBarangMasukPerTransaksi   (JPanel jp, String no);
    void lapBarangMasukPerPeriode (JPanel jp, String tgl1, String tgl2);
    void lapBarangMasukPerBulan     (JPanel jp, String dt1, int dt2);
    void lapBarangMasukPerDistributor      (JPanel jp, String id);
    
    void lapBarangKeluarPerTransaksi   (JPanel jp, String no);
    void lapBarangKeluarPerPeriode (JPanel jp, String tgl1, String tgl2);
    void lapBarangKeluarPerBulan     (JPanel jp, String dt1, int dt2);
}
