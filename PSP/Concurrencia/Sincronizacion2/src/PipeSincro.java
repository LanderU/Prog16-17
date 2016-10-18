/**
 * 
 * @author Lander
 *
 */
public class PipeSincro {
	
	public static int num;
	
	public static synchronized void Aumentar(){
				
		for (int i = 0; i < 10; i++) {
			
			System.out.println("Nombre del hílo "+Thread.currentThread().getName()+" "+num);
			
			num++;
			
		}// end for
		
		
	}// end Aumentar
}//class
