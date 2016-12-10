/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servercertificados;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lander
 */
public class Hilo extends Thread{
    
    private Socket cliente = null;
    private ObjectInputStream recibido = null;
   
    
   public Hilo(Socket s){
       
       cliente = s;
       
   }// end constructor 
   
   @Override
   public void run(){
       
        Signature certificado = null;
       
        try {
           certificado = Signature.getInstance("DSA");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            // Recibimos el key
            recibido = new ObjectInputStream(cliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
            Key clave = null;
        try {
            clave = (Key) recibido.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
            // Recibimos el mansaje
            byte [] mensaje = null;
        try {
            mensaje = (byte [])recibido.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("El mensaje recibido es: "+new String(mensaje));
            // Recibimos la firma
            byte [] firma = null;
        try {
            firma = (byte []) recibido.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // Comprobamos
            certificado.initVerify((PublicKey) clave);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            certificado.update(mensaje);
        } catch (SignatureException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(certificado.verify(firma)){
                System.out.println("Mensaje correcto");
            }else{
                System.out.println("Algo ha pasado");
            }
        } catch (SignatureException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
           recibido.close();
           cliente.close();
       } catch (Exception e) {
       }
   }// end run
    
}// class
