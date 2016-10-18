
public class Hilo implements Runnable{
	
	private String texto;
	
	public Hilo (String t){
		this.texto = t;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Hilo lanzado");
		
		System.out.println("Has escrito: "+texto+ " y lo vamos a repetir 5 veces");
		
		for (int i = 0; i < 5; i++){
			
			System.out.println(texto);

		}//end for
		
	}// end run
	

}// end class
