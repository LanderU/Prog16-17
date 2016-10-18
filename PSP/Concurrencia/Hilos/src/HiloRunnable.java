
public class HiloRunnable implements Runnable{
	private int id;
	
	public HiloRunnable(int id){
		this.id = id;	
	}// end constructor

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Hilo Runnable: "+ id);
		
	}

}// end class
