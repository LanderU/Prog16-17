/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servercertificados;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

/**
 *
 * @author lander
 */
public class Cliente {
    
    private static final int PUERTO = 5555;
    
    public static void main(String[] args) {
        // TODO code application logic here
        InetAddress local = null;
        Socket server = null;
        ObjectOutputStream envio = null;
        
        try {
            local = InetAddress.getLocalHost();
            server = new Socket(local,PUERTO);
            KeyPairGenerator generador = KeyPairGenerator.getInstance("DSA");
            KeyPair clave = generador.generateKeyPair();
            Signature firma = Signature.getInstance("DSA");
            firma.initSign(clave.getPrivate());
            // Enviamos la clave pública
            envio = new ObjectOutputStream(server.getOutputStream());
            envio.writeObject(clave.getPublic());
            byte [] mensaje = "Hola Lander".getBytes();
            // Enviamos el mensaje
            envio.writeObject(mensaje);
            // Rompemos el mensaje
            //envio.writeObject("kk".getBytes());
            firma.update(mensaje);
            byte [] certificado = firma.sign();
            // Enviamos el certificado
            envio.writeObject(certificado);
            envio.close();
            server.close();  
        } catch (Exception e) {
        }
    }  // main 
    
}// class
