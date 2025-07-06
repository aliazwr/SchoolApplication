/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import Koneksi.Koneksi;
/**
 *
 * @author aliazwar
 */
public class DataSiswa extends javax.swing.JPanel {
    private final Connection conn = new Koneksi().connect();
    private DefaultTableModel tabmode;

    /**
     * Creates new form menuDashboard
     */
    public DataSiswa(){
        initComponents();
        
        
        btn_tambah.addActionListener(this::btn_tambahActionPerformed); 
        btn_ubah.addActionListener(this::btn_ubahActionPerformed);
        btn_hapus.addActionListener(this::btn_hapusActionPerformed);
        btn_batal.addActionListener(this::btn_batalActionPerformed);
        btn_simpan.addActionListener(this::btn_simpanActionPerformed);

        loadTableData();
        addSearchFunctionality();
        populateKelasComboBox();
        
        t_alamat.setLineWrap(true);
        t_alamat.setWrapStyleWord(true);
    }
    private void populateKelasComboBox() {
        try (Connection conn = new Koneksi().connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT ID_KELAS FROM Kelas")) {
            cb_kelas.removeAllItems(); // Kosongkan JComboBox
            while (rs.next()) {
                cb_kelas.addItem(rs.getString("ID_KELAS"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data kelas: " + e.getMessage());
        }
    }
    private void filterTable(TableRowSorter<DefaultTableModel> sorter) {
    String keyword = t_cari.getText().trim(); // Ambil teks dari JTextField pencarian
    if (keyword.isEmpty()) {
        sorter.setRowFilter(null); // Tampilkan semua data jika tidak ada keyword
    } else {
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword)); // Filter berdasarkan keyword
        }
    }
    private void addSearchFunctionality() {
        DefaultTableModel model = (DefaultTableModel) tbl_DataSiswa.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tbl_DataSiswa.setRowSorter(sorter);

        t_cari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                filterTable(sorter);
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                filterTable(sorter);
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                filterTable(sorter);
            }
        });
    }
        

    private void clearForm() {
    t_nik.setText("");
    t_nama.setText("");
    t_alamat.setText("");
    t_ttl.setText("");
    cb_kelas.setSelectedIndex(0);
    
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_DataSiswa = new javax.swing.JTable();
        btn_tambah = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        t_nik = new javax.swing.JTextField();
        t_nama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_alamat = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        t_ttl = new javax.swing.JTextField();
        t_cari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cb_kelas = new javax.swing.JComboBox<>();
        cb_kelas1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1067, 765));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(740, 518));

        tbl_DataSiswa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbl_DataSiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NIK", "NAMA SISWA/I", "ALAMAT", "JENIS KELAMIN", "TEMPAT TANGGAL LAHIR", "KELAS"
            }
        ));
        jScrollPane1.setViewportView(tbl_DataSiswa);

        btn_tambah.setBackground(new java.awt.Color(255, 255, 255));
        btn_tambah.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        btn_tambah.setText("TAMBAH");
        btn_tambah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_tambah.setPreferredSize(new java.awt.Dimension(100, 20));

        btn_ubah.setBackground(new java.awt.Color(255, 255, 255));
        btn_ubah.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        btn_ubah.setText("UBAH");
        btn_ubah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_ubah.setPreferredSize(new java.awt.Dimension(100, 20));
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        btn_simpan.setBackground(new java.awt.Color(255, 255, 255));
        btn_simpan.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        btn_simpan.setText("SIMPAN");
        btn_simpan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        t_nik.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        t_nik.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t_nik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nikActionPerformed(evt);
            }
        });

        t_nama.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        t_nama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        jLabel2.setText("NIK");

        jLabel3.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        jLabel3.setText("NAMA");

        t_alamat.setColumns(20);
        t_alamat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        t_alamat.setRows(5);
        t_alamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(t_alamat);

        jLabel4.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        jLabel4.setText("ALAMAT");

        jLabel5.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        jLabel5.setText("TTL");

        t_ttl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        t_ttl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        t_cari.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        t_cari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cariActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        jLabel6.setText("PENCARIAN DATA SISWA/I :");

        btn_hapus.setBackground(new java.awt.Color(255, 255, 255));
        btn_hapus.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        btn_hapus.setText("HAPUS");
        btn_hapus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_hapus.setPreferredSize(new java.awt.Dimension(100, 20));

        btn_batal.setBackground(new java.awt.Color(255, 255, 255));
        btn_batal.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        btn_batal.setText("BATAL");
        btn_batal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_batal.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel1.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        jLabel1.setText("KELAS");

        cb_kelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kelas A", "Kelas B", "Kelas C", "Kelas D" }));

        cb_kelas1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LAKI-LAKI", "PEREMPUAN" }));

        jLabel7.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        jLabel7.setText("JENIS KELAMIN");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("MASTER DATA > DATA SISWA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel1))
                                        .addGap(65, 65, 65)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cb_kelas, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(t_ttl, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                                            .addComponent(t_nama)
                                            .addComponent(t_nik)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(20, 20, 20)
                                        .addComponent(cb_kelas1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(t_nik, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(t_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cb_kelas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_ttl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int selectedRow = tbl_DataSiswa.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Konfirmasi penghapusan
    int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            // Ambil kode ruangan dari baris yang dipilih
            String kode = tbl_DataSiswa.getValueAt(selectedRow, 0).toString();

            // Hapus data dari database
            String sql = "DELETE FROM Siswa WHERE nik = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, kode);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");

            // Muat ulang data ke JTable
            loadTableData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
            }
        }
    }        
    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {                                           
         // Reset form
    clearForm();
    }            
    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        int selectedRow = tbl_DataSiswa.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang ingin diubah!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
        try {
        // Query untuk memperbarui data di database
        String sql = "UPDATE Siswa SET NAMA = ?, ALAMAT = ?, TTL = ?, KELAS =? WHERE NIK = ?";
        PreparedStatement pst = conn.prepareStatement(sql);

        // Set nilai dari form ke query
        pst.setString(1, t_nama.getText());
        pst.setString(2, t_alamat.getText());
        pst.setString(3, t_ttl.getText());
        pst.setString(4, (String) cb_kelas.getSelectedItem());
        pst.setString(5, t_nik.getText()); // NIK sebagai WHERE condition

        

        // Eksekusi query
        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!");

        // Reset form
        clearForm();

        // Muat ulang data ke JTable
        loadTableData();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal memperbarui data: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void t_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cariActionPerformed

    private void t_nikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nikActionPerformed
    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        String sql = "INSERT INTO Siswa (NIK, NAMA, ALAMAT, TTL, KELAS) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, t_nik.getText());
        pst.setString(2, t_nama.getText());
        pst.setString(3, t_alamat.getText());
        pst.setString(4, t_ttl.getText());
        pst.setString(5, (String) cb_kelas.getSelectedItem());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        clearForm();
        loadTableData();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage());
    }
}
       
    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try {
        // Query untuk memasukkan data ke tabel
        String sql = "INSERT INTO Siswa (NIK, NAMA, ALAMAT, TTL, KELAS) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);

        // Set nilai dari form ke query
        pst.setString(1, t_nik.getText());
        pst.setString(2, t_nama.getText());
        pst.setString(3, t_alamat.getText());
        pst.setString(4, t_ttl.getText());
        pst.setString(5, (String) cb_kelas.getSelectedItem());
        

        // Eksekusi query
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke database!");

        // Reset form
        clearForm();
        loadTableData();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage());
    }
        
    }   
    private void loadTableData() {
    Object[] kolom = {"NIK", "NAMA SISWA", "ALAMAT", "TEMPAT, TANGGAL LAHIR", "KELAS"};
    tabmode = new DefaultTableModel(null, kolom);
    tbl_DataSiswa.setModel(tabmode);
    
    try {
        String sql = "SELECT * FROM Siswa";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            String nik = rs.getString("NIK");
            String nama = rs.getString("NAMA");
            String alamat = rs.getString("ALAMAT");
            String ttl = rs.getString("TTL");
            String kelas = rs.getString("KELAS");
            String[] data = {nik, nama, alamat, ttl, kelas};
            tabmode.addRow(data);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
    }
}

    
     public static void main(String args[]) {
        
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new DataSiswa().setVisible(true);
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JComboBox<String> cb_kelas;
    private javax.swing.JComboBox<String> cb_kelas1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea t_alamat;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_nama;
    private javax.swing.JTextField t_nik;
    private javax.swing.JTextField t_ttl;
    private javax.swing.JTable tbl_DataSiswa;
    // End of variables declaration//GEN-END:variables
}
    
