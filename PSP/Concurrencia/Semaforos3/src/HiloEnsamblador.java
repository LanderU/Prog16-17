/**
 * 
 * @author Lander
 *
 */
public class HiloEnsamblador extends Thread{
	
	private Pipe tuberia;

	public HiloEnsamblador(Pipe p){
		
		this.tuberia = p;
	}
	@Override
	public void run(){
		while (true)
			tuberia.componerJarsey();	
	}

}// class
