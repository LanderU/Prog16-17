import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Lander
 *
 */
public class Server {
	
	static final int PORT = 5000;
	public static void main(String[] args) throws IOException {
		ServerSocket owner = new ServerSocket(PORT);
		Socket client;
		try {
			client = owner.accept();
			PrintStream aceptacion = new PrintStream(client.getOutputStream());
			aceptacion.print("Conexión aceptada");
			System.out.println("Mandado el primer mensaje");
			// Recibimos el mensaje del cliente
			DataInputStream mensajeCliente = new DataInputStream(client.getInputStream());
			System.out.println(mensajeCliente.readUTF());
			System.out.println("Recibido el mensaje");
			DataOutputStream segundoMensaje = new DataOutputStream(client.getOutputStream());
			segundoMensaje.writeUTF("Segundo mensaje");
			System.out.println("Enviado el último mensaje.");
			// Cerramos los flujos
			aceptacion.close();
			mensajeCliente.close();
			segundoMensaje.close();
			client.close();
			owner.close();
		} catch (Exception e) {
			
		}finally{
			owner.close();
		}
	}// main

}// class
