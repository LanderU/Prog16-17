import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Buffers {
	
	public static int TAMANO_BUFFER = 100;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader lectura = new FileReader(new File("/home/lander/prueba"));
		
		char [] carLeidos = new char [TAMANO_BUFFER];
		
		lectura.read(carLeidos, 20, 20);
		
		for (char caracter:carLeidos){
			
			if((int)caracter==0)
				caracter = '-';
			System.out.print(caracter);
			
		}
		
		lectura.close();

	}// main

}// class
