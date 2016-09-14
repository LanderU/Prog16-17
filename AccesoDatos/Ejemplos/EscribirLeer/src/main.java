import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Lander
 *
 */
public class main {
	

	
	public static void mostrarMenu(){
		
		System.out.println("Seleccione una opción de la lista \n \n"
				+ "1- Crear un directorio \n"
				+ "2- Crear un fichero \n"
				+ "3- Escribir en el fichero \n"
				+ "4- Leer el fichero \n"
				+ "5 - Salir \n");
		System.out.print("Opcion: ");
		
	}// end mostrar menú
	
	public static void accion(int opcion, BufferedReader br) throws IOException, InterruptedException{
		
		switch (opcion){
			case 1:
					System.out.print("Escriba el nombre del directorio: ");
					String directorio = br.readLine();
					File nuevoDir = new File (directorio);
					
					if (nuevoDir.exists()){
						
						System.out.println("Ya existe un elemento con ese nombre.");
					}else {
						if (nuevoDir.mkdir()){
							
							System.out.println("Directorio creado.");
						}else {
							
							System.out.println("Error");
						}// end if
					}// end if
					
					break;
			case 2:	
					System.out.print("Escriba el nombre del fichero: ");
					
					String fichero = br.readLine();
					
					File nuevoFich = new File (fichero);
					
					if (nuevoFich.exists()){
						
						System.out.println("Ya existe un elemento con ese nombre.");
						
					}else {
						if (nuevoFich.createNewFile()){
							
							System.out.println("Fichero creado.");
							
						}else {
							
							System.out.println("Error");
							
						}// end if
						
					}// end if

					break;
			case 3: 
					System.out.print("Escriba la ruta del fichero, \"/home/lander\", por ejemplo: ");
					
					String ruta = br.readLine();
					
					File path = new File (ruta);
					
					if (!path.exists()){
			            
						System.out.println("La ruta/fichero indicada no existe, salimos...");
			            Thread.sleep(1000); 
			            System.exit(0);		
					}else {
						
						File [] contenido = path.listFiles();
						
						for (int i = 0; i < contenido.length ; i++){
							if (contenido [i].isFile() && contenido[i].canWrite()){
								
								System.out.println("Usted puede escribir este fichero: "+ contenido[i].toString());
							}
							
						}// end for
					
						System.out.print("Nombre del archivo en el que escribir: ");
						
						String nomFich = br.readLine();
						
						File escribir = new File(path,nomFich);
						
						if (escribir.exists() && escribir.isFile() && escribir.canWrite()){
							
							System.out.print("Frase a escribir: ");
							
							String frase = br.readLine();
							
							try {
								// Debug
								//System.out.println("ruta"+ ruta + "nomFich"+ nomFich);
								FileWriter fichEscribir = new FileWriter(ruta+"/"+nomFich);
								
								fichEscribir.write(frase + "\n");
								
								fichEscribir.close();
								
							}catch (Exception ex){
								
								System.out.println("Error inesperado.");
							}
							
						}else {
							
							System.out.println("Error...");
						}
					}// end if

					break;
			case 4: 
					System.out.print("Archivo del cual desea ver su contenido, ejemplo \"/home/lander/prueba\", por ejemplo: ");
					String leerArchivo = br.readLine();
					
					File pathLeer = new File(leerArchivo);
					
					if (pathLeer.exists() && pathLeer.isFile() && pathLeer.canRead()){
						
						FileReader lectura = new FileReader(leerArchivo);
						System.out.print("El contenido del archivo es: ");
						
						int i = 0;
						
						while ((i=lectura.read()) != -1 ){
							
							System.out.print((char) i);
							
						}// end while
						
					}else {
						
						System.out.println("Error...");
					}

					break;
			case 5:	
					System.out.println("Gracias por usar nuestro programa");
					break;
	
		}// end switch
		
		
	}// end acción

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/* 	Programa que muestra un menú con las siguientes acciones:
		 * 1- Crear directorio
		 * 2- Crear fichero
		 * 3- Escribir en el fichero
		 * 4- Leer el fichero
		 * 5- Salir
		*/
				
		//Declaración de las variables
		
		int opcion = 0;
		
		do{
			mostrarMenu();

			try {
				
				opcion = Integer.parseInt(br.readLine());
				
				if (opcion > 5 || opcion < 1) {
					
					System.out.println("Recuerde que los números validos son del 1-5, intentelo otra vez");
					Thread.sleep(1000);
				}else {
					
					accion(opcion, br);
					
				}// end if
				
			}catch (NumberFormatException e){
				System.out.println("Seleccione una opcion de la lista, un número, intentelo otra vez");
				Thread.sleep(1000);
				opcion = 0;
				
			}// end try catch
			
			
		}while (opcion != 5);
				
		
	}// main

}//class
