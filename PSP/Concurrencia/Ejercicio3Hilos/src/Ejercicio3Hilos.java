
public class Ejercicio3Hilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Thread a = new Thread(new Hilo("prueba"));
		Thread b = new Thread(new Hilo("otro"));
		Thread c = new Thread(new Hilo("kk"));
		
		a.start();
		b.start();
		c.start();

	}//main

}//class
