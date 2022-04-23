/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import System.Archivo;
import System.Jugador;

/**
 *
 * @author avalo
 */
public class panelMenu extends javax.swing.JPanel {

    /**
     * Creates new form panelMenu
     */
    private static Panel siu;
    
    public panelMenu() {
        
        initComponents();
        siu=new Panel("/icons/menu.png");
        siu.setBounds(0, 0, 800, 600);
        siu.setVisible(true);
        add(siu);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        playBtn = new javax.swing.JButton();
        scoreBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jButton1.setText("jButton1");

        playBtn.setText("Jugar");
        playBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBtnActionPerformed(evt);
            }
        });

        scoreBtn.setText("Scores");
        scoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(playBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(scoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(261, 261, 261))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void playBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBtnActionPerformed
        // TODO add your handling code here:DEBE LLEVAR A panelJuego
        
       VentanaJuego.setJugador(new Jugador("Azarel", 2001, 11, 20));
        
        VentanaJuego.getPnlJuego().setTableroLogico(Archivo.getArchivo("src/Files/Tablero1.dat"));
        VentanaJuego.getPnlJuego().setJugador(VentanaJuego.getJugador());
        
        VentanaJuego.getPnlMenu().setVisible(false);
        VentanaJuego.getPnlJuego().setVisible(true);
    }//GEN-LAST:event_playBtnActionPerformed

    private void scoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreBtnActionPerformed
        // TODO add your handling code here: DEBE LLEVAR A panelScore
        VentanaJuego.getPnlMenu().setVisible(false);
        VentanaJuego.getPnlsScore().setVisible(true);
    }//GEN-LAST:event_scoreBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton playBtn;
    private javax.swing.JButton scoreBtn;
    // End of variables declaration//GEN-END:variables
}
