package serverFTPConcurrente;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Lander
 *
 */

public class Server {
	
	private static int PORT = 6666;
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(PORT);
		Socket cliente;
		
		for(;;){
			cliente = server.accept();
			ServerHilo hiloServer = new ServerHilo(cliente);
			hiloServer.start();
		}// end for
		
	}// main

}// class
