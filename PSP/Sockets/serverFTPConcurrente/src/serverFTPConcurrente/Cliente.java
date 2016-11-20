package serverFTPConcurrente;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.swing.JOptionPane;

/**
 * 
 * @author Lander
 *
 */

public class Cliente {

	private static final int PUERTO = 6666;

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
			servidor.setSoTimeout(4000);
			// Nos quedamos con la cantidad de ficheros
			recibido = new DataInputStream(servidor.getInputStream());
			int cantidadFicheros = recibido.readInt();
			// Array para quedarnos con el nombre de los ficheros
			String [] nomFicheros = new String [cantidadFicheros];
			// Recorremos los ficheros y los guardamos en el array
			for (int i = 0; i < cantidadFicheros; i++) {
				recibido = new DataInputStream(servidor.getInputStream());
				nomFicheros[i] = recibido.readUTF().toString();
			}// end for
			System.out.println("Seleccione un fichero de la lista para descargar: ");
			for (int i = 0; i < nomFicheros.length; i++) {
				System.out.println(i+1+"- Nombre del fichero: "+nomFicheros[i]);
			}
			try {
				int opcion = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número del fichero"));
				// Nos quedamos con el nombre de la posición en el array
				if (opcion <= 0){
					JOptionPane.showMessageDialog(null, "El número no puede ser menor o igual a 0");
				}else{
					String nomFichero = nomFicheros[opcion-1];
					System.out.println(nomFichero);
					enviado = new DataOutputStream(servidor.getOutputStream());
					enviado.writeUTF(nomFichero);
					// Recibimos el tamaño del fichero por parte del servidor
					recibido = new DataInputStream(servidor.getInputStream());
					int tamFichero = (int) recibido.readInt();
					FileOutputStream path = new FileOutputStream(nomFichero);
					BufferedOutputStream escritura = new BufferedOutputStream(path);
					BufferedInputStream lectura = new BufferedInputStream(servidor.getInputStream());
					byte [] bufferFichero = new byte [tamFichero];
					// Leemos los ficheros
					for (int i = 0; i < bufferFichero.length; i++) {
						bufferFichero [i] = (byte) lectura.read();
						
					}// end for
					
					//Persistimos el ficheros
					escritura.write(bufferFichero);
					// Cerramos los flujos
					escritura.flush();
					lectura.close();
					escritura.close();
					servidor.close();
					JOptionPane.showMessageDialog(null, "Fichero guardado");
					
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Número inválido");
			}
			
		} catch (SocketTimeoutException e) {
			// Controlamos la excepción el tiempo del socket
			JOptionPane.showMessageDialog(null, "Tiempo del socket expirado");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		


	}// main

}// class
