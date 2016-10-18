import java.util.concurrent.Semaphore;

/**
 * 
 * @author Lander
 *
 */
public class Intermedia {
	
	Semaphore s = new Semaphore(10);
	
	public void Leer() throws InterruptedException{
		System.out.println("Intentando leer.");
		s.acquire(1);
		System.out.println("Leído");
		s.release();
	}// end Leer
	
	public void Escribir() throws InterruptedException{
		
		System.out.println("Intentando escribir.");
		s.acquire(10);
		System.out.println("Escrito");
		s.release(10);
	}// enc Escribir

}//class
