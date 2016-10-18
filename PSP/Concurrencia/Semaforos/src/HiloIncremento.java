
public class HiloIncremento extends Thread{
	
	private int n;
	
	ClaseIntermedia c = new ClaseIntermedia();
	
	public HiloIncremento(int incremento){
		
		this.n= incremento;
		
	}// end Constructor
	
	@Override
	public void run(){
		
		c.Incrementar(n);
		
	}// end run

}// end class
