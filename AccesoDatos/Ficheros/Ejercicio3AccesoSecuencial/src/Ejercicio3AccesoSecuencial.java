import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * @author root
 *
 */ 
 
public class Ejercicio3AccesoSecuencial {
	
	/*
	 * Funciones
	 */
	
	public static void Menu(){
		System.out.println("Seleccione una opción de la lista \n \n"
				+ "1- Buscar Empleado \n"
				+ "2- Modificar salario \n"
				+ "3- Borrar Empleado \n"
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
		
		RandomAccessFile fichero = new RandomAccessFile(new File ("prueba"), "rw");

				
		int mayorNombre = Integer.MIN_VALUE;
						
		for (int i = 0; i < empleados.length; i++) {
			if (empleados[i].length() > mayorNombre){
				mayorNombre = empleados[i].length();
			}// end if
		}// end for
		
		// Referencia al para el Buffer
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
	
	public static void MostrarEmpleado(int numEmpleado, String [] empleados) throws IOException{
		
		RandomAccessFile fichero = new RandomAccessFile(new File ("prueba"), "r");
		
		int posicion = (numEmpleado -1)* TotalBuffer(empleados);
		
		if (posicion > fichero.length()){
			
			System.out.println("Ese registro no existe");
			fichero.close();
			
		}else{
			fichero.seek(posicion);
			char [] nom = new char [TotalBuffer(empleados) - 12];
			char aux;
			int id = fichero.readInt();
			for (int i = 0; i < TotalBuffer(empleados) - 12; i++) {
				aux = fichero.readChar();
				nom [i] = aux;
			}// end for 
			String nombre = new String (nom);
			Double sueldo = fichero.readDouble();
			System.out.println("El identificador: "+id);
			System.out.println("El nombre: "+nombre);
			System.out.println("Salario: "+sueldo);
			fichero.close();
		}	
		
	}// end MostrarEmpleado
	
	
	/*
	 * End funciones
	 */
	
	public static void main(String[] args) throws IOException {
		
		// Datos
		String [] empleados = {"Lander", "Alberto","Ion", "Marcos"};
		Double [] sueldos = {1200.0, 900.0, 1000.0, 3000.0};
		
		//int opcion = 0;
		
		//do {
		//	Menu();
			
		//} while (opcion != 4);
		long total = CrearFichero(empleados, sueldos);
		
		MostrarEmpleado(1,empleados);
		
		
	}// main

}// class
