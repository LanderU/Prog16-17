import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Lander
 *
 */


public class Repaso1 {

	public static void main(String[] args) throws IOException {
		
		FileWriter fichero = new FileWriter(new File ("repaso1"));
		
		String texto = "Hola esto es una prueba.";
		
		fichero.write(texto);
		
		fichero.close();
		
		FileReader lectura = new FileReader (new File ("repaso1"));
		int i;
		char [] aux = new char [texto.length()];
		int cont = 0;
		while ((i = lectura.read()) != -1) {
			
			aux[cont] = (char)i;
			cont++;
		}
		
		lectura.close();
		
		String textSinEspacios = new String(aux);
		System.out.println(textSinEspacios.replace(" ", ""));
		
		
	}// main

}// class
