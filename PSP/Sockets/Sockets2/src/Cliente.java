import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 
 * @author Lander
 *
 */
public class Cliente {
	
	public static final int PORT = 5000;

	public static void main(String[] args) {
		// Dirección local
		InetAddress direccion;
		Socket servidor;
		try {
			direccion = InetAddress.getLocalHost();
			servidor = new Socket(direccion, PORT);
			BufferedReader datos = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
			System.out.println(datos.readLine());
			// Cerramos el flujo
			datos.close();
			// Cerramos el socket
			servidor.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}// main

}// class
