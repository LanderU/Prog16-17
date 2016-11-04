import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySql11 {
	
	public static final String FOR_NAME="com.mysql.jdbc.Driver";
	public static final String CONNECTION="jdbc:mysql://localhost/ejercicio1?noAccessToProcedureBodies=true";
	public static final String USERNAME="root";
	public static final String PASSWORD="erle";
	public static List<Departamento> listaDepartamentos = new ArrayList<Departamento>();

	
	public static void RellenarFichero() throws IOException{
		// Datos
		int [] numDepart = {10,20,60,70};
		String [] nomDepart = {"CONTABILIDAD","I+D","DIRECCION","??"};
		String [] localidad = {"SEVILLA","GIRONA","AMURRIO","TEGUCIGALPA"};
		// Flujos
		FileOutputStream escribir = new FileOutputStream(new File ("DatosDepartamenotos"));
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
	}// end function
	
	public void CompararDatos() throws ClassNotFoundException, SQLException{
		Class.forName(FOR_NAME);
		Connection conn = DriverManager.getConnection(CONNECTION,USERNAME,PASSWORD);
		Statement checkDepartamento = conn.createStatement();
		ResultSet departs = checkDepartamento.executeQuery("SELECT * FROM departamentos");
		while(departs.next()){
			Departamento dep = new Departamento(departs.getInt(1),(String)departs.getString(2),departs.getString(3));
			listaDepartamentos.add(dep);
		}// end while
	}// end function
	
	public static void main(String[] args) throws IOException {
		// Rellenamos el fichero con los datos
		RellenarFichero();
		
		
	}// main

}// class
