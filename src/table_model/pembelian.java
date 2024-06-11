/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package table_model;

import custom_palette.ComboBoxListCellRender;
import custom_palette.TableActionCellEditor;
import custom_palette.TableActionCellRender;
import custom_palette.TableActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.UIManager;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import transaksi.RincianDataPembelian;

/**
 *
 * @author nerve
 */
public class pembelian extends javax.swing.JFrame {

    private DefaultTableModel tabmode;

    /**
     * Creates new form penjualan
     */
    public pembelian() {
        initComponents();
        initializeTableActionEvent();
        initializeComboBox();
        dataTable();
        kosong();

        tablepembelian.fixTable(jScrollPane1);
    }

    private void initializeComboBox() {
        ArrayList<Integer> targetIndices = new ArrayList<>();
        targetIndices.add(0);
        targetIndices.add(4);
        targetIndices.add(7);

        searchFilter.setRenderer(new ComboBoxListCellRender(targetIndices));
    }

    protected void dataTable() {
        Connection conn = koneksi.getConnection();

        Object[] Baris = {"No Faktur", "Tanggal Beli", "Nama Supplier", "Nama Barang", "Kuantitas", "Total Harga", "Status", "Aksi"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariItem = searchBar.getText();

        try {
            String sql = "SELECT pbl.id AS 'No Faktur', pbl.tanggal_beli AS 'Tanggal Beli', sup.nama_supplier AS 'Nama Supplier', "
                    + "brg.nama AS 'Nama Barang', pbl.kuantitas AS 'Kuantitas', pbl.total_harga AS 'Total Harga', pbl.status AS 'Status' "
                    + "FROM pembelian AS pbl "
                    + "JOIN suppliers AS sup ON pbl.id_supplier = sup.id "
                    + "JOIN barang AS brg ON pbl.id_barang = brg.id "
                    + "WHERE pbl.id LIKE ? OR brg.nama LIKE ? "
                    + "ORDER BY pbl.id ASC";

            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, "%" + cariItem + "%");
            stat.setString(2, "%" + cariItem + "%");

            ResultSet hasil = stat.executeQuery();
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                    hasil.getString(7),
                });
            }
            tablepembelian.setModel(tabmode);
            initializeTableActionEvent();

            conn.close();
            stat.close();
            hasil.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal ditampilkan, pesan error: " + e);
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
                System.out.println("View Button row: " + row);
                sendData(row);
            }
        };

        tablepembelian.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
        tablepembelian.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
        tablepembelian.setDefaultRenderer(String.class, new TableActionCellRender());

    }
    
    private void sendData(int row) {
        int id = Integer.parseInt(tabmode.getValueAt(row, 0).toString());
        
        try {
            // Mengatur look and feel kembali ke default
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            // Buat objek JFrame baru
            RincianDataPembelian formRincianPembelian = new transaksi.RincianDataPembelian();
            
            formRincianPembelian.setData(id);

            // Tampilkan JFrame baru
            formRincianPembelian.setVisible(true);

            // Tutup jendela saat ini
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
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

        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        roundedPanel1 = new custom_palette.RoundedPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        searchButton = new custom_palette.RoundedButton();
        searchBar = new custom_palette.RoundedTextField();
        searchFilter = new javax.swing.JComboBox<>();
        roundedPanel2 = new custom_palette.RoundedPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepembelian = new custom_palette.CustomTable();
        addDataButton = new custom_palette.RoundedButton();
        cetakNota = new custom_palette.RoundedButton();
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
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-pembelian2.png"))); // NOI18N
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 49, -1, -1));

        jLabel10.setBackground(new java.awt.Color(142, 175, 148));
        jLabel10.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(142, 175, 148));
        jLabel10.setText("Manajemen Pembelian");
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

        searchButton.setForeground(new java.awt.Color(125, 125, 125));
        searchButton.setText("Cari");
        searchButton.setColor(new java.awt.Color(238, 231, 218));
        searchButton.setColorClick(new java.awt.Color(190, 184, 174));
        searchButton.setColorOver(new java.awt.Color(214, 207, 196));
        searchButton.setcornerRadius(20);
        searchButton.setFont(new java.awt.Font("Inter", 1, 20)); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel8.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(631, 150, 94, 35));

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

        searchFilter.setBackground(new java.awt.Color(238, 231, 218));
        searchFilter.setFont(new java.awt.Font("Inter", 0, 15)); // NOI18N
        searchFilter.setForeground(new java.awt.Color(175, 200, 173));
        searchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rentang Waktu", "Hari ini", "Minggu ini", "Bulan ini", "Status Bayar", "Lunas", "Belum Lunas", "Transaksi", "Tertinggi", "Terendah" }));
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
        jLabel14.setText("Data Pembelian");
        roundedPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel8.add(roundedPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 244, 1096, 44));

        jScrollPane1.setBackground(new java.awt.Color(242, 241, 235));
        jScrollPane1.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N

        tablepembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablepembelian.setSelectionBackground(new java.awt.Color(160, 190, 158));
        jScrollPane1.setViewportView(tablepembelian);

        jPanel8.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 371, 1096, 398));

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

        cetakNota.setForeground(new java.awt.Color(242, 241, 235));
        cetakNota.setText("Cetak Nota");
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
        jPanel8.add(cetakNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 195, 120, 41));

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

        sidePenjualan.setBackground(new java.awt.Color(136, 171, 142));
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

        sidePembelian.setBackground(new java.awt.Color(190, 184, 174));
        sidePembelian.setForeground(new java.awt.Color(136, 171, 142));
        sidePembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/uang.png"))); // NOI18N
        sidePembelian.setColor(new java.awt.Color(190, 184, 174));
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

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dataTable();
        }
    }//GEN-LAST:event_searchBarKeyPressed

    private void searchFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFilterActionPerformed
        if (searchFilter.getSelectedItem() != null) {
            int filter = searchFilter.getSelectedIndex();
            String sql = "";

            switch (filter) {
                case 1:
                    sql = "SELECT pbl.id AS 'No Faktur', pbl.tanggal_beli AS 'Tanggal Beli', sup.nama_supplier AS 'Nama Supplier', "
                            + "brg.nama AS 'Nama Barang', pbl.kuantitas AS 'Kuantitas', pbl.total_harga AS 'Total Harga', pbl.status AS 'Status' "
                            + "FROM pembelian AS pbl "
                            + "JOIN suppliers AS sup ON pbl.id_supplier = sup.id "
                            + "JOIN barang AS brg ON pbl.id_barang = brg.id "
                            + "WHERE DATE(pbl.tanggal_beli) = CURDATE() "
                            + "ORDER BY pbl.id ASC";
                    break;
                case 2:
                    sql = "SELECT pbl.id AS 'No Faktur', pbl.tanggal_beli AS 'Tanggal Beli', sup.nama_supplier AS 'Nama Supplier', "
                            + "brg.nama AS 'Nama Barang', pbl.kuantitas AS 'Kuantitas', pbl.total_harga AS 'Total Harga', pbl.status AS 'Status' "
                            + "FROM pembelian AS pbl "
                            + "JOIN suppliers AS sup ON pbl.id_supplier = sup.id "
                            + "JOIN barang AS brg ON pbl.id_barang = brg.id "
                            + "WHERE pbl.tanggal_beli BETWEEN DATE_SUB(CURDATE(), INTERVAL 7 DAY) AND CURDATE() "
                            + "ORDER BY pbl.id ASC";
                    break;
                case 3:
                    LocalDate currentDate = LocalDate.now();
                    int currentMonth = currentDate.getMonthValue();
                    int currentYear = currentDate.getYear();

                    sql = "SELECT pbl.id AS 'No Faktur', pbl.tanggal_beli AS 'Tanggal Beli', sup.nama_supplier AS 'Nama Supplier', "
                            + "brg.nama AS 'Nama Barang', pbl.kuantitas AS 'Kuantitas', pbl.total_harga AS 'Total Harga', pbl.status AS 'Status' "
                            + "FROM pembelian AS pbl "
                            + "JOIN suppliers AS sup ON pbl.id_supplier = sup.id "
                            + "JOIN barang AS brg ON pbl.id_barang = brg.id "
                            + "WHERE MONTH(pbl.tanggal_beli) = " + currentMonth + " AND YEAR(pbl.tanggal_beli) = " + currentYear + " "
                            + "ORDER BY pbl.id ASC";
                    break;
                case 5:
                    sql = "SELECT pbl.id AS 'No Faktur', pbl.tanggal_beli AS 'Tanggal Beli', sup.nama_supplier AS 'Nama Supplier', "
                            + "brg.nama AS 'Nama Barang', pbl.kuantitas AS 'Kuantitas', pbl.total_harga AS 'Total Harga', pbl.status AS 'Status' "
                            + "FROM pembelian AS pbl "
                            + "JOIN suppliers AS sup ON pbl.id_supplier = sup.id "
                            + "JOIN barang AS brg ON pbl.id_barang = brg.id "
                            + "WHERE pbl.status LIKE 'Lunas%' "
                            + "ORDER BY pbl.id ASC";
                    break;
                case 6:
                    sql = "SELECT pbl.id AS 'No Faktur', pbl.tanggal_beli AS 'Tanggal Beli', sup.nama_supplier AS 'Nama Supplier', "
                            + "brg.nama AS 'Nama Barang', pbl.kuantitas AS 'Kuantitas', pbl.total_harga AS 'Total Harga', pbl.status AS 'Status' "
                            + "FROM pembelian AS pbl "
                            + "JOIN suppliers AS sup ON pbl.id_supplier = sup.id "
                            + "JOIN barang AS brg ON pbl.id_barang = brg.id "
                            + "WHERE pbl.status LIKE '%Belum%' "
                            + "ORDER BY pbl.id ASC";
                    break;
                case 8:
                    sql = "SELECT pbl.id AS 'No Faktur', pbl.tanggal_beli AS 'Tanggal Beli', sup.nama_supplier AS 'Nama Supplier', "
                            + "brg.nama AS 'Nama Barang', pbl.kuantitas AS 'Kuantitas', pbl.total_harga AS 'Total Harga', pbl.status AS 'Status' "
                            + "FROM pembelian AS pbl "
                            + "JOIN suppliers AS sup ON pbl.id_supplier = sup.id "
                            + "JOIN barang AS brg ON pbl.id_barang = brg.id "
                            + "ORDER BY pbl.total_harga DESC";
                    break;
                case 9:
                    sql = "SELECT pbl.id AS 'No Faktur', pbl.tanggal_beli AS 'Tanggal Beli', sup.nama_supplier AS 'Nama Supplier', "
                            + "brg.nama AS 'Nama Barang', pbl.kuantitas AS 'Kuantitas', pbl.total_harga AS 'Total Harga', pbl.status AS 'Status' "
                            + "FROM pembelian AS pbl "
                            + "JOIN suppliers AS sup ON pbl.id_supplier = sup.id "
                            + "JOIN barang AS brg ON pbl.id_barang = brg.id "
                            + "ORDER BY pbl.total_harga ASC";
                    break;
            }

            Connection conn = new koneksi().getConnection();

            Object[] Baris = {"No Faktur", "Tanggal Beli", "Nama Supplier", "Nama Barang", "Kuantitas", "Total Harga", "Status", "Aksi"};
            tabmode = new DefaultTableModel(null, Baris);

            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                ResultSet hasil = stat.executeQuery();
                while (hasil.next()) {
                    tabmode.addRow(new Object[]{
                        hasil.getString(1),
                        hasil.getString(2),
                        hasil.getString(3),
                        hasil.getString(4),
                        hasil.getString(5),
                        hasil.getString(6),
                        hasil.getString(7),
                    });
                }
                tablepembelian.setModel(tabmode);
                initializeTableActionEvent();

                conn.close();
                stat.close();
                hasil.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal ditampilkan, pesan error: " + e);
                Logger.getLogger(supplier.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_searchFilterActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        dataTable();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void addDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataButtonActionPerformed
         try {
            // Mengatur look and feel kembali ke default
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            // Buat objek JFrame baru
            JFrame formTambahPembelian = new transaksi.TambahPembelian();

            // Tampilkan JFrame baru
            formTambahPembelian.setVisible(true);

            // Tutup jendela saat ini
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addDataButtonActionPerformed

    private void cetakNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakNotaActionPerformed
        JFrame popUpLaporanPembelian = new table_model.PopUpLaporanPembelian();
        popUpLaporanPembelian.setVisible(true);
    }//GEN-LAST:event_cetakNotaActionPerformed

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
            JFrame formPembelian = new table_model.pembelian();

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
            java.util.logging.Logger.getLogger(pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_palette.RoundedButton addDataButton;
    private custom_palette.RoundedButton cetakNota;
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
    private custom_palette.RoundedButton searchButton;
    private javax.swing.JComboBox<String> searchFilter;
    private custom_palette.RoundedButton sideBarang;
    private custom_palette.RoundedButton sideHome;
    private custom_palette.RoundedButton sideKaryawan;
    private custom_palette.RoundedButton sidePembelian;
    private custom_palette.RoundedButton sidePenjualan;
    private custom_palette.RoundedButton sideSupplier;
    private custom_palette.CustomTable tablepembelian;
    // End of variables declaration//GEN-END:variables
}
