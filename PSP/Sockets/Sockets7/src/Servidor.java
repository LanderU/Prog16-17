import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JOptionPane;

/**
 * 
 * @author Lander
 *
 */
public class Servidor {
	
	private static final int PUERTO = 5000;
	private static final String CANAL = "230.0.0.1";

	public static void main(String[] args) throws IOException {
		
		MulticastSocket server = new MulticastSocket();
		byte [] mensaje = new byte [1024];
		String lectura = JOptionPane.showInputDialog("Mensaje a enviar");
		// Convertimos a bytes
		mensaje = lectura.getBytes();
		DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length,InetAddress.getByName(CANAL),PUERTO);
		server.send(envio);
		
	} // main

} //class
