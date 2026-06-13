/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projekpbo;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

;
public class FormJabatan extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormJabatan.class.getName());

    /**
     * Creates new form FormJabatan
     */
    public FormJabatan() {
        initComponents();
        kosong();
        tampilData();
    }
    

    
    public void kosong() {
        txtIdJabatan.setText("");
        txtJabatan.setText("");
        txtGajiPokok.setText("");
        txtTunjanganJabatan.setText("");
        txtTunjanganAnak.setText("");
        txtTunjanganKesehatan.setText("");
        txtPerjalananDinas.setText("");
        
        txtIdJabatan.setEditable(false);
        txtJabatan.requestFocus();
    }
    
    public void tampilData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID JABATAN");      
        model.addColumn("NAMA JABATAN");    
        model.addColumn("GAJI POKOK");      
        model.addColumn("TUNJ. JABATAN");   
        model.addColumn("TUNJ. ANAK");      
        model.addColumn("TUNJ. KESEHATAN"); 
        model.addColumn("PERJ. DINAS");     
        
        try {
            String sql = "SELECT * FROM jabatan";
            java.sql.Connection conn = Koneksi.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("id_jabatan"),
                    rs.getString("jabatan"),
                    rs.getString("gaji_pokok"),
                    rs.getString("tunj_jabatan"),
                    rs.getString("tunj_anak"),
                    rs.getString("tunj_kesehatan"),
                    rs.getString("perj_dinas")
                });
            }
            tableJabatan.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Tampil Data" + e);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtJabatan = new javax.swing.JTextField();
        txtGajiPokok = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdJabatan = new javax.swing.JTextField();
        txtTunjanganAnak = new javax.swing.JTextField();
        txtPerjalananDinas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTunjanganJabatan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTunjanganKesehatan = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJabatan = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 228, 230));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(136, 19, 55));
        jLabel2.setText("ID JABATAN");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(136, 19, 55));
        jLabel3.setText("JABATAN");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(136, 19, 55));
        jLabel4.setText("GAJI POKOK");

        txtIdJabatan.addActionListener(this::txtIdJabatanActionPerformed);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(136, 19, 55));
        jLabel5.setText("TUNJANGAN JABATAN");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(136, 19, 55));
        jLabel6.setText("TUNJANGAN ANAK");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(136, 19, 55));
        jLabel7.setText("TUNJANGAN KESEHATAN");

        txtTunjanganJabatan.addActionListener(this::txtTunjanganJabatanActionPerformed);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(136, 19, 55));
        jLabel8.setText("PERJALANAN DINAS");

        btnSimpan.setBackground(new java.awt.Color(225, 29, 72));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);

        btnHapus.setBackground(new java.awt.Color(225, 29, 72));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        btnClose.setBackground(new java.awt.Color(220, 38, 38));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("CLOSE");
        btnClose.addActionListener(this::btnCloseActionPerformed);

        btnUpdate.setBackground(new java.awt.Color(225, 29, 72));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        tableJabatan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableJabatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableJabatanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableJabatan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(104, 104, 104)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTunjanganJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGajiPokok, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTunjanganKesehatan, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPerjalananDinas, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTunjanganAnak, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 129, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGajiPokok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTunjanganJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTunjanganAnak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTunjanganKesehatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtPerjalananDinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jMenu1.setText("FormJabatan");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdJabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdJabatanActionPerformed

    private void txtTunjanganJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTunjanganJabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTunjanganJabatanActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
        FormMenu FormMenu = new FormMenu();
        FormMenu.setVisible(true);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "INSERT INTO jabatan (jabatan, gaji_pokok, tunj_jabatan, tunj_anak, tunj_kesehatan, perj_dinas) VALUES (?,?,?,?,?,?)";
            
            java.sql.Connection conn = Koneksi.getConnection();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, txtJabatan.getText());
            pst.setString(2, txtGajiPokok.getText());
            pst.setString(3, txtTunjanganJabatan.getText());
            pst.setString(4, txtTunjanganAnak.getText());
            pst.setString(5, txtTunjanganKesehatan.getText());
            pst.setString(6, txtPerjalananDinas.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Jabatan Berhasil Disimpan!");
            tampilData();
            kosong();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Simpan: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (txtIdJabatan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data di tabel dulu bang!");
            return;
        }

        try {
            String sql = "UPDATE jabatan SET jabatan=?, gaji_pokok=?, tunj_jabatan=?, tunj_anak=?, tunj_kesehatan=?, perj_dinas=? WHERE id_jabatan=?";
            
            java.sql.Connection conn = Koneksi.getConnection();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, txtJabatan.getText());
            pst.setString(2, txtGajiPokok.getText());
            pst.setString(3, txtTunjanganJabatan.getText());
            pst.setString(4, txtTunjanganAnak.getText());
            pst.setString(5, txtTunjanganKesehatan.getText());
            pst.setString(6, txtPerjalananDinas.getText());
            pst.setString(7, txtIdJabatan.getText()); // ID buat kondisi WHERE
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Jabatan Berhasil Diupdate!");
            tampilData();
            kosong();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Update: " + e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if (txtIdJabatan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data di tabel dulu bang!");
            return;
        }
        
        // Kasih konfirmasi biar gak kehapus gak sengaja
        int tanya = JOptionPane.showConfirmDialog(null, "Yakin mau hapus jabatan ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        
        if (tanya == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM jabatan WHERE id_jabatan=?";
                
                java.sql.Connection conn = Koneksi.getConnection();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                
                pst.setString(1, txtIdJabatan.getText());
                
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
                tampilData();
                kosong();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal Hapus: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tableJabatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableJabatanMouseClicked
        // TODO add your handling code here:
        int baris = tableJabatan.getSelectedRow();
        
        if (baris != -1) {
            // Ambil data sesuai urutan kolom di 'tampilData'
            // 0:ID, 1:Jabatan, 2:Gaji, 3:TunjJab, 4:TunjAnak, 5:TunjKes, 6:PerjDinas
            
            txtIdJabatan.setText(tableJabatan.getValueAt(baris, 0).toString());
            txtJabatan.setText(tableJabatan.getValueAt(baris, 1).toString());
            txtGajiPokok.setText(tableJabatan.getValueAt(baris, 2).toString());
            txtTunjanganJabatan.setText(tableJabatan.getValueAt(baris, 3).toString());
            txtTunjanganAnak.setText(tableJabatan.getValueAt(baris, 4).toString());
            txtTunjanganKesehatan.setText(tableJabatan.getValueAt(baris, 5).toString());
            txtPerjalananDinas.setText(tableJabatan.getValueAt(baris, 6).toString());
            
            // Kunci ID
            txtIdJabatan.setEditable(false);
        }
    }//GEN-LAST:event_tableJabatanMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new FormJabatan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableJabatan;
    private javax.swing.JTextField txtGajiPokok;
    private javax.swing.JTextField txtIdJabatan;
    private javax.swing.JTextField txtJabatan;
    private javax.swing.JTextField txtPerjalananDinas;
    private javax.swing.JTextField txtTunjanganAnak;
    private javax.swing.JTextField txtTunjanganJabatan;
    private javax.swing.JTextField txtTunjanganKesehatan;
    // End of variables declaration//GEN-END:variables
}
