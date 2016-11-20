package servidorFTP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

import javax.swing.JOptionPane;

/**
 * @author Lander
 */

public class Servidor {
	
	private static final int PUERTO = 6300;
	private static final String PATH = "/home/lander/FTP/";
	
	public static void main(String[] args) throws IOException {
		// Creamos el server socket
		ServerSocket servidor = new ServerSocket(PUERTO);
		// Creamos el socket de parte del cliente
		Socket cliente = null;
		// Ruta de los ficheros en el servidor
		File directorioFicheros = new File(PATH);
		if (!directorioFicheros.exists()){
			JOptionPane.showMessageDialog(null, "Cambie la constante PATH en el servidor");
			System.exit(0);
		}
		// Array de ficheros/carpetas contenidos en el directorio
		File [] listaFicheros = directorioFicheros.listFiles();
		// Streams
		DataOutputStream envio = null;
		DataInputStream recibido = null;
		String nomFichero = "";
		BufferedOutputStream bufferSalida = null;
		BufferedInputStream bufferEntrada = null;
		byte [] bufferLeido = null;
		
		while(true){
			cliente = servidor.accept();
			System.out.println("Conexión aceptada desde: "+ cliente.getInetAddress());
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
			File ficheroEnviar = new File(PATH+nomFichero);
			envio = new DataOutputStream(cliente.getOutputStream());
			// Enviamos el tamaño
			envio.writeInt((int)ficheroEnviar.length());
			// Preparamos los streams para el envío de los datos
			FileInputStream lectura = new FileInputStream(ficheroEnviar);
			bufferEntrada = new BufferedInputStream(lectura);
			bufferSalida = new BufferedOutputStream(cliente.getOutputStream());
			// Buffer de bytes leídos desde el fichero
			bufferLeido = new byte [(int) ficheroEnviar.length()];
			// Introducimos el contenido del fichero en el array
			bufferEntrada.read(bufferLeido);
			
			// Recorremos el array de bytes y lo enviamos
			for (int i = 0; i < bufferLeido.length; i++) {
				
				bufferSalida.write(bufferLeido [i]);
				
			}// end for
			
			// Cerramos los streams
			bufferSalida.close();
			bufferEntrada.close();
			
		}// end while
		
	}// main

}// class
