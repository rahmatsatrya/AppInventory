/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.model_barang;
import model.model_chartBarangMasuk;
import model.model_chartPesanan;
import model.model_detBarangMasuk;
import model.model_detPemesanan;
import service.service_chartBarangMasuk;

/**
 *
 * @author alams
 */
public class DAO_chartBarangMasuk implements service_chartBarangMasuk{
    
    private Connection conn;
    
    public DAO_chartBarangMasuk(){
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_chartBarangMasuk mod_barMasuk) {
        PreparedStatement st = null;
        String sql = "INSERT INTO chart_barang_masuk (kode_barang,nama_barang,harga,jml_masuk,subtotal_masuk) VALUES (?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString    (1,mod_barMasuk.getMod_barang().getKode_barang());
            st.setString    (2,mod_barMasuk.getMod_barang().getNama_barang());
            st.setLong      (3,mod_barMasuk.getMod_barang().getHarga());
            st.setLong      (4,mod_barMasuk.getMod_detMasuk().getJml_masuk());
            st.setLong      (5,mod_barMasuk.getMod_detMasuk().getSubtotal_masuk());
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(DAO_chartBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_chartBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public void perbaruiData(model_chartBarangMasuk mod_barMasuk) {
        PreparedStatement st = null;
        String sql = "UPDATE chart_barang_masuk SET nama_barang = ?, harga = ?, jml_masuk = ?, subtotal_masuk = ? WHERE kode_barang = ?";
        
        try {
            st = conn.prepareStatement(sql);

            st.setString(1, mod_barMasuk.getMod_barang().getNama_barang());
            st.setLong (2, mod_barMasuk.getMod_barang().getHarga());
            st.setLong(3, mod_barMasuk.getMod_detMasuk().getJml_masuk());
            st.setLong(4, mod_barMasuk.getMod_detMasuk().getSubtotal_masuk());
            st.setString(5, mod_barMasuk.getMod_barang().getKode_barang()); // Pastikan kode_barang digunakan sebagai kondisi WHERE

            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Memperbarui Data");
            Logger.getLogger(DAO_chartBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_chartBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public void hapusData(model_chartBarangMasuk mod_barMasuk) {
        PreparedStatement st = null;
        String sql = "DELETE FROM chart_barang_masuk WHERE kode_barang = ? AND nama_barang = ? AND harga = ? AND jml_masuk = ? AND subtotal_masuk = ?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString        (1, mod_barMasuk.getMod_barang().getKode_barang());
            st.setString        (2, mod_barMasuk.getMod_barang().getNama_barang());
            st.setLong          (3, mod_barMasuk.getMod_barang().getHarga());
            st.setLong          (4, mod_barMasuk.getMod_detMasuk().getJml_masuk());
            st.setLong          (5, mod_barMasuk.getMod_detMasuk().getSubtotal_masuk());
            
            st.executeUpdate();
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(DAO_chartBarangMasuk.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            if (st != null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_chartBarangMasuk.class.getName()).log(Level.SEVERE,null,ex);
            }
         }
        }
    }

    @Override
    public model_chartBarangMasuk getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_chartBarangMasuk> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM chart_barang_masuk";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                
                model_chartBarangMasuk chartBarMas = new model_chartBarangMasuk();
                model_barang brg = new model_barang();
                model_detBarangMasuk detBarMas = new model_detBarangMasuk();
                
                brg.setKode_barang(rs.getString("kode_barang"));
                brg.setNama_barang(rs.getString("nama_barang"));
                brg.setHarga(rs.getLong("harga"));
                
                detBarMas.setJml_masuk(rs.getLong("jml_masuk"));
                detBarMas.setSubtotal_masuk(rs.getLong("subtotal_masuk"));
                
                chartBarMas.setMod_barang(brg);
                chartBarMas.setMod_detMasuk(detBarMas);
                list.add(chartBarMas);
            }
            return list;
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_chartBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_chartBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_chartBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }
    
}
