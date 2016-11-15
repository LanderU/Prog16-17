package servidorFTP;

import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

import org.omg.CORBA.DataOutputStream;

/**
 * 
 * @author Lander
 *
 */

public class Cliente {
	
	private static final int PUERTO = 6300;
	
	public static void main(String[] args) {
		
		// Declaración de los sockets
		InetAddress local = null;
		Socket servidor = null;
		// Streams
		DataInputStream recibido = null;
		DataOutputStream enviado = null;
		try {
			local = InetAddress.getLocalHost();
			servidor = new Socket(local, PUERTO);
			// Nos quedamos con la cantidad de ficheros
			recibido = new DataInputStream(servidor.getInputStream());
			int cantidadFicheros = recibido.readInt();
			// Array para quedarnos con el nombre de los ficheros
			String [] nomFicheros = new String [cantidadFicheros];
			// Recorremos los ficheros y los guardamos en el array
			for (int i = 0; i < cantidadFicheros; i++) {
				recibido = new DataInputStream(servidor.getInputStream());
				nomFicheros[i] = recibido.readUTF();
			}// end for
			System.out.println("Seleccione un fichero de la lista para descargar: ");
			for (int i = 0; i < nomFicheros.length; i++) {
				System.out.println(i+1+"Nombre del fichero: "+nomFicheros[i]);
			}
			try {
				int opcion = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número del fichero"));
			} catch (NumberFormatException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Número inválido");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		

	}// main

}// class
