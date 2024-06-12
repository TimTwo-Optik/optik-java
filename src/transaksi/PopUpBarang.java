/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package transaksi;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import table_model.supplier;

/**
 *
 * @author Bagus
 */
public class PopUpBarang extends javax.swing.JFrame {
    Connection conn = new koneksi().getConnection();

    private DefaultTableModel tabmode;
    
    public TambahPenjualan tambahPenjualan = null;
    public RincianDataPenjualan rincianDataPenjualan = null;

    /**
     * Creates new form PopUpPelanggan
     */
    public PopUpBarang() {
        initComponents();
        dataTable();
        
        tableBarang.fixTable(jScrollPane1);
    }

    protected void dataTable() {
        Object[] Baris = {"ID", "Nama Barang", "kategori", "harga"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariItem = searchBar.getText();

        try {
            String sql = "SELECT id, nama, kategori, harga FROM barang WHERE stok > 0 AND (id like ? OR nama LIKE ? OR kategori LIKE ?) order by id asc";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, "%" + cariItem + "%");
            stat.setString(2, "%" + cariItem + "%");
            stat.setString(3, "%" + cariItem + "%");
            ResultSet hasil = stat.executeQuery();
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                });
            }
            tableBarang.setModel(tabmode);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal ditampilkan, pesan error: " + e);
            Logger.getLogger(supplier.class.getName()).log(Level.SEVERE, null, e);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBarang = new custom_palette.CustomTable();
        jLabel3 = new javax.swing.JLabel();
        searchButton = new custom_palette.RoundedButton();
        searchBar = new custom_palette.RoundedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(242, 241, 235));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(242, 241, 235));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBarang);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 526, 245));

        jLabel3.setFont(new java.awt.Font("Inter", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(175, 200, 173));
        jLabel3.setText("Data Barang");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 390, 37));

        searchButton.setForeground(new java.awt.Color(125, 125, 125));
        searchButton.setText("Cari");
        searchButton.setColor(new java.awt.Color(238, 231, 218));
        searchButton.setColorClick(new java.awt.Color(190, 184, 174));
        searchButton.setColorOver(new java.awt.Color(214, 207, 196));
        searchButton.setcornerRadius(10);
        searchButton.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 122, 70, 25));

        searchBar.setBackground(new java.awt.Color(242, 241, 235));
        searchBar.setCornerRadius(5);
        searchBar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        searchBar.setLineColor(new java.awt.Color(217, 217, 217));
        searchBar.setMargin(new java.awt.Insets(2, 6, 2, 200));
        searchBar.setStrokeWidth(1);
        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchBarKeyPressed(evt);
            }
        });
        jPanel1.add(searchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 118, 260, 33));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dataTable();
        }
    }//GEN-LAST:event_searchBarKeyPressed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        dataTable();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void tableBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBarangMouseClicked
        int TableBarang = tableBarang.getSelectedRow();
        
        if(rincianDataPenjualan != null) {
            rincianDataPenjualan.IDBarang = tableBarang.getValueAt(TableBarang, 0).toString();
            rincianDataPenjualan.NamaBarang = tableBarang.getValueAt(TableBarang, 1).toString();
            rincianDataPenjualan.KategoriBarang = tableBarang.getValueAt(TableBarang, 2).toString();
            rincianDataPenjualan.HargaBarang = tableBarang.getValueAt(TableBarang, 3).toString();
            rincianDataPenjualan.barangTerpilih();
        } else if(tambahPenjualan != null) {
            tambahPenjualan.IDBarang = tableBarang.getValueAt(TableBarang, 0).toString();
            tambahPenjualan.NamaBarang = tableBarang.getValueAt(TableBarang, 1).toString();
            tambahPenjualan.KategoriBarang = tableBarang.getValueAt(TableBarang, 2).toString();
            tambahPenjualan.HargaBarang = tableBarang.getValueAt(TableBarang, 3).toString();
            tambahPenjualan.barangTerpilih();
        }
        this.dispose();
    }//GEN-LAST:event_tableBarangMouseClicked

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
            java.util.logging.Logger.getLogger(PopUpBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopUpBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopUpBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopUpBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopUpBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private custom_palette.RoundedTextField searchBar;
    private custom_palette.RoundedButton searchButton;
    private custom_palette.CustomTable tableBarang;
    // End of variables declaration//GEN-END:variables
}
