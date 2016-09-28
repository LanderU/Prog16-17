import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * 
 * @author Lander
 *
 */

public class XMLFicherosbinario {

	public static void main(String[] args) throws IOException, ClassNotFoundException, TransformerFactoryConfigurationError, TransformerException {
		// TODO Auto-generated method stub
		
        BufferedReader leerTerminal = new BufferedReader(new InputStreamReader(System.in));
        
		FileOutputStream escribir = new FileOutputStream(new File ("prueba"));
		ObjectOutputStream datos = new ObjectOutputStream(escribir);
		
		String continuar="";
		Persona per;
		String nombre = "";
		int edad = Integer.MAX_VALUE;
		
		do {
			
			System.out.print("Escriba el nombre de la persona a guardar: ");
			nombre = leerTerminal.readLine();
			System.out.print("Escriba la edad: ");
			edad = Integer.parseInt(leerTerminal.readLine());
			// Creamos el objeto
			per = new Persona(nombre,edad);
			// Se lo pasamos al stream
			datos.writeObject(per);
			System.out.print("Desea seguir introduciendo personas¿?, s,n: ");
			continuar = leerTerminal.readLine();
		} while (!continuar.equals("n"));
		
		// Cerramos el flujo
		datos.close();
/*		
		System.out.println("Estos son los datos que has guardado");
		
		FileInputStream leer = new FileInputStream(new File ("prueba"));
		ObjectInputStream datosLeidos = new ObjectInputStream(leer);
		
		
		try {
			
			while (true){
				per = (Persona) datosLeidos.readObject();
				System.out.println("Nombre: "+per.getNombre()+ ", edad: "+ per.getEdad());
			}// end while
			
		} catch (EOFException e) {
			// TODO: handle exception
		}finally{
			datosLeidos.close();
		}// end try
		
*/
		
		/**
		 * #######################################################
		 * ####################XML################################
		 * #######################################################
		 */
		Document document;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			document = implementation.createDocument(null, "Personas", null);
			document.setXmlVersion("1.0");
			
			ObjectInputStream leer = new ObjectInputStream(new FileInputStream("prueba"));
			try {
				
				while(true){
					
					// Creamos un elemento Persona dentro de la raíz personas
					Element persona = document.createElement("persona");
					document.getDocumentElement().appendChild(persona);
					per = (Persona) leer.readObject();
					Element elementoNombre = document.createElement("nombre");
					Element elementoEdad = document.createElement("edad");
					Text nomPersona = document.createTextNode(per.getNombre());
					Text edadPersona =  document.createTextNode(String.valueOf(per.getEdad()));
					persona.appendChild(elementoNombre);
					persona.appendChild(elementoEdad);
					elementoNombre.appendChild(nomPersona);
					elementoNombre.appendChild(edadPersona);
				}// end
				
			} catch (EOFException e) {
				// TODO: handle exception
			}finally{
				leer.close();
				Source source = new DOMSource(document);
				Result archivo = new StreamResult(new File("Personas.xml"));
				Transformer trans = TransformerFactory.newInstance().newTransformer();
				trans.transform(source, archivo);
			}// end try
				
		} catch (ParserConfigurationException e) {
			// TODO: handle exception
		}
		
		
		
	}//main

}//class
