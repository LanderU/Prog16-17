/**
 * 
 * @author Lander
 *
 */
public class Hilo implements Runnable{
	
	Pipe tuberia = new Pipe();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		tuberia.Sumar();
		
	}// end run

}//class
