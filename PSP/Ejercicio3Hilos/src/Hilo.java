
public class Hilo implements Runnable{
	
	private String label;
	
	public Hilo (String etiqueta){
		this.label = etiqueta;
		
	}// end constructor

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 5; i++ ){
			System.out.println("Lanzandose el hilo "+label+": "+i);	
		}//end for
		
	}

}// class
