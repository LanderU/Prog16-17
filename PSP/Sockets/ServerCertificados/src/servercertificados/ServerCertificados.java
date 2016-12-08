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
        ObjectInputStream recibido = null;
        Signature certificado = Signature.getInstance("DSA");
       
        while(true){
            System.out.println("Esperando una conexión...");
            cliente = servidor.accept();
            // Recibimos el key
            recibido = new ObjectInputStream(cliente.getInputStream());
            Key clave = (Key) recibido.readObject();
            // Recibimos el mansaje
            byte [] mensaje = (byte [])recibido.readObject();
            System.out.println("El mensaje recibido es: "+new String(mensaje));
            // Recibimos la firma
            byte [] firma = (byte []) recibido.readObject();
            // Comprobamos
            certificado.initVerify((PublicKey) clave);
            certificado.update(mensaje);
            if(certificado.verify(firma)){
                System.out.println("Mensaje correcto");
            }else{
                System.out.println("Algo ha pasado");
            }
            
            
            
        
        }// end while
    }// main
    
}// class
