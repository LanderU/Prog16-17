
public class Semaforos1 {

	public static void main(String[] args) {
		Hilo [] hilos = new Hilo [10];
		HiloEscritor [] hilos2 = new HiloEscritor [3];
		
		for (int i = 0; i < hilos.length; i++) {
			hilos[i] = new Hilo();
			hilos[i].start();
			
		}// end for
		
		for (int i = 0; i < hilos2.length; i++) {
			hilos2[i] = new HiloEscritor();
			hilos2[i].start();
		}

	}// main

}// class
