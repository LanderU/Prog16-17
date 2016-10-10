/**
 * 
 * @author Lander
 *
 */
public class HiloCuerpo extends Thread{

	private Pipe tuberia;

	public HiloCuerpo(Pipe p){
		
		this.tuberia = p;
	}
	@Override
	public void run(){
		while (true)
			tuberia.hacerCuerpos();	
	}// end run
}// class
