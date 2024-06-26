/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import java.awt.Toolkit;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import koneksi.koneksi;

/**
 *
 * @author Bagus
 */
public class RincianDataKaryawan extends javax.swing.JFrame {
    
    private int id;
    /**
     * Creates new form UbahKaryawan
     */
    public RincianDataKaryawan() {
        initComponents();
    }
    
    public void setData(int id, String[] values) {
        this.id = id;
        
        nama.setText(values[0]);
        kontak.setText(values[1]);
        alamat.setText(values[2]);
        email.setText(values[3]);
        inputStatus.setSelectedItem(values[4]);
   
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        
        try {
            date = sdf.parse(values[5]);
            waktu_bergabung.setDate(date);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(RincianDataKaryawan.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        roundedPanel1 = new custom_palette.RoundedPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nama = new custom_palette.RoundedTextField();
        kontak = new custom_palette.RoundedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        email = new custom_palette.RoundedTextField();
        waktu_bergabung = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        inputStatus = new javax.swing.JComboBox<>();
        editButton = new custom_palette.RoundedButton();
        removeButton = new custom_palette.RoundedButton();
        cancelButton = new custom_palette.RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(242, 241, 235));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-employee.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 45, -1, -1));

        jLabel2.setFont(new java.awt.Font("Inter", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(142, 175, 148));
        jLabel2.setText("Manajemen Data Karyawan");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 47, 290, 40));

        roundedPanel1.setBackground(new java.awt.Color(136, 171, 142));
        roundedPanel1.setForeground(new java.awt.Color(136, 171, 142));
        roundedPanel1.setCornerRadius(30);
        roundedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Inter", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 231, 218));
        jLabel3.setText("Rincian Data Karyawan");
        roundedPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 38, 420, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-employee2.png"))); // NOI18N
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
        roundedPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 240, 100, -1));

        jLabel8.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(238, 231, 218));
        jLabel8.setText("Email");
        roundedPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 352, 90, -1));

        jLabel9.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(238, 231, 218));
        jLabel9.setText("Waktu bergabung");
        roundedPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 426, 160, 20));

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

        roundedPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, 232, -1));

        email.setBackground(new java.awt.Color(238, 231, 218));
        email.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        email.setLineColor(new java.awt.Color(238, 231, 218));
        roundedPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 352, 232, -1));

        waktu_bergabung.setBackground(new java.awt.Color(238, 231, 218));
        waktu_bergabung.setDateFormatString("yyyy-MM-dd");
        waktu_bergabung.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        waktu_bergabung.setOpaque(false);
        waktu_bergabung.setPreferredSize(new java.awt.Dimension(232, 22));
        roundedPanel1.add(waktu_bergabung, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 426, -1, -1));

        jLabel10.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(238, 231, 218));
        jLabel10.setText("Status");
        roundedPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 389, -1, -1));

        inputStatus.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        inputStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Tidak Aktif" }));
        inputStatus.setPreferredSize(new java.awt.Dimension(118, 22));
        roundedPanel1.add(inputStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 389, -1, -1));

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-write.png"))); // NOI18N
        editButton.setColor(new java.awt.Color(247, 147, 39));
        editButton.setColorClick(new java.awt.Color(197, 117, 31));
        editButton.setColorOver(new java.awt.Color(222, 132, 35));
        editButton.setcornerRadius(15);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        roundedPanel1.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 488, 83, 41));

        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-trash.png"))); // NOI18N
        removeButton.setColor(new java.awt.Color(255, 75, 75));
        removeButton.setColorClick(new java.awt.Color(204, 60, 60));
        removeButton.setColorOver(new java.awt.Color(229, 67, 67));
        removeButton.setcornerRadius(15);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        roundedPanel1.add(removeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 488, 83, 41));

        jPanel1.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 118, 1006, 583));

        cancelButton.setForeground(new java.awt.Color(238, 231, 218));
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/material-symbols_batal.png"))); // NOI18N
        cancelButton.setText("Batal");
        cancelButton.setColor(new java.awt.Color(136, 171, 142));
        cancelButton.setColorClick(new java.awt.Color(108, 136, 113));
        cancelButton.setColorOver(new java.awt.Color(122, 153, 127));
        cancelButton.setcornerRadius(20);
        cancelButton.setFont(new java.awt.Font("Inter", 1, 16)); // NOI18N
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

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        Connection conn = new koneksi().getConnection();
         
        String status = "";
        int statusInt = inputStatus.getSelectedIndex();
        
        if(statusInt == 0) {
            status = "1";
        } else {
            status = "0";
        }

        try {
            String sql = "update karyawan set nama=?,kontak=?,alamat=?,email=?,status=?,waktu_bergabung=? where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama.getText());
            stat.setString(2, kontak.getText());
            stat.setString(3, alamat.getText());
            stat.setString(4, email.getText());
            stat.setString(5, status);
            stat.setDate(6, new java.sql.Date(waktu_bergabung.getDate().getTime()));
            stat.setInt(7, id);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");

            conn.close();
            stat.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal diubah, pesan error: " + e);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        Connection conn = new koneksi().getConnection();

        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data karyawan ini?", "Hapus Data Karyawan", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from karyawan where id = ?";

            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setInt(1, id);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
               
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus, pesan error: " + e);
            }
            
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
                JFrame formSupplier = new table_model.karyawan();

                // Tampilkan JFrame baru
                formSupplier.setVisible(true);

                // Tutup jendela saat ini
                this.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed

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
            JFrame formSupplier = new table_model.karyawan();

            // Tampilkan JFrame baru
            formSupplier.setVisible(true);

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
//            java.util.logging.Logger.getLogger(UbahKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UbahKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UbahKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UbahKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RincianDataKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private custom_palette.RoundedButton cancelButton;
    private custom_palette.RoundedButton editButton;
    private custom_palette.RoundedTextField email;
    private javax.swing.JComboBox<String> inputStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private custom_palette.RoundedTextField kontak;
    private custom_palette.RoundedTextField nama;
    private custom_palette.RoundedButton removeButton;
    private custom_palette.RoundedPanel roundedPanel1;
    private com.toedter.calendar.JDateChooser waktu_bergabung;
    // End of variables declaration//GEN-END:variables
}
