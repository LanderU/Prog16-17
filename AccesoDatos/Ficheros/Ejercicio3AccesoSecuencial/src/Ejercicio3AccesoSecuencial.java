import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 * 
 * @author Lander
 *
 */ 
 
public class Ejercicio3AccesoSecuencial {
	
	static BufferedReader leerTerminal = new BufferedReader(new InputStreamReader(System.in));
	static RandomAccessFile fichero;

	
	/*
	 * Funciones
	 */
	
	public static void Menu(){
		System.out.println("Seleccione una opción de la lista \n \n"
				+ "1- Buscar Empleado \n"
				+ "2- Modificar salario \n"
				+ "3- Borrar empleado \n"
				+ "4- Salir \n");
		System.out.print("Opcion: ");
		
	}// end menú
	
	public static int TotalBuffer (String [] empleados){
		
		int mayorNombre = Integer.MIN_VALUE;
		// Calculamos el tamaño máximo del String.
		for (int i = 0; i < empleados.length; i++) {
			if (empleados[i].length() > mayorNombre){
				mayorNombre = empleados[i].length();
			}// end if
		}// end for
		// Total del buffer Cada caracter vale 2 bytes por total de letras y luego tenemos un int, el identificador y double el sueldo 8 bytes
		int total = (mayorNombre * 2) + 4 + 8;
		//Debug
		//System.out.println(total);
		
		return total;
		
	}// end CalcularBuffer
	
	public static long CrearFichero(String [] empleados, Double [] sueldos) throws IOException{
		
		fichero = new RandomAccessFile(new File ("prueba"), "rw");

				
		int mayorNombre = Integer.MIN_VALUE;
						
		for (int i = 0; i < empleados.length; i++) {
			if (empleados[i].length() > mayorNombre){
				mayorNombre = empleados[i].length();
			}// end if
		}// end for
		
		// Referencia para el Buffer
		StringBuffer bufferEmpleados = null;
			// Guardamos los datos
			for (int i = 0; i < empleados.length; i++){
				// Escribimos el identificador
				fichero.writeInt(i+1);
				// Buffer String nombre
				bufferEmpleados = new StringBuffer(empleados[i]);
				bufferEmpleados.setLength(mayorNombre);
				// Escribimos el Nombre
				fichero.writeChars(bufferEmpleados.toString());
				// Ecribimos el sueldo
				fichero.writeDouble(sueldos[i]);
				
			}// end for	
			
		long total = fichero.length();
		
		fichero.close();
		
		return total;

		
		
	}// end CrearFichero
	
	
	public static int TotalNombre(String [] empleados){
		
		int mayorNombre = Integer.MIN_VALUE;
		
		for (int i = 0; i < empleados.length; i++) {
			if (empleados[i].length() > mayorNombre){
				mayorNombre = empleados[i].length();
			}// end if
		}// end for
		
		return mayorNombre;
	}//
	
	public static void MostrarEmpleado(int numEmpleado, String [] empleados) throws IOException, InterruptedException{
		
		fichero = new RandomAccessFile(new File ("prueba"), "r");
		
		int posicion = (numEmpleado -1)* TotalBuffer(empleados);
		
		if (posicion > fichero.length() || posicion < 0){
			
			System.out.println("Ese registro no existe");
			fichero.close();
			Thread.sleep(1000);
			
		}else{
			fichero.seek(posicion);
			char [] nom = new char [TotalBuffer(empleados) - 12];
			char aux;
			System.out.println("Estos son los datos: \n"
					+ "################################");
			int id = fichero.readInt();
			for (int i = 0; i < TotalNombre(empleados); i++) {
				aux = fichero.readChar();
				nom [i] = aux;
			}// end for 
			String nombre = new String (nom);
			Double sueldo = fichero.readDouble();
			System.out.println("El identificador: "+id);
			System.out.println("El nombre: "+nombre);
			System.out.println("Salario: "+sueldo);
			fichero.close();
			Thread.sleep(1000);
		}	
		
	}// end MostrarEmpleado
	
	public static void ModificarSalario(int numEmpleado, String [] empleados) throws IOException, InterruptedException{
		
		fichero = new RandomAccessFile(new File ("prueba"), "rw");
		
		//Posicionamos el puntero en el sueldo, primero nos ponemos en la primera posición del registro y luego le sumamos el total el int 4 y el total calculado del nombre.
		
		long posicion = (numEmpleado -1)* TotalBuffer(empleados) + 4 + (TotalNombre(empleados) *2);
		
		if (posicion > fichero.length() || posicion < 0){
			
			System.out.println("Ese registro no existe");
			fichero.close();
			Thread.sleep(1000);
			
		}else{
			fichero.seek(posicion);
			Double sueldo = fichero.readDouble();
			Double nuevoSueldo;
			System.out.print("El salario actual del empleado es: "+sueldo+"\n");
			System.out.print("Nuevo salario: ");
			try {
				nuevoSueldo = Double.parseDouble(leerTerminal.readLine());
				// Nos volvemos a posicionar
				fichero.seek(posicion);
				fichero.writeDouble(nuevoSueldo);
				System.out.println("Sueldo actualizado!!");
				Thread.sleep(1000);
				
			} catch (NumberFormatException  e) {
				System.out.println("Introduzca un sueldo válido, ejemplo: 1000");
				System.out.println("Salimos al menú.");
				Thread.sleep(1000);
			}
			fichero.close();
			Thread.sleep(1000);
		}	
		
		
	}// end ModificarSalario
	
	public static void BorrarEmpleado(int numEmpleado, String [] empleados) throws IOException, InterruptedException{
		// Stream
		fichero = new RandomAccessFile(new File ("prueba"), "rw");
		
		long posicion = (numEmpleado -1)* TotalBuffer(empleados);
		
		if (posicion > fichero.length() || posicion < 0){

			System.out.println("Ese registro no existe");
			fichero.close();
			Thread.sleep(1000);
			
		}else{
			fichero.seek(posicion);
			//System.out.println(fichero.readInt());
			fichero.writeInt(0);
			fichero.close();
			System.out.println("Empleado borrado!");
			Thread.sleep(1000);
		}// end if

		
	}// end BorrarEmpleado
	
	public static void Acciones(int opcion, String [] empleados) throws IOException, InterruptedException{
		
		int numEmple;
		
		switch (opcion) {
		case 1:
				System.out.print("Escriba el número de empleado a buscar: ");
				try{
					numEmple = Integer.parseInt(leerTerminal.readLine());
					
					MostrarEmpleado(numEmple, empleados);
					
				}catch (NumberFormatException ex){
					System.out.println("Introduzca un número.");
					System.out.println("Salimos al menú.");
					Thread.sleep(1000);
				}// end catch
			
			break;
		case 2:
			
			System.out.print("Escriba el número de empleado a buscar: ");
			try{
				numEmple = Integer.parseInt(leerTerminal.readLine());
				
				ModificarSalario(numEmple,empleados);
				
			}catch (NumberFormatException ex){
				System.out.println("Introduzca un número.");
				System.out.println("Salimos al menú.");
				Thread.sleep(1000);
			}// end catch
					
			break;
		case 3: 
			
			System.out.print("Escriba el número de empleado a borrar: ");
			try{
				numEmple = Integer.parseInt(leerTerminal.readLine());
				
				BorrarEmpleado(numEmple,empleados);
				
			}catch (NumberFormatException ex){
				System.out.println("Introduzca un número.");
				System.out.println("Salimos al menú.");
				Thread.sleep(1000);
			}// end catch
			
			break;
		case 4:
			
			System.out.println("Gracias por usar nuestra aplicación.");
			Thread.sleep(1000);
			System.exit(0);
			
			break;
		}// end sw	
		
	}// end Acción
	
	
	/*
	 * End funciones
	 */
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		// Datos
		String [] empleados = {"Lander", "Alberto","Ion", "Marcos"};
		Double [] sueldos = {1200.0, 900.0, 1000.0, 3000.0};
		
		// Creamos el fichero
		CrearFichero(empleados, sueldos);

		int opcion = 0;
		
		do {
			
			Menu();
			
			try {
				opcion = Integer.parseInt(leerTerminal.readLine());
				if (opcion < 1 || opcion > 4){
					System.out.println("Rcuerde que tiene que introducir un número entro el 1 y el 4");
					Thread.sleep(1000);
				}// end if
				
				// Función
				Acciones(opcion, empleados);
				
			} catch (NumberFormatException e) {
				System.out.println("Rcuerde que tiene que introducir un número entro el 1 y el 4");
				opcion = 0;
				Thread.sleep(1000);
			}// end try
				
		} while (opcion != 3);
		
	}// main

}// class
