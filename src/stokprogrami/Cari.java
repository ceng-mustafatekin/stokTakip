/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokprogrami;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableColumn;

/**
 *
 * 
 */
public class Cari extends javax.swing.JFrame {

    //LİSTELE
        public void Listele(){         
          ((DefaultTableModel)tableListe.getModel()).setNumRows(0);
        try{
        Baglanti bgln = new Baglanti();
        bgln.baglan();
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = bgln.conn;
        stmt = conn.createStatement();

            rs = stmt.executeQuery("Select * from cari");
            int sutunSayisi = rs.getMetaData().getColumnCount();
            rs = stmt.getResultSet();
            
          DefaultTableModel table = (DefaultTableModel)this.tableListe.getModel();
          TableColumnModel sutunBoy = tableListe.getColumnModel();
          
          sutunBoy.getColumn(0).setPreferredWidth(5);
          sutunBoy.getColumn(1).setPreferredWidth(80);
          sutunBoy.getColumn(2).setPreferredWidth(80);
          sutunBoy.getColumn(3).setPreferredWidth(60);
          sutunBoy.getColumn(4).setPreferredWidth(250);
      
            
            while(rs.next()){
 
                Object[] row=new Object[sutunSayisi];
               for(int i=1;i<=sutunSayisi;i++){
                    row[i-1]=rs.getObject(i);
               }
              table.addRow(row);   
            }
            tableListe.setModel(table);
        } catch (SQLException ex) {
            Logger.getLogger(Giris.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        
        // ARAMA
        public void Arama(String aranacak){         
       
((DefaultTableModel)tableListe.getModel()).setNumRows(0);
        try{
        Baglanti bgln = new Baglanti();
        bgln.baglan();
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = bgln.conn;
        stmt = conn.createStatement();
            System.out.println(aranacak);
            rs = stmt.executeQuery("Select * from cari where adi like '%"+aranacak+"%' or id like '%"+aranacak+"%' or telefon like '%"+aranacak+"%'");
            
            int sutunSayisi = rs.getMetaData().getColumnCount();
            rs = stmt.getResultSet();
            
          DefaultTableModel table = (DefaultTableModel)this.tableListe.getModel();
          TableColumnModel sutunBoy = tableListe.getColumnModel();
          
               sutunBoy.getColumn(0).setPreferredWidth(5);
          sutunBoy.getColumn(1).setPreferredWidth(80);
          sutunBoy.getColumn(2).setPreferredWidth(80);
          sutunBoy.getColumn(3).setPreferredWidth(60);
          sutunBoy.getColumn(4).setPreferredWidth(250);
    
            
            while(rs.next()){
 
                Object[] row=new Object[sutunSayisi];
               for(int i=1;i<=sutunSayisi;i++){
                    row[i-1]=rs.getObject(i);
               }
              table.addRow(row);   
            }
            tableListe.setModel(table);
        } catch (SQLException ex) {
            Logger.getLogger(Giris.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        }

       // SİLME
        
        public void Silme(int silinecek){
            
                try{
        Baglanti bgln = new Baglanti();
        bgln.baglan();
        Statement stmt = null;
        Connection conn = bgln.conn;
        stmt = conn.createStatement();
        System.out.println(silinecek);
        
        int yesOrNo = JOptionPane.showConfirmDialog(null, silinecek+" Numaralı Cariyi Silmek İstiyor musunuz ? ","Silme Onay ?", JOptionPane.YES_NO_OPTION);
   
        if(yesOrNo == JOptionPane.YES_OPTION){
                   
        stmt.executeUpdate("Delete From cari where id='"+silinecek+"'");
        JOptionPane.showMessageDialog(null, silinecek+" Numaralı Cari Silinmiştir","Ürün Silme Başarılır",JOptionPane.INFORMATION_MESSAGE);
        Listele();
            
        } 
                
 
           
            
        } catch (SQLException ex) {
            Logger.getLogger(Giris.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
         
         
        
    public Cari() {
        initComponents();
       
        
       Listele();
         System.out.println();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCariEkle = new javax.swing.JButton();
        btnCariDuzenle = new javax.swing.JButton();
        btnCariSil = new javax.swing.JButton();
        btnKapat = new javax.swing.JButton();
        txtKelime = new javax.swing.JTextField();
        btnAra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListe = new javax.swing.JTable();
        lblKim = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cari | Stok Otomasyonu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btnCariEkle.setText("Cari Ekle");
        btnCariEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCariEkleMouseClicked(evt);
            }
        });

        btnCariDuzenle.setText("Cari Düzenle");
        btnCariDuzenle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCariDuzenleMouseClicked(evt);
            }
        });

        btnCariSil.setText("Cari Sil");
        btnCariSil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCariSilMouseClicked(evt);
            }
        });

        btnKapat.setText("Kapat");
        btnKapat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKapatMouseClicked(evt);
            }
        });

        txtKelime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtKelime.setText("Aranacak Cari ?");
        txtKelime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtKelimeMouseClicked(evt);
            }
        });
        txtKelime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKelimeKeyPressed(evt);
            }
        });

        btnAra.setText("Ara");
        btnAra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAraMouseClicked(evt);
            }
        });
        btnAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAraKeyPressed(evt);
            }
        });

        tableListe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "ADI", "SOYADI", "TELEFON", "ADRES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableListe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableListe.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        tableListe.setRowHeight(30);
        tableListe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableListe);

        lblKim.setForeground(new java.awt.Color(255, 255, 255));
        lblKim.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtKelime, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAra, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCariSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCariDuzenle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCariEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKapat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblKim))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCariEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCariDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCariSil, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAra, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(txtKelime))
                        .addGap(18, 18, 18)
                        .addComponent(btnKapat, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblKim))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableListeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListeMouseClicked
            if(evt.getClickCount()==2){
                btnCariDuzenleMouseClicked(evt);
            }
    }//GEN-LAST:event_tableListeMouseClicked

    private void btnCariEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariEkleMouseClicked
       // ÜRÜN EKLE
        
     //StokEkle stkEkle = new StokEkle();
    // new StokEkle(this).setVisible(true);
    CariEkle criEkle = new CariEkle(this);
    criEkle.setVisible(true);
    criEkle.setLocationRelativeTo(null);
    
     
    
    }//GEN-LAST:event_btnCariEkleMouseClicked

    private void txtKelimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtKelimeMouseClicked
      if(txtKelime.getText().equals("Aranacak Cari ?")){
          txtKelime.setText("");
      }
        
    }//GEN-LAST:event_txtKelimeMouseClicked

    private void btnKapatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKapatMouseClicked
        setVisible(false);
        Menu mnu = new Menu();
        mnu.setVisible(true);
        mnu.lblKim.setText(lblKim.getText());
        mnu.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnKapatMouseClicked

    private void btnAraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAraMouseClicked
        String deger = txtKelime.getText();
     
        Arama(deger);
    }//GEN-LAST:event_btnAraMouseClicked

    private void txtKelimeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKelimeKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           String deger = txtKelime.getText();
           Arama(deger);
       }else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
           txtKelime.setText("Aranacak Cari ?");
           Listele();
       }
    }//GEN-LAST:event_txtKelimeKeyPressed

    private void btnAraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAraKeyPressed
        txtKelimeKeyPressed(evt);
    }//GEN-LAST:event_btnAraKeyPressed

    private void btnCariSilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariSilMouseClicked

          Yetkilendirme yt = new Yetkilendirme();
        
        yt.yetkilendirme(lblKim.getText());
        
        
        if(yt.yetki.equals("Admin") || yt.yetki.equals("Silme") || yt.yetki.equals("Yönetim Yok")){
             try {
              String deger = tableListe.getValueAt(tableListe.getSelectedRow(), 0).toString();
                System.out.println(deger);
                Silme(Integer.decode(deger));
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Cari Seçmediniz..", "Hata!",JOptionPane.ERROR_MESSAGE);
        }
        }else{
            JOptionPane.showMessageDialog(null, "İznin Yok","Kısıtlama..",JOptionPane.WARNING_MESSAGE);
        }
      
       
      
         
    }//GEN-LAST:event_btnCariSilMouseClicked

    private void btnCariDuzenleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariDuzenleMouseClicked
       // CARİ DUZENLE
       
       
         Yetkilendirme yt = new Yetkilendirme();
        
        yt.yetkilendirme(lblKim.getText());
        
        
        if(yt.yetki.equals("Admin") || yt.yetki.equals("Düzenleme") || yt.yetki.equals("Yönetim Yok")){
            
              try {
             String cari_id = tableListe.getValueAt(tableListe.getSelectedRow(), 0).toString();
              String adi = tableListe.getValueAt(tableListe.getSelectedRow(), 1).toString();
               String soyisim = tableListe.getValueAt(tableListe.getSelectedRow(), 2).toString();
                String telefon = tableListe.getValueAt(tableListe.getSelectedRow(), 3).toString();
                 String adres = tableListe.getValueAt(tableListe.getSelectedRow(), 4).toString();
      
                    
             
              CariDuzenle criDuzenle = new CariDuzenle(this);
              criDuzenle.veriAl(adi,Integer.parseInt(cari_id),soyisim,telefon,adres);
              criDuzenle.setVisible(true);
              criDuzenle.setLocationRelativeTo(null);   
              
                
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Cari Seçmediniz..", "Hata!",JOptionPane.ERROR_MESSAGE);
              System.err.println("Hata : " + e);
        }
        }else{
            JOptionPane.showMessageDialog(null, "İznin Yok","Kısıtlama..",JOptionPane.WARNING_MESSAGE);
        }
       
      
       
    
    }//GEN-LAST:event_btnCariDuzenleMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Menu mnu = new Menu();
        mnu.setVisible(true);
        mnu.lblKim.setText(lblKim.getText());
        mnu.setLocationRelativeTo(null);
       
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
   
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new Cari().setVisible(true);
                   
            }
           
        });
        
  
        
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAra;
    private javax.swing.JButton btnCariDuzenle;
    private javax.swing.JButton btnCariEkle;
    private javax.swing.JButton btnCariSil;
    private javax.swing.JButton btnKapat;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblKim;
    private javax.swing.JTable tableListe;
    private javax.swing.JTextField txtKelime;
    // End of variables declaration//GEN-END:variables

  
}
