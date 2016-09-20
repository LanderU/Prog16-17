import java.io.BufferedReader;
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


public class AccesoAleatorio {
	
	public static int NombreMayor(String [] empleados){
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < empleados.length; i++) {
			if (empleados[i].length() > max){
				max = empleados[i].length();
			}// end for
		}
		
		return max;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// Creación del fichero.
		RandomAccessFile fichero = new RandomAccessFile(new File ("prueba"), "rw");
		
		String [] empleados = {"Lander", "Alberto","Ion", "Marcos"};
		
		// Calculamos el tamaño del buffer del empleado
		int mayorNombre = NombreMayor(empleados);
		StringBuffer bufferEmpleados = null;
		
		// Guardamos los datos
		for (int i = 0; i < empleados.length; i++){
			// Escribimos el identificador
			fichero.writeInt(i+1);
			bufferEmpleados = new StringBuffer(empleados[i]);
			bufferEmpleados.setLength(mayorNombre);
			fichero.writeChars(bufferEmpleados.toString());
		}// end for
				
		// Cálculo de la posición, String 2 bytes int 4
		int tamano = (mayorNombre *2) + 4;
		
		int pos = 0, id = 0;
		char [] name = new char [mayorNombre];
		char aux;
		// Ponemos la posición a 0
		fichero.seek(pos);
		
		while (fichero.getFilePointer() < fichero.length()){
			fichero.seek(pos);
			id = fichero.readInt();
			for (int i = 0; i < empleados.length; i++) {
				aux = fichero.readChar();
				name [i] = aux;
			}// end for
			String nombre = new String (name);
			System.out.println("Número de persona: "+id+", nombre de la persona: "+nombre);
			pos = pos + tamano;
		}// end while
		
		fichero.close();
		
		
	}// main

}// class
