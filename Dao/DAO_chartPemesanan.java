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
import model.model_chartPesanan;
import model.model_detPemesanan;
import service.service_chartPesanan;

/**
 *
 * @author alams
 */
public class DAO_chartPemesanan implements service_chartPesanan{

    private Connection conn;
    
    public DAO_chartPemesanan(){
        conn = koneksi.getConnection();
    }
    @Override
    public void tambahData(model_chartPesanan mod_pesanan) {
        PreparedStatement st = null;
        String sql = "INSERT INTO chart_pesanan (kode_barang,nama_barang,harga,jml_pesanan,subtotal_pesan,status) VALUES (?,?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString    (1,mod_pesanan.getMod_barang().getKode_barang());
            st.setString    (2,mod_pesanan.getMod_barang().getNama_barang());
            st.setLong      (3,mod_pesanan.getMod_barang().getHarga());
            st.setLong      (4,mod_pesanan.getMod_pesan().getJml_pesan());
            st.setLong      (5,mod_pesanan.getMod_pesan().getSubtotal_pesan());
            st.setString    (6,mod_pesanan.getMod_pesan().getStatus());
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(DAO_chartPemesanan.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_chartPemesanan.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }

    }

    @Override
    public void perbaruiData(model_chartPesanan mod_pesanan) {
        PreparedStatement st = null;
        String sql = "UPDATE chart_pesanan SET nama_barang = ?, harga = ?, jml_pesanan = ?, subtotal_pesan = ? WHERE kode_barang = ?";
        
        try {
            st = conn.prepareStatement(sql);

            st.setString(1, mod_pesanan.getMod_barang().getNama_barang());
            st.setLong (2, mod_pesanan.getMod_barang().getHarga());
            st.setLong(3, mod_pesanan.getMod_pesan().getJml_pesan());
            st.setLong(4, mod_pesanan.getMod_pesan().getSubtotal_pesan());
            st.setString(5, mod_pesanan.getMod_barang().getKode_barang()); // Pastikan kode_barang digunakan sebagai kondisi WHERE

            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Memperbarui Data");
            Logger.getLogger(DAO_chartPemesanan.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_chartPemesanan.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }


    @Override
    public void hapusData(model_chartPesanan mod_pesanan) {
        PreparedStatement st = null;
        String sql = "DELETE FROM chart_pesanan WHERE kode_barang = ? AND nama_barang = ? AND harga = ? AND jml_pesanan = ? AND subtotal_pesan = ?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString        (1, mod_pesanan.getMod_barang().getKode_barang());
            st.setString        (2, mod_pesanan.getMod_barang().getNama_barang());
            st.setLong          (3, mod_pesanan.getMod_barang().getHarga());
            st.setLong          (4, mod_pesanan.getMod_pesan().getJml_pesan());
            st.setLong          (5, mod_pesanan.getMod_pesan().getSubtotal_pesan());
            
            st.executeUpdate();
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(DAO_chartPemesanan.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            if (st != null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_chartPemesanan.class.getName()).log(Level.SEVERE,null,ex);
            }
         }
        }
    }

    @Override
    public model_chartPesanan getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_chartPesanan> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM chart_pesanan";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                
                model_chartPesanan chartPes = new model_chartPesanan();
                model_barang brg = new model_barang();
                model_detPemesanan detPes = new model_detPemesanan();
                
                brg.setKode_barang(rs.getString("kode_barang"));
                brg.setNama_barang(rs.getString("nama_barang"));
                brg.setHarga(rs.getLong("harga"));
                
                detPes.setJml_pesan(rs.getLong("jml_pesanan"));
                detPes.setSubtotal_pesan(rs.getLong("subtotal_pesan"));
                
                chartPes.setMod_barang(brg);
                chartPes.setMod_pesan(detPes);
                list.add(chartPes);
            }
            return list;
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_chartPemesanan.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_chartPemesanan.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_chartPemesanan.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }
    
}
