package servidorFTP;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Lander
 */

public class Servidor {
	
	private static final int PUERTO = 6300;
	
	public static void main(String[] args) throws IOException {
		// Creamos el server socket
		ServerSocket servidor = new ServerSocket(PUERTO);
		// Creamos el socket de parte del cliente
		Socket cliente = null;
		// Ruta de los ficheros en el servidor
		File directorioFicheros = new File("/home/lander/FTP");
		// Array de ficheros/carpetas contenidos en el directorio
		File [] listaFicheros = directorioFicheros.listFiles();
		// Streams
		DataOutputStream envio = null;
		DataInput recibido = null;
		
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
		}// end while
		
	}// main

}// class
