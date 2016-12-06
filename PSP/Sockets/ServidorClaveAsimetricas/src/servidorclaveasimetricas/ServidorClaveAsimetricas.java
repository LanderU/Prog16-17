/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorclaveasimetricas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;


/**
 *
 * @author lander
 */
public class ServidorClaveAsimetricas {

    /**
     * @param args the command line arguments
     */
    
    private static final int PUERTO = 5656;
    
    public static void main(String[] args) throws IOException{
        ServerSocket servidor =  new ServerSocket(PUERTO);
        Socket cliente;
        
        while (true){
            System.out.println("Esperando una conexión entrante...");
            cliente = servidor.accept();
            System.out.println("Conexión aceptada desde: "+cliente.getInetAddress());
            Hilo h = new Hilo(cliente);
            h.start();
        }// end while
        
    }// main
    
}// class
