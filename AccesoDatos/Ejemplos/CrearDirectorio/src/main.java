import java.io.File;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		// Creamos un direcotorio en la ruta actual
		
		File nuevoDirectorio = new File("kk");
		File fichero = new File(nuevoDirectorio,"kk.txt");
		
		if (nuevoDirectorio.mkdir()){
			
			System.out.println("El direcotorio se ha creado correctamente");
			System.out.println("Ahora vamos a crear el archivo kk.txt");
			
			try {
				if (fichero.createNewFile()){
					
					System.out.println("Fichero creado con exito");
				}else{
					
					System.out.println("Imposible crear el fichero");
				}
			}catch (IOException ioe) {
				
				System.out.println("Error IO");
			}
			
		}else {
			
			System.out.println("No se puede crear el direcotorio, ¿existe?");
			System.out.println("Salimos...");
			Thread.sleep(1000); 
			System.exit(0);
		}
		

	}

}
