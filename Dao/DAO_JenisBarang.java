/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import config.koneksi;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.List;
import javax.swing.JOptionPane;
import model.model_distributor;
import model.model_jenisBarang;
import service.service_jenisBarang;

/**
 *
 * @author alams
 */
public class DAO_JenisBarang implements service_jenisBarang{
    
    private Connection connection;
    
    public DAO_JenisBarang(){
        connection = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_jenisBarang mod_jenbar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO jenis_barang (kode_jenis,nama_jenis) VALUES (?,?)";
        try {
            st = connection.prepareStatement(sql);
            
            st.setString    (1,mod_jenbar.getKode_jenis());
            st.setString    (2,mod_jenbar.getNama_jenis());
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public void perbaruiData(model_jenisBarang mod_jenbar) {
        PreparedStatement st = null;
        String sql = "UPDATE jenis_barang SET kode_jenis = ?,nama_jenis = ? WHERE kode_jenis = ?";
        
        try {
            st = connection.prepareStatement(sql);

            st.setString(1, mod_jenbar.getKode_jenis());
            st.setString(2, mod_jenbar.getNama_jenis());
            st.setString(3, mod_jenbar.getKode_jenis());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                // Jika tidak ada baris yang terpengaruh, artinya kode_barang tidak ditemukan
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan untuk diperbarui");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Memperbarui Data");
            Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public void hapusData(model_jenisBarang mod_jenbar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM jenis_barang WHERE kode_jenis = ?";
        try{
            st = connection.prepareStatement(sql);
            st.setString(1, mod_jenbar.getKode_jenis());
            st.executeUpdate();
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            if (st != null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE,null,ex);
                }  
            }
        }
    }

    @Override
    public model_jenisBarang getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_jenisBarang> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM jenis_barang";
        
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_jenisBarang mojeb = new model_jenisBarang();
                mojeb.setKode_jenis     (rs.getString("kode_jenis"));
                mojeb.setNama_jenis     (rs.getString("nama_jenis"));
                
                list.add(mojeb);
            }
            return list;
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
        
    }

    @Override
    public List<model_jenisBarang> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT jb.kode_jenis, jb.nama_jenis FROM jenis_barang jb WHERE jb.kode_jenis LIKE ? OR jb.nama_jenis LIKE ?";
        try{
            st = connection.prepareStatement(sql);
            String searchPattern = "%" + id + "%";
            st.setString(1, searchPattern);
            st.setString(2, searchPattern);
            
            rs = st.executeQuery();
            while(rs.next()){
                model_jenisBarang jbr = new model_jenisBarang();
                
                jbr.setKode_jenis          (rs.getString("kode_jenis"));
                jbr.setNama_jenis          (rs.getString("nama_jenis"));
                
                list.add(jbr);
            }
            return list;
        }catch (SQLException e){
            java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if(rs!= null){
                try{
                    rs.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        String sql = "SELECT RIGHT (kode_jenis,3) AS Nomor FROM jenis_barang ORDER BY Nomor DESC LIMIT 1";
        
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()){
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = String.format("JB%03d", nomor);
            }else{
                urutan = "JB001";
            }
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
     return urutan;
        
    }

    @Override
    public boolean validasiNamaJenisBarang(model_jenisBarang mod_jenbar) { //agar tidak terjadi duplikasi nama barang
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean valid = false;
        String sql = "SELECT nama_jenis FROM jenis_barang WHERE kode_jenis!='" + mod_jenbar.getKode_jenis() +"' AND nama_jenis LIKE BINARY '"
                    + mod_jenbar.getNama_jenis() +"';";
        
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Nama jenis barang telah ada!\nSilahkan masukkan nama jenis barang yang lain","Peringatan",JOptionPane.WARNING_MESSAGE);
            }else{
                valid = true;
            }
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
     return valid;

    }

    @Override
    public List<model_jenisBarang> getData(int startIndex, int entriesPerPage) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM jenis_barang LIMIT ?,?";
        List<model_jenisBarang> list = new ArrayList<>();
        
        try {
            st = connection.prepareStatement(sql);
            st.setInt (1,startIndex);
            st.setInt (2, entriesPerPage);
            rs = st.executeQuery();
            
            while(rs.next()){
                model_jenisBarang mojeb = new model_jenisBarang();
                mojeb.setKode_jenis     (rs.getString("kode_jenis"));
                mojeb.setNama_jenis     (rs.getString("nama_jenis"));
                
                list.add(mojeb);
            }
            return list;
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }

    }

    @Override
    public int getTotalHalaman() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) AS total FROM jenis_barang";
        
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            
            if (rs.next()){
                return rs.getInt("total");
            }else{
                return 0;
            }
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
            return 0;
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }
    
}
