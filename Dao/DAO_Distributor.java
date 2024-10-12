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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.model_distributor;
import service.service_distributor;

/**
 *
 * @author alams
 */
public class DAO_Distributor implements service_distributor{
    private Connection connection;
    
    public DAO_Distributor(){
        connection = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_distributor mod_dis) {
        PreparedStatement st = null;
        String sql = "INSERT INTO distributor (id_distributor,nama_distributor,tlp_distributor,alamat_distributor) VALUES (?,?,?,?)";
        try {
            st = connection.prepareStatement(sql);
            
            st.setString    (1,mod_dis.getId_distributor());
            st.setString    (2,mod_dis.getNama_distributor());
            st.setString    (3,mod_dis.getTlp_distributor());
            st.setString    (4,mod_dis.getAlamat_distributor());
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }

    }

    @Override
    public void perbaruiData(model_distributor mod_dis) {
        PreparedStatement st = null;
        String sql = "UPDATE distributor SET nama_distributor = ?,tlp_distributor = ?,alamat_distributor = ? WHERE id_distributor = ?";
        
        try {
            st = connection.prepareStatement(sql);

            st.setString(1, mod_dis.getNama_distributor());
            st.setString(2, mod_dis.getTlp_distributor());
            st.setString(3, mod_dis.getAlamat_distributor());
            st.setString(4, mod_dis.getId_distributor());
        
        int rowsAffected = st.executeUpdate();
        if (rowsAffected == 0) {
            // Jika tidak ada baris yang terpengaruh, artinya kode_barang tidak ditemukan
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan untuk diperbarui");
        }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Memperbarui Data");
            Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public void hapusData(model_distributor mod_dis) {
        PreparedStatement st = null;
        String sql = "DELETE FROM distributor WHERE id_distributor = ?";
        try{
            st = connection.prepareStatement(sql);
            st.setString(1, mod_dis.getId_distributor());
            st.executeUpdate();
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            if (st != null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
    }

    @Override
    public model_distributor getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_distributor> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM distributor";
        
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_distributor modis = new model_distributor();
                modis.setId_distributor(rs.getString("id_distributor"));
                modis.setNama_distributor(rs.getString("nama_distributor"));
                modis.setTlp_distributor(rs.getString("tlp_distributor"));
                modis.setAlamat_distributor(rs.getString("alamat_distributor"));
                
                
                list.add(modis);
            }
            return list;
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public List<model_distributor> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM distributor WHERE id_distributor LIKE ? OR nama_distributor LIKE ? OR tlp_distributor LIKE ? OR alamat_distributor LIKE ?";
        try{
            st = connection.prepareStatement(sql);
            String searchPattern = "%" + id + "%";
            st.setString(1, searchPattern);
            st.setString(2, searchPattern);
            st.setString(3, searchPattern);
            st.setString(4, searchPattern);
            
            rs = st.executeQuery();
            while(rs.next()){
                model_distributor modis = new model_distributor();
                
                modis.setId_distributor     (rs.getString("id_distributor"));
                modis.setNama_distributor   (rs.getString("nama_distributor"));
                modis.setTlp_distributor    (rs.getString("tlp_distributor"));
                modis.setAlamat_distributor (rs.getString("alamat_distributor"));
                
                list.add(modis);
            }
            return list;
        }catch (SQLException e){
            java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if(rs!= null){
                try{
                    rs.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,e);
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
        SimpleDateFormat tanggal = new SimpleDateFormat("yyy-MM-dd");
        SimpleDateFormat noformat = new SimpleDateFormat("yyMM");
        String tgl = tanggal.format(now);
        String no = noformat.format(now);
                
        String sql = "SELECT RIGHT (id_distributor,3) AS Nomor FROM distributor WHERE id_distributor LIKE 'DIS" + no+ "%' ORDER BY id_distributor DESC LIMIT 1";
        
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()){
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "DIS" +no+ String.format("%03d", nomor);
            }else{
                urutan = "DIS" +no+ "001";
            }
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
     return urutan;
    }

    @Override
    public List<model_distributor> getData(int startIndex, int entriesPerPage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getTotalEntries() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
