import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class EscribirCaracter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		FileWriter escritura = new FileWriter(new File ("kk"));
		
		System.out.print("Escribe la cadena a escribir: ");
		
		String frase = br.readLine();
		
		
		for (int i = 0; i < frase.length(); i++){
			
			escritura.append(frase.toCharArray()[i]);
		}//
		
		escritura.close();
		
		
		

	}// main

}// class
