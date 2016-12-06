package serverclavesimetrica;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lander
 */
public class Cliente {
    
        
      private static final int PUERTO = 5555; 
      public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // TODO code application logic here
        InetAddress local = null;
        Socket servidor = null;
        try{
              local = InetAddress.getLocalHost();
              servidor = new Socket(local,PUERTO);
              // Generamos la clave
              KeyGenerator generador = KeyGenerator.getInstance("AES");
              SecretKey clave = generador.generateKey();
              // Preparamos el envío
              ObjectOutputStream envio = new ObjectOutputStream(servidor.getOutputStream());
              // Envíamos la clave
              envio.writeObject(clave);
              // Encriptamos el mensaje
              Cipher aesCipher = Cipher.getInstance("AES");
              aesCipher.init(Cipher.ENCRYPT_MODE, clave);
              byte [] textoPlano = "Hola Eider".getBytes();
              byte [] cifrado = aesCipher.doFinal(textoPlano);
              envio.writeObject(cifrado);
              //aesCipher.init(Cipher.DECRYPT_MODE, clave);
              //byte [] desencriptado = aesCipher.doFinal(cifrado);
              //System.out.println(new String(desencriptado));
              // Enviamos el mensaje
              //envio.writeObject(mensajeCifrado);
              envio.close();
              servidor.close();
        }catch(Exception e){
        
        }
        
    }// main
    
}// class
