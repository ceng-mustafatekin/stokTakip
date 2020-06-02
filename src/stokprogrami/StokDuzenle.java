/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokprogrami;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class StokDuzenle extends javax.swing.JFrame {

    /**
     * Creates new form StokEkle
     */
    int urun_id;
   
    
    public void veriAl(String urun_ismi,int id,String model,String seri_no,String adet,String alis_fiyat,String satis_fiyat){
        lblUrunIsmi.setText(urun_ismi);
        urun_id = id;
        txtAdet.setText(adet);
        txtAlisFiyati.setText(alis_fiyat);
        txtSatisFiyati.setText(satis_fiyat);
        txtUrunSeriNo.setText(seri_no);
        txtUrunModel.setText(model);
        txtUrunIsmi.setText(urun_ismi);
        
        
    }
    
    
    public StokDuzenle() {
        initComponents();

    }

     private Stok stk;
     public StokDuzenle(Stok ata){
        
         this.stk = ata;
         initComponents();
         
        
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtUrunSeriNo = new javax.swing.JTextField();
        txtSatisFiyati = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUrunModel = new javax.swing.JTextField();
        txtUrunIsmi = new javax.swing.JTextField();
        txtAlisFiyati = new javax.swing.JTextField();
        txtAdet = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblUrunIsmi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stok Düzenle | Stok Otomasyonu ");
        setFocusTraversalPolicyProvider(true);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jButton1.setText("DÜZENLE");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        txtSatisFiyati.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSatisFiyati.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSatisFiyatiKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Ürün Seri No : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Ürün İsmi :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Ürün Model :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Adet :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Alış Fiyatı :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Satış Fiyatı :");

        txtAlisFiyati.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlisFiyatiKeyTyped(evt);
            }
        });

        txtAdet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdetKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(48, 66, 105));

        lblUrunIsmi.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblUrunIsmi.setForeground(new java.awt.Color(255, 255, 255));
        lblUrunIsmi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUrunIsmi.setText("# Ürün Düzenle #");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblUrunIsmi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUrunIsmi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAlisFiyati, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(txtAdet, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUrunModel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUrunIsmi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUrunSeriNo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSatisFiyati))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUrunSeriNo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUrunIsmi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUrunModel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlisFiyati, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSatisFiyati, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
      // ÜRÜN DÜZENLE
        try {
        Baglanti bgln = new Baglanti();
        bgln.baglan();
        Statement stmt = null;
        Connection conn = bgln.conn;
        stmt = conn.createStatement();
        String sorgu = "UPDATE stok SET "+" adi='"+txtUrunIsmi.getText()+"',model='"+txtUrunModel.getText()+"',seri_no='"+txtUrunSeriNo.getText()+"',adet='"+Integer.parseInt(txtAdet.getText())+"',alis_fiyat='"+Float.parseFloat(txtAlisFiyati.getText())+"',satis_fiyat='"+Float.parseFloat(txtSatisFiyati.getText())+"'   "+" WHERE ID='"+urun_id+"' ";
         
        stmt.executeUpdate(sorgu);
        JOptionPane.showMessageDialog(null,"Stok Düzenleme Başarılı..", "Eklendi!",JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
          stk.Listele();
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Hatalı Giriş Lütfen Kontrol Ediniz..","Hata..!",JOptionPane.ERROR_MESSAGE);
            System.err.print(e);
            
        }
    }//GEN-LAST:event_jButton1MouseClicked

 
 
    private void txtSatisFiyatiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSatisFiyatiKeyTyped
                char caracter = evt.getKeyChar();
               
                     if (((caracter < '0') || (caracter > '9')) && (caracter != '.')) {
                  evt.consume();
                    
                }
                
       
    }//GEN-LAST:event_txtSatisFiyatiKeyTyped

    private void txtAlisFiyatiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlisFiyatiKeyTyped
        char caracter = evt.getKeyChar();
               
                     if (((caracter < '0') || (caracter > '9')) && (caracter != '.')) {
                  evt.consume();
                    
                }
    }//GEN-LAST:event_txtAlisFiyatiKeyTyped

    private void txtAdetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdetKeyTyped
         char caracter = evt.getKeyChar();
               
                     if (((caracter < '0') || (caracter > '9'))) {
                  evt.consume();
                    
                }
    }//GEN-LAST:event_txtAdetKeyTyped

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
            java.util.logging.Logger.getLogger(StokDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StokDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StokDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StokDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StokDuzenle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblUrunIsmi;
    private javax.swing.JTextField txtAdet;
    private javax.swing.JTextField txtAlisFiyati;
    private javax.swing.JTextField txtSatisFiyati;
    private javax.swing.JTextField txtUrunIsmi;
    private javax.swing.JTextField txtUrunModel;
    private javax.swing.JTextField txtUrunSeriNo;
    // End of variables declaration//GEN-END:variables
}