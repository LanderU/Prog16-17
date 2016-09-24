import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Lander
 *
 */

public class ObjetosBinarios {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
        BufferedReader leerTerminal = new BufferedReader(new InputStreamReader(System.in));
        
		FileOutputStream escribir = new FileOutputStream(new File ("prueba"));
		ObjectOutputStream datos = new ObjectOutputStream(escribir);
		
		String continuar="";
		Persona per;
		String nombre = "";
		int edad = Integer.MAX_VALUE;
		
		do {
			
			System.out.print("Escriba el nombre de la persona a guardar: ");
			nombre = leerTerminal.readLine();
			System.out.print("Escriba la edad: ");
			edad = Integer.parseInt(leerTerminal.readLine());
			// Creamos el objeto
			per = new Persona(nombre,edad);
			// Se lo pasamos al stream
			datos.writeObject(per);
			System.out.print("Desea seguir introduciendo personas¿?, s,n: ");
			continuar = leerTerminal.readLine();
		} while (!continuar.equals("n"));
		
		// Cerramos el flujo
		datos.close();
		
		System.out.println("Estos son los datos que has guardado");
		
		FileInputStream leer = new FileInputStream(new File ("prueba"));
		ObjectInputStream datosLeidos = new ObjectInputStream(leer);
		
		
		try {
			
			while (true){
				per = (Persona) datosLeidos.readObject();
				System.out.println("Nombre: "+per.getNombre()+ ", edad: "+ per.getEdad());
			}// end while
			
		} catch (EOFException e) {
			// TODO: handle exception
		}finally{
			datosLeidos.close();
		}// end try
		

	}//main

}//class
