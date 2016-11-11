import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 
 * @author Lander
 *
 */
public class Servidor {

	static final int PUERTO = 8000;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		byte [] recibido = new byte [1024];
		byte [] envio = new byte [1024];
		DatagramSocket server = new DatagramSocket(PUERTO);
		DatagramPacket p = null;
		String vuelta ="";
		System.out.println("Escuchando");
		while(true){
			
			p = new DatagramPacket(recibido, recibido.length);
			//entrada de datos
			server.receive(p);
			System.out.println("Entrada desde la ip: "+p.getAddress());
			System.out.println("En el puerto: "+p.getPort());
			
			// preparamos el String para mandarlo de vuelta
			recibido = p.getData();
			vuelta = new String (recibido).toUpperCase();
			System.out.println(vuelta);
			envio = vuelta.getBytes();
			// Enviamos el paquete de vuelta
			p = new DatagramPacket(envio, envio.length, p.getAddress(),p.getPort());
			
			server.send(p);
			
		}// end 
		
		
	}// main

}// class
