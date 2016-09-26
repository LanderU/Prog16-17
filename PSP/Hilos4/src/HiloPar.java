/**
 * 
 * @author Lander
 *
 */

public class HiloPar implements Runnable{
	
	private String nomHilo;
	
	public HiloPar(String nombre){
		this.nomHilo = nombre;
		
	}// end constructor

	@Override
	public void run() {
		
		for (int i = 2; i <= 100; i+=2) {
			
			System.out.println("Hilo "+nomHilo+", valor: "+i);
			
		}// end for
	}// end run

}// class
