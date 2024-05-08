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
import koneksi.koneksi;
import table_model.supplier;

/**
 *
 * @author Bagus
 */
public class home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    public home() {
        initComponents();
        dataChart();
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
            chartBar.addData(new ModelChart(namaBulan, new double[]{data[i][0], data[i][1], data[i][1]-data[i][0]}));
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
        jPanel10 = new javax.swing.JPanel();
        chartBar = new chart.ChartBar();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        jScrollPane1.setPreferredSize(new java.awt.Dimension(853, 300));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 490, -1, -1));

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
