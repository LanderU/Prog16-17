import java.util.concurrent.Semaphore;

public class ClaseIntermedia {
	
	public static int total = 0;
	Semaphore s = new Semaphore(1);
	
	public void Incrementar(int incremento){
		System.out.println("Valor previo a sumar: "+total);
		try {
			// Comprobamos si se puede
			s.acquire();
			total += incremento;
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("Despúes de sumar: "+total);
		// Liberamos el semáforo
		s.release();
		
	}// end Incrementar
	
	public void Decrementar(int decremento){
		System.out.println("Valor previo a restar: "+total);
		try {
			// Comprobamos si se puede
			s.acquire();
			total -= decremento;
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("Despúes de restar: "+total);
		// Liberamos el semáforo
		s.release();
		
	}// end Incrementar

}// end class
