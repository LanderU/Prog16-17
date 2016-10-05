import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import com.thoughtworks.xstream.XStream;

/**
 * 
 * @author Lander
 *
 */
public class Examen1 {
	
	public static boolean BuscarRegistro(GOT c, String borrar) throws FileNotFoundException, IOException, ClassNotFoundException{
		
		ObjectInputStream leer = new ObjectInputStream(new FileInputStream("juegodetronos.dat"));
		
		boolean existe = false;
		try {
			while (true){
				
				c = (GOT) leer.readObject();
				
				if (c.getNombre().equals(borrar)){
					
					existe = true;
				}
				
				
			}// end while
		} catch (EOFException e) {
			// TODO: handle exception
		}finally{
			leer.close();
		}
		
		if (!existe){
			
			JOptionPane.showMessageDialog(null, "Ese reino no juego al juego de trono");
		}
		
		return existe;
		
	}// end Buscar
	
	public static void BorrarRegistro(String borrar) throws FileNotFoundException, IOException, ClassNotFoundException{
		//Leer
		ObjectInputStream lectura = new ObjectInputStream(new FileInputStream("juegodetronos.dat"));
		//Escribir
		ObjectOutputStream nuevo = new ObjectOutputStream(new FileOutputStream("aux"));
		
		GOT otra = null;
		
		try {
			while (true){
				otra = (GOT) lectura.readObject();
				if (!otra.getNombre().equals(borrar))
					nuevo.writeObject(otra);
			}// end while
			
		} catch (EOFException e) {
			// TODO: handle exception
		}finally{
			nuevo.close();
			JOptionPane.showMessageDialog(null, "Borrada la casa "+borrar);
		}
		
	}// end Borrar
	

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// Datos
		int [] numReinos = {1,2,3};
		String [] nombres = {"Stark","Lannister","Baratheon"};
		String [] emblemas = {"Lobo Huargo", "León", "Ciervo"};
		String [] lemas = {"El invierno se acerca", "Un Lannister siempre paga sus deudas", "Nuestra es la furia"};
		
		// Stream
		ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("juegodetronos.dat"));
		
		// Guardamos los datos
		GOT casa = null;
		for (int i = 0; i < numReinos.length; i++) {
			
			casa = new GOT(numReinos[i], nombres[i], emblemas[i], lemas[i]);
			escribir.writeObject(casa);
			
		}// end for
		//Cerramos el flujo
		escribir.close();
		
		String borrar = JOptionPane.showInputDialog("Nombre del reino a borrar");
		// Guardar
		ObjectOutputStream anadir = new AppendObject(new FileOutputStream("aux", true));

		//Borrar un reino
		if(BuscarRegistro(casa, borrar)){
			
			BorrarRegistro(borrar);
			
			GOT otraCasa = new GOT(4,"Targaryen","Dragón","Fuego y Sangre");
			
			anadir.writeObject(otraCasa);
			anadir.close();
			JOptionPane.showMessageDialog(null, "Guardada la casa "+ otraCasa.getNombre());
			
			// Dejar un sólo archivo
			File viejo = new File("juegodetronos.dat");
			File aux = new File("aux");
			File definitivo = new File("juegodetronos.dat");
			
			if (viejo.exists() && aux.exists()){
				viejo.delete();
				aux.renameTo(definitivo);
			}// end if
			
		}// end if
		
		/*
		 * #######################XML##################################
		 */
		ListaGOT listado = new ListaGOT();
		// Preparamos la lista
		ObjectInputStream lecturaFinal = new ObjectInputStream(new FileInputStream("juegodetronos.dat"));
		GOT objectFinal = null;
		try {
			
			while (true){
				
				objectFinal = (GOT) lecturaFinal.readObject();
				listado.anadir(objectFinal);
				
			}
			
		} catch (EOFException e) {
			// TODO: handle exception
		}finally{
			lecturaFinal.close();
		}
		
		try {
			XStream xml = new XStream();
			xml.alias("ListadoReinos", ListaGOT.class);
			xml.alias("Reinos", GOT.class);
			xml.addImplicitCollection(ListaGOT.class, "listaReinos");
			xml.toXML(listado, new FileOutputStream("ReinosJuegoDeTronos.xml"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		

/*		
		ObjectInputStream lecturaFinal = new ObjectInputStream(new FileInputStream("juegodetronos.dat"));
		GOT objectFinal = null;
		try {
			
			while (true){
				objectFinal = (GOT) lecturaFinal.readObject();
				System.out.println(objectFinal.getNombre());
				
			}
			
		} catch (EOFException e) {
			// TODO: handle exception
		}
*/		
		
		
	}// main

}// class
