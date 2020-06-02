/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokprogrami;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class Yetkilendirme {
       public String yetki;
     public void yetkilendirme(String kullanici){
         // YETKİ AYARI
      
           try{
        Baglanti bgln = new Baglanti();
        bgln.baglan();
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = bgln.conn;
        stmt = conn.createStatement();
            
            rs = stmt.executeQuery("Select * from kullanici where kullanici='"+kullanici+"'");
            rs = stmt.getResultSet();
              
            rs.next();
           boolean admin = Boolean.parseBoolean(rs.getObject("admin").toString());
           boolean duzenleme = Boolean.parseBoolean(rs.getObject("duzenleme").toString());
           boolean silme = Boolean.parseBoolean(rs.getObject("silme").toString());
                
           if(admin == true){
             
               yetki = "Admin";
           }else{
               if(duzenleme == false && silme == false){
                  
                      yetki = "Yetki Yok";
               }else{
                   
              
               if(duzenleme == false){
                  
                   yetki = "Silme";
               }else{
                   if(silme == false){
                    
                       yetki = "Düzenleme";
                   } else{
                  
                       yetki = "Yönetim Yok";
                   }
               }
                }
           }
        } catch (SQLException ex) {
            Logger.getLogger(Giris.class.getName()).log(Level.SEVERE, null, ex);
        }
        
              
        // YETKİ AYARI BİTİŞ
    }
    
}
