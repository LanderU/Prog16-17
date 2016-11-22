/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverftpgui;

import com.sun.xml.internal.stream.writers.WriterUtility;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lander
 */
public class VentanaCliente extends javax.swing.JFrame {

    /**
     * Creates new form VentanaCliente
     */
    private static final int PUERTO = 6666;
    private static InetAddress local = null;
    private static Socket servidor = null;
    // Streams
    private static DataInputStream recibido = null;
    private static DataOutputStream enviado = null;
    // Para el cliente
    private static final String PATH = "/home/lander/FTPCliente/";
    
    public VentanaCliente() {
        initComponents();
        this.jButton1.setEnabled(false);
        this.jComboBox1.removeAllItems();
        this.jButton2.setText("Conectar");
        this.jButton1.setText("Download");
        this.jLabel1.setText("Ficheros disponibles");
        this.jButton3.setEnabled(false);
        this.jButton3.setText("Upload");
        this.jComboBox1.setVisible(false);
        this.jLabel1.setVisible(false);
        this.jButton4.setVisible(false);
        this.jButton5.setVisible(false);
        this.jButton4.setText("Complet download");
        this.jButton5.setText("Complet upload ");
    }// Constructor

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setName("ListaFicheros"); // NOI18N

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jButton4)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jButton5)))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (this.jButton2.getText().equals("Conectar")){
            this.jButton2.setText("Desconectar");
            this.jButton3.setEnabled(true);
            this.jButton1.setEnabled(true);
            this.jButton1.setVisible(true);
            this.jButton3.setVisible(true);
        }else{
            this.jButton2.setText("Conectar");
            this.jButton1.setEnabled(false);
            this.jComboBox1.removeAllItems();
            this.jButton3.setEnabled(false);
            this.jLabel1.setVisible(false);
            this.jButton3.setVisible(false);
            this.jButton4.setVisible(false);
            this.jButton5.setVisible(false);
            this.jButton1.setVisible(false);
            try {
                servidor.close();
            } catch (IOException ex) {
                Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }// end if
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.jLabel1.setText("Ficheros en el servidor");
            this.jLabel1.setVisible(true);
            this.jComboBox1.setVisible(true);
            local = InetAddress.getLocalHost();
            servidor = new Socket(local, PUERTO);
            servidor.setSoTimeout(4000);
            // Envíamos el flag
            enviado = new DataOutputStream(servidor.getOutputStream());
            enviado.writeInt(0);
            // Nos quedamos con la cantidad de ficheros
            recibido = new DataInputStream(servidor.getInputStream());
            int cantidadFicheros = recibido.readInt();
            // Recorremos los ficheros y los guardamos en el array
            for (int i = 0; i < cantidadFicheros; i++) {
                recibido = new DataInputStream(servidor.getInputStream());
		this.jComboBox1.addItem(recibido.readUTF().toString());
            }// end for
             this.jButton4.setVisible(true);
             this.jButton1.setVisible(false);
             this.jButton3.setVisible(false);
        }catch (IOException e){
            e.printStackTrace();
        }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        try{
            enviado = new DataOutputStream(servidor.getOutputStream());
            enviado.writeUTF(this.jComboBox1.getSelectedItem().toString());
            // Recibimos el tamaño del fichero por parte del servidor
            recibido = new DataInputStream(servidor.getInputStream());
            int tamFichero = (int) recibido.readInt();
            FileOutputStream path = new FileOutputStream(PATH+this.jComboBox1.getSelectedItem().toString());
            BufferedOutputStream escritura = new BufferedOutputStream(path);
            BufferedInputStream lectura = new BufferedInputStream(servidor.getInputStream());
            byte [] bufferFichero = new byte [tamFichero];
            // Leemos los ficheros
            for (int i = 0; i < bufferFichero.length; i++) {
                bufferFichero [i] = (byte) lectura.read();
            }// end for
            //Persistimos el ficheros
            escritura.write(bufferFichero);
            escritura.flush();
            lectura.close();
            escritura.close();
            JOptionPane.showMessageDialog(null, "Fichero descargado con éxito");
        }catch(IOException e){
            e.printStackTrace();
        }
        this.jButton4.setVisible(false);
        this.jComboBox1.removeAllItems();
        this.jButton1.setVisible(true);
        this.jLabel1.setVisible(false);
        this.jButton3.setVisible(true);
            

         
            
       
    }//GEN-LAST:event_jButton4ActionPerformed
        File clienteDirectorio = null;
        File [] listaCliente = null;
        
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.jLabel1.setVisible(true);
        this.jLabel1.setText("Ficheros en el cliente");
        this.jButton1.setVisible(false);
        this.jButton5.setVisible(true);
        this.jButton3.setVisible(false);
        this.jComboBox1.setVisible(true);
        clienteDirectorio = new File(PATH);
        listaCliente = clienteDirectorio.listFiles();
        for(int i = 0; i < listaCliente.length; i++){
            this.jComboBox1.addItem(listaCliente[i].getName());
        }// end for
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            // Nos conectamos al servidor
            local = InetAddress.getLocalHost();
            servidor = new Socket(local, PUERTO);
            servidor.setSoTimeout(4000);
            // Envíamos el flag
            enviado = new DataOutputStream(servidor.getOutputStream());
            enviado.writeInt(1);
            // Enviamos el nombre del fichero
            enviado = new DataOutputStream(servidor.getOutputStream());
            enviado.writeUTF(this.jComboBox1.getSelectedItem().toString());
            // Enviamos el tamaño del fichero
            enviado = new DataOutputStream(servidor.getOutputStream());
            File ficheroEnviar = new File(PATH+this.jComboBox1.getSelectedItem().toString());
            enviado.writeInt((int)ficheroEnviar.length());
            // Streams para enviar los datos
            FileInputStream lectura = new FileInputStream(ficheroEnviar);
            BufferedInputStream bufferEntrada = new BufferedInputStream(lectura);
            BufferedOutputStream bufferSalida = new BufferedOutputStream(servidor.getOutputStream());
            byte [] bufferFichero = new byte [(int) ficheroEnviar.length()];
            bufferEntrada.read(bufferFichero);
            // Recorremos el array y lo enviamos
            for (int i = 0; i < bufferFichero.length; i++) {
                
                bufferSalida.write(bufferFichero[i]);
                
            }// end for
            // Cerramos los flujos
            lectura.close();
            bufferEntrada.close();
            bufferSalida.close();

        } catch (IOException e) {
        }
        this.jLabel1.setVisible(false);
        this.jButton5.setVisible(false);
        this.jButton1.setVisible(true);
        this.jButton3.setVisible(true);
        this.jComboBox1.removeAllItems();
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
