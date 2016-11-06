import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MySql11 {
	
	public static final String FOR_NAME="com.mysql.jdbc.Driver";
	public static final String CONNECTION="jdbc:mysql://localhost/ejercicio1?noAccessToProcedureBodies=true";
	public static final String USERNAME="root";
	public static final String PASSWORD="erle";
	public static List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
	private static ObjectInputStream datos;

	
	public static void RellenarFichero() throws IOException{
		// Datos
		int [] numDepart = {10,20,60,70};
		String [] nomDepart = {"CONTABILIDAD","I+D","DIRECCION","??"};
		String [] localidad = {"SEVILLA","GIRONA","AMURRIO","TEGUCIGALPA"};
		File find = new File("DatosDepartamentos");
		if(!(find.exists())){
			FileOutputStream escribir = new FileOutputStream(new File ("DatosDepartamentos"));
			ObjectOutputStream datos = new ObjectOutputStream(escribir);
			Departamento d = null;
			for (int i = 0; i < numDepart.length; i++) {
				 d = new Departamento(numDepart[i],nomDepart[i],localidad[i]);
				datos.writeObject(d);
			}// end for
			//Objeto null para controlar el bucle
			d = null;
			datos.writeObject(d);
			// Cerramos los streams
			datos.close();
			escribir.close();
			JOptionPane.showMessageDialog(null, "Datos guardados");
		}// end if
	}// end function
	
	public static void RellenarLista() throws ClassNotFoundException, SQLException{
		Class.forName(FOR_NAME);
		Connection conn = DriverManager.getConnection(CONNECTION,USERNAME,PASSWORD);
		Statement checkDepartamento = conn.createStatement();
		ResultSet departs = checkDepartamento.executeQuery("SELECT * FROM departamentos ORDER BY dept_no");
		while(departs.next()){
			Departamento dep = new Departamento(departs.getInt(1),(String)departs.getString(2),departs.getString(3));
			listaDepartamentos.add(dep);
		}// end while
		// Cerramos los flujos
		departs.close();
		checkDepartamento.close();
		conn.close();
	}// end function
	
	public static void ActualizarDatos() throws IOException, ClassNotFoundException, SQLException{
		FileInputStream leer = new FileInputStream(new File ("DatosDepartamentos"));
		datos = new ObjectInputStream(leer);
		Departamento depAux = (Departamento) datos.readObject();
		int index = 0;
		Class.forName(FOR_NAME);
		Connection conn = DriverManager.getConnection(CONNECTION,USERNAME,PASSWORD);
		String sql = "";
		PreparedStatement sentencia =  null;
		while(depAux != null){
			if (listaDepartamentos.contains(depAux)){
				JOptionPane.showMessageDialog(null, "Nada que actualizar");
			}else if(listaDepartamentos.get(index).getDept_no() != depAux.getDept_no()){
				JOptionPane.showMessageDialog(null, "La clave primaria no puede ser modificada");
			}else if((listaDepartamentos.get(index).getDept_no() == depAux.getDept_no()) && (!listaDepartamentos.get(index).getDnombre().equals(depAux.getDnombre())) && (listaDepartamentos.get(index).getLocalidad().equals(depAux.getLocalidad()))){
				JOptionPane.showMessageDialog(null, "Se actualizará el nombre del departamento");
				sql = "UPDATE departamentos SET dnombre = ? WHERE dept_no = ?";
				sentencia = conn.prepareStatement(sql);
				sentencia.setString(1, depAux.getDnombre());
				sentencia.setInt(2, depAux.getDept_no());
				sentencia.close();
				conn.close();
			}else if ((listaDepartamentos.get(index).getDept_no() == depAux.getDept_no()) && (listaDepartamentos.get(index).getDnombre().equals(depAux.getDnombre())) && (!listaDepartamentos.get(index).getLocalidad().equals(depAux.getLocalidad()))){
				JOptionPane.showMessageDialog(null, "Se actualizará la localidad");
				sql = "UPDATE departamentos SET loc = ? WHERE dept_no = ?";
				sentencia = conn.prepareStatement(sql);
				sentencia.setString(1, depAux.getLocalidad());
				sentencia.setInt(2, depAux.getDept_no());
				sentencia.close();
				conn.close();
			}else{
				JOptionPane.showMessageDialog(null, "Datos invalidos");
			}
			
			index++;
		}// end while
		
		
	}// end function
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// Rellenamos el fichero con los datos
		RellenarFichero();
		RellenarLista();
		ActualizarDatos();
		
	}// main

}// class
