import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Lander
 *
 */
public class CopiarDatos {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		 * Copiar datos de un fichero a otro
		 */
		
		
		// Creamos el primer fichero
		
		DataOutputStream salida= new DataOutputStream (new FileOutputStream(new File("prueba")));
		
		String [] nombres = {"Ana","Luis Miguel","Alicia","Pedro","Manuel"
				+"Andrés","Júlio","Antonio","María Jesús"};

		int [] edades = {10,20,40,18,32,56,89,19,32};
		
		for (int i = 0; i < nombres.length; i++) {
			
			salida.writeUTF(nombres[i]);
			salida.writeInt(edades[i]);
			
		}// end for

		// Cerramos el flujo
		salida.close();
		
		// Leemos los datos
		 
		DataInputStream lectura = new DataInputStream(new FileInputStream(new File("prueba")));
		
		// Nuevo flujo para guardar en un archivo normal
		FileWriter fichEscribir = new FileWriter("copia");
		
		try {
			
			while (true){
					
				fichEscribir.write(lectura.readUTF()+" "+String.valueOf(lectura.readInt())+" ");
					

			}// end while
		}catch (EOFException eo){
		}finally{	
			System.out.println("Cierro");
			lectura.close();
			fichEscribir.close();
		}

	}// main

}// class
