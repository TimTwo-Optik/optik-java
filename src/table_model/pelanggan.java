/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package table_model;

import custom_palette.TableActionCellEditor;
import custom_palette.TableActionCellRender;
import custom_palette.TableActionEvent;
import java.awt.Color;
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

/**
 *
 * @author nerve
 */
public class pelanggan extends javax.swing.JFrame {
    
    private DefaultTableModel tabmode;

    /**
     * Creates new form pelanggan
     */
    public pelanggan() {
        initComponents();
        initializeTableActionEvent();
        dataTable();
        kosong();
    }
    
    protected void dataTable() {
        Connection conn = koneksi.getConnection();
        
        Object[] Baris ={"Nama Pelanggan","Kontak","Alamat","Total Pengeluaran", "Status", "Aksi"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariItem = searchBar.getText();
        
        try {
            String sql = "SELECT nama_pelanggan,kontak,alamat,id,status FROM pelanggan WHERE nama_pelanggan LIKE ? OR status LIKE ? OR kontak LIKE ? OR alamat LIKE ? order by id asc";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, "%" + cariItem + "%");
            stat.setString(2, "%" + cariItem + "%");
            stat.setString(3, "%" + cariItem + "%");
            stat.setString(4, "%" + cariItem + "%");
            
            ResultSet hasil = stat.executeQuery();
            while (hasil.next()){
                tabmode.addRow(new Object[]{    
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                });
            }  
            tablepelanggan.setModel(tabmode);
            initializeTableActionEvent();
        
            conn.close();
            stat.close();
            hasil.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal ditampilkan, pesan error: "+e);
            Logger.getLogger(supplier.class.getName()).log(Level.SEVERE, null, e);
        } 
    }
    
    private void kosong() {
        searchBar.setText("");
        searchFilter.setSelectedItem(null);
    }
    
    private void initializeTableActionEvent() {
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onView(int row) {
                System.out.println("View Button row: "+row);
            }
        };
        
        tablepelanggan.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        tablepelanggan.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
        tablepelanggan.setDefaultRenderer(String.class, new TableActionCellRender());
    
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        roundedPanel1 = new custom_palette.RoundedPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        searchBar = new custom_palette.RoundedTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepelanggan = new javax.swing.JTable();
        searchFilter = new javax.swing.JComboBox<>();
        roundedPanel2 = new custom_palette.RoundedPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(136, 171, 142));
        jPanel1.setPreferredSize(new java.awt.Dimension(127, 832));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(136, 171, 142));
        jPanel2.setPreferredSize(new java.awt.Dimension(127, 91));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-home.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 44, -1, -1));

        jPanel3.setBackground(new java.awt.Color(136, 171, 142));
        jPanel3.setPreferredSize(new java.awt.Dimension(127, 91));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-box.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 30, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 173, -1, -1));

        jPanel4.setBackground(new java.awt.Color(136, 171, 142));
        jPanel4.setPreferredSize(new java.awt.Dimension(127, 91));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-chart.png"))); // NOI18N
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 307, -1, -1));

        jPanel5.setBackground(new java.awt.Color(136, 171, 142));
        jPanel5.setPreferredSize(new java.awt.Dimension(127, 91));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-user.png"))); // NOI18N
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 438, -1, -1));

        jPanel6.setBackground(new java.awt.Color(136, 171, 142));
        jPanel6.setPreferredSize(new java.awt.Dimension(127, 91));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-document.png"))); // NOI18N
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 565, -1, -1));

        jPanel7.setBackground(new java.awt.Color(136, 171, 142));
        jPanel7.setPreferredSize(new java.awt.Dimension(127, 91));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-truck.png"))); // NOI18N
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 698, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel8.setBackground(new java.awt.Color(242, 241, 235));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setForeground(new java.awt.Color(8, 10, 16));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-user-2.png"))); // NOI18N
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        jLabel10.setBackground(new java.awt.Color(142, 175, 148));
        jLabel10.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(142, 175, 148));
        jLabel10.setText("Manajemen Pelanggan");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 65, 294, -1));

        jSeparator1.setBackground(new java.awt.Color(136, 171, 142));
        jSeparator1.setForeground(new java.awt.Color(136, 171, 142));
        jSeparator1.setPreferredSize(new java.awt.Dimension(316, 10));
        jPanel8.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 103, -1, -1));

        roundedPanel1.setBackground(new java.awt.Color(175, 200, 173));
        roundedPanel1.setCornerRadius(5);
        roundedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-filter.png"))); // NOI18N
        roundedPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, -1, -1));

        jLabel12.setFont(new java.awt.Font("Inter", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(238, 231, 218));
        jLabel12.setText("Filter");
        roundedPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 8, -1, -1));

        jPanel8.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 146, 116, 44));

        jButton1.setBackground(new java.awt.Color(238, 231, 218));
        jButton1.setFont(new java.awt.Font("Inter", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(125, 125, 125));
        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(631, 152, 94, 31));

        searchBar.setBackground(new java.awt.Color(242, 241, 235));
        searchBar.setCornerRadius(5);
        searchBar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        searchBar.setLineColor(new java.awt.Color(217, 217, 217));
        searchBar.setMargin(new java.awt.Insets(2, 6, 2, 200));
        searchBar.setStrokeWidth(1);
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchBarKeyPressed(evt);
            }
        });
        jPanel8.add(searchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 146, 582, 44));

        jButton3.setBackground(new java.awt.Color(136, 171, 142));
        jButton3.setFont(new java.awt.Font("Inter", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(242, 241, 235));
        jButton3.setText("+ Tambah");
        jButton3.setBorderPainted(false);
        jButton3.setPreferredSize(new java.awt.Dimension(103, 37));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 197, 120, -1));
        jButton3.getAccessibleContext().setAccessibleDescription("");

        jScrollPane1.setBackground(new java.awt.Color(242, 241, 235));
        jScrollPane1.setForeground(new java.awt.Color(242, 241, 235));
        jScrollPane1.setToolTipText("");
        jScrollPane1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        tablepelanggan.getTableHeader().setOpaque(false);
        tablepelanggan.getTableHeader().setBackground(new Color(136, 171, 142));
        tablepelanggan.setBackground(new java.awt.Color(242, 241, 235));
        tablepelanggan.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        tablepelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablepelanggan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tablepelanggan.setRowHeight(60);
        tablepelanggan.setSelectionBackground(new java.awt.Color(136, 171, 142));
        jScrollPane1.setViewportView(tablepelanggan);

        jPanel8.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 371, 1096, 398));

        searchFilter.setBackground(new java.awt.Color(255, 255, 255));
        searchFilter.setForeground(new java.awt.Color(175, 200, 173));
        searchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jenis Supplier", "Frame", "Lensa", "Aksesoris", "Lokasi", "Luar negeri", "Dalam negeri" }));
        searchFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFilterActionPerformed(evt);
            }
        });
        jPanel8.add(searchFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 146, 116, 44));

        roundedPanel2.setBackground(new java.awt.Color(175, 200, 173));
        roundedPanel2.setForeground(new java.awt.Color(175, 200, 173));
        roundedPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-note2.png"))); // NOI18N
        roundedPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 6, -1, -1));

        jLabel14.setFont(new java.awt.Font("Inter", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(238, 231, 218));
        jLabel14.setText("Data Pelanggan");
        roundedPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel8.add(roundedPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 244, 1096, 44));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 0, 1153, 832));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFilterActionPerformed
        Object filter = searchFilter.getSelectedItem();

        if(filter != null) {
            searchBar.setText(filter.toString());
        }
    }//GEN-LAST:event_searchFilterActionPerformed

    private void searchBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dataTable();
        }
    }//GEN-LAST:event_searchBarKeyPressed

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
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private custom_palette.RoundedPanel roundedPanel1;
    private custom_palette.RoundedPanel roundedPanel2;
    private custom_palette.RoundedTextField searchBar;
    private javax.swing.JComboBox<String> searchFilter;
    private javax.swing.JTable tablepelanggan;
    // End of variables declaration//GEN-END:variables
}