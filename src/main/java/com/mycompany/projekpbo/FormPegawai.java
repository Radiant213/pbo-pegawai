/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projekpbo;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
    

public class FormPegawai extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormPegawai.class.getName());

    public FormPegawai() {
        initComponents();
        isiComboDivisi();
        isiComboJabatan();
        tampilData();
        kosong();
    }

    private void isiComboDivisi() {
        try {
            String sql = "SELECT * FROM divisi";
            java.sql.Connection conn = Koneksi.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                String id = rs.getString("id_divisi");
                String nama = rs.getString("nama_divisi");
                
                cbDivisi.addItem(new ItemCombo(id, nama));
            }
        } catch (Exception e) {
            System.out.println("Gagal Load Divisi: " + e.getMessage());
        }
    }
    
    private void isiComboJabatan() {
        try {
            String sql = "SELECT * FROM jabatan";
            java.sql.Connection conn = Koneksi.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                String id = rs.getString("id_jabatan");
                String nama = rs.getString("jabatan");
                cbJabatan.addItem(new ItemCombo(id, nama));
            }
        } catch (Exception e) {
            System.out.println("Gagal Load Jabatan: " + e.getMessage());
        }
    }
    
    private void kosong() {
        txtNIP.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        txtUsia.setText("");
        
        // Balikin ComboBox ke pilihan pertama
        if (cbDivisi.getItemCount() > 0) cbDivisi.setSelectedIndex(0);
        if (cbJabatan.getItemCount() > 0) cbJabatan.setSelectedIndex(0);
        
        // NIP Pegawai itu manual input (bukan Auto Increment), jadi harus di-enable pas tambah baru
        txtNIP.setEditable(true);
        txtNIP.requestFocus();
    }
    
    private void tampilData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIP");         // Index 0 (id_pegawai)
        model.addColumn("NAMA");        // Index 1
        model.addColumn("DIVISI");      // Index 2 (nama_divisi)
        model.addColumn("JABATAN");     // Index 3 (jabatan)
        model.addColumn("ALAMAT");      // Index 4
        model.addColumn("USIA");        // Index 5

        try {
            // Kita pake JOIN biar yang muncul NAMA Divisi, bukan ID-nya
            String sql = "SELECT pegawai.*, divisi.nama_divisi, jabatan.jabatan " +
                         "FROM pegawai " +
                         "INNER JOIN divisi ON pegawai.id_divisi = divisi.id_divisi " +
                         "INNER JOIN jabatan ON pegawai.id_jabatan = jabatan.id_jabatan";
                         
            java.sql.Connection conn = Koneksi.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_pegawai"),   // NIP
                    rs.getString("nama"),         // Nama
                    rs.getString("nama_divisi"),  // Nama Divisi (Hasil Join)
                    rs.getString("jabatan"),      // Nama Jabatan (Hasil Join)
                    rs.getString("alamat"),
                    rs.getString("usia")
                });
            }
            tablePegawai.setModel(model);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Tampil Data: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsia = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNIP = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        cbDivisi = new javax.swing.JComboBox<>();
        cbJabatan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePegawai = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("JABATAN");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("ALAMAT");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("USIA");

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        btnClose.setText("CLOSE");
        btnClose.addActionListener(this::btnCloseActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("NIP");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("NAMA");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("DIVISI");

        txtNIP.addActionListener(this::txtNIPActionPerformed);

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        cbJabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        tablePegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablePegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePegawai);

        jMenu1.setText("Form Pegawai");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNIP)
                            .addComponent(txtUsia)
                            .addComponent(txtAlamat)
                            .addComponent(txtNama)
                            .addComponent(cbDivisi, 0, 288, Short.MAX_VALUE)
                            .addComponent(cbJabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(125, 125, 125)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtUsia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "INSERT INTO pegawai (id_pegawai, id_divisi, id_jabatan, nama, alamat, usia) VALUES (?,?,?,?,?,?)";
            
            java.sql.Connection conn = Koneksi.getConnection();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
            // 1. Ambil NIP
            pst.setString(1, txtNIP.getText());
            
            // 2. Ambil ID Divisi Tersembunyi dari ComboBox
            ItemCombo divisi = (ItemCombo) cbDivisi.getSelectedItem();
            pst.setString(2, divisi.getKey()); // Masukin ID (misal "1") bukan Nama
            
            // 3. Ambil ID Jabatan Tersembunyi
            ItemCombo jabatan = (ItemCombo) cbJabatan.getSelectedItem();
            pst.setString(3, jabatan.getKey());
            
            // 4. Sisa data text biasa
            pst.setString(4, txtNama.getText());
            pst.setString(5, txtAlamat.getText());
            pst.setString(6, txtUsia.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Pegawai Berhasil Disimpan!");
            tampilData();
            kosong();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Simpan: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if (txtNIP.getText().equals("")) {
             JOptionPane.showMessageDialog(this, "Pilih data dulu bang!");
             return;
        }
        
        int tanya = JOptionPane.showConfirmDialog(null, "Yakin hapus pegawai ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (tanya == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM pegawai WHERE id_pegawai=?";
                java.sql.Connection conn = Koneksi.getConnection();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, txtNIP.getText());
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Berhasil Hapus!");
                tampilData();
                kosong();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal Hapus: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
        FormMenu FormMenu = new FormMenu();
        FormMenu.setVisible(true);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtNIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNIPActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (txtNIP.getText().equals("")) {
             JOptionPane.showMessageDialog(this, "Pilih data dulu bang!");
             return;
        }
        
        try {
            String sql = "UPDATE pegawai SET id_divisi=?, id_jabatan=?, nama=?, alamat=?, usia=? WHERE id_pegawai=?";
            java.sql.Connection conn = Koneksi.getConnection();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
            // Ambil ID dari Combo
            ItemCombo divisi = (ItemCombo) cbDivisi.getSelectedItem();
            pst.setString(1, divisi.getKey());
            
            ItemCombo jabatan = (ItemCombo) cbJabatan.getSelectedItem();
            pst.setString(2, jabatan.getKey());
            
            pst.setString(3, txtNama.getText());
            pst.setString(4, txtAlamat.getText());
            pst.setString(5, txtUsia.getText());
            pst.setString(6, txtNIP.getText()); // Where Clause
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate!");
            tampilData();
            kosong();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Update: " + e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tablePegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePegawaiMouseClicked
        // TODO add your handling code here:
        int baris = tablePegawai.getSelectedRow();
        
        if (baris != -1) {
            txtNIP.setText(tablePegawai.getValueAt(baris, 0).toString());
            txtNama.setText(tablePegawai.getValueAt(baris, 1).toString());
            
            String namaDivisiTabel = tablePegawai.getValueAt(baris, 2).toString();
            String namaJabatanTabel = tablePegawai.getValueAt(baris, 3).toString();
            
            txtAlamat.setText(tablePegawai.getValueAt(baris, 4).toString());
            txtUsia.setText(tablePegawai.getValueAt(baris, 5).toString());
            
            txtNIP.setEditable(false); // NIP gak boleh diedit pas update
            
            // --- LOGIC MENCARI POSISI COMBOBOX ---
            // Kita loop item combobox satu-satu buat nyamain teksnya
            
            // Set Divisi
            for (int i = 0; i < cbDivisi.getItemCount(); i++) {
                // Ambil item ke-i, ubah jadi string (panggil toString() otomatis)
                if (cbDivisi.getItemAt(i).toString().equals(namaDivisiTabel)) {
                    cbDivisi.setSelectedIndex(i);
                    break;
                }
            }
            
            // Set Jabatan
            for (int i = 0; i < cbJabatan.getItemCount(); i++) {
                if (cbJabatan.getItemAt(i).toString().equals(namaJabatanTabel)) {
                    cbJabatan.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_tablePegawaiMouseClicked

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormPegawai().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Object> cbDivisi;
    private javax.swing.JComboBox<Object> cbJabatan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablePegawai;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtNIP;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtUsia;
    // End of variables declaration//GEN-END:variables
}
