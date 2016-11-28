/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverftpgui;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lander
 */
public class ServerHilo extends Thread {

    private Socket cliente = new Socket();
    private static final String PATH = "/home/lander/FTP/";

    // Constructor
    public ServerHilo(Socket cliente) {
        this.cliente = cliente;
    }// end constructor

    @Override
    public void run() {
        // Streams
        DataOutputStream envio = null;
        DataInputStream recibido = null;
        String nomFichero = "";
        BufferedOutputStream bufferSalida = null;
        BufferedInputStream bufferEntrada = null;
        File[] listaFicheros = null;
        File directorioFicheros = null;
        File ficheroEnviar = null;
        FileInputStream lectura = null;
        FileOutputStream ficheroGuardar = null;
        byte[] bufferLeido = null;

        // flag
        int flag = Integer.MIN_VALUE;
        do {

            try {
                // Recibimos el flag del usuario
                DataInputStream recFlag = new DataInputStream(cliente.getInputStream());
                flag = recFlag.readInt();
                System.out.println(flag);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (flag == 0) {
                // Descargamos del servidor
                try {
                    // Ruta de los ficheros en el servidor
                    directorioFicheros = new File(PATH);
                    if (!directorioFicheros.exists()) {
                        JOptionPane.showMessageDialog(null, "Cambie la constante PATH en el servidor");
                        System.exit(0);
                    }
                    // Array de ficheros/carpetas contenidos en el directorio
                    listaFicheros = directorioFicheros.listFiles();
                    // Enviamos al cliente la cantidad de ficheros que tenemos
                    envio = new DataOutputStream(cliente.getOutputStream());
                    envio.writeInt(listaFicheros.length);
                    // Le enviamos la lista
                    for (int i = 0; i < listaFicheros.length; i++) {
                        envio.writeUTF(listaFicheros[i].getName());
                    }// end for
                    // Recibimos por parte del cliente el nombre del fichero a descargar
                    recibido = new DataInputStream(cliente.getInputStream());
                    nomFichero = recibido.readUTF();
                    // Leemos los datos del arvhivo para poder recibirnos en el cliente
                    // debug
                    //System.out.println(nomFichero);
                    ficheroEnviar = new File(PATH + nomFichero);
                    envio = new DataOutputStream(cliente.getOutputStream());
                    // Enviamos el tamaño
                    envio.writeInt((int) ficheroEnviar.length());
                    // Preparamos los streams para el envío de los datos
                    lectura = new FileInputStream(ficheroEnviar);
                    bufferEntrada = new BufferedInputStream(lectura);
                    bufferSalida = new BufferedOutputStream(cliente.getOutputStream());
                    bufferLeido = new byte[(int) ficheroEnviar.length()];
                    lectura.read(bufferLeido);
                    envio.write(bufferLeido);
                    // Buffer de bytes leídos desde el fichero
                    
                    // Introducimos el contenido del fichero en el array
                    //bufferEntrada.read(bufferLeido);
                    // Recorremos el array de bytes y lo enviamos
                    //for (int i = 0; i < bufferLeido.length; i++) {
                    //    System.out.println("Aquí");
                    //    bufferSalida.write(bufferLeido[i]);

                    //}// end for
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            } else if (flag == 1) {
                // El servidor recibe el fichero

                try {
                    // Recibimos el nombre del fichero
                    recibido = new DataInputStream(cliente.getInputStream());
                    nomFichero = recibido.readUTF();
                    // Recibimos el tamaño del fichero
                    recibido = new DataInputStream(cliente.getInputStream());
                    int tamFichero = (int) recibido.readInt();
                    ficheroGuardar = new FileOutputStream(PATH + nomFichero);
                    bufferSalida = new BufferedOutputStream(ficheroGuardar);
                    bufferEntrada = new BufferedInputStream(cliente.getInputStream());
                    byte[] bufferFichero = new byte[tamFichero];
                    for (int i = 0; i < bufferFichero.length; i++) {
                        System.out.println("Me llega el byte");
                        bufferFichero[i] = (byte) bufferEntrada.read();
                    }// end for

                    // Persistimos el fichero
                    bufferSalida.write(bufferFichero);
                    System.out.println("Lo escribo");
                    bufferSalida.flush();
                    JOptionPane.showMessageDialog(null, "Fichero en el servidor");

                } catch (IOException e) {

                }
            }
            System.out.println(flag);
        } while (flag != -1);
        System.out.println("Muerto");
        try {
            if (envio != null) {
                envio.close();

            }
            if (recibido != null) {
                recibido.close();
            }
            if (bufferSalida != null) {
                bufferSalida.close();

            }

            if (bufferEntrada != null) {
                bufferEntrada.close();

            }

            if (lectura != null) {
                lectura.close();

            }

            if (ficheroGuardar != null) {
                ficheroGuardar.close();

            }
            cliente.close();

        } catch (IOException e) {
        }

    }// end run

}// class
