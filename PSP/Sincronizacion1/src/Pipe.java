/**
 * 
 * @author Lander
 *
 */

public class Pipe {
	
	public static int num;
	
	public static synchronized void Sumar(){
		
		for (int i = 0; i < 10; i++) {
			num++;
			System.out.println("Thread "+Thread.currentThread().getName()+" el valor de la variable es: "+num);
		}// end for
		
		
	}// end Sumar

	

}//class
