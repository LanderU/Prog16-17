/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverclavesimetrica;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author lander
 */
public class Hilo extends Thread {

    private Socket cliente = null;

    public Hilo(Socket h) {
        cliente = h;
    }// end constructor

    @Override
    public void run() {
        // Recibimos el key
        ObjectInputStream recibido = null;

        try {
            recibido = new ObjectInputStream(cliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        Key key = null;

        try {
            key = (Key) recibido.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] textoCifrado = null;
        try {
            textoCifrado = (byte[]) recibido.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Mensaje cifrado: " + new String(textoCifrado));
        // Desencriptamos el mensaje
        Cipher aesCipher = null;

        try {
            aesCipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            aesCipher.init(Cipher.DECRYPT_MODE, key);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        String descifrado = "";
        try {
            descifrado = new String(aesCipher.doFinal(textoCifrado));
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Mensaje descrifrado: " + descifrado);
        try {
            recibido.close();
            cliente.close();
        } catch (Exception e) {
        }

    }// end run

}// class
