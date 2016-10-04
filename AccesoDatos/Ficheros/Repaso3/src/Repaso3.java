import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Lander
 *
 */
public class Repaso3 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// Datos para los coches
		String [] matriculas = {"8878dwl", "2743djg", "3800fzw"};
		Double [] capacidades = {100.00, 140.00, 90.00};
		String [] modelos = {"c4","207", "golf"};
		Coche c = null;
		
		// Fichero
		ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("datosCoches"));
		
		// Guardamos los datos
		for (int i = 0; i < matriculas.length; i++) {
			
			c = new Coche(matriculas[i],capacidades[i],modelos[i]);
			escribir.writeObject(c);
			
		}// end for
		
		// Cerramos el flujo
		escribir.close();
		
		ObjectInputStream leer = new ObjectInputStream(new FileInputStream("datosCoches"));
		
		// Copiamos el contenido a otro archivo
		ObjectOutputStream nuevo = new ObjectOutputStream(new FileOutputStream("aux"));
		
		// Mostrar todos los datos
		try {
			while(true){
				
				c = (Coche) leer.readObject();
				if (!c.getMatricula().equals("8878dwl")){
					nuevo.writeObject(c);
				}
				
			}// end while
			
		} catch (EOFException e) {
			// TODO: handle exception
		}finally{
			leer.close();
			nuevo.close();
		}
		
		File fichero = new File("datosCoches");
		File fichero2 = new File("aux");
		
		if (fichero.exists() && fichero2.exists()){
			fichero.delete();
			File ficheroOK = new File ("datosCoches");
			if (fichero2.renameTo(ficheroOK)){
				System.out.println("Nombre cambiado");
			}
			
		}
		Coche c2 = new Coche("kk1",3.0,"fdsfds");
		ObjectOutputStream anadir = new AppendObject(new FileOutputStream ("datosCoches",true));
		anadir.writeObject(c2);
		
	
		ObjectInputStream otro = new ObjectInputStream(new FileInputStream("datosCoches"));
/*		
		try {
			while (true){
				
				c = (Coche) otro.readObject();
				System.out.println(c.getMatricula());
			}
		} catch (EOFException e) {
			// TODO: handle exception
		}finally{
			otro.close();
		}
*/
	}// main

}// class
