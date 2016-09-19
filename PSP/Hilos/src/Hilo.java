
public class Hilo extends Thread{
	
	public int id;
	
	public Hilo(int id) {
		this.id = id;
	}// end Constructor

	@Override
	public void run() {
		
		System.out.println("Lanzamiento del hilo: "+ id);
				
	}// end run
	
	

}// end class
