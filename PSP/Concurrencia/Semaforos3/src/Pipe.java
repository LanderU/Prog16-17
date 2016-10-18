import java.util.concurrent.Semaphore;

/**
 * 
 * @author Lander
 *
 */
public class Pipe {
	
	private int cMangas;
	private int cCuerpos;
	private Semaphore semaforo1;
	private Semaphore semaforo2;
	private static int totalMangas = 0;
	private static int totalCuerpos = 0;
	
	public Pipe(int cestaMangas, int cestaCuerpos, Semaphore s1, Semaphore s2){
		this.cMangas = cestaMangas;
		this.cCuerpos = cestaCuerpos;
		this.semaforo1 = s1;
		this.semaforo2 = s2;
	}
	
	public void hacerMangas(){
		
		if(totalMangas < cMangas){
			
			try {
				semaforo1.acquire();
				totalMangas +=2;
				System.out.println("Haciendo dos mangas");
			} catch (Exception e) {
				// TODO: handle exception
			}
			semaforo1.release();
		}
		
	}// end hacerMangas
	
	public void hacerCuerpos(){
		
		if (totalCuerpos < cCuerpos){
			try {
				semaforo2.acquire();
				totalCuerpos += 1;
				System.out.println("Haciendo un cuerpo");
			} catch (Exception e) {
				// TODO: handle exception
			}
			semaforo2.release();
		}
	}// end hacerCuerpos
	
	public void componerJarsey(){
		try {
			if (totalCuerpos > 1 && totalMangas >2){
				
				semaforo1.acquire();
				semaforo2.acquire();
				totalMangas -= 2;
				totalCuerpos -= 1;	
				System.out.println("Componiendo el jersey");
			}

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		semaforo1.release();
		semaforo2.release();
	}// end componerJarsey

}//class
