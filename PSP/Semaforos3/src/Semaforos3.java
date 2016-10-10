import java.util.concurrent.Semaphore;

/**
 * 
 * @author Lander
 *
 */
public class Semaforos3 {
	
	public static int cestaMangas = 10;
	public static int cestaCuerpo = 5;

	public static void main(String[] args) {
		
		/*
			Tenemos un taller de costura , dedicado a hacer jerséis. 
			En su interior tenemos a tres personas trabajando de sol a sol. 
			Una persona está continuamente fabricando mangas, que va depositando en un cesto. 
			El cesto tiene una capacidad limitada: cuando se llena, la costurera deja de coser más mangas hasta que hay hueco libre. 
			Otra persona está continuamente fabricando los cuerpos de los jerséis, que también deposita en su correspondiente cesta de capacidad limitada. 
			Una tercera persona se encarga continuamente de ensamblar jerséis, cogiendo en cada caso dos mangas de la cesta de mangas y un cuerpo de la cesta de cuerpos. 
			Se trata de escribir el código que sincronice a estas tres personas, de forma que las dos primeras personas no avancen si su cesta está llena, y que la tercera persona no avance si le faltan piezas para hacer un nuevo jersey.
			 Se supone que las capacidades de las dos cestas son constantes y distintas.Termina el programa pulsando return en el hilo principal.
		*/
		
		// Semaforos
		Semaphore semaforoMangas = new Semaphore(2);
		Semaphore semaforoCuerpo = new Semaphore(2);
		
		Pipe intermedio = new Pipe(cestaMangas,cestaCuerpo,semaforoMangas,semaforoCuerpo);
		
		HiloMangas hM = new HiloMangas(intermedio);
		HiloCuerpo hC = new HiloCuerpo(intermedio);
		HiloEnsamblador hE = new HiloEnsamblador(intermedio);
	
			
		hM.start();
		hC.start();
		hE.start();
				
		
	}// main

}// class
