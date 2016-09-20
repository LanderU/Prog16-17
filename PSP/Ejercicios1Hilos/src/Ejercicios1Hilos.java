import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicios1Hilos {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Escriba lo que quiera: ");
        String texto = br.readLine();
        
        Hilo aux = new Hilo(texto);
        
        Thread h = new Thread(aux);
        
        h.start();
        
        System.out.println("Hilo main end");
        
        


	}// main

}// class
