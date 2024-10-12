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
import model.model_chartBarangKeluar;
import model.model_detBarangKeluar;
import service.service_chartBarangKeluar;

/**
 *
 * @author alams
 */
public class DAO_chartBarangKeluar implements service_chartBarangKeluar{
    private Connection conn;
    
    public DAO_chartBarangKeluar(){
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_chartBarangKeluar mod_barKel) {
        PreparedStatement st = null;
        String sql = "INSERT INTO chart_barang_keluar (kode_barang,nama_barang,harga,jml_keluar,subtotal_keluar) VALUES (?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString    (1,mod_barKel.getMod_barang().getKode_barang());
            st.setString    (2,mod_barKel.getMod_barang().getNama_barang());
            st.setLong      (3,mod_barKel.getMod_barang().getHarga());
            st.setLong      (4,mod_barKel.getMod_detKeluar().getJml_keluar());
            st.setLong      (5,mod_barKel.getMod_detKeluar().getSubtotal_keluar());
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(DAO_chartBarangKeluar.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_chartBarangKeluar.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public void perbaruiData(model_chartBarangKeluar mod_barKel) {
        PreparedStatement st = null;
        String sql = "UPDATE chart_barang_keluar SET nama_barang = ?, harga = ?, jml_keluar = ?, subtotal_keluar = ? WHERE kode_barang = ?";
        
        try {
            st = conn.prepareStatement(sql);

            st.setString(1, mod_barKel.getMod_barang().getNama_barang());
            st.setLong (2, mod_barKel.getMod_barang().getHarga());
            st.setLong(3, mod_barKel.getMod_detKeluar().getJml_keluar());
            st.setLong(4, mod_barKel.getMod_detKeluar().getSubtotal_keluar());
            st.setString(5, mod_barKel.getMod_barang().getKode_barang()); // Pastikan kode_barang digunakan sebagai kondisi WHERE

            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Memperbarui Data");
            Logger.getLogger(DAO_chartBarangKeluar.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_chartBarangKeluar.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public void hapusData(model_chartBarangKeluar mod_barKel) {
        PreparedStatement st = null;
        String sql = "DELETE FROM chart_barang_keluar WHERE kode_barang = ? AND nama_barang = ? AND harga = ? AND jml_keluar = ? AND subtotal_keluar = ?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString        (1, mod_barKel.getMod_barang().getKode_barang());
            st.setString        (2, mod_barKel.getMod_barang().getNama_barang());
            st.setLong          (3, mod_barKel.getMod_barang().getHarga());
            st.setLong          (4, mod_barKel.getMod_detKeluar().getJml_keluar());
            st.setLong          (5, mod_barKel.getMod_detKeluar().getSubtotal_keluar());
            
            st.executeUpdate();
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(DAO_chartBarangKeluar.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            if (st != null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_chartBarangKeluar.class.getName()).log(Level.SEVERE,null,ex);
            }
         }
        }
    }

    @Override
    public model_chartBarangKeluar getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_chartBarangKeluar> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM chart_barang_keluar";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                
                model_chartBarangKeluar chartBarKel = new model_chartBarangKeluar();
                model_barang brg = new model_barang();
                model_detBarangKeluar detBarKel = new model_detBarangKeluar();
                
                brg.setKode_barang(rs.getString("kode_barang"));
                brg.setNama_barang(rs.getString("nama_barang"));
                brg.setHarga(rs.getLong("harga"));
                
                detBarKel.setJml_keluar(rs.getInt("jml_keluar"));
                detBarKel.setSubtotal_keluar(rs.getLong("subtotal_keluar"));
                
                chartBarKel.setMod_barang(brg);
                chartBarKel.setMod_detKeluar(detBarKel);
                list.add(chartBarKel);
            }
            return list;
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_chartBarangKeluar.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_chartBarangKeluar.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_chartBarangKeluar.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }
    
}
