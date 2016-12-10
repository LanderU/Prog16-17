/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servercertificados;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

/**
 *
 * @author lander
 */
public class ServerCertificados {

    /**
     * @param args the command line arguments
     */
    private static final int PUERTO = 5555;
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // TODO code application logic here
        ServerSocket servidor = new ServerSocket(PUERTO);
        Socket cliente;
        Hilo h = null;
       
        while(true){
            System.out.println("Esperando una conexión...");
            cliente = servidor.accept();
            h = new Hilo(cliente);
            h.start();
        }// end while
    }// main
    
}// class
