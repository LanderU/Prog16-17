import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * 
 * @author Lander
 *
 */
public class Client {
	static final int PORT = 5000;
	
	public static void main(String[] args) {
		
		String mensaje = JOptionPane.showInputDialog("Escriba el mensaje a enviar");
		Socket servidor = null;
		InetAddress dir = null;
		try {
			dir = InetAddress.getLocalHost();
			servidor = new Socket(dir, PORT);
			DataOutputStream dato = new DataOutputStream(servidor.getOutputStream());
			dato.writeUTF(mensaje);
			DataInputStream recibido = new DataInputStream(servidor.getInputStream());
			System.out.println("El servidor dice: "+recibido.readUTF());
			recibido.close();
			dato.close();
			servidor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}// main

}// class
