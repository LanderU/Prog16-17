/**
 * 
 * @author Lander
 *
 */
public class Sincronizacion1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Thread h1 = new Thread(new Hilo());
		Thread h2 = new Thread(new Hilo());
		h1.setName("kk");
		h2.setName("jj");
		h1.start();
		h2.start();

	}// mains

}//class
