/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import config.koneksi;
import java.util.List;
import model.model_pemesanan;
import service.service_pemesanan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.model_distributor;
import model.model_pengguna;


/**
 *
 * @author alams
 */
public class DAO_Pemesanan implements service_pemesanan{
    private Connection conn;
    
    public DAO_Pemesanan(){
        conn = koneksi.getConnection();
    }        

    @Override
    public void tambahData(model_pemesanan mod_pesan) {
       PreparedStatement st = null;
        String sql = "INSERT INTO pemesanan (no_pesan,tgl_pesan,total_pesan,id_distributor,id_pengguna) VALUES (?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString    (1,mod_pesan.getNo_pesan());
            st.setString    (2,mod_pesan.getTgl_pesan());
            st.setLong      (3,mod_pesan.getTotal_pesan());
            st.setString    (4,mod_pesan.getIdDistributor().getId_distributor());
            st.setString    (5,mod_pesan.getIdPengguna().getId_pengguna());
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public model_pemesanan getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_pemesanan> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM pemesanan";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_pemesanan pesan = new model_pemesanan();
                model_distributor distributor = new model_distributor();
                model_pengguna pengguna = new model_pengguna();
                
                
                
                pesan.setNo_pesan                   (rs.getString("no_pesan"));
                pesan.setTgl_pesan                  (rs.getString("tgl_pesan"));
                pesan.setTotal_pesan                (rs.getLong("total_pesan"));
                distributor.setId_distributor       (rs.getString("id_distributor"));
                pengguna.setId_pengguna             (rs.getString("id_pengguna"));
                
                pesan.setIdDistributor(distributor);
                pesan.setIdPengguna(pengguna);
                
                list.add(pesan);
            }
            return list;
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public List<model_pemesanan> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM pemesanan WHERE no_pesan LIKE '%" + id + "%' OR tgl_pesan LIKE '% " + id + "%' OR total_pesan LIKE '%" + id + "%' "
                +"OR id_distributor LIKE '%" + id + "%' OR id_pengguna LIKE '%" + id + "%'";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()){
                model_pemesanan pesan = new model_pemesanan();
                model_distributor modDis = new model_distributor();
                model_pengguna modPen = new model_pengguna();
                
                pesan.setNo_pesan(rs.getString("no_pesan"));
                pesan.setTgl_pesan(rs.getString("tgl_pesan"));
                pesan.setTotal_pesan(rs.getLong("total_pesan"));
                modDis.setId_distributor(rs.getString("id_distributor"));
                modPen.setId_pengguna(rs.getString("id_pengguna"));
                
                pesan.setIdDistributor(modDis);
                pesan.setIdPengguna(modPen);
                
                list.add(pesan);
            }
            return list;
        }catch (SQLException e){
            java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if(rs!= null){
                try{
                    rs.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE,null,e);
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
        
        String sql = "SELECT RIGHT(no_pesan, 3) AS Nomor "+
                     "FROM pemesanan "+
                     "WHERE no_pesan LIKE 'PB"+ no +"%' "+
                     "ORDER By no_pesan DESC "+
                     "LIMIT 1";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()){
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor ++;
                urutan = "PB" + no + String.format("%03d", nomor);
            }else{
                urutan = "PB" + no + "001";
            }
            
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }finally{
            if (st!= null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                }
            }
        }
        return urutan;
    }
    

    @Override
    public void perbaruiData(model_pemesanan mod_pesan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void hapusData(model_pemesanan mod_pesan) {
        PreparedStatement st = null;
        String sql = "DELETE FROM pemesanan WHERE no_pesan = ?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mod_pesan.getNo_pesan());
            st.executeUpdate();
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            if (st != null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE,null,ex);
                }  
            }
        }
    }
    
}
