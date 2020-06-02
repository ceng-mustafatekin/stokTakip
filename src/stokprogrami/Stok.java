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



public class Stok extends javax.swing.JFrame {

    
    
    
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

            rs = stmt.executeQuery("Select * from stok");
            int sutunSayisi = rs.getMetaData().getColumnCount();
            rs = stmt.getResultSet();
            
          DefaultTableModel table = (DefaultTableModel)this.tableListe.getModel();
          TableColumnModel sutunBoy = tableListe.getColumnModel();
          
          sutunBoy.getColumn(0).setPreferredWidth(5);
          sutunBoy.getColumn(1).setPreferredWidth(110);
          sutunBoy.getColumn(2).setPreferredWidth(100);
          sutunBoy.getColumn(3).setPreferredWidth(100);
          sutunBoy.getColumn(4).setPreferredWidth(10);
          sutunBoy.getColumn(5).setPreferredWidth(35);
          sutunBoy.getColumn(6).setPreferredWidth(35);
           sutunBoy.getColumn(7).setPreferredWidth(45);
            
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
            rs = stmt.executeQuery("Select * from stok where adi like '%"+aranacak+"%' or id like '%"+aranacak+"%' or seri_no like '%"+aranacak+"%'");
            
            int sutunSayisi = rs.getMetaData().getColumnCount();
            rs = stmt.getResultSet();
            
          DefaultTableModel table = (DefaultTableModel)this.tableListe.getModel();
          TableColumnModel sutunBoy = tableListe.getColumnModel();
          
          sutunBoy.getColumn(0).setPreferredWidth(5);
          sutunBoy.getColumn(1).setPreferredWidth(110);
          sutunBoy.getColumn(2).setPreferredWidth(100);
          sutunBoy.getColumn(3).setPreferredWidth(100);
          sutunBoy.getColumn(4).setPreferredWidth(10);
          sutunBoy.getColumn(5).setPreferredWidth(35);
          sutunBoy.getColumn(6).setPreferredWidth(35);
          sutunBoy.getColumn(7).setPreferredWidth(45);
            
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
        
        int yesOrNo = JOptionPane.showConfirmDialog(null, silinecek+" Numaralı Ürünü Silmek İstiyor musunuz ? ","Silme Onay ?", JOptionPane.YES_NO_OPTION);
   
        if(yesOrNo == JOptionPane.YES_OPTION){
                   
        stmt.executeUpdate("Delete From stok where id='"+silinecek+"'");
        JOptionPane.showMessageDialog(null, silinecek+" Numaralı Ürün Silinmiştir","Ürün Silme Başarılır",JOptionPane.INFORMATION_MESSAGE);
        Listele();
            
        } 
                
 
           
            
        } catch (SQLException ex) {
            Logger.getLogger(Giris.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
         private Menu ataPencere;
         public Stok(Menu ata){
            this.ataPencere = ata;
            initComponents();  
                              
            
            
         }
        
     
    public Stok() {
      initComponents();
        
      
        
       Listele();
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUrunEkle = new javax.swing.JButton();
        btnUrunDuzenle = new javax.swing.JButton();
        btnUrunSil = new javax.swing.JButton();
        btnKapat = new javax.swing.JButton();
        txtKelime = new javax.swing.JTextField();
        btnAra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListe = new javax.swing.JTable();
        lblKim = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stok | Stok Otomasyonu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btnUrunEkle.setText("Ürün Ekle");
        btnUrunEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUrunEkleMouseClicked(evt);
            }
        });

        btnUrunDuzenle.setText("Ürün Düzenle");
        btnUrunDuzenle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUrunDuzenleMouseClicked(evt);
            }
        });

        btnUrunSil.setText("Ürün Sil");
        btnUrunSil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUrunSilMouseClicked(evt);
            }
        });

        btnKapat.setText("Kapat");
        btnKapat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKapatMouseClicked(evt);
            }
        });

        txtKelime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtKelime.setText("Aranacak Ürün ?");
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
                "NO", "ÜRÜN ADI", "MODEL", "SERİ NO", "ADET", "ALIŞ FİYATI", "SATIŞ FİYATI", "DEPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
                            .addComponent(btnUrunSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUrunDuzenle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUrunEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(btnUrunEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUrunDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUrunSil, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                btnUrunDuzenleMouseClicked(evt);
            }
    }//GEN-LAST:event_tableListeMouseClicked

    private void btnUrunEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUrunEkleMouseClicked
       // ÜRÜN EKLE
        
     //StokEkle stkEkle = new StokEkle();
    // new StokEkle(this).setVisible(true);
    StokEkle stkEkle = new StokEkle(this);
    stkEkle.setVisible(true);
    stkEkle.setLocationRelativeTo(null);
    
     
    
    }//GEN-LAST:event_btnUrunEkleMouseClicked

    private void txtKelimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtKelimeMouseClicked
      if(txtKelime.getText().equals("Aranacak Ürün ?")){
          txtKelime.setText("");
      }
        
    }//GEN-LAST:event_txtKelimeMouseClicked

    private void btnKapatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKapatMouseClicked
        setVisible(false);
        Menu mnu = new Menu();
        mnu.lblKim.setText(lblKim.getText());
        mnu.setVisible(true);
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
           txtKelime.setText("Aranacak Ürün ?");
           Listele();
       }
    }//GEN-LAST:event_txtKelimeKeyPressed

    private void btnAraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAraKeyPressed
        txtKelimeKeyPressed(evt);
    }//GEN-LAST:event_btnAraKeyPressed

    private void btnUrunSilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUrunSilMouseClicked
 
      
         Yetkilendirme yt = new Yetkilendirme();
        
        yt.yetkilendirme(lblKim.getText());
        
        
        if(yt.yetki.equals("Admin") || yt.yetki.equals("Silme") || yt.yetki.equals("Yönetim Yok")){
              try {
              String deger = tableListe.getValueAt(tableListe.getSelectedRow(), 0).toString();
                System.out.println(deger);
                Silme(Integer.decode(deger));
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Ürün Seçmediniz..", "Hata!",JOptionPane.ERROR_MESSAGE);
        }
        }else{
            JOptionPane.showMessageDialog(null, "İznin Yok","Kısıtlama..",JOptionPane.WARNING_MESSAGE);
        }
        
        
      
      
         
    }//GEN-LAST:event_btnUrunSilMouseClicked

    private void btnUrunDuzenleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUrunDuzenleMouseClicked
       // URUN DUZENLE
        
        Yetkilendirme yt = new Yetkilendirme();
        yt.yetkilendirme(lblKim.getText());

        System.out.println(yt.yetki);
        if(yt.yetki.equals("Admin") || yt.yetki.equals("Düzenleme") || yt.yetki.equals("Yönetim Yok")){
             try {
             String urun_id = tableListe.getValueAt(tableListe.getSelectedRow(), 0).toString();
              String urun_ismi = tableListe.getValueAt(tableListe.getSelectedRow(), 1).toString();
               String urun_model = tableListe.getValueAt(tableListe.getSelectedRow(), 2).toString();
                String seri_no = tableListe.getValueAt(tableListe.getSelectedRow(), 3).toString();
                 String adet = tableListe.getValueAt(tableListe.getSelectedRow(), 4).toString();
                  String alis_fiyati = tableListe.getValueAt(tableListe.getSelectedRow(), 5).toString();
                   String satis_fiyati = tableListe.getValueAt(tableListe.getSelectedRow(), 6).toString();
                    
             
              StokDuzenle stkDuzenle = new StokDuzenle(this);
              stkDuzenle.veriAl(urun_ismi,Integer.parseInt(urun_id),urun_model,seri_no,adet,alis_fiyati,satis_fiyati);
              stkDuzenle.setVisible(true);
              stkDuzenle.setLocationRelativeTo(null);   
              
                
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Ürün Seçmediniz..", "Hata!",JOptionPane.ERROR_MESSAGE);
              System.err.println("Hata : " + e);
        }
        }else{
            JOptionPane.showMessageDialog(null, "İznin Yok","Kısıtlama..",JOptionPane.WARNING_MESSAGE);
        }
       
      
       
    
    }//GEN-LAST:event_btnUrunDuzenleMouseClicked

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
            java.util.logging.Logger.getLogger(Stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
   
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new Stok().setVisible(true);
                   
            }
           
        });
        
  
        
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAra;
    private javax.swing.JButton btnKapat;
    private javax.swing.JButton btnUrunDuzenle;
    private javax.swing.JButton btnUrunEkle;
    private javax.swing.JButton btnUrunSil;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblKim;
    private javax.swing.JTable tableListe;
    private javax.swing.JTextField txtKelime;
    // End of variables declaration//GEN-END:variables

  
}
