import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Lander
 *
 */
public class Server {
	
	static final int PORT = 5000;

	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket client = null;
		try {
			server = new ServerSocket(PORT);
			do {	
				System.out.println("Esperando una conexión");
				Thread.sleep(1000);
				client = server.accept();
				System.out.println("Conectado");
				DataInputStream recibido = new DataInputStream(client.getInputStream());
				String vuelta = recibido.readUTF().toUpperCase();
				System.out.println(vuelta);
				DataOutputStream enviar = new DataOutputStream(client.getOutputStream());
				enviar.writeUTF(vuelta);
				enviar.flush();
				enviar.close();
				recibido.close();
				client.close();
				server.close();
			} while (true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}// main

}// class
