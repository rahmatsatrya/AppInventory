/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import config.koneksi;
import static config.koneksi.getConnection;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import service.service_laporan;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author alams
 */
public class DAO_Laporan implements service_laporan{
    
    private Connection conn;
    
    public DAO_Laporan(){
        conn = koneksi.getConnection();
    }

    @Override
    public void suratJalanPemesanan(String no) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void transaksiBarangMasuk(String no) {
        try {
                String reportPath = "src/report/BarangMasuk.jasper";

                HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("no", no); //menyimpan nomor pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                JasperViewer viewer = new JasperViewer(print,false);
                viewer.setVisible(true);
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }

    @Override
    public void transaksiBarangKeluar(String no) {
        try {
                String reportPath = "src/report/BarangKeluar.jasper";

                HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("no", no); //menyimpan nomor pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                JasperViewer viewer = new JasperViewer(print,false);
                viewer.setVisible(true);
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }

    @Override
    public void lapDataBarang(JPanel jp) {
        try {
                String reportPath = "src/report/lapDataBarang.jasper";

                HashMap<String,Object> parameters = new HashMap<>();

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
//                tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }

    @Override
    public void lapTransaksiBarang(JPanel jp) {
        try {
                String reportPath = "src/report/lapTransaksi.jasper";

                HashMap<String,Object> parameters = new HashMap<>();

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
//                tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }

    @Override
    public void lapPemesananPerTransaksi(JPanel jp, String no) {
        try {
                String reportPath = "src/report/lapPertransaksi.jasper";

                HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("no", no); //menyimpan nomor pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //  tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }

    @Override
    public void lapPemesananPerPeriode(JPanel jp, String tgl1, String tgl2) {
        try {
                String reportPath = "src/report/lapPerPeriode.jasper";

                HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("tgl1", tgl1); //menyimpan tgl pemesanan sebagai parameter
                parameters.put("tgl2", tgl2); //menyimpan tgl pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //  tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }

    @Override
    public void lapPemesananPerBulan(JPanel jp, String dt1, int dt2) {
        try {
                String reportPath = "src/report/lapPerBulan.jasper";

                HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("dt1", dt1); //menyimpan bulan pemesanan sebagai parameter
                parameters.put("dt2", dt2); //menyimpan tahun pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //  tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }

    @Override
    public void lapPemesananPerDistributor(JPanel jp, String id) {
        try {
                String reportPath = "src/report/lapPerDistributor.jasper";

                HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("id", id); //menyimpan nomor pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //  tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }

    @Override
    public void lapBarangMasukPerTransaksi(JPanel jp, String no) {
        try {
                String reportPath = "src/report/lapMasukPertransaksi.jasper";

                HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("no", no); //menyimpan nomor pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //  tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }

    @Override
    public void lapBarangMasukPerPeriode(JPanel jp, String tgl1, String tgl2) {
        try {
                String reportPath = "src/report/lapMasukPerperiode.jasper";

                HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("tgl1", tgl1); //menyimpan tgl pemesanan sebagai parameter
                parameters.put("tgl2", tgl2); //menyimpan tgl pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //  tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }

    @Override
    public void lapBarangMasukPerBulan(JPanel jp, String dt1, int dt2) {
        try {
                String reportPath = "src/report/lapMasukPerbulan.jasper";

                HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("dt1", dt1); //menyimpan bulan pemesanan sebagai parameter
                parameters.put("dt2", dt2); //menyimpan tahun pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //  tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }

    @Override
    public void lapBarangMasukPerDistributor(JPanel jp, String id) {
        try {
                String reportPath = "src/report/lapMasukPerdistributor.jasper";

                HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("id", id); //menyimpan nomor pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //  tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }

    @Override
    public void lapBarangKeluarPerTransaksi(JPanel jp, String no) {
        try {
                String reportPath = "src/report/lapKeluarPertransaksi.jasper";

                HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("no", no); //menyimpan nomor pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //  tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }

    @Override
    public void lapBarangKeluarPerPeriode(JPanel jp, String tgl1, String tgl2) {
        try {
                String reportPath = "src/report/lapKeluarPerperiode.jasper";

                HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("tgl1", tgl1); //menyimpan tgl pemesanan sebagai parameter
                parameters.put("tgl2", tgl2); //menyimpan tgl pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //  tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }

    @Override
    public void lapBarangKeluarPerBulan(JPanel jp, String dt1, int dt2) {
        try {
                String reportPath = "src/report/lapKeluarPerbulan.jasper";

                HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("dt1", dt1); //menyimpan bulan pemesanan sebagai parameter
                parameters.put("dt2", dt2); //menyimpan tahun pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //  tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
        }catch (Exception e){
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
    }
    
}
