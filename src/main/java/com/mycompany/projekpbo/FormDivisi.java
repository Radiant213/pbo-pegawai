
package com.mycompany.projekpbo;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormDivisi extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormDivisi.class.getName());

   
    public FormDivisi() {
        initComponents();
        tampilData();
        kosong();
    }
    

    
    private void kosong() {
        txtIdDivisi.setText("");
        txtNamaDivisi.setText("");
        txtHonorDivisi.setText("");
        
        txtIdDivisi.setEditable(false);
        txtNamaDivisi.requestFocus();
    }
    
    private void tampilData() {
        DefaultTableModel model = new DefaultTableModel();         
        model.addColumn("ID DIVISI");    
        model.addColumn("NAMA DIVISI"); 
        model.addColumn("HONOR DIVISI"); 
        
        try {
            String sql = "SELECT * FROM divisi";
            java.sql.Connection conn = Koneksi.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            
            while (rs.next()) {
                model.addRow(new Object[]{  
                    rs.getString("id_divisi"),   
                    rs.getString("nama_divisi"), 
                    rs.getString("honor_divisi") 
                });
            }
            tableDivisi.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal tampil data" + e);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdDivisi = new javax.swing.JTextField();
        txtNamaDivisi = new javax.swing.JTextField();
        txtHonorDivisi = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDivisi = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(254, 243, 199));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(120, 53, 15));
        jLabel2.setText("ID DIVISI");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(120, 53, 15));
        jLabel3.setText("NAMA DIVISI");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(120, 53, 15));
        jLabel4.setText("HONOR DIVISI");

        txtIdDivisi.addActionListener(this::txtIdDivisiActionPerformed);

        btnTambah.setBackground(new java.awt.Color(217, 119, 6));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("TAMBAH");
        btnTambah.addActionListener(this::btnTambahActionPerformed);

        btnUpdate.setBackground(new java.awt.Color(217, 119, 6));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnHapus.setBackground(new java.awt.Color(217, 119, 6));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        btnKeluar.setBackground(new java.awt.Color(220, 38, 38));
        btnKeluar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnKeluar.setText("KELUAR");
        btnKeluar.addActionListener(this::btnKeluarActionPerformed);

        tableDivisi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableDivisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDivisiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDivisi);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTambah)
                                .addGap(26, 26, 26)
                                .addComponent(btnUpdate)
                                .addGap(30, 30, 30)
                                .addComponent(btnHapus)
                                .addGap(26, 26, 26)
                                .addComponent(btnKeluar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHonorDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamaDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addComponent(txtNamaDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHonorDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnUpdate)
                    .addComponent(btnHapus)
                    .addComponent(btnKeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jMenu1.setText("Form Divisi");
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

    private void txtIdDivisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdDivisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdDivisiActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        try {
            String sql = "INSERT INTO divisi (nama_divisi, honor_divisi) VALUES (?, ?)";
            
            java.sql.Connection conn = Koneksi.getConnection();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, txtNamaDivisi.getText());
            pst.setString(2, txtHonorDivisi.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!");
            tampilData(); 
            kosong();     
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Simpan: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        if (txtIdDivisi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data di tabel dulu!");
            return; 
}
        try {
            String sql = "UPDATE divisi SET nama_divisi=?, honor_divisi=? WHERE id_divisi=?";
            
            java.sql.Connection conn = Koneksi.getConnection();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, txtNamaDivisi.getText());
            pst.setString(2, txtHonorDivisi.getText());
            pst.setString(3, txtIdDivisi.getText()); // ID diambil buat kondisi WHERE
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate!");
            tampilData();
            kosong();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Update: " + e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            String sql = "DELETE FROM divisi WHERE id_divisi=?";
            
            java.sql.Connection conn = Koneksi.getConnection();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, txtIdDivisi.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
            tampilData();
            kosong();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Hapus: " + e.getMessage());
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tableDivisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDivisiMouseClicked
        int baris = tableDivisi.getSelectedRow();
        
        if (baris != -1) {
            // Karena Kolom 0 itu "No", kita ambil mulai dari 1
            String id = tableDivisi.getValueAt(baris, 0).toString();   
            String nama = tableDivisi.getValueAt(baris, 1).toString(); 
            String honor = tableDivisi.getValueAt(baris, 2).toString(); 
            
            txtIdDivisi.setText(id);
            txtNamaDivisi.setText(nama);
            txtHonorDivisi.setText(honor);
            
            txtIdDivisi.setEditable(false);
        }
    }//GEN-LAST:event_tableDivisiMouseClicked

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        this.dispose();
        FormMenu formMenu = new FormMenu();
        formMenu.setVisible(true);
    }//GEN-LAST:event_btnKeluarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FormDivisi().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDivisi;
    private javax.swing.JTextField txtHonorDivisi;
    private javax.swing.JTextField txtIdDivisi;
    private javax.swing.JTextField txtNamaDivisi;
    // End of variables declaration//GEN-END:variables
}
