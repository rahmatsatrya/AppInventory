/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Dao.DAO_detBarangMasuk;
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
import model.model_barangKeluar;
import model.model_detBarangKeluar;
import service.service_detBarangKeluar;

/**
 *
 * @author alams
 */
public class DAO_detBarangKeluar implements service_detBarangKeluar{
    private Connection conn;
    
    public DAO_detBarangKeluar(){
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_detBarangKeluar mod_detKeluar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_barang_keluar (no_keluar, kode_barang, jml_keluar, subtotal_keluar) " +
                     "SELECT ?, kode_barang, jml_keluar, subtotal_keluar FROM chart_barang_keluar";

        try {
            st = conn.prepareStatement(sql);
            // Set parameter untuk no_masuk
            st.setString(1, mod_detKeluar.getNo_keluar().getNo_keluar());

            // Eksekusi update
            st.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(DAO_detBarangKeluar.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_detBarangKeluar.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public void sumTotal(model_detBarangKeluar mod_detKeluar) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(subtotal_keluar) FROM chart_barang_keluar";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                mod_detKeluar.setSubtotal_keluar(rs.getLong(1));
            }
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_detBarangKeluar.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_detBarangKeluar.class.getName()).log(Level.SEVERE,null,e);
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
    public void hapusSementara(model_detBarangKeluar mod_detKeluar) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "DELETE FROM chart_barang_keluar";
        
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
    public model_detBarangKeluar getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_detBarangKeluar> getData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT detKeluar.no_keluar, detKeluar.kode_barang, brg.nama_barang, "
                    +"brg.harga, detKeluar.jml_keluar, detKeluar.subtotal_keluar " 
                    +"FROM detail_barang_keluar detKeluar "
                    +"INNER JOIN barang_keluar keluar ON keluar.no_keluar=detKeluar.no_keluar "
                    +"INNER JOIN data_barang brg ON brg.kode_barang=detKeluar.kode_barang "
                    +"WHERE detKeluar.no_keluar ='"+id+"' ORDER BY no_keluar  ASC";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_barangKeluar keluar = new model_barangKeluar();
                model_detBarangKeluar detKel = new model_detBarangKeluar();
                model_barang brg = new model_barang();
                
                keluar.setNo_keluar(String.valueOf(rs.getString("detKeluar.no_keluar")));
                detKel.setNo_keluar(keluar);
                
                brg.setKode_barang              (rs.getString("kode_barang"));
                brg.setNama_barang              (rs.getString("nama_barang"));
                brg.setHarga                    (rs.getLong("harga"));
                detKel.setJml_keluar            (rs.getInt("jml_keluar"));
                detKel.setSubtotal_keluar       (rs.getLong("subtotal_keluar"));

                detKel.setKode_barang(brg);
                
                list.add(detKel);
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


    @Override
    public List<model_detBarangKeluar> pencarian(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validasiStok(model_detBarangKeluar mod_detKeluar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
