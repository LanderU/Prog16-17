/**
 * 
 * @author Lander
 *
 */
public class Hilos6 {

	public static void main(String[] args) throws InterruptedException {
		
		Thread [] hilos = new Thread[6];
		String [] nombres = {"a","b","c","d","e","f"};
		
		for (int i = 0; i < nombres.length; i++) {
			
			hilos[i] = new Thread(new Hilo(nombres[i]));
			hilos[i].start();
			hilos[i].join();
			
		}// end for
	}// main

}//class
