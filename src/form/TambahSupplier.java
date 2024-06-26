/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import koneksi.koneksi;

/**
 *
 * @author Bagus
 */
public class TambahSupplier extends javax.swing.JFrame {

    /**
     * Creates new form supplier
     */
    public TambahSupplier() {
        initComponents();
        kosong();
    }
    
    protected void kosong() {
        nama.setText("");
        kontak.setText("");
        email.setText("");
        jenisSupplier.setSelectedItem(null);
        lokasiSupplier.setSelectedItem(null);
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

        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        roundedPanel1 = new custom_palette.RoundedPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        roundedPanel3 = new custom_palette.RoundedPanel();
        roundedPanel4 = new custom_palette.RoundedPanel();
        jLabel13 = new javax.swing.JLabel();
        roundedPanel5 = new custom_palette.RoundedPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jenisSupplier = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        nama = new custom_palette.RoundedTextField();
        kontak = new custom_palette.RoundedTextField();
        email = new custom_palette.RoundedTextField();
        lokasiSupplier = new javax.swing.JComboBox<>();
        addDataButton = new custom_palette.RoundedButton();
        cancelButton = new custom_palette.RoundedButton();
        roundedPanel2 = new custom_palette.RoundedPanel();
        jPanel1 = new javax.swing.JPanel();
        sideHome = new custom_palette.RoundedButton();
        sideBarang = new custom_palette.RoundedButton();
        sideKaryawan = new custom_palette.RoundedButton();
        sidePenjualan = new custom_palette.RoundedButton();
        sidePembelian = new custom_palette.RoundedButton();
        sideSupplier = new custom_palette.RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setBackground(new java.awt.Color(242, 241, 235));
        jPanel8.setPreferredSize(new java.awt.Dimension(1153, 832));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-truck2.png"))); // NOI18N
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 52, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(136, 171, 142));
        jSeparator1.setForeground(new java.awt.Color(136, 171, 142));
        jSeparator1.setPreferredSize(new java.awt.Dimension(316, 10));
        jPanel8.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 103, -1, -1));

        jLabel8.setBackground(new java.awt.Color(142, 175, 148));
        jLabel8.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(142, 175, 148));
        jLabel8.setText("Manajemen Supplier");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 65, 210, -1));

        roundedPanel1.setBackground(new java.awt.Color(175, 200, 173));
        roundedPanel1.setForeground(new java.awt.Color(189, 189, 189));
        roundedPanel1.setCornerRadius(30);
        roundedPanel1.setPreferredSize(new java.awt.Dimension(1117, 73));
        roundedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-note.png"))); // NOI18N
        roundedPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 16, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tambah Data Supplier");
        roundedPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 23, 300, -1));

        jPanel8.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 142, 1117, 73));

        roundedPanel3.setBackground(new java.awt.Color(136, 171, 142));
        roundedPanel3.setForeground(new java.awt.Color(136, 171, 142));
        roundedPanel3.setCornerRadius(50);
        roundedPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel4.setBackground(new java.awt.Color(175, 200, 173));
        roundedPanel4.setForeground(new java.awt.Color(175, 200, 173));
        roundedPanel4.setCornerRadius(30);

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("+ Tambah Data Supplier");
        jLabel13.setPreferredSize(new java.awt.Dimension(337, 34));

        javax.swing.GroupLayout roundedPanel4Layout = new javax.swing.GroupLayout(roundedPanel4);
        roundedPanel4.setLayout(roundedPanel4Layout);
        roundedPanel4Layout.setHorizontalGroup(
            roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
            .addGroup(roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundedPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        roundedPanel4Layout.setVerticalGroup(
            roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundedPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        roundedPanel3.add(roundedPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 0, 250, 44));

        roundedPanel5.setBackground(new java.awt.Color(248, 248, 248));
        roundedPanel5.setForeground(new java.awt.Color(248, 248, 248));
        roundedPanel5.setCornerRadius(70);
        roundedPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-supplier.png"))); // NOI18N
        roundedPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 66, -1, -1));

        jLabel10.setBackground(new java.awt.Color(94, 90, 90));
        jLabel10.setFont(new java.awt.Font("Inter", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(94, 90, 90));
        jLabel10.setText("Nama supplier");
        roundedPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 45, -1, -1));

        jLabel14.setBackground(new java.awt.Color(94, 90, 90));
        jLabel14.setFont(new java.awt.Font("Inter", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(94, 90, 90));
        jLabel14.setText("Kontak");
        roundedPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 81, -1, -1));

        jLabel15.setFont(new java.awt.Font("Inter", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(94, 90, 90));
        jLabel15.setText("E-mail");
        roundedPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 117, -1, -1));

        jLabel16.setBackground(new java.awt.Color(94, 90, 90));
        jLabel16.setFont(new java.awt.Font("Inter", 0, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(94, 90, 90));
        jLabel16.setText("Jenis supplier");
        roundedPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 151, -1, -1));

        jLabel17.setFont(new java.awt.Font("Inter", 0, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(94, 90, 90));
        jLabel17.setText("Lokasi supplier");
        roundedPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 186, -1, -1));

        jLabel18.setFont(new java.awt.Font("Inter", 0, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(94, 90, 90));
        jLabel18.setText("Alamat");
        roundedPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 219, -1, -1));

        jenisSupplier.setBackground(new java.awt.Color(248, 248, 248));
        jenisSupplier.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jenisSupplier.setForeground(new java.awt.Color(94, 90, 90));
        jenisSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Frame", "Lensa", "Aksesoris" }));
        jenisSupplier.setPreferredSize(new java.awt.Dimension(118, 26));
        roundedPanel5.add(jenisSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 151, -1, -1));

        jScrollPane1.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N

        alamat.setBackground(new java.awt.Color(238, 231, 218));
        alamat.setColumns(20);
        alamat.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        alamat.setRows(5);
        jScrollPane1.setViewportView(alamat);

        roundedPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 226, 285, -1));

        nama.setBackground(new java.awt.Color(238, 231, 218));
        nama.setCornerRadius(5);
        nama.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        nama.setLineColor(new java.awt.Color(175, 200, 173));
        roundedPanel5.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 45, 285, -1));

        kontak.setBackground(new java.awt.Color(238, 231, 218));
        kontak.setCornerRadius(5);
        kontak.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        kontak.setLineColor(new java.awt.Color(175, 200, 173));
        roundedPanel5.add(kontak, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 81, 285, -1));

        email.setBackground(new java.awt.Color(238, 231, 218));
        email.setCornerRadius(5);
        email.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        email.setLineColor(new java.awt.Color(175, 200, 173));
        email.setName(""); // NOI18N
        roundedPanel5.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 117, 285, -1));

        lokasiSupplier.setBackground(new java.awt.Color(248, 248, 248));
        lokasiSupplier.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lokasiSupplier.setForeground(new java.awt.Color(94, 90, 90));
        lokasiSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jabodetabek", "Luar Kota", "Luar Negeri" }));
        lokasiSupplier.setPreferredSize(new java.awt.Dimension(118, 26));
        roundedPanel5.add(lokasiSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 186, -1, -1));

        roundedPanel3.add(roundedPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 63, 895, 343));

        addDataButton.setForeground(new java.awt.Color(136, 171, 142));
        addDataButton.setText("+ Tambah");
        addDataButton.setColor(new java.awt.Color(248, 248, 248));
        addDataButton.setColorClick(new java.awt.Color(198, 198, 198));
        addDataButton.setColorOver(new java.awt.Color(223, 223, 223));
        addDataButton.setcornerRadius(15);
        addDataButton.setFont(new java.awt.Font("Inter", 1, 16)); // NOI18N
        addDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDataButtonActionPerformed(evt);
            }
        });
        roundedPanel3.add(addDataButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 416, 120, 41));

        cancelButton.setForeground(new java.awt.Color(136, 171, 142));
        cancelButton.setText("X Batal");
        cancelButton.setColorClick(new java.awt.Color(198, 198, 198));
        cancelButton.setColorOver(new java.awt.Color(223, 223, 223));
        cancelButton.setcornerRadius(15);
        cancelButton.setFont(new java.awt.Font("Inter", 1, 16)); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        roundedPanel3.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(801, 416, 103, 41));

        jPanel8.add(roundedPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 273, 983, 465));

        roundedPanel2.setBackground(new java.awt.Color(238, 231, 218));
        roundedPanel2.setForeground(new java.awt.Color(238, 231, 218));
        roundedPanel2.setCornerRadius(70);
        roundedPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(roundedPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 259, 980, 451));

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
        sideSupplier.setColor(new java.awt.Color(190, 184, 174));
        sideSupplier.setColorClick(new java.awt.Color(190, 184, 174));
        sideSupplier.setColorOver(new java.awt.Color(190, 184, 174));
        sideSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sideSupplierActionPerformed(evt);
            }
        });
        jPanel1.add(sideSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 698, 130, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            JFrame tableModelSupplier = new table_model.supplier();

            // Tampilkan JFrame baru
            tableModelSupplier.setVisible(true);

            // Tutup jendela saat ini
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataButtonActionPerformed
        Connection conn = new koneksi().getConnection();
        
        String sql = "insert into suppliers(nama_supplier, kontak, email, jenis_supplier, lokasi_supplier, alamat) values (?,?,?,?,?,?)";
        
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama.getText());
            stat.setString(2, kontak.getText());
            stat.setString(3, email.getText());
            stat.setString(4, jenisSupplier.getSelectedItem().toString());
            stat.setString(5, lokasiSupplier.getSelectedItem().toString());
            stat.setString(6, alamat.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            nama.requestFocus();
            kosong();
            
            conn.close();
            stat.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal disimpan, pesan error: "+e);
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
//            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_palette.RoundedButton addDataButton;
    private javax.swing.JTextArea alamat;
    private custom_palette.RoundedButton cancelButton;
    private custom_palette.RoundedTextField email;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jenisSupplier;
    private custom_palette.RoundedTextField kontak;
    private javax.swing.JComboBox<String> lokasiSupplier;
    private custom_palette.RoundedTextField nama;
    private custom_palette.RoundedPanel roundedPanel1;
    private custom_palette.RoundedPanel roundedPanel2;
    private custom_palette.RoundedPanel roundedPanel3;
    private custom_palette.RoundedPanel roundedPanel4;
    private custom_palette.RoundedPanel roundedPanel5;
    private custom_palette.RoundedButton sideBarang;
    private custom_palette.RoundedButton sideHome;
    private custom_palette.RoundedButton sideKaryawan;
    private custom_palette.RoundedButton sidePembelian;
    private custom_palette.RoundedButton sidePenjualan;
    private custom_palette.RoundedButton sideSupplier;
    // End of variables declaration//GEN-END:variables
}
