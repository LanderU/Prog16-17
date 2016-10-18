/**
 * 
 * @author Lander
 *
 */
public class Hilo implements Runnable{
	
	private String nombre;
	
	public Hilo(String nom){
		
		this.nombre= nom;
		
	}// end constructor

	@Override
	public void run() {
		System.out.println("Hola mundo desde el hilo: "+this.nombre);
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}//class
