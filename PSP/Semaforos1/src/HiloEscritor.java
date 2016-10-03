/**
 * 
 * @author Lander
 *
 */
public class HiloEscritor extends Thread{
	Intermedia in = new Intermedia();
	
	@Override
	public void run(){
		
		try {
			in.Escribir();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}// end run
}// class
