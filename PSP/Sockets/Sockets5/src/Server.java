import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * 
 * @author Lander
 *
 */
public class Server {
	
	static final int PUERTO = 5000;

	public static void main(String[] args) throws IOException {
		Date fecha = null;	
		
		byte [] mensaje = new byte [1024];
		// Creación del socket
		DatagramSocket servidor = new DatagramSocket(PUERTO);
		System.out.println("Servidor UDP escuchando");
		
		while (true) {
			// Paquete
			DatagramPacket recibido = new DatagramPacket(new byte [1024], 1024);
			
			// Entrada de datos
			servidor.receive(recibido);
			System.out.println("Petición del cliente con ip: "+recibido.getAddress());
			System.out.println("Petición del cliente en el puerto: "+recibido.getPort());
			System.out.println("Sirviendo la petición");
			
			fecha = new Date();
			
			String envio = fecha.toString();
			mensaje = envio.getBytes();
			
			// Composición del mensaje a enviar
			DatagramPacket p = new DatagramPacket(mensaje, mensaje.length,recibido.getAddress(),recibido.getPort());
			
			// Enviamos los datos
			servidor.send(p);
			
			
		}// end while
		
	}// main

}// class
