import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 
 * @author Lander
 *
 */
public class Client {
	
	static final int PORT = 5000;

	public static void main(String[] args) {
		byte [] buffer = new byte [1024];
		DatagramSocket socket;
		try {
			socket = new DatagramSocket();
			InetAddress dir = InetAddress.getLocalHost();
			DatagramPacket paquete = new DatagramPacket(buffer, buffer.length,dir,PORT);
			socket.send(paquete);
			paquete = new DatagramPacket(buffer, buffer.length);
			socket.receive(paquete);
			System.out.println(new String(paquete.getData()));
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		socket.close();
	}// main

}// class
