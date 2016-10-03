import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

/**
 * 
 * @author Lander
 *
 */

public class Caja {
	
	private static int totalCaja = 15;
	Semaphore semaforo = new Semaphore(1);
	
	public void Restar(int cantidad){
		
		if (cantidad > totalCaja || totalCaja == 0){
			
			JOptionPane.showMessageDialog(null, Thread.currentThread().getName()+" dice, que no hay más cromos");
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


}// class
