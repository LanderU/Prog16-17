/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorclaveasimetricas;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;

/**
 *
 * @author lander
 */
public class Cliente {
    
    private static final int PUERTO = 5656;
    
    public static void main(String[] args) {
        InetAddress local = null;
        Socket server = null;
        try {
            local = InetAddress.getLocalHost();
            server = new Socket(local,PUERTO);
            // Generamos el par de claves para el cliente
            KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
            KeyPair claves = generador.generateKeyPair();
            Cipher rsa = Cipher.getInstance("RSA");
            rsa.init(Cipher.DECRYPT_MODE, claves.getPrivate());
            //byte [] textoPlano = "Hola Lander".getBytes();
            //byte [] encriptado = rsa.doFinal(textoPlano);
            ObjectOutputStream envio = new ObjectOutputStream(server.getOutputStream());
            // Enviamos la clave
            envio.writeObject(claves.getPublic());
            // Envío de la información
            //envio.writeObject(encriptado);
            ObjectInputStream recibido = new ObjectInputStream(server.getInputStream());
            byte [] encriptado = (byte [])recibido.readObject();
            byte [] desencriptado = rsa.doFinal(encriptado);
            System.out.println("Desencriptado: "+new String(desencriptado));
            recibido.close();
            envio.close();
            server.close();
        } catch (Exception e) {
        }
        
    }// main
    
}// class
