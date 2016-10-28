import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 
 * @author Lander
 *
 */
public class Cliente {

	static final int PORT = 5000;
	
	public static void main(String[] args) {
		InetAddress local;
		Socket server;
		try {
			local = InetAddress.getLocalHost();
			server = new Socket(local, PORT);
			DataInputStream mensaje = new DataInputStream(server.getInputStream());
			System.out.println(mensaje.readUTF());
			System.out.println("Primer mensaje leído");
			// Mandamos el primer mensaje
			DataOutputStream mensajeServer = new DataOutputStream(server.getOutputStream());
			mensajeServer.writeUTF("Primer mensaje del cliente");
			DataInputStream mensaje2 = new DataInputStream(server.getInputStream());
			System.out.println(mensaje2.readUTF());
			// Cerramos
			mensaje.close();
			mensaje2.close();
			server.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}// main

}// class
