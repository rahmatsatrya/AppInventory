package Dao;

import Main.Dashboard;
import View.Form_Login;
import com.mysql.cj.jdbc.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import config.koneksi;
import model.model_login;
import service.service_login;
import java.security.NoSuchAlgorithmException;

public class DAO_Login implements service_login {
    
    private Connection conn;
    
    public DAO_Login() {
        conn = koneksi.getConnection();
    }

    @Override
    public void prosesLogin(model_login model_in) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String Id = null;
        String Nama = null;
        String Level2 = null;
        String Username = null;
        String sql = "SELECT * FROM pengguna WHERE id_pengguna = ? OR username = ? AND password = ?";
        
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, model_in.getId_user());
            st.setString(2, model_in.getUsername()); // Assume Encrypt.getmd5java() is properly implemented
            st.setString(3, Encrypt.getmd5java(model_in.getPass()));
            
            rs = st.executeQuery();
            if (rs.next()) {
                // User found, proceed with dashboard
                Id = rs.getString("id_pengguna");
                Nama = rs.getString("nama_pengguna");
                Level2 = rs.getString("level");
                Username = rs.getString("username");
                Blob gambarBlob = (Blob) rs.getBlob("gambar");
                
                model_login mod = new model_login();
                
                mod.setId_user(Id);
                mod.setNama_pengguna(Nama);
                mod.setUsername(Username);
                mod.setLevel(Level2);
                mod.setGambar(gambarBlob);
                
                
                Dashboard menu = new Dashboard(mod);
                menu.setVisible(true);
                menu.revalidate();
                
                Form_Login lg = new Form_Login();
                lg.tutup = true;
            } else {
                // User not found
                JOptionPane.showMessageDialog(null, "Username dan Password Salah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                Form_Login lg = new Form_Login();
                lg.tutup = false;
            }
        } catch (SQLException e) {
            Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Properly close resources
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException e) {
                Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
