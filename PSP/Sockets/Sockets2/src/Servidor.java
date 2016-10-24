import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Lander
 *
 */
public class Servidor {
	
	public static final int PORT = 5000;

	public static void main(String[] args) {
		ServerSocket owner = null;
		Socket cliente = null;
		int numCliente = 0;
		try {
			owner = new ServerSocket(PORT);
			System.out.println("Socket abierto");
			do {
				numCliente++;
				// Aceptamos la conexión
				cliente = owner.accept();
				PrintStream dato = new PrintStream(cliente.getOutputStream());
				dato.print("Eres mi cliente número: "+numCliente);
				// Cerramos el Stream
				dato.close();
				// Cerramos el socket
				cliente.close();	
			} while (true);
			
		} catch (Exception e) {
			System.out.println("Error");
		}// end try
		
	}// main

}// class
