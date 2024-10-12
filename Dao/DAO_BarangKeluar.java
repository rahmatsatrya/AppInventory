/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.model_barangKeluar;
import service.service_BarangKeluar;
import config.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.model_pengguna;

/**
 *
 * @author alams
 */
public class DAO_BarangKeluar implements service_BarangKeluar{
    
    private Connection conn;

    public DAO_BarangKeluar() {
        conn = koneksi.getConnection();
    }
    
    

    @Override
    public void tambahData(model_barangKeluar mod_Keluar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO barang_keluar (no_keluar,tgl_keluar,total_keluar,id_pengguna) VALUES (?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString    (1,mod_Keluar.getNo_keluar());
            st.setString    (2,mod_Keluar.getTgl_keluar());
            st.setLong      (3,mod_Keluar.getTotal_keluar());
            st.setString    (4,mod_Keluar.getMod_pengguna().getId_pengguna());
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }
    
    @Override
    public void hapusData(model_barangKeluar mod_Keluar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM barang_keluar WHERE no_keluar = ?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mod_Keluar.getNo_keluar());
            st.executeUpdate();
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            if (st != null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE,null,ex);
                }  
            }
        }
    }

    @Override
    public model_barangKeluar getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_barangKeluar> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM barang_keluar";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_barangKeluar BarKel = new model_barangKeluar();
                model_pengguna pengguna = new model_pengguna();
                
                
                
                BarKel.setNo_keluar                 (rs.getString("no_keluar"));
                BarKel.setTgl_keluar                (rs.getString("tgl_keluar"));
                BarKel.setTotal_keluar              (rs.getLong("total_keluar"));
                pengguna.setId_pengguna             (rs.getString("id_pengguna"));
                
                BarKel.setMod_pengguna(pengguna);
                
                list.add(BarKel);
            }
            return list;
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public List<model_barangKeluar> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM barang_keluar WHERE no_keluar LIKE '%" + id + "%' OR tgl_keluar LIKE '% " + id + "%' OR total_keluar LIKE '%" + id + "%' "
                +"OR id_pengguna LIKE '%" + id + "%'";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()){
                model_barangKeluar BarKel = new model_barangKeluar();
                model_pengguna pengguna = new model_pengguna();
                
                
                
                BarKel.setNo_keluar                 (rs.getString("no_keluar"));
                BarKel.setTgl_keluar                (rs.getString("tgl_keluar"));
                BarKel.setTotal_keluar              (rs.getLong("total_keluar"));
                pengguna.setId_pengguna             (rs.getString("id_pengguna"));
                
                BarKel.setMod_pengguna(pengguna);
                
                list.add(BarKel);
               
            }
            return list;
        }catch (SQLException e){
            java.util.logging.Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if(rs!= null){
                try{
                    rs.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }    
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        
        Date now = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat noformat = new SimpleDateFormat("yyMM");
        String tgl = tanggal.format(now);
        String no = noformat.format(now);
        
        String sql = "SELECT RIGHT(no_keluar, 3) AS Nomor "+
                     "FROM barang_keluar "+
                     "WHERE no_keluar LIKE 'BK"+ no +"%' "+
                     "ORDER By no_keluar DESC "+
                     "LIMIT 1";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()){
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor ++;
                urutan = "BK" + no + String.format("%03d", nomor);
            }else{
                urutan = "BK" + no + "001";
            }
            
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_BarangKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }finally{
            if (st!= null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_BarangKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                }
            }
        }
        return urutan;
    }

    
    
}
