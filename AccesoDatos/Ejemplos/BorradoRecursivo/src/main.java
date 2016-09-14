import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Lander
 *
 */



public class main {
	
	public static void borrar (File contenido){
		
		File [] borrado = contenido.listFiles();
		
		for (int i = 0; i < borrado.length; i++){
			
			if (borrado[i].isDirectory()){
				
				borrar(borrado[i]);
				
			}else{
				
				borrado[i].delete();
				contenido.delete();
				
			}// end if		
			
		}// end if
		
	}//end borrar
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Escriba la ruta de la carpeta que quiere borrar: ");
		String carpeta = br.readLine();
		
		File contenido = new File (carpeta);
		
		if (contenido.exists()){
			borrar(contenido);
			System.out.println("Todo borrado!!!");
			
		}else {
			
			System.out.println("Ruta erronea.");
		}	

	}// end main

}// end class
