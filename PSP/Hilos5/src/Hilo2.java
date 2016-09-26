
public class Hilo2 implements Runnable{
	
	private String nom;
	
	public Hilo2(String nombre){
		this.nom = nombre;
		
	}// end constructor

	@Override
	public void run() {
		Thread.currentThread().setPriority(1);
		for (int i = 0; i < 4; i++) {
			
			System.out.print(this.nom+" ");
			Thread.currentThread().yield();
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}// end for		
	}// end run

}//class
