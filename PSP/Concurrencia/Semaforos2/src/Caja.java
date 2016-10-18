import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

/**
 * 
 * @author Lander
 *
 */

public class Caja {
	
	private static int totalCaja = 15;
	
	public static Semaphore semaforo = new Semaphore(1);
	public static Semaphore s2 = new Semaphore(1);
	
	public void Restar(int cantidad) throws InterruptedException{
		
		if (cantidad > totalCaja || totalCaja == 0){
			
			JOptionPane.showMessageDialog(null, Thread.currentThread().getName()+" dice, que no hay m√°s cromos");
			 s2.acquire();
			Sumar();
			 s2.release();
		}else{
			try {
				semaforo.acquire();
				totalCaja -= cantidad;
			} catch (InterruptedException e) {
			}
			semaforo.release();
			// debug
			//System.out.println("Quedan "+totalCaja+" cromos para seguir cogiendo.");
						
		}
	}
	
	public void Sumar(){
		totalCaja = 15;
	}


}// class
