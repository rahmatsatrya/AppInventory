/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Dao.DAO_Pengguna;
import javax.swing.JOptionPane;
import service.service_pengguna;

/**
 *
 * @author alams
 */
public class Form_gantiPass extends javax.swing.JPanel {

    private service_pengguna servis = new DAO_Pengguna();
    public Form_gantiPass() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        t_username = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        t_passwordOld = new javax.swing.JPasswordField();
        t_passwordNew = new javax.swing.JPasswordField();
        t_passwordConfirm = new javax.swing.JPasswordField();
        btn_submit = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setFocusCycleRoot(true);
        setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pergantian Password");

        t_username.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        t_username.setText("Username");
        t_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        t_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_usernameFocusLost(evt);
            }
        });
        t_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_usernameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel3.setText("Password Lama");

        jLabel2.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel2.setText("Username");

        jLabel4.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel4.setText("Password Baru");

        jLabel5.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel5.setText("Konfirmasi Password");

        t_passwordOld.setText("Password");
        t_passwordOld.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        t_passwordOld.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_passwordOldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_passwordOldFocusLost(evt);
            }
        });

        t_passwordNew.setText("Password");
        t_passwordNew.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        t_passwordNew.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_passwordNewFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_passwordNewFocusLost(evt);
            }
        });

        t_passwordConfirm.setText("Password");
        t_passwordConfirm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        t_passwordConfirm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_passwordConfirmFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_passwordConfirmFocusLost(evt);
            }
        });

        btn_submit.setBackground(new java.awt.Color(153, 255, 153));
        btn_submit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t_username)
                                    .addComponent(t_passwordOld)
                                    .addComponent(t_passwordNew)
                                    .addComponent(t_passwordConfirm)
                                    .addComponent(btn_submit, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_username, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_passwordOld, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_passwordNew, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_passwordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btn_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void t_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_usernameActionPerformed

    private void t_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_usernameFocusGained
        String username = t_username.getText();
        if (username.equals("Username")){
            t_username.setText("");
        }
    }//GEN-LAST:event_t_usernameFocusGained

    private void t_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_usernameFocusLost
        String username = t_username.getText();
        if (username.equals("")|| username.equals("Username")){
            t_username.setText("Username");
        }
    }//GEN-LAST:event_t_usernameFocusLost

    private void t_passwordOldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passwordOldFocusGained
        String pass = t_passwordOld.getText();
        if (pass.equals("Password")){
            t_passwordOld.setText("");
        }
    }//GEN-LAST:event_t_passwordOldFocusGained

    private void t_passwordOldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passwordOldFocusLost
        String pass = t_passwordOld.getText();
        if(pass.equals("")||pass.equals("Password")){
            t_passwordOld.setText("Password");
        }
    }//GEN-LAST:event_t_passwordOldFocusLost

    private void t_passwordNewFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passwordNewFocusGained
        String pass = t_passwordNew.getText();
        if (pass.equals("Password")){
            t_passwordNew.setText("");
        }
    }//GEN-LAST:event_t_passwordNewFocusGained

    private void t_passwordNewFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passwordNewFocusLost
        String pass = t_passwordNew.getText();
        if(pass.equals("")||pass.equals("Password")){
            t_passwordNew.setText("Password");
        }
    }//GEN-LAST:event_t_passwordNewFocusLost

    private void t_passwordConfirmFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passwordConfirmFocusGained
        String pass = t_passwordConfirm.getText();
        if (pass.equals("Password")){
            t_passwordConfirm.setText("");
        }
    }//GEN-LAST:event_t_passwordConfirmFocusGained

    private void t_passwordConfirmFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passwordConfirmFocusLost
        String pass = t_passwordConfirm.getText();
        if(pass.equals("")||pass.equals("Password")){
            t_passwordConfirm.setText("Password");
        }
    }//GEN-LAST:event_t_passwordConfirmFocusLost

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        String Username = t_username.getText();
        String oldPassword = t_passwordOld.getText();
        String newPassword = t_passwordNew.getText();
        String confirmPassword = t_passwordConfirm.getText();
        
        if (!newPassword.equals(confirmPassword)){
            JOptionPane.showMessageDialog(null, "Konfirmasi Password Baru Tidak Sesuai!");
            return;
        }
        
        if(!servis.validateOldPassword(Username, oldPassword)){ //validasi pass lama
            JOptionPane.showMessageDialog(null, "Username dan Password lama tidak valid!");
            return;
        }
        
        if(servis.changePassword(Username, oldPassword, newPassword)){ //validasi pass baru
            JOptionPane.showMessageDialog(null, "Password berhasil diubah!");
        }else{
            JOptionPane.showMessageDialog(null, "Password gagal diubah!");
        }
        
        resetForm();
    }//GEN-LAST:event_btn_submitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_submit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField t_passwordConfirm;
    private javax.swing.JPasswordField t_passwordNew;
    private javax.swing.JPasswordField t_passwordOld;
    private javax.swing.JTextField t_username;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        t_username.setText("Username");
        t_passwordOld.setText("Password");
        t_passwordNew.setText("Password");
        t_passwordConfirm.setText("Password");
    }
}
