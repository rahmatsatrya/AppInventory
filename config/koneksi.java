/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alams
 */
public class koneksi {
    private static Connection connection;
//    membuat koneksi ke database mysql
    public static Connection getConnection(){
        if (connection == null){
            try{
                String url = "jdbc:mysql://localhost/db_inventory";
                String user = "root";
                String pass = "";
                
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = DriverManager.getConnection(url,user,pass);
            } catch(SQLException e){
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE,null,e);
            }
       }
        return connection;
    }
    
}
