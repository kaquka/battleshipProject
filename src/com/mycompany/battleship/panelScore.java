/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.battleship;

/**
 *
 * @author avalo
 */
public class panelScore extends javax.swing.JPanel {

    /**
     * Creates new form panelScore
     */
    public panelScore() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labelScore = new javax.swing.JLabel();
        atrasBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 640, 310));

        labelScore.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        labelScore.setText("Score...");
        add(labelScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        atrasBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/flecha-hacia-atras.png"))); // NOI18N
        atrasBtn.setBorderPainted(false);
        atrasBtn.setContentAreaFilled(false);
        atrasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBtnActionPerformed(evt);
            }
        });
        add(atrasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void atrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        VentanaJuego.getPnlMenu().setVisible(true);
    }//GEN-LAST:event_atrasBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelScore;
    // End of variables declaration//GEN-END:variables
}
