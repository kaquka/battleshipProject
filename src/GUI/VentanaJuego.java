/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import System.Tablero;

/**
 *
 * @author avalo
 */
public class VentanaJuego extends javax.swing.JFrame {

    /**
     * Creates new form VentanaJuego
     */
    private static panelStart pnlStart;
    private static panelMenu pnlMenu;
    private static panelRegistro pnlRegistro;
    private static panelJuego pnlJuego;
    private static panelScore pnlsScore;

    static Object getAtrasBtn() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public VentanaJuego() {
        initComponents();
        panelsInit();
        //sisisi
    }
    
    public void panelsInit(){
        int height=600;
        int width=800;
        pnlStart=new panelStart();
        pnlStart.setBounds(0, 0, width, height);
        pnlStart.setVisible(true);
        add(pnlStart);
        
        pnlMenu=new panelMenu();
        pnlMenu.setBounds(0, 0, width, height);
        pnlMenu.setVisible(false);
        add(pnlMenu);
        
        pnlRegistro=new panelRegistro();
        pnlRegistro.setBounds(0, 0, width, height);
        pnlRegistro.setVisible(false);
        add(pnlRegistro);
        
        pnlJuego=new panelJuego();
        pnlJuego.setBounds(0, 0, width, height);
        pnlJuego.setVisible(false);
        add(pnlJuego);
        
        pnlsScore=new panelScore();
        pnlsScore.setBounds(0, 0, width, height);
        pnlsScore.setVisible(false);
        add(pnlsScore);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Battleship");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        outBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/check-out.png"))); // NOI18N
        outBtn.setToolTipText("Salir de juego");
        outBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outBtnMouseEntered(evt);
            }
        });
        outBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(outBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(726, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(outBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(540, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void outBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outBtnActionPerformed
        // TODO add your handling code here: DEBE DE LLEVAR A START
        /*CONDICIONES: 
        -SI ESTA EN PANELJUEGO DEBE VERIFICAR QUE EL JUGADOR REALMENTE QUIERE SALIR
        -SI ESTA EN OTROS (PROPONER QUÉ HARA)
        */
        pnlStart.setVisible(true);
        pnlMenu.setVisible(false);
        pnlRegistro.setVisible(false);
        pnlJuego.setVisible(false);
        pnlsScore.setVisible(false);
        
    }//GEN-LAST:event_outBtnActionPerformed

    private void outBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outBtnMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_outBtnMouseEntered

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Tablero tableroJ = new Tablero();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaJuego().setVisible(true);
            }
        });
    }

    public static panelStart getPnlStart() {
        return pnlStart;
    }

    public static panelMenu getPnlMenu() {
        return pnlMenu;
    }

    public static panelRegistro getPnlRegistro() {
        return pnlRegistro;
    }

    public static panelJuego getPnlJuego() {
        return pnlJuego;
    }

    public static panelScore getPnlsScore() {
        return pnlsScore;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton outBtn;
    // End of variables declaration//GEN-END:variables
}


