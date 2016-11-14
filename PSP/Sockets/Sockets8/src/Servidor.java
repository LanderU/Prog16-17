import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Servidor {
	
	private static final int PUERTO = 9100;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//Objeto
		Multiplicar multi = new Multiplicar();
		// Streams
		ObjectOutputStream objetoSalida = null;
		ObjectInputStream objetoEntrada = null;
		// Preparamos el objeto para enviar
		multi.setM1(5);
		multi.setM2(2);
		// Declaración de los sockets
		ServerSocket servidor = null;
		Socket cliente = null;
		
		servidor = new ServerSocket(PUERTO);
		cliente = servidor.accept();
		System.out.println("Conexión aceptada");
		objetoSalida = new ObjectOutputStream(cliente.getOutputStream());
		objetoSalida.writeObject(multi);
		
		objetoEntrada = new ObjectInputStream(cliente.getInputStream());
		multi = (Multiplicar) objetoEntrada.readObject();
		JOptionPane.showMessageDialog(null, "El reulstado es: "+ multi.getResultado());
		// Cerramos el stream
		objetoEntrada.close();
		// cerramos el stream
		objetoSalida.close();
		
		// cerramos los sockets
		cliente.close();
		servidor.close();
		

	}// main

}// class
