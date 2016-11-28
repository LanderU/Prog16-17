/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverftpgui;

import java.io.IOException;

/**
 *
 * @author lander
 */
public class ServerFTPGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        VentanaCliente vCliente = new VentanaCliente();
        vCliente.setVisible(true);
    }// main
    
}// class
