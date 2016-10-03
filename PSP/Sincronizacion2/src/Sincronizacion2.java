import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;

public class Sincronizacion2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader leerTerminal = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Número de hílos¿? ");
		int cantHilos;
	
		try {
		
			cantHilos = Integer.parseInt(leerTerminal.readLine());
			
			
			for (int i = 0; i < cantHilos; i++) {
				
				Thread h = new Thread(new HiloSincro());
				h.setName(String.valueOf(i));
				h.start();
				
			}// end for
				
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}

	}// main

}//class
