import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JOptionPane;

/**
 * 
 * @author Lander
 *
 */
public class Cliente {
	
	static final int PUERTO = 8000;

	
	public static void main(String[] args) throws IOException {

		byte [] envio = new byte [1024];
		byte [] recibido = new byte [1024];
		
		DatagramSocket socket = null;
		InetAddress serverAddress = InetAddress.getLocalHost();
		DatagramPacket p = null;
		String dato = "";
		
		try {
			socket = new DatagramSocket();
			String mensaje = JOptionPane.showInputDialog("Texto a enviar");
			envio = mensaje.getBytes();
			// paquete de envio
			p  = new DatagramPacket(envio, envio.length,serverAddress, PUERTO);
			// enviamos el paquete
			socket.send(p);
			// recibimos la vuelta
			p = new DatagramPacket(recibido, recibido.length,serverAddress,PUERTO);
			socket.receive(p);
			recibido = p.getData();
			dato = new String (recibido);
			JOptionPane.showMessageDialog(null, "El servidor dice: "+ dato);
			socket.close();
		} catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Error IO");
		}
		socket.close();
	}// main

}// class
