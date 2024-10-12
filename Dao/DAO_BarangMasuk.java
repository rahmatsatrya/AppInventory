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
import model.model_barangMasuk;
import model.model_distributor;
import model.model_pemesanan;
import model.model_pengguna;
import service.service_barangMasuk;

/**
 *
 * @author alams
 */
public class DAO_BarangMasuk implements service_barangMasuk{
    
    private Connection conn;
    
    public DAO_BarangMasuk(){
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_barangMasuk mod_Masuk) {
        PreparedStatement st = null;
        String sql = "INSERT INTO barang_masuk (no_masuk,tgl_masuk,total_masuk,id_distributor,id_pengguna) VALUES (?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            
            st.setString    (1,mod_Masuk.getNo_masuk());
            st.setString    (2,mod_Masuk.getTgl_masuk());
            st.setLong      (3,mod_Masuk.getTotal_masuk());
            st.setString    (4,mod_Masuk.getId_distributor().getId_distributor());
            st.setString    (5,mod_Masuk.getIdpengguna().getId_pengguna());
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }
    
    @Override
    public void hapusData(model_barangMasuk mod_Masuk) {
        PreparedStatement st = null;
        String sql = "DELETE FROM barang_masuk WHERE no_masuk = ?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mod_Masuk.getNo_masuk());
            st.executeUpdate();
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            if (st != null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE,null,ex);
                }  
            }
        }
    }

    @Override
    public void perbaruiStatus(String kode_barang) {
        PreparedStatement st = null;
        String sql = "UPDATE detail_pemesanan SET status = 'Barang telah diterima' WHERE kode_barang = '" + kode_barang + "'";
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Gagal perbarui status Barang");
            java.util.logging.Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public model_barangMasuk getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_barangMasuk> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM barang_masuk";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                model_barangMasuk BarMas = new model_barangMasuk();
                model_distributor distributor = new model_distributor();
                model_pengguna pengguna = new model_pengguna();
                
                
                
                BarMas.setNo_masuk                  (rs.getString("no_masuk"));
                BarMas.setTgl_masuk                 (rs.getString("tgl_masuk"));
                BarMas.setTotal_masuk               (rs.getLong("total_masuk"));
                distributor.setId_distributor       (rs.getString("id_distributor"));
                pengguna.setId_pengguna             (rs.getString("id_pengguna"));
                
                BarMas.setId_distributor(distributor);
                BarMas.setIdpengguna(pengguna);
                
                list.add(BarMas);
            }
            return list;
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public List<model_barangMasuk> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM barang_masuk WHERE no_masuk LIKE '%" + id + "%' OR tgl_masuk LIKE '% " + id + "%' OR total_masuk LIKE '%" + id + "%' "
                +"OR id_distributor LIKE '%" + id + "%' OR id_pengguna LIKE '%" + id + "%'";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()){
                model_pemesanan pesan = new model_pemesanan();
                model_distributor modDis = new model_distributor();
                model_pengguna modPen = new model_pengguna();
                
                pesan.setNo_pesan(rs.getString("no_masuk"));
                pesan.setTgl_pesan(rs.getString("tgl_masuk"));
                pesan.setTotal_pesan(rs.getLong("total_masuk"));
                modDis.setId_distributor(rs.getString("id_distributor"));
                modPen.setId_pengguna(rs.getString("id_pengguna"));
                
                pesan.setIdDistributor(modDis);
                pesan.setIdPengguna(modPen);
                
                list.add(pesan);
            }
            return list;
        }catch (SQLException e){
            java.util.logging.Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if(rs!= null){
                try{
                    rs.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE,null,e);
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
        
        String sql = "SELECT RIGHT(no_masuk, 3) AS Nomor "+
                     "FROM barang_masuk "+
                     "WHERE no_masuk LIKE 'BM"+ no +"%' "+
                     "ORDER By no_masuk DESC "+
                     "LIMIT 1";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()){
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor ++;
                urutan = "BM" + no + String.format("%03d", nomor);
            }else{
                urutan = "BM" + no + "001";
            }
            
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_BarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }finally{
            if (st!= null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_BarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                }
            }
        }
        return urutan;
    }


    
}
