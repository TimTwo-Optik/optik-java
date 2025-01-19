/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import chart.ModelChart;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JFrame;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
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
        populateCombobox();
        dataChart();
        incomeTable();
        expenseTable();
        
        incomeTable.fixTable(jScrollPane1);
        expenseTable.fixTable(jScrollPane2);
        
        chartBar.addLegend("Penjualan", new Color(136,171,142));
        chartBar.addLegend("Pembelian", new Color(142,136,171));
        chartBar.addLegend("Keuntungan", new Color(171,142,136));
    }
    
    protected void incomeTable() {
        Connection conn = koneksi.getConnection();
        
        Object[] Baris ={"ID", "tanggal", "Nama Barang", "kuantitas", "total harga", "status"};
        tabmode = new DefaultTableModel(null, Baris);
        
        try {
            String sql = "SELECT p.id, p.tanggal_jual, b.nama, dp.kuantitas, dp.total_harga, p.status "+
                    "FROM detail_penjualan AS dp JOIN barang AS b ON dp.id_barang = b.id " +
                    "JOIN penjualan AS p ON dp.id_penjualan = p.id";
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
    
    private void dataChart() {
        Connection conn = new koneksi().getConnection();
        double[][] data = new double[12][2];

        try {
            String currentYear = cbtahun.getSelectedItem().toString();
            
            String sql = "SELECT MONTH(p.tanggal_jual) AS bulan, SUM(dp.total_harga) AS total_penjualan_per_bulan " +
                         "FROM penjualan AS P " +
                         "JOIN detail_penjualan AS dp ON p.id = dp.id_penjualan " +
                         "WHERE YEAR(tanggal_jual) = " + currentYear + " " +
                         "GROUP BY bulan " +
                         "ORDER BY bulan";
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
            String currentYear = cbtahun.getSelectedItem().toString();
            
            String sql = "SELECT MONTH(tanggal_beli) AS bulan, SUM(total_harga) AS total_pembelian_per_bulan " +
                         "FROM pembelian " +
                         "WHERE YEAR(tanggal_beli) = " + currentYear + " " +
                         "GROUP BY bulan " +
                         "ORDER BY bulan";
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
        
        chartBar.start();
        
        for(int i = 0; i < data.length; i++) {
            String namaBulan = new DateFormatSymbols().getMonths()[i];
            chartBar.addData(new ModelChart(namaBulan, new double[]{data[i][0], data[i][1], data[i][0]-data[i][1]}));
        }
    }
    
    private void populateCombobox(){
        Connection conn = new koneksi().getConnection();
    
        String sql = "SELECT YEAR(tanggal_jual) FROM penjualan GROUP BY YEAR(tanggal_jual) ORDER BY YEAR(tanggal_jual) DESC";
        
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

        cetak = new custom_palette.RoundedButton();
        jPanel1 = new javax.swing.JPanel();
        sideHome = new custom_palette.RoundedButton();
        sideBarang = new custom_palette.RoundedButton();
        sideKaryawan = new custom_palette.RoundedButton();
        sidePenjualan = new custom_palette.RoundedButton();
        sidePembelian = new custom_palette.RoundedButton();
        sideSupplier = new custom_palette.RoundedButton();
        jScrollPane3 = new javax.swing.JScrollPane();
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
        jLabel11 = new javax.swing.JLabel();
        cbtahun = new javax.swing.JComboBox<>();
        cetak1 = new custom_palette.RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cetak.setForeground(new java.awt.Color(242, 241, 235));
        cetak.setText("Cetak");
        cetak.setColor(new java.awt.Color(136, 171, 142));
        cetak.setColorClick(new java.awt.Color(108, 136, 113));
        cetak.setColorOver(new java.awt.Color(122, 153, 127));
        cetak.setcornerRadius(20);
        cetak.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        getContentPane().add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 75, 90, 41));

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

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(1153, 832));

        jPanel10.setBackground(new java.awt.Color(242, 241, 235));
        jPanel10.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jPanel10.setMinimumSize(new java.awt.Dimension(1123, 1191));
        jPanel10.setPreferredSize(new java.awt.Dimension(1153, 1250));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chartBar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chartBar.setPreferredSize(new java.awt.Dimension(558, 320));
        jPanel10.add(chartBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 136, 970, 370));

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

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 566, 965, 277));

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

        jPanel10.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 907, 965, 277));

        jLabel9.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(136, 171, 142));
        jLabel9.setText("Penjualan");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 533, -1, -1));

        jLabel10.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(136, 171, 142));
        jLabel10.setText("Pembelian");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 875, -1, -1));

        jLabel11.setFont(new java.awt.Font("Inter", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(136, 171, 142));
        jLabel11.setText("Tahun");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        cbtahun.setBackground(new java.awt.Color(248, 248, 248));
        cbtahun.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        cbtahun.setPreferredSize(new java.awt.Dimension(90, 22));
        jPanel10.add(cbtahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 102, -1, -1));

        cetak1.setForeground(new java.awt.Color(242, 241, 235));
        cetak1.setText("Pilih");
        cetak1.setColor(new java.awt.Color(136, 171, 142));
        cetak1.setColorClick(new java.awt.Color(108, 136, 113));
        cetak1.setColorOver(new java.awt.Color(122, 153, 127));
        cetak1.setcornerRadius(20);
        cetak1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        cetak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetak1ActionPerformed(evt);
            }
        });
        jPanel10.add(cetak1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 93, 80, 38));

        jScrollPane3.setViewportView(jPanel10);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 0, -1, -1));

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
            JFrame formPenjualan = new table_model.penjualan();

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

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        try {
            JFrame popUpLaporanKeuangan = new view.PopUpLaporanKeuangan();
            popUpLaporanKeuangan.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cetakActionPerformed

    private void cetak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetak1ActionPerformed
        chartBar.clear();
        dataChart();
    }//GEN-LAST:event_cetak1ActionPerformed

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
    private javax.swing.JComboBox<String> cbtahun;
    private custom_palette.RoundedButton cetak;
    private custom_palette.RoundedButton cetak1;
    private chart.ChartBar chartBar;
    private custom_palette.CustomTable expenseTable;
    private custom_palette.CustomTable incomeTable;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private custom_palette.RoundedButton sideBarang;
    private custom_palette.RoundedButton sideHome;
    private custom_palette.RoundedButton sideKaryawan;
    private custom_palette.RoundedButton sidePembelian;
    private custom_palette.RoundedButton sidePenjualan;
    private custom_palette.RoundedButton sideSupplier;
    // End of variables declaration//GEN-END:variables
}
