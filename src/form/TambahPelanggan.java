/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import koneksi.koneksi;

/**
 *
 * @author Bagus
 */
public class TambahPelanggan extends javax.swing.JFrame {
    
    /**
     * Creates new form TambahKaryawan
     */
    public TambahPelanggan() {
        initComponents();
        kosong();
    } 
    
    protected void kosong() {
        nama.setText("");
        kontak.setText("");
        alamat.setText("");

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        roundedPanel1 = new custom_palette.RoundedPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nama = new custom_palette.RoundedTextField();
        kontak = new custom_palette.RoundedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        addDataButton = new custom_palette.RoundedButton();
        cancelButton = new custom_palette.RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(242, 241, 235));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-user-2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 45, -1, -1));

        jLabel2.setFont(new java.awt.Font("Inter", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(142, 175, 148));
        jLabel2.setText("Manajemen Data Pelanggan");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 47, 290, 40));

        roundedPanel1.setBackground(new java.awt.Color(136, 171, 142));
        roundedPanel1.setForeground(new java.awt.Color(136, 171, 142));
        roundedPanel1.setCornerRadius(30);
        roundedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Inter", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 231, 218));
        jLabel3.setText("Tambah Data Pelanggan");
        roundedPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 38, 420, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-pelanggan-image.png"))); // NOI18N
        roundedPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 148, -1, -1));

        jLabel5.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(238, 231, 218));
        jLabel5.setText("Nama");
        roundedPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 163, 90, -1));

        jLabel6.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(238, 231, 218));
        jLabel6.setText("Kontak");
        roundedPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 203, 100, -1));

        jLabel7.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(238, 231, 218));
        jLabel7.setText("Alamat");
        roundedPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 100, -1));

        nama.setBackground(new java.awt.Color(238, 231, 218));
        nama.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        nama.setLineColor(new java.awt.Color(238, 231, 218));
        roundedPanel1.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 163, 232, -1));

        kontak.setBackground(new java.awt.Color(238, 231, 218));
        kontak.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        kontak.setLineColor(new java.awt.Color(238, 231, 218));
        kontak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontakActionPerformed(evt);
            }
        });
        roundedPanel1.add(kontak, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 203, 232, -1));

        alamat.setBackground(new java.awt.Color(238, 231, 218));
        alamat.setColumns(20);
        alamat.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        alamat.setRows(5);
        alamat.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(alamat);

        roundedPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 260, 232, -1));

        addDataButton.setForeground(new java.awt.Color(136, 171, 142));
        addDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/material-symbols_tambah.png"))); // NOI18N
        addDataButton.setText("Tambah");
        addDataButton.setColor(new java.awt.Color(238, 231, 218));
        addDataButton.setColorClick(new java.awt.Color(190, 184, 174));
        addDataButton.setColorOver(new java.awt.Color(214, 207, 196));
        addDataButton.setcornerRadius(15);
        addDataButton.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        addDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDataButtonActionPerformed(evt);
            }
        });
        roundedPanel1.add(addDataButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 508, 125, 43));

        jPanel1.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 118, 1006, 583));

        cancelButton.setForeground(new java.awt.Color(238, 231, 218));
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/material-symbols_batal.png"))); // NOI18N
        cancelButton.setText("Batal");
        cancelButton.setColor(new java.awt.Color(136, 171, 142));
        cancelButton.setColorClick(new java.awt.Color(108, 136, 113));
        cancelButton.setColorOver(new java.awt.Color(122, 153, 127));
        cancelButton.setcornerRadius(15);
        cancelButton.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1118, 744, 130, 49));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 832));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kontakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kontakActionPerformed

    private void addDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataButtonActionPerformed
        Connection conn = new koneksi().getConnection();
        
        String sql = "insert into pelanggan(nama_pelanggan, kontak, alamat) values (?,?,?)";
        
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama.getText());
            stat.setString(2, kontak.getText());
            stat.setString(3, alamat.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosong();
            nama.requestFocus();
            
            conn.close();
            stat.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal disimpan, pesan error: "+e);
        }
    }//GEN-LAST:event_addDataButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
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
            JFrame formPelanggan = new table_model.pelanggan();

            // Tampilkan JFrame baru
            formPelanggan.setVisible(true);

            // Tutup jendela saat ini
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException ignored) {
            Toolkit.getDefaultToolkit().beep();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
            return;
        }
        
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TambahKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TambahKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TambahKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TambahKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahPelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_palette.RoundedButton addDataButton;
    private javax.swing.JTextArea alamat;
    private custom_palette.RoundedButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private custom_palette.RoundedTextField kontak;
    private custom_palette.RoundedTextField nama;
    private custom_palette.RoundedPanel roundedPanel1;
    // End of variables declaration//GEN-END:variables
}
