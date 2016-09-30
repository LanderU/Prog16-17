import java.io.EOFException;
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
public class XStream {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		String [] nombres = {"Lander","Marcos","Alberto"};
		int [] edades = {28 ,34 ,30};
		
		ObjectOutputStream escribir = new ObjectOutputStream (new FileOutputStream ("datos"));
		
		Persona per;
		
		for (int i = 0; i < nombres.length; i++) {
			per = new Persona(nombres[i],edades[i]);
			escribir.writeObject(per);		
		}// end for
				
		escribir.close();
		
		// Leemos los datos y generamos un XML
		
		ObjectInputStream leer = new ObjectInputStream(new FileInputStream("datos"));
		ListaPersonas lista = new ListaPersonas();
		
		try {
			
			while (true){
				
				per = (Persona) leer.readObject();
				lista.addPersona(per);
				
			}// end while
			
		}catch (EOFException e){
			
			
		}finally{
			leer.close();
		}// end try
		
		try {
			com.thoughtworks.xstream.XStream flujo = new com.thoughtworks.xstream.XStream();
			flujo.alias("ListaPersonas", ListaPersonas.class);
			flujo.alias("DatosPersona", Persona.class);
			flujo.addImplicitCollection(ListaPersonas.class, "listado");
			flujo.toXML(lista, new FileOutputStream("Personas.xml"));
			System.out.println("Creado");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}//main

}// class
