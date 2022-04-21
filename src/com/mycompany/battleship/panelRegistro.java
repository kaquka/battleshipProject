/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.battleship;

import javax.swing.JOptionPane;

/**
 *
 * @author avalo
 */
public class panelRegistro extends javax.swing.JPanel {

    /**
     * Creates new form panelRegistro
     */
    public panelRegistro() {
        initComponents();
        //initImage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        birthdate = new javax.swing.JFormattedTextField();
        txtFieldName = new javax.swing.JTextField();
        signinBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setVerifyInputWhenFocusTarget(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        birthdate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de nacimiento", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Stencil", 1, 36))); // NOI18N
        birthdate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        birthdate.setText("yyyy/mm/dd");
        birthdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        birthdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                birthdateMouseClicked(evt);
            }
        });
        birthdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthdateActionPerformed(evt);
            }
        });
        add(birthdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 458, 80));

        txtFieldName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFieldName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Stencil", 1, 36))); // NOI18N
        add(txtFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 331, -1));

        signinBtn.setText("Entrar");
        signinBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        signinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinBtnActionPerformed(evt);
            }
        });
        add(signinBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 160, 60));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Webp.net-resizeimage.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Webp.net-resizeimage (1).png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void birthdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthdateActionPerformed

    private void signinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinBtnActionPerformed
        // TODO add your handling code here: DEBE LLEVAR A MENU
        //CHECA EN BASE DE DATOS SI ESTA EL JUGADOR, SINO LO REGISTRA Y TIENE QUE GUARDARSE EN LA VARIABLE JUGADOR.
        //VentanaJuego.getPnlRegistro().setVisible(false);
        //VentanaJuego.getPnlMenu().setVisible(true);
        JOptionPane.showMessageDialog(null, birthdate.getText());
    }//GEN-LAST:event_signinBtnActionPerformed

    private void birthdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_birthdateMouseClicked
        // TODO add your handling code here:
        birthdate.setText("");
    }//GEN-LAST:event_birthdateMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField birthdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton signinBtn;
    private javax.swing.JTextField txtFieldName;
    // End of variables declaration//GEN-END:variables
}
