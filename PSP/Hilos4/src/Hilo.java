/**
 * 
 * @author Lander
 *
 */
public class Hilo implements Runnable{
	
	private String nomHilo;
	
	public Hilo(String nombre){
		this.nomHilo= nombre;
		
	}// end Constructor

	@Override
	public void run() {
		
		for (int i = 1; i <=100 ; i+=2) {
			
			System.out.println("Hilo"+nomHilo+", valor: "+i);
			
		}// end for
		
	}//end run

}//class
