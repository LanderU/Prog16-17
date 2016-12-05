/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorclaveasimetricas;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author lander
 */
public class ServidorClaveAsimetricas {

    /**
     * @param args the command line arguments
     */
    
    private static final int PUERTO = 5656;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // TODO code application logic here
        ServerSocket servidor = null;
        Socket cliente = null;
        
        try {
            servidor = new ServerSocket(PUERTO);
            
        } catch (IOException e) {
        }
        
        while (true){
            System.out.println("Esperando una conexión entrante...");
            cliente = servidor.accept();
            System.out.println("Conexión aceptada desde: "+cliente.getInetAddress());
            // Recibimos la clave pública
            ObjectInputStream recibido = new ObjectInputStream(cliente.getInputStream());
            Key publicKey = (Key) recibido.readObject();
            Cipher rsa = Cipher.getInstance("RSA");
            rsa.init(Cipher.ENCRYPT_MODE, publicKey);
            byte [] textoPlano = "Hola Lander".getBytes();
            byte [] encriptado = rsa.doFinal(textoPlano);
            ObjectOutputStream envio = new ObjectOutputStream(cliente.getOutputStream());
            envio.writeObject(encriptado);
        }// end while
        
    }// main
    
}// class
