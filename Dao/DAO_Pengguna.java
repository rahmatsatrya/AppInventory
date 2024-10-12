/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import config.koneksi;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.model_pengguna;
import service.service_pengguna;


/**
 *
 * @author alams
 */
public class DAO_Pengguna implements service_pengguna{
    private Connection connection;
    
    public DAO_Pengguna(){
        connection = koneksi.getConnection();
    }

    @Override
    public void tambahData(model_pengguna mod_pengguna) {
        PreparedStatement st = null;
        String sql = "INSERT INTO pengguna (id_pengguna,nama_pengguna,username,password,tlp_pengguna,alamat_pengguna,level,gambar) VALUES (?,?,?,?,?,?,?,?)";
        try {
            st = connection.prepareStatement(sql);
            
            st.setString    (1,mod_pengguna.getId_pengguna());
            st.setString    (2,mod_pengguna.getNama_pengguna());
            st.setString    (3,mod_pengguna.getUsername());
            st.setString    (4,Encrypt.getmd5java(mod_pengguna.getPassword()));
            st.setString    (5,mod_pengguna.getTlp_pengguna());
            st.setString    (6,mod_pengguna.getAlamat_pengguna());
            st.setString    (7,mod_pengguna.getLevel());
            
            // mengubah gambar menjadi byte array
            String imagePath = mod_pengguna.getImagePath();
            if (imagePath != null){
                File imageFIle = new File(imagePath);
                FileInputStream fis = new FileInputStream(imageFIle);
                byte[] imageData = new byte[(int) imageFIle.length()];
                fis.read(imageData);
                fis.close();
                st.setBytes(8, imageData);
            }else{
                st.setNull(8, java.sql.Types.BLOB);
            }
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE,null,e);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }


    @Override
    public void perbaruiData(model_pengguna mod_pengguna) {
        PreparedStatement st = null;
        String sql = "UPDATE pengguna SET nama_pengguna = ?, username = ?, tlp_pengguna = ?, alamat_pengguna = ?, level = ?";
        
        if (mod_pengguna.getImagePath() != null && !mod_pengguna.getImagePath().isEmpty()){
            sql += ",gambar = ?";
        }
            sql += " WHERE id_pengguna = ?";
        
        try {
            st = connection.prepareStatement(sql);

            st.setString    (1,mod_pengguna.getNama_pengguna());
            st.setString    (2,mod_pengguna.getUsername());
            st.setString    (3,mod_pengguna.getTlp_pengguna());
            st.setString    (4,mod_pengguna.getAlamat_pengguna());
            st.setString    (5,mod_pengguna.getLevel());
            
            // mengubah gambar menjadi byte array
            if (mod_pengguna.getImagePath() != null && !mod_pengguna.getImagePath().isEmpty()){
                File imageFile = new File(mod_pengguna.getImagePath());
                FileInputStream fis = new FileInputStream(imageFile);
                st.setBinaryStream(6, fis, (int) imageFile.length());
                st.setString(7, mod_pengguna.getId_pengguna());
            }else{
                st.setString(6, mod_pengguna.getId_pengguna());
            }

            st.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Memperbarui Data");
            Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE,null,e);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public void hapusData(model_pengguna mod_pengguna) {
        PreparedStatement st = null;
        String sql = "DELETE FROM pengguna WHERE id_pengguna = ?";
        try{
            st = connection.prepareStatement(sql);
            st.setString(1, mod_pengguna.getId_pengguna());
            st.executeUpdate();
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            if (st != null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE,null,ex);
                }  
            }
        }
    }

    @Override
    public model_pengguna getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<model_pengguna> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM pengguna";
        
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                
                model_pengguna mopen = new model_pengguna();
                
                mopen.setId_pengguna        (rs.getString("id_pengguna"));
                mopen.setNama_pengguna      (rs.getString("nama_pengguna"));
                mopen.setUsername           (rs.getString("username"));
                mopen.setTlp_pengguna       (rs.getString("tlp_pengguna"));
                mopen.setAlamat_pengguna    (rs.getString("alamat_pengguna"));
                mopen.setLevel              (rs.getString("level"));
                
                list.add(mopen);
            }
            return list;
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    java.util.logging.Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public List<model_pengguna> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM pengguna WHERE id_pengguna LIKE ? OR nama_pengguna LIKE ? OR username LIKE ? OR tlp_pengguna LIKE ? OR alamat_pengguna LIKE ? OR level LIKE ?";
        try{
            st = connection.prepareStatement(sql);
            String searchPattern = "%" + id + "%";
            st.setString(1, searchPattern);
            st.setString(2, searchPattern);
            st.setString(3, searchPattern);
            st.setString(4, searchPattern);
            st.setString(5, searchPattern);
            st.setString(6, searchPattern);
            
            rs = st.executeQuery();
            while(rs.next()){
                model_pengguna mopen = new model_pengguna();
                
                mopen.setId_pengguna        (rs.getString("id_pengguna"));
                mopen.setNama_pengguna      (rs.getString("nama_pengguna"));
                mopen.setUsername           (rs.getString("username"));
                mopen.setTlp_pengguna       (rs.getString("tlp_pengguna"));
                mopen.setAlamat_pengguna    (rs.getString("alamat_pengguna"));
                mopen.setLevel              (rs.getString("level"));
                
                list.add(mopen);
            }
            return list;
        }catch (SQLException e){
            java.util.logging.Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }finally{
            if (st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if(rs!= null){
                try{
                    rs.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_Pengguna.class.getName()).log(Level.SEVERE,null,e);
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
                
        String sql = "SELECT RIGHT (id_pengguna,3) AS Nomor FROM pengguna WHERE id_pengguna LIKE 'USR" + no+ "%' ORDER BY id_pengguna DESC LIMIT 1";
        
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()){
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "USR" +no+ String.format("%03d", nomor);
            }else{
                urutan = "USR" +no+ "001";
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
    public void tampilGambar (JLabel lb_gambar, String id){
        try{
            String sql = "SELECT * FROM pengguna WHERE id_pengguna = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
            
                    if (rs.next()){
                        byte[] img = rs.getBytes("gambar");
                        if (img != null){
                            ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lb_gambar.getWidth(), lb_gambar.getHeight(), Image.SCALE_SMOOTH));
                            lb_gambar.setIcon(imageIcon);
                        }else{
                            ImageIcon defaulIcon = new ImageIcon(getClass().getResource("/img/profile.png"));
                            lb_gambar.setIcon(defaulIcon);
                        }
                    }
                }
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public boolean validateOldPassword(String username, String oldPassword) {
        
        String encryptOldPassword = Encrypt.getmd5java(oldPassword);
        
        try{
            String sql = "SELECT * FROM pengguna WHERE username = ? AND password = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, encryptOldPassword);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        String encryptOldPassword = Encrypt.getmd5java(oldPassword);
        String encryptNewPassword = Encrypt.getmd5java(newPassword);
        
        try{
            String sql = "SELECT * FROM pengguna WHERE username = ? AND password = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, encryptOldPassword);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()){
                String sqlUpdate = "UPDATE pengguna SET password = ? WHERE username = ?";
                PreparedStatement pstmtUpdate = connection.prepareStatement(sqlUpdate);
                pstmtUpdate.setString(1, encryptNewPassword);
                pstmtUpdate.setString(2, username);
                int result = pstmtUpdate.executeUpdate();
                return result > 0;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
}
