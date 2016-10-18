
public class Hilo extends Thread{
	
	Intermedia i = new Intermedia();
	
	@Override
	public void run(){
		try {
			i.Leer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end run

	
}// end Class
