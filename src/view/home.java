/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import chart.ModelChart;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JFrame;
import koneksi.koneksi;
import table_model.supplier;

/**
 *
 * @author Bagus
 */
public class home extends javax.swing.JFrame {
    private DefaultTableModel tabmode;

    /**
     * Creates new form home
     */
    public home() {
        initComponents();
        dataChart();
        incomeTable();
        expenseTable();
        
        incomeTable.fixTable(jScrollPane1);
        expenseTable.fixTable(jScrollPane2);
    }
    
    protected void incomeTable() {
        Connection conn = koneksi.getConnection();
        
        Object[] Baris ={"ID","tanggal", "Nama Barang", "kuantitas", "total harga", "status"};
        tabmode = new DefaultTableModel(null, Baris);
        
        try {
            String sql = "SELECT p.id, p.tanggal_jual, b.nama, p.kuantitas, p.total_harga, p.status FROM penjualan AS p JOIN barang AS b ON b.id = p.id_barang";
            Statement stat = conn.createStatement();
            
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                tabmode.addRow(new Object[]{    
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                });
            }  
            incomeTable.setModel(tabmode);
        
            conn.close();
            stat.close();
            hasil.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal ditampilkan, pesan error: "+e);
            Logger.getLogger(supplier.class.getName()).log(Level.SEVERE, null, e);
        } 
    }
    
    protected void expenseTable() {
        Connection conn = koneksi.getConnection();
        
        Object[] Baris ={"ID","tanggal", "Nama Barang", "kuantitas", "total harga", "status"};
        tabmode = new DefaultTableModel(null, Baris);
        
        try {
            String sql = "SELECT p.id, p.tanggal_beli, b.nama, p.kuantitas, p.total_harga, p.status FROM pembelian AS p JOIN barang AS b ON b.id = p.id_barang";
            Statement stat = conn.createStatement();
            
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                tabmode.addRow(new Object[]{    
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                });
            }  
            expenseTable.setModel(tabmode);
        
            conn.close();
            stat.close();
            hasil.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal ditampilkan, pesan error: "+e);
            Logger.getLogger(supplier.class.getName()).log(Level.SEVERE, null, e);
        } 
    }
    
//    private void dataChart() {
//        Connection conn = new koneksi().getConnection();
//        
//        double[] dataPenjualan = new double[12];
//        double[] dataPembelian = new double[12];
//        
//        try {
//            String sql = "SELECT SUM(total_harga) AS total_penjualan_per_bulan\n" +
//                        "FROM penjualan\n" +
//                        "WHERE YEAR(tanggal_jual) = 2024\n" +
//                        "GROUP BY MONTH(tanggal_jual)\n" +
//                        "ORDER BY MONTH(tanggal_jual);";
//            Statement stat = conn.createStatement();
//            
//            ResultSet hasil = stat.executeQuery(sql);
//            
//            int index = 0;
//            while(hasil.next()){
//                dataPenjualan[index] = hasil.getDouble(1);
//                index++;
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "terjadi error, pesan error: "+e);
//            Logger.getLogger(supplier.class.getName()).log(Level.SEVERE, null, e);
//        }
//        
//        try {
//            String sql = "SELECT SUM(total_harga) AS total_pembelian_per_bulan\n" +
//                        "FROM pembelian\n" +
//                        "WHERE YEAR(tanggal_beli) = 2024\n" +
//                        "GROUP BY MONTH(tanggal_beli)\n" +
//                        "ORDER BY MONTH(tanggal_beli);";
//            Statement stat = conn.createStatement();
//            
//            ResultSet hasil = stat.executeQuery(sql);
//            
//            int index = 0;
//            while(hasil.next()){
//                dataPembelian[index] = hasil.getDouble(1);
//                index++;
//            }
//            
//            conn.close();
//            stat.close();
//            hasil.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "terjadi error, pesan error: "+e);
//            Logger.getLogger(supplier.class.getName()).log(Level.SEVERE, null, e);
//        } 
//        
//        System.out.println(dataPenjualan[0]);
//        System.out.println(dataPembelian[0]);
//        
//        getContentPane().setBackground(new Color(250,250,250));
//        chartBar.addLegend("Penjualan", new Color(136,171,142));
//        chartBar.addLegend("Pembelian", new Color(142,136,171));
//        chartBar.addData(new ModelChart("Januari", new double[]{dataPenjualan[0], dataPembelian[0]}));
//        chartBar.addData(new ModelChart("Februari", new double[]{dataPenjualan[1], dataPembelian[1]}));
//        chartBar.addData(new ModelChart("Maret", new double[]{dataPenjualan[2], dataPembelian[2]}));
//        chartBar.addData(new ModelChart("April", new double[]{dataPenjualan[3], dataPembelian[3]}));
//        chartBar.addData(new ModelChart("Mei", new double[]{dataPenjualan[4], dataPembelian[4]}));
//        chartBar.addData(new ModelChart("Juni", new double[]{dataPenjualan[5], dataPembelian[5]}));
//        chartBar.addData(new ModelChart("Juli", new double[]{dataPenjualan[6], dataPembelian[6]}));
//        chartBar.addData(new ModelChart("Agustus", new double[]{dataPenjualan[7], dataPembelian[7]}));
//        chartBar.addData(new ModelChart("September", new double[]{dataPenjualan[8], dataPembelian[8]}));
//        chartBar.addData(new ModelChart("Oktober", new double[]{dataPenjualan[9], dataPembelian[9]}));
//        chartBar.addData(new ModelChart("November", new double[]{dataPenjualan[10], dataPembelian[10]}));
//        chartBar.addData(new ModelChart("Desember", new double[]{dataPenjualan[11], dataPembelian[11]}));
//    }
    
    private void dataChart() {
        Connection conn = new koneksi().getConnection();
        double[][] data = new double[12][2];

        try {
            String sql = "SELECT MONTH(tanggal_jual) AS bulan, SUM(total_harga) AS total_penjualan_per_bulan " +
                         "FROM penjualan " +
                         "WHERE YEAR(tanggal_jual) = 2024 " +
                         "GROUP BY bulan " +
                         "ORDER BY bulan;";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);

            while(hasil.next()) {
                int bulan = hasil.getInt("bulan");
                double totalPenjualan = hasil.getDouble("total_penjualan_per_bulan");
                data[bulan - 1][0] = totalPenjualan;
            }

            hasil.close();
            stat.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "terjadi error, pesan error: " + e);
            Logger.getLogger(supplier.class.getName()).log(Level.SEVERE, null, e);
        } 

        try {
            String sql = "SELECT MONTH(tanggal_beli) AS bulan, SUM(total_harga) AS total_pembelian_per_bulan " +
                         "FROM pembelian " +
                         "WHERE YEAR(tanggal_beli) = 2024 " +
                         "GROUP BY bulan " +
                         "ORDER BY bulan;";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);

            while(hasil.next()) {
                int bulan = hasil.getInt("bulan");
                double totalPembelian = hasil.getDouble("total_pembelian_per_bulan");
                data[bulan - 1][1] = totalPembelian;
            }

            hasil.close();
            stat.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "terjadi error, pesan error: " + e);
            Logger.getLogger(supplier.class.getName()).log(Level.SEVERE, null, e);
        } 

        chartBar.addLegend("Penjualan", new Color(136,171,142));
        chartBar.addLegend("Pembelian", new Color(142,136,171));
        chartBar.addLegend("Keuntungan", new Color(171,142,136));
        
        for(int i = 0; i < data.length; i++) {
            String namaBulan = new DateFormatSymbols().getMonths()[i];
            chartBar.addData(new ModelChart(namaBulan, new double[]{data[i][0], data[i][1], data[i][0]-data[i][1]}));
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

        jPanel10 = new javax.swing.JPanel();
        chartBar = new chart.ChartBar();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        incomeTable = new custom_palette.CustomTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        expenseTable = new custom_palette.CustomTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        sideHome = new custom_palette.RoundedButton();
        sideBarang = new custom_palette.RoundedButton();
        sideKaryawan = new custom_palette.RoundedButton();
        sidePenjualan = new custom_palette.RoundedButton();
        sidePembelian = new custom_palette.RoundedButton();
        sideSupplier = new custom_palette.RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(242, 241, 235));
        jPanel10.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(1153, 832));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chartBar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel10.add(chartBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 105, 993, 370));

        jLabel7.setFont(new java.awt.Font("Inter", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(136, 171, 142));
        jLabel7.setText("Grafik Laporan Bulanan ");
        jPanel10.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 35, -1, -1));

        jLabel8.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("TimTwo Optik");
        jPanel10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(226, 300));

        incomeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        incomeTable.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(incomeTable);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 530, 300));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(226, 300));

        expenseTable.setModel(new javax.swing.table.DefaultTableModel(
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
        expenseTable.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(expenseTable);

        jPanel10.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 510, 523, 300));

        jLabel9.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(136, 171, 142));
        jLabel9.setText("Penjualan");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 485, -1, -1));

        jLabel10.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(136, 171, 142));
        jLabel10.setText("Pembelian");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 485, -1, -1));

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(136, 171, 142));
        jPanel1.setPreferredSize(new java.awt.Dimension(127, 832));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideHome.setBorder(null);
        sideHome.setForeground(new java.awt.Color(136, 171, 142));
        sideHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-home.png"))); // NOI18N
        sideHome.setColor(new java.awt.Color(190, 184, 174));
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

        sideKaryawan.setBackground(new java.awt.Color(136, 171, 142));
        sideKaryawan.setBorder(null);
        sideKaryawan.setForeground(new java.awt.Color(136, 171, 142));
        sideKaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-user.png"))); // NOI18N
        sideKaryawan.setColor(new java.awt.Color(136, 171, 142));
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

        sideSupplier.setBackground(new java.awt.Color(136, 171, 142));
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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chart.ChartBar chartBar;
    private custom_palette.CustomTable expenseTable;
    private custom_palette.CustomTable incomeTable;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private custom_palette.RoundedButton sideBarang;
    private custom_palette.RoundedButton sideHome;
    private custom_palette.RoundedButton sideKaryawan;
    private custom_palette.RoundedButton sidePembelian;
    private custom_palette.RoundedButton sidePenjualan;
    private custom_palette.RoundedButton sideSupplier;
    // End of variables declaration//GEN-END:variables
}
