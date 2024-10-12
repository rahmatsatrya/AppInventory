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
import model.model_barang;
import model.model_detPemesanan;
import model.model_pemesanan;
import service.service_detPemesanan;

/**
 *
 * @author alams
 */
public class DAO_detPemesanan implements service_detPemesanan{
    private Connection conn;
    
    public DAO_detPemesanan(){
        conn = koneksi.getConnection();
    }
    @Override
    public void tambahData(model_detPemesanan mod_detPesan) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_pemesanan (no_pesan,kode_barang,jml_pesan,subtotal_pesan,status) SELECT '"+ mod_detPesan.getNo_detPesan().getNo_pesan() +"'"
                    +", kode_barang, jml_pesanan, subtotal_pesan, status FROM chart_pesanan";
        try {
            st = conn.prepareStatement(sql);
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(DAO_detPemesanan.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_detPemesanan.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public void sumTotal(model_detPemesanan mod_detPesan) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(subtotal_pesan) FROM chart_pesanan";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                mod_detPesan.setSubtotal_pesan(rs.getLong(1));
            }
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_detPemesanan.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_detPemesanan.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_detPemesanan.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public void hapusSementara(model_detPemesanan mod_detPesan) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "DELETE FROM chart_pesanan";
        
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_detPemesanan.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_detPemesanan.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public model_detPemesanan getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_detPemesanan> getData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT detPesan.no_pesan, detPesan.kode_barang, brg.nama_barang, "
                    +"brg.harga, detPesan.jml_pesan, detPesan.subtotal_pesan, detPesan.status " 
                    +"FROM detail_pemesanan detPesan "
                    +"INNER JOIN pemesanan pesan ON pesan.no_pesan=detPesan.no_pesan "
                    +"INNER JOIN data_barang brg ON brg.kode_barang=detPesan.kode_barang "
                    +"WHERE detPesan.no_pesan ='"+id+"' ORDER BY no_pesan  ASC";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_pemesanan pesan = new model_pemesanan();
                model_detPemesanan detPesan = new model_detPemesanan();
                model_barang brg = new model_barang();
                
                pesan.setNo_pesan(String.valueOf(rs.getString("detPesan.no_pesan")));
                detPesan.setNo_detPesan(pesan);
                
                brg.setKode_barang              (rs.getString("kode_barang"));
                brg.setNama_barang              (rs.getString("nama_barang"));
                brg.setHarga                    (rs.getLong("harga"));
                detPesan.setJml_pesan           (rs.getLong("jml_pesan"));
                detPesan.setSubtotal_pesan      (rs.getLong("subtotal_pesan"));
                detPesan.setStatus              (rs.getString("status"));

                detPesan.setKode_barang(brg);
                
                list.add(detPesan);
            }
            return list;
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_detPemesanan.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_detPemesanan.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_detPemesanan.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public List<model_detPemesanan> pencarian(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
