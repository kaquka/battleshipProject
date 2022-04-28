/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Database.databaseConnections;
import System.Archivo;
import System.Jugador;
import java.io.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author avalo
 */
public class panelRegistro extends javax.swing.JPanel {

    /**
     * Creates new form panelRegistro
     */
    
    databaseConnections database;
    
    public panelRegistro() {
        initComponents();
        database=new databaseConnections();
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

        txtFieldName = new javax.swing.JTextField();
        signinBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setVerifyInputWhenFocusTarget(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de nacimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 36))); // NOI18N
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 450, 110));
    }// </editor-fold>//GEN-END:initComponents

    private void signinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinBtnActionPerformed
        
        // TODO add your handling code here: DEBE LLEVAR A MENU
        //CHECA EN BASE DE DATOS SI ESTA EL JUGADOR, SINO LO REGISTRA Y TIENE QUE GUARDARSE EN LA VARIABLE JUGADOR.
        
        //PRIMERO PREGUNTA SI EL NOMBRE SE ENCUENTRA BANEADO VERIFICANDO EL ARCHIVO DE BANEADOS
        //SI ESTA BANEADO NO LO DEJA PASAR, SI NO LO ESTA ENTONCES CALCULA SI ES MENOR DE EDAD
        
        try {//SE CREA EL ARCHIVO DE TEXTO PARA LOS RENEGADOS EN CASO DE SER NOMBRES DE MENORES DE EDAD EN CASO DE NO EXIXTIR 
            FileWriter archivo = new FileWriter("src/Files/Baneados.txt",true);
            archivo.close();
        } catch (IOException ex) {
            Logger.getLogger(panelRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!txtFieldName.getText().isEmpty()&&jDateChooser1.getDate()!=null) {
            LocalDate fecha_nacimientoLD = DateUtils.asLocalDate(jDateChooser1.getDate());//
            LocalDate hoy = LocalDate.now();//
            Period periodo = Period.between(fecha_nacimientoLD, hoy);//
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            
            if(!checaBaneado()){
                
                if(/**/periodo.getYears()>=18){//SI ES MAYOR DE EDAD ENTONCES REVISA SI ESTA EN LA BASE DE DATOS
                    if(database.verificaJugador(txtFieldName.getText(), sdf.format(jDateChooser1.getDate()))){
                        System.out.println("existe, lo rellena");
                        VentanaJuego.setJugador(new Jugador(txtFieldName.getText(),jDateChooser1.getDate()));
                        System.out.println(VentanaJuego.getJugador().toString());
                    }else{
                        System.out.println("No existe, lo crea");
                        database.registro(txtFieldName.getText(), sdf.format(jDateChooser1.getDate()));
                        VentanaJuego.setJugador(new Jugador(txtFieldName.getText(),jDateChooser1.getDate()));
                        System.out.println(VentanaJuego.getJugador().toString());
                    }

                    VentanaJuego.getJugador().setId(database.consultaID(txtFieldName.getText(), sdf.format(jDateChooser1.getDate())));
                    VentanaJuego.getPnlRegistro().setVisible(false);
                    VentanaJuego.getPnlJuego().setTableroLogico(Archivo.elegirArchivo());
                    VentanaJuego.getPnlJuego().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Eres menor de edad, no puedes jugar");
                    banea(); //banea nombre LO GUARDA EN UN ARCHIVO
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Este nombre está baneado");
            }

        }else{
            JOptionPane.showMessageDialog(null, "Llene los campos necesarios.");
        }
        txtFieldName.setText("");
        jDateChooser1.setCalendar(null);
        //JOptionPane.showMessageDialog(null, birthdate.getText());
    }//GEN-LAST:event_signinBtnActionPerformed

    private boolean checaBaneado(){
        try {
            FileReader archivo = new FileReader("src/Files/Baneados.txt");
            BufferedReader lectura = new BufferedReader(archivo);
            String cadena;
            String cadena2 = txtFieldName.getText();
            while((cadena = lectura.readLine()) != null){
                if(cadena.equalsIgnoreCase(cadena2)){
                    return true;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(panelRegistro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
           Logger.getLogger(panelRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private void banea(){
        try {
            FileWriter archivo = new FileWriter("src/Files/Baneados.txt",true);
            try(BufferedWriter almacen = new BufferedWriter(archivo)){
                almacen.write(txtFieldName.getText()+"\n");
                almacen.close();
            }
            archivo.close();
        } catch (IOException ex) {
            Logger.getLogger(panelRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton signinBtn;
    private javax.swing.JTextField txtFieldName;
    // End of variables declaration//GEN-END:variables
}
