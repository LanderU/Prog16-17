import java.util.Arrays;

import javax.swing.JOptionPane;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;

/**
 * 
 * @author Lander
 *
 */
public class DB40Ejemplo {
	
	public static final String BASE_DATOS= "EMPLEDEP.YAP";

	public static void main(String[] args) {
	/*
		Crea una BD Db4o de nombre EMPLEDEP.YAP e
		inserta objetos EMPLEADO y DEPARTAMENTOS
		en ella. Después obtén todos los objetos empleado
		de un departamento concreto. Visualiza también el
		nombre de dicho departamento
	*/
		
		ObjectContainer manejadorDB = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BASE_DATOS);
		// Objetos Departamento
		Departamento dep1 = new Departamento(1,"Informático");
		Departamento dep2 = new Departamento(2,"Marketing");
		Departamento dep3 = new Departamento(3,"Dirección");
		
		// Objetos Empleado
		
		Empleado emp1 = new Empleado(1,"Lander",1);
		Empleado emp2 = new Empleado(2,"Marcos",1);
		Empleado emp3 = new Empleado(3,"Alberto",3);
		Empleado emp4 = new Empleado (4,"Gabriel", 2);
		Empleado emp5 = new Empleado (5, "Ixone",3);
		Empleado emp6 = new Empleado(6,"Iker",2);
		
		// Guardamos en la BD
		manejadorDB.store(emp1);
		manejadorDB.store(emp2);
		manejadorDB.store(emp3);
		manejadorDB.store(emp4);
		manejadorDB.store(emp5);
		manejadorDB.store(emp6);
		
		//Cerramos la conexión
		//manejadorDB.close();
		
		JOptionPane.showMessageDialog(null, "Datos guardados!!");
		
		// Recuperar los datos
		try {
			
			Integer dep = Integer.parseInt(JOptionPane.showInputDialog("Número del departamento"));
			try {
				
			} catch (DatabaseClosedException e) {
				System.out.println(e.toString());
				// TODO: handle exception
			}
			Departamento buscar = new Departamento(dep,null);
			Empleado buscEmpleado = new Empleado(null,null,dep);
			
			ObjectSet<Departamento> resultado = manejadorDB.queryByExample(buscar);
			ObjectSet<Empleado> resEmple = manejadorDB.queryByExample(buscEmpleado);
			
			if((resultado.size() == 0) || (resEmple.size() == 0)){
				JOptionPane.showMessageDialog(null, "No hay datos");
			}else{
				String [] nombres = new String[resEmple.size()];
				int i = 0;
				while (resEmple.hasNext()){
					Empleado aux = resEmple.next();
					nombres[i] = aux.getNomEmpleado();
					i++;
				}// end while
				// Ordenamos los empleados
				Arrays.sort(nombres);
				Departamento depAux = resultado.next();
				System.out.println("Los empleados listados a continación pertenecen al departamento: "+depAux.getNombre());
				for (int j = 0; j < nombres.length; j++) {
					System.out.println("Empleado: "+nombres[i]);
				}// End for	
			}// end if
		} catch (NumberFormatException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "No es un número váido");
		}finally{
			manejadorDB.close();
		}
		
	}//main

}//class
