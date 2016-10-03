/**
 * 
 * @author Lander
 *
 */
public class Hilo extends Thread{
	
	private int n;
	
	Caja c = new Caja();
	
	public Hilo(int cantidad){
		
		this.n= cantidad;
		
	}// end constructor
	
	@Override
	public void run(){
		
		c.Restar(n);
		
	}// end run

}// class
