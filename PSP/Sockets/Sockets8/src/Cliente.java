import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
	
	private static final int PORT = 9100;

	public static void main(String[] args) {
		Multiplicar multiCliente = new Multiplicar();
		InetAddress local = null;
		Socket servidor = null;
		ObjectOutputStream salidaDato = null;
		ObjectInputStream entradaDato = null;
		int resultado = 0;
		
		try {
			
			local = InetAddress.getLocalHost();
			servidor = new Socket(local, PORT);
			entradaDato = new ObjectInputStream(servidor.getInputStream());
			multiCliente = (Multiplicar)entradaDato.readObject();
			resultado = multiCliente.getM1() * multiCliente.getM2();
			multiCliente.setResultado(resultado);
			salidaDato = new ObjectOutputStream(servidor.getOutputStream());
			salidaDato.writeObject((Multiplicar)multiCliente);
			// Cerramos los flujos
			salidaDato.close();
			entradaDato.close();
			servidor.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}

	}// main 

}// class
