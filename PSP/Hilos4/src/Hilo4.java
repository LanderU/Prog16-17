/**
 * 
 * @author Lander
 *
 */
public class Hilo4 {

	public static void main(String[] args) {
		Thread h1 = new Thread(new Hilo("Impar"));
		Thread h2 = new Thread(new HiloPar("Par"));
		h1.setPriority(10);
		h1.start();
		h2.start();

	}// main

}// class
