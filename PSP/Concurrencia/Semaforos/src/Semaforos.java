/**
 * 
 * @author Lander
 *
 */
public class Semaforos {

	public static void main(String[] args) {
		
		HiloIncremento h1 = new HiloIncremento(2);
		HiloDecremento h2 = new HiloDecremento(1);
		h1.start();
		h2.start();
	}//main

}//class
