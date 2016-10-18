/**
 * 
 * @author Lander
 *
 */
public class HiloSincro implements Runnable{
	
	PipeSincro sinc = new PipeSincro();

	@Override
	public void run() {
		
		PipeSincro.Aumentar();
		
	}// end run

}// class
