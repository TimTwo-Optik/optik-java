/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

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
import javax.swing.JFrame;
import javax.swing.UIManager;
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
       String sql = "SELECT p.nama_pelanggan, p.kontak, p.alamat, SUM(j.total_harga) AS total_harga, j.status " +
                "FROM pelanggan p " +
                "JOIN penjualan j ON p.id = j.id_pelanggan " +
                "WHERE p.nama_pelanggan LIKE ? " +
                "GROUP BY p.nama_pelanggan, p.kontak, p.alamat, j.status " +
                "ORDER BY p.nama_pelanggan ASC";

            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, "%" + cariItem + "%");
            
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
            Logger.getLogger(pelanggan.class.getName()).log(Level.SEVERE, null, e);
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

        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        roundedPanel1 = new custom_palette.RoundedPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bcari = new javax.swing.JButton();
        searchBar = new custom_palette.RoundedTextField();
        searchFilter = new javax.swing.JComboBox<>();
        roundedPanel2 = new custom_palette.RoundedPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepelanggan = new custom_palette.CustomTable();
        addDataButton = new custom_palette.RoundedButton();
        jPanel1 = new javax.swing.JPanel();
        sideHome = new custom_palette.RoundedButton();
        sideBarang = new custom_palette.RoundedButton();
        sideKaryawan = new custom_palette.RoundedButton();
        sidePenjualan = new custom_palette.RoundedButton();
        sidePembelian = new custom_palette.RoundedButton();
        sideSupplier = new custom_palette.RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        bcari.setBackground(new java.awt.Color(238, 231, 218));
        bcari.setFont(new java.awt.Font("Inter", 1, 20)); // NOI18N
        bcari.setForeground(new java.awt.Color(125, 125, 125));
        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });
        jPanel8.add(bcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(631, 152, 94, 31));

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

        searchFilter.setForeground(new java.awt.Color(175, 200, 173));
        searchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A-Z", "Z-A", "Total Transaksi", "Tertinggi", "Terendah" }));
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

        jScrollPane1.setBackground(new java.awt.Color(242, 241, 235));

        tablepelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablepelanggan.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        tablepelanggan.setSelectionBackground(new java.awt.Color(160, 190, 158));
        jScrollPane1.setViewportView(tablepelanggan);

        jPanel8.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 1090, 402));

        addDataButton.setForeground(new java.awt.Color(242, 241, 235));
        addDataButton.setText("+ Tambah");
        addDataButton.setColor(new java.awt.Color(136, 171, 142));
        addDataButton.setColorClick(new java.awt.Color(108, 136, 113));
        addDataButton.setColorOver(new java.awt.Color(122, 153, 127));
        addDataButton.setcornerRadius(20);
        addDataButton.setFont(new java.awt.Font("Inter", 1, 16)); // NOI18N
        addDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDataButtonActionPerformed(evt);
            }
        });
        jPanel8.add(addDataButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 195, 120, 41));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 0, 1153, 832));

        jPanel1.setBackground(new java.awt.Color(136, 171, 142));
        jPanel1.setPreferredSize(new java.awt.Dimension(127, 832));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideHome.setBackground(new java.awt.Color(136, 171, 142));
        sideHome.setBorder(null);
        sideHome.setForeground(new java.awt.Color(136, 171, 142));
        sideHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-home.png"))); // NOI18N
        sideHome.setColor(new java.awt.Color(136, 171, 142));
        sideHome.setColorClick(new java.awt.Color(190, 184, 174));
        sideHome.setColorOver(new java.awt.Color(190, 184, 174));
        sideHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sideHomeActionPerformed(evt);
            }
        });
        jPanel1.add(sideHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 44, 130, 90));

        sideBarang.setBackground(new java.awt.Color(136, 171, 142));
        sideBarang.setBorder(null);
        sideBarang.setForeground(new java.awt.Color(136, 171, 142));
        sideBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-box.png"))); // NOI18N
        sideBarang.setColor(new java.awt.Color(136, 171, 142));
        sideBarang.setColorClick(new java.awt.Color(190, 184, 174));
        sideBarang.setColorOver(new java.awt.Color(190, 184, 174));
        sideBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sideBarangActionPerformed(evt);
            }
        });
        jPanel1.add(sideBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 173, 130, 90));

        sideKaryawan.setBorder(null);
        sideKaryawan.setForeground(new java.awt.Color(136, 171, 142));
        sideKaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-user.png"))); // NOI18N
        sideKaryawan.setColor(new java.awt.Color(190, 184, 174));
        sideKaryawan.setColorClick(new java.awt.Color(190, 184, 174));
        sideKaryawan.setColorOver(new java.awt.Color(190, 184, 174));
        sideKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sideKaryawanActionPerformed(evt);
            }
        });
        jPanel1.add(sideKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 307, 130, 90));

        sidePenjualan.setBorder(null);
        sidePenjualan.setForeground(new java.awt.Color(136, 171, 142));
        sidePenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-chart.png"))); // NOI18N
        sidePenjualan.setColor(new java.awt.Color(136, 171, 142));
        sidePenjualan.setColorClick(new java.awt.Color(190, 184, 174));
        sidePenjualan.setColorOver(new java.awt.Color(190, 184, 174));
        sidePenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidePenjualanActionPerformed(evt);
            }
        });
        jPanel1.add(sidePenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 438, 130, 90));

        sidePembelian.setBackground(new java.awt.Color(136, 171, 142));
        sidePembelian.setForeground(new java.awt.Color(136, 171, 142));
        sidePembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/uang.png"))); // NOI18N
        sidePembelian.setColor(new java.awt.Color(136, 171, 142));
        sidePembelian.setColorClick(new java.awt.Color(190, 184, 174));
        sidePembelian.setColorOver(new java.awt.Color(190, 184, 174));
        sidePembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidePembelianActionPerformed(evt);
            }
        });
        jPanel1.add(sidePembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 565, 130, 90));

        sideSupplier.setForeground(new java.awt.Color(136, 171, 142));
        sideSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-truck.png"))); // NOI18N
        sideSupplier.setColor(new java.awt.Color(136, 171, 142));
        sideSupplier.setColorClick(new java.awt.Color(190, 184, 174));
        sideSupplier.setColorOver(new java.awt.Color(190, 184, 174));
        sideSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sideSupplierActionPerformed(evt);
            }
        });
        jPanel1.add(sideSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 698, 130, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed

        dataTable();
    }//GEN-LAST:event_bcariActionPerformed

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

    private void addDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataButtonActionPerformed
        try {
            // Buat objek JFrame baru
            JFrame formTambahPelanggan = new form.TambahPelanggan();

            // Tampilkan JFrame baru
            formTambahPelanggan.setVisible(true);

            // Tutup jendela saat ini
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addDataButtonActionPerformed

    private void sideHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sideHomeActionPerformed
        // TODO add your handling code here:
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
            JFrame formHome = new view.home();

            // Tampilkan JFrame baru
            formHome.setVisible(true);

            // Tutup jendela saat ini
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_sideHomeActionPerformed

    private void sideBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sideBarangActionPerformed
        // TODO add your handling code here:
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
            JFrame formBarang = new table_model.barang();

            // Tampilkan JFrame baru
            formBarang.setVisible(true);

            // Tutup jendela saat ini
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_sideBarangActionPerformed

    private void sideKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sideKaryawanActionPerformed
        // TODO add your handling code here:
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
            JFrame formKaryawan = new view.ManajemenPelangganKaryawan();

            // Tampilkan JFrame baru
            formKaryawan.setVisible(true);

            // Tutup jendela saat ini
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_sideKaryawanActionPerformed

    private void sidePenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidePenjualanActionPerformed
        // TODO add your handling code here:
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
            JFrame formPenjualan = new view.ManajemenPenjualanPembelian();

            // Tampilkan JFrame baru
            formPenjualan.setVisible(true);

            // Tutup jendela saat ini
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_sidePenjualanActionPerformed

    private void sidePembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidePembelianActionPerformed
        // TODO add your handling code here:
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
            JFrame formPembelian = new  table_model.pembelian();

            // Tampilkan JFrame baru
            formPembelian.setVisible(true);

            // Tutup jendela saat ini
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_sidePembelianActionPerformed

    private void sideSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sideSupplierActionPerformed
        // TODO add your handling code here:
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
            JFrame formSupplier = new table_model.supplier();

            // Tampilkan JFrame baru
            formSupplier.setVisible(true);

            // Tutup jendela saat ini
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_sideSupplierActionPerformed

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
    private custom_palette.RoundedButton addDataButton;
    private javax.swing.JButton bcari;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private custom_palette.RoundedPanel roundedPanel1;
    private custom_palette.RoundedPanel roundedPanel2;
    private custom_palette.RoundedTextField searchBar;
    private javax.swing.JComboBox<String> searchFilter;
    private custom_palette.RoundedButton sideBarang;
    private custom_palette.RoundedButton sideHome;
    private custom_palette.RoundedButton sideKaryawan;
    private custom_palette.RoundedButton sidePembelian;
    private custom_palette.RoundedButton sidePenjualan;
    private custom_palette.RoundedButton sideSupplier;
    private custom_palette.CustomTable tablepelanggan;
    // End of variables declaration//GEN-END:variables
}
