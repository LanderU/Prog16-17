/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverclavesimetrica;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.acl.Owner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author lander
 */
public class ServerClaveSimetrica {

    /**
     * @param args the command line arguments
     */
    private static final int PORT = 5555;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        
        ServerSocket owner = new ServerSocket(PORT);
        Socket cliente;
        
        while (true){
            System.out.println("Esperando una conexión entrante...");
            cliente = owner.accept();
            System.out.println("Conexión aceptada desde: "+cliente.getInetAddress());  
            Hilo h = new Hilo(cliente);
            h.start();
            
        }// end while
    }// main
    
}// class
