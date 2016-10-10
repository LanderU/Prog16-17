/**
 * 
 * @author Lander
 *
 */
public class HiloMangas extends Thread{
	
	private Pipe tuberia;

	public HiloMangas(Pipe p){
		
		this.tuberia = p;
	}
	@Override
	public void run(){
		while(true)
			tuberia.hacerMangas();
			
	}

}// class
