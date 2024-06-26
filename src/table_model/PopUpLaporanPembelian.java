/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package table_model;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sabdha
 */
public class PopUpLaporanPembelian extends javax.swing.JFrame {

    /**
     * Creates new form PopUpLaporanPembelian
     */
    public PopUpLaporanPembelian() {
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

        jPanel1 = new javax.swing.JPanel();
        btnBatal = new custom_palette.RoundedButton();
        jLabel3 = new javax.swing.JLabel();
        cbulan = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txttahun = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cetakNota1 = new custom_palette.RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(242, 241, 235));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBatal.setForeground(new java.awt.Color(242, 241, 235));
        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/material-symbols_batal.png"))); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.setColor(new java.awt.Color(136, 171, 142));
        btnBatal.setColorClick(new java.awt.Color(108, 136, 113));
        btnBatal.setColorOver(new java.awt.Color(122, 153, 127));
        btnBatal.setcornerRadius(20);
        btnBatal.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnBatal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel1.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 120, 41));

        jLabel3.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(175, 200, 173));
        jLabel3.setText("Masukkan Tahun");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 130, 37));

        cbulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        jPanel1.add(cbulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 130, -1));

        jLabel4.setFont(new java.awt.Font("Inter", 1, 32)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(175, 200, 173));
        jLabel4.setText("Pilih Bulan dan Tahun");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 390, 37));
        jPanel1.add(txttahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 130, -1));

        jLabel5.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(175, 200, 173));
        jLabel5.setText("Pilih Bulan");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 80, 37));

        cetakNota1.setForeground(new java.awt.Color(242, 241, 235));
        cetakNota1.setText("Cetak Nota");
        cetakNota1.setColor(new java.awt.Color(136, 171, 142));
        cetakNota1.setColorClick(new java.awt.Color(108, 136, 113));
        cetakNota1.setColorOver(new java.awt.Color(122, 153, 127));
        cetakNota1.setcornerRadius(20);
        cetakNota1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        cetakNota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakNota1ActionPerformed(evt);
            }
        });
        jPanel1.add(cetakNota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 120, 41));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
         try {
            // Mengatur look and feel menjadi Nimbus
            UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
            for (UIManager.LookAndFeelInfo look : looks) {
                if ("Nimbus".equals(look.getName())) {
                    UIManager.setLookAndFeel(look.getClassName());
                    break;
                }
            }

            // Buat objek JFrame baru
            JFrame formPembelian = new table_model.pembelian();

            // Tampilkan JFrame baru
            formPembelian.setVisible(true);

            // Tutup jendela saat ini
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnBatalActionPerformed

    private void cetakNota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakNota1ActionPerformed
        // TODO add your handling code here:
        Connection conn = new koneksi().getConnection();
        
        int bulan = cbulan.getSelectedIndex()+1;
        String tahun = txttahun.getText();

        try {
            String logo = "src/assets/logo-TeamTwo.png";
            String ttd = "src/assets/ttd-fadhil.jpg";
            Locale locale = new Locale("in", "ID");
            
            String report = "src/report/LaporanPembelian.jrxml";
            HashMap parameter = new HashMap();
            parameter.put("bulan", bulan);
            parameter.put("tahun", tahun);
            parameter.put("logo", logo);
            parameter.put("ttd", ttd);
            parameter.put(JRParameter.REPORT_LOCALE, locale);
            JasperReport jasperReport = JasperCompileManager.compileReport(report);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal ditampilkan, pesan error: " + e);
            Logger.getLogger(supplier.class.getName()).log(Level.SEVERE, null, e);
        }
        
        this.dispose();
    }//GEN-LAST:event_cetakNota1ActionPerformed

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
            java.util.logging.Logger.getLogger(PopUpLaporanPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopUpLaporanPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopUpLaporanPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopUpLaporanPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopUpLaporanPembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_palette.RoundedButton btnBatal;
    private javax.swing.JComboBox<String> cbulan;
    private custom_palette.RoundedButton cetakNota1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txttahun;
    // End of variables declaration//GEN-END:variables
}
