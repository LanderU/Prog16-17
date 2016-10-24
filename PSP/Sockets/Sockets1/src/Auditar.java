import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 * @author Lander
 *
 */
public class Auditar{

	public static void main(String[] args) {

		try {
			// Local
			InetAddress local = InetAddress.getLocalHost();
			System.out.println(local);
			// Google
			InetAddress[] google = InetAddress.getAllByName("www.google.es");
			for (int i = 0; i < google.length; i++) {
				System.out.println(google[i]);
			}
			
		} catch (UnknownHostException e) {
			// TODO: handle exception
			System.out.println("Error en la dirección.");
		}

	}// main

}// class
