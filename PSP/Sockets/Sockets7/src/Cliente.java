import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 
 * @author Lander
 *
 */
public class Cliente {
	
	private static final int PUERTO = 5000;
	private static final String CANAL = "230.0.0.1";

	public static void main(String[] args) throws IOException {
		MulticastSocket escucha = new MulticastSocket(PUERTO);
		byte [] datos = new byte [1024];
		DatagramPacket paquete = null;
		escucha.joinGroup(InetAddress.getByName(CANAL));
		String output = "";
		while (true){
			paquete = new DatagramPacket(datos, datos.length);
			escucha.receive(paquete);
			datos = paquete.getData();
			output = new String(datos);
			System.out.println(output);
		}// end while
		
	}// main

}// class
