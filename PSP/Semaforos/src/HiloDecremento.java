
public class HiloDecremento extends Thread{
	
	private int n;
	
	ClaseIntermedia c = new ClaseIntermedia();
	
	public HiloDecremento(int decremento){
		
		this.n= decremento;
		
	}// end Constructor
	
	@Override
	public void run(){
		
		c.Decrementar(n);
		
	}// end run


}// end class
