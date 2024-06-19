/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import table_model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class PopUpLaporanKeuangan extends javax.swing.JFrame {

    /**
     * Creates new form PopUpLaporanPelanggan
     */
    public PopUpLaporanKeuangan() {
        initComponents();
        populateCombobox();
    }
    
    private void populateCombobox(){
        Connection conn = new koneksi().getConnection();
    
        String sql = "SELECT YEAR(tanggal_jual) FROM penjualan GROUP BY YEAR(tanggal_jual)";
        
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet result = stat.executeQuery();
            while (result.next()) {
                String tahun = result.getString(1);
                cbtahun.addItem(tahun);
            }
            
            conn.close();
            stat.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal ditampilkan, pesan error: "+e);
        }
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
        cetakNota = new custom_palette.RoundedButton();
        jLabel6 = new javax.swing.JLabel();
        cancelButton = new custom_palette.RoundedButton();
        cbtahun = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(242, 241, 235));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cetakNota.setForeground(new java.awt.Color(242, 241, 235));
        cetakNota.setText("Cetak Laporan");
        cetakNota.setColor(new java.awt.Color(136, 171, 142));
        cetakNota.setColorClick(new java.awt.Color(108, 136, 113));
        cetakNota.setColorOver(new java.awt.Color(122, 153, 127));
        cetakNota.setcornerRadius(20);
        cetakNota.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        cetakNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakNotaActionPerformed(evt);
            }
        });
        jPanel1.add(cetakNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 140, 41));

        jLabel6.setFont(new java.awt.Font("Inter", 1, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(175, 200, 173));
        jLabel6.setText("Masukkan Tahun");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 270, 37));

        cancelButton.setForeground(new java.awt.Color(242, 241, 235));
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/material-symbols_batal.png"))); // NOI18N
        cancelButton.setText("Batal");
        cancelButton.setColor(new java.awt.Color(136, 171, 142));
        cancelButton.setColorClick(new java.awt.Color(108, 136, 113));
        cancelButton.setColorOver(new java.awt.Color(122, 153, 127));
        cancelButton.setcornerRadius(15);
        cancelButton.setFont(new java.awt.Font("Inter", 1, 16)); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 120, 40));

        jPanel1.add(cbtahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cetakNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakNotaActionPerformed
        Connection conn = new koneksi().getConnection();

        try {
            String report = "src/report/LaporanKeuangan.jrxml";
            String logo = "src/assets/logo-TeamTwo.png";
            String ttd = "src/assets/ttd-fadhil.jpg";
            Locale locale = new Locale("in", "ID");

            HashMap parameter = new HashMap();
            parameter.put("tahun", cbtahun.getSelectedItem().toString());
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
    }//GEN-LAST:event_cetakNotaActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PopUpLaporanKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopUpLaporanKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopUpLaporanKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopUpLaporanKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopUpLaporanKeuangan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_palette.RoundedButton cancelButton;
    private javax.swing.JComboBox<String> cbtahun;
    private custom_palette.RoundedButton cetakNota;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
