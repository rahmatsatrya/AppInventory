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
import model.model_barang;
import model.model_jenisBarang;
import service.service_barang;


public class DAO_Barang implements service_barang{
    private Connection conn;
    
    public DAO_Barang(){
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_barang mod_bar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO data_barang (kode_barang,kode_jenis,nama_barang,satuan,harga,stok) VALUES (?,?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString    (1,mod_bar.getKode_barang());
            st.setString    (2,mod_bar.getJenis_barang().getKode_jenis());
            st.setString    (3,mod_bar.getNama_barang());
            st.setString    (4,mod_bar.getSatuan());
            st.setLong      (5,mod_bar.getHarga());
            st.setInt       (6,mod_bar.getStok());
            
            st.executeUpdate();
            
        } catch (SQLException e) {
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
    public void perbaruiData(model_barang mod_bar) {
        PreparedStatement st = null;
        String sql = "UPDATE data_barang SET kode_jenis = ?, nama_barang = ?, satuan = ?, harga = ?, stok = ? WHERE kode_barang = ?";
        
        try {
        st = conn.prepareStatement(sql);
        
        st.setString(1, mod_bar.getJenis_barang().getKode_jenis());
        st.setString(2, mod_bar.getNama_barang());
        st.setString(3, mod_bar.getSatuan());
        st.setLong(4, mod_bar.getHarga());
        st.setInt(5, mod_bar.getStok());
        st.setString(6, mod_bar.getKode_barang()); // Pastikan kode_barang digunakan sebagai kondisi WHERE
        
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
    public void hapusData(model_barang mod_bar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM data_barang WHERE kode_barang = ?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mod_bar.getKode_barang());
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
    public model_barang getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<model_barang> getDataByID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_barang> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT bg.kode_barang,bg.kode_jenis,jb.nama_jenis,bg.nama_barang,bg.satuan,bg.harga,bg.stok FROM data_barang bg INNER JOIN jenis_barang jb ON jb.kode_jenis=bg.kode_jenis";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_barang mobar = new model_barang();
                model_jenisBarang jbr = new model_jenisBarang();
                
                mobar.setKode_barang       (rs.getString("kode_barang"));
                jbr.setKode_jenis          (rs.getString("kode_jenis"));
                jbr.setNama_jenis          (rs.getString("nama_jenis"));
                mobar.setNama_barang       (rs.getString("nama_barang"));
                mobar.setSatuan            (rs.getString("satuan"));
                mobar.setHarga             (rs.getLong("harga"));
                mobar.setStok              (rs.getInt("stok"));
                
                mobar.setJenis_barang(jbr);
                
                list.add(mobar);
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
    public List<model_barang> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT bg.kode_barang, bg.kode_jenis, jb.nama_jenis, bg.nama_barang, bg.satuan, bg.harga, bg.stok "
                    +"FROM data_barang bg INNER JOIN jenis_barang jb ON jb.kode_jenis = bg.kode_jenis "
                    +"WHERE kode_barang LIKE '%" + id + "%' OR nama_barang LIKE '%" +id+ "%'";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_barang mobar = new model_barang();
                model_jenisBarang jbr = new model_jenisBarang();
                
                mobar.setKode_barang       (rs.getString("kode_barang"));
                jbr.setKode_jenis          (rs.getString("kode_jenis"));
                jbr.setNama_jenis          (rs.getString("nama_jenis"));
                mobar.setNama_barang       (rs.getString("nama_barang"));
                mobar.setSatuan            (rs.getString("satuan"));
                mobar.setHarga             (rs.getLong("harga"));
                mobar.setStok              (rs.getInt("stok"));
                
                mobar.setJenis_barang(jbr);
                
                list.add(mobar);
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
    public List<model_barang> pencarian2(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nomor() { //penomoran otomatis
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        
        Date now = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat noformat = new SimpleDateFormat("yyMM");
        String tgl = tanggal.format(now);
        String no = noformat.format(now);
        
        String sql = "SELECT RIGHT(kode_barang, 3) AS Nomor "+
                     "FROM data_barang "+
                     "WHERE kode_barang LIKE 'B"+ no +"%' "+
                     "ORDER By kode_barang DESC "+
                     "LIMIT 1";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()){
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor ++;
                urutan = "B" + no + String.format("%03d", nomor);
            }else{
                urutan = "B" + no + "001";
            }
            
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }finally{
            if (st!= null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                }
            }
        }
        return urutan;
    }

    @Override
    public String nomor2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    
}
