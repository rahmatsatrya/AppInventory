/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author alams
 */
public class Encrypt {
    public static String getmd5java(String message){
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
            
            //merubah byte array ke dalam String Hexadecimal
            StringBuilder sb = new StringBuilder(2*hash.length);
            for(byte b : hash){
                sb.append(String.format("%02x", b&0xff));
            }
            digest = sb.toString();
        } catch (UnsupportedEncodingException ex) {
           Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE,null,ex); 
        } catch (NoSuchAlgorithmException ex){
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE,null,ex);
        }
        return digest;
    }
}
