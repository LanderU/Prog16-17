
public class MainHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hilos herencia thread");
		for (int i = 1; i <= 15 ; i++){
			Hilo h = new Hilo(i);
			h.start();	
		}// end for		
		System.out.println();
		System.out.println("Hilos Runnables");
		for (int i = 1; i <= 15 ; i++){
			HiloRunnable h = new HiloRunnable(i);
			Thread hilorun = new Thread(h);
			hilorun.start();	
		}// end for
	}// main

}//class
