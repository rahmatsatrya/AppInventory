/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Dao.DAO_Laporan;
import service.service_laporan;

public class Laporan_Barang extends javax.swing.JPanel {
   private service_laporan servisLap = new DAO_Laporan();
//    private final int noColumnIndex = 0;
//    private final int noColumnWidth = 50;
    
    public Laporan_Barang(String id) {
        initComponents();
        lb_id.setText(id);
        pn_dataBarang.setVisible(false);
        pn_transaksiBarang.setVisible(false);
        btn_batal.setVisible(false);
        lb_id.setVisible(false);
       
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField8 = new javax.swing.JTextField();
        mainPanel = new javax.swing.JPanel();
        Laporan = new javax.swing.JPanel();
        pn_pilihLaporan = new javax.swing.JPanel();
        cbx_laporan = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btn_batal = new javax.swing.JButton();
        pn_dataBarang = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        pn_transaksiBarang = new javax.swing.JPanel();
        btn_print2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pn_tampilLaporan = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();

        jTextField8.setText("jTextField2");
        jTextField8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        Laporan.setBackground(new java.awt.Color(255, 255, 255));
        Laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LaporanMouseClicked(evt);
            }
        });

        pn_pilihLaporan.setBackground(new java.awt.Color(255, 255, 255));
        pn_pilihLaporan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbx_laporan.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        cbx_laporan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Jenis Laporan --", "Laporan Data Barang", "Laporan Transaksi Barang" }));
        cbx_laporan.setBorder(null);
        cbx_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_laporanActionPerformed(evt);
            }
        });
        pn_pilihLaporan.add(cbx_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 34, 284, 36));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pilih Jenis Laporan");
        pn_pilihLaporan.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 284, 22));

        btn_batal.setBackground(new java.awt.Color(255, 255, 153));
        btn_batal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/back.png"))); // NOI18N
        btn_batal.setText("Kembali");
        btn_batal.setBorder(null);
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        pn_pilihLaporan.add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 150, 40));

        pn_dataBarang.setBackground(new java.awt.Color(255, 255, 255));
        pn_dataBarang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Laporan Data Barang");

        btn_print.setBackground(new java.awt.Color(51, 153, 255));
        btn_print.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/printer.png"))); // NOI18N
        btn_print.setText("Print");
        btn_print.setBorder(null);
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_dataBarangLayout = new javax.swing.GroupLayout(pn_dataBarang);
        pn_dataBarang.setLayout(pn_dataBarangLayout);
        pn_dataBarangLayout.setHorizontalGroup(
            pn_dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dataBarangLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(pn_dataBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_dataBarangLayout.setVerticalGroup(
            pn_dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dataBarangLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pn_pilihLaporan.add(pn_dataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 82, 284, -1));

        pn_transaksiBarang.setBackground(new java.awt.Color(255, 255, 255));
        pn_transaksiBarang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_print2.setBackground(new java.awt.Color(51, 153, 255));
        btn_print2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_print2.setForeground(new java.awt.Color(255, 255, 255));
        btn_print2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/printer.png"))); // NOI18N
        btn_print2.setText("Print");
        btn_print2.setBorder(null);
        btn_print2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Laporan Transaksi Barang");

        javax.swing.GroupLayout pn_transaksiBarangLayout = new javax.swing.GroupLayout(pn_transaksiBarang);
        pn_transaksiBarang.setLayout(pn_transaksiBarangLayout);
        pn_transaksiBarangLayout.setHorizontalGroup(
            pn_transaksiBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_transaksiBarangLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btn_print2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(pn_transaksiBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_transaksiBarangLayout.setVerticalGroup(
            pn_transaksiBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_transaksiBarangLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(btn_print2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pn_pilihLaporan.add(pn_transaksiBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 82, 284, -1));

        pn_tampilLaporan.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_tampilLaporanLayout = new javax.swing.GroupLayout(pn_tampilLaporan);
        pn_tampilLaporan.setLayout(pn_tampilLaporanLayout);
        pn_tampilLaporanLayout.setHorizontalGroup(
            pn_tampilLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );
        pn_tampilLaporanLayout.setVerticalGroup(
            pn_tampilLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Laporan Barang");

        lb_id.setForeground(new java.awt.Color(255, 255, 255));
        lb_id.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_id.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_id)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout LaporanLayout = new javax.swing.GroupLayout(Laporan);
        Laporan.setLayout(LaporanLayout);
        LaporanLayout.setHorizontalGroup(
            LaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LaporanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_pilihLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_tampilLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LaporanLayout.setVerticalGroup(
            LaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LaporanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_pilihLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(pn_tampilLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPanel.add(Laporan, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        mainPanel.removeAll();
        String id = lb_id.getText();
        mainPanel.add(new Laporan_Barang(id));
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void LaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LaporanMouseClicked
        
    }//GEN-LAST:event_LaporanMouseClicked

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        pn_tampilLaporan.removeAll();
        servisLap.lapDataBarang(pn_tampilLaporan);
    }//GEN-LAST:event_btn_printActionPerformed

    private void cbx_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_laporanActionPerformed
        if(cbx_laporan.getSelectedItem() == "-- Pilih Jenis Laporan --"){
            btn_batal.setVisible(false);
            pn_dataBarang.setVisible(false);
            pn_transaksiBarang.setVisible(false);
        }else if(cbx_laporan.getSelectedItem() == "Laporan Data Barang"){
            btn_batal.setVisible(true);
            pn_dataBarang.setVisible(true);
            pn_transaksiBarang.setVisible(false);
        }else if (cbx_laporan.getSelectedItem() == "Laporan Transaksi Barang"){
            btn_batal.setVisible(true);
            pn_dataBarang.setVisible(false);
            pn_transaksiBarang.setVisible(true);
        }
    }//GEN-LAST:event_cbx_laporanActionPerformed

    private void btn_print2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print2ActionPerformed
        pn_tampilLaporan.removeAll();
        servisLap.lapTransaksiBarang(pn_tampilLaporan);
    }//GEN-LAST:event_btn_print2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Laporan;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_print2;
    private javax.swing.JComboBox<String> cbx_laporan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lb_id;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pn_dataBarang;
    private javax.swing.JPanel pn_pilihLaporan;
    private javax.swing.JPanel pn_tampilLaporan;
    private javax.swing.JPanel pn_transaksiBarang;
    // End of variables declaration//GEN-END:variables



}
