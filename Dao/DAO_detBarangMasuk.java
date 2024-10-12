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
import model.model_barangMasuk;
import model.model_detBarangMasuk;
import service.service_detBarangMasuk;

/**
 *
 * @author alams
 */
public class DAO_detBarangMasuk implements service_detBarangMasuk{
    
    private Connection conn;
    
    public DAO_detBarangMasuk(){
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_detBarangMasuk mod_detMasuk) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_barang_masuk (no_masuk, kode_barang, jml_masuk, subtotal_masuk) " +
                     "SELECT ?, kode_barang, jml_masuk, subtotal_masuk FROM chart_barang_masuk";

        try {
            st = conn.prepareStatement(sql);
            // Set parameter untuk no_masuk
            st.setString(1, mod_detMasuk.getNo_detBarMas().getNo_masuk());

            // Eksekusi update
            st.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(DAO_detBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_detBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }

    }

    @Override
    public void sumTotal(model_detBarangMasuk mod_detMasuk) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(subtotal_masuk) FROM chart_barang_masuk";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                mod_detMasuk.setSubtotal_masuk(rs.getLong(1));
            }
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_detBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_detBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_detBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public void hapusSementara(model_detBarangMasuk mod_detMasuk) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "DELETE FROM chart_barang_masuk";
        
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_detBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_detBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public model_detBarangMasuk getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_detBarangMasuk> getData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT detMasuk.no_masuk, detMasuk.kode_barang, brg.nama_barang, "
                    +"brg.harga, detMasuk.jml_masuk, detMasuk.subtotal_masuk " 
                    +"FROM detail_barang_masuk detMasuk "
                    +"INNER JOIN barang_masuk masuk ON masuk.no_masuk=detMasuk.no_masuk "
                    +"INNER JOIN data_barang brg ON brg.kode_barang=detMasuk.kode_barang "
                    +"WHERE detMasuk.no_masuk ='"+id+"' ORDER BY no_masuk  ASC";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_barangMasuk masuk = new model_barangMasuk();
                model_detBarangMasuk detMasuk = new model_detBarangMasuk();
                model_barang brg = new model_barang();
                
                masuk.setNo_masuk(String.valueOf(rs.getString("detMasuk.no_masuk")));
                detMasuk.setNo_detBarMas(masuk);
                
                brg.setKode_barang              (rs.getString("kode_barang"));
                brg.setNama_barang              (rs.getString("nama_barang"));
                brg.setHarga                    (rs.getLong("harga"));
                detMasuk.setJml_masuk           (rs.getLong("jml_masuk"));
                detMasuk.setSubtotal_masuk      (rs.getLong("subtotal_masuk"));

                detMasuk.setKode_barang(brg);
                
                list.add(detMasuk);
            }
            return list;
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_detBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_detBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_detBarangMasuk.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }
    
}
