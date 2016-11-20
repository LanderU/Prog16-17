/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverftpgui;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author lander
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
