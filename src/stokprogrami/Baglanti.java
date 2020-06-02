package stokprogrami;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Baglanti {
    
      private static final String USERNAME = "root";
      private static final String PASSWORD = "";
      private static final String CONN_STRING = "jdbc:mysql://localhost:3306/vb_stok?useUnicode=true&characterEncoding=UTF-8";
       public  Connection conn = null;
     
       
       public void baglan(){
       try {
             conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
        //      System.out.println("Bağlantı Başarılı");
         } catch (SQLException ex) {
         System.err.println("Bağlantı Başarısız"+ex);
         }
       }
       
}

 