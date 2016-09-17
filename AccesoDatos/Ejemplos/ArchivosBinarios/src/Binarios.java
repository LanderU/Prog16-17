import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author Lander
 *
 */
public class Binarios {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File ficBinario = new File ("archivo");
		FileOutputStream data = new FileOutputStream(ficBinario);
		DataOutputStream escritura = new DataOutputStream(data);
		
		String [] nombres = {"Ana","Luis Miguel","Alicia","Pedro","Manuel"
							+"Andrés","Júlio","Antonio","MarÌa Jesús"};
		
		int [] edades = {10,20,40,18,32,56,89,19,32};
		
		for(int i = 0; i < nombres.length; i++){
			
			escritura.writeUTF(nombres[i]);
			escritura.writeInt(edades[i]);
			
		}// end for
		
		escritura.close();	
		// Leer los datos.
		
		FileInputStream datosFichero = new FileInputStream (new File ("archivo"));
		DataInputStream datos = new DataInputStream(datosFichero);
		
		try {
			while (true){
				
				System.out.println("Nombre: "+datos.readUTF() + ", edad: "+datos.readInt());
				
			}// end while
		}catch (EOFException eo){
		}finally{	
			System.out.println("Cerramos el flujo.");
			datos.close();
		}
	}// main

}//class
