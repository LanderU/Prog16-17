import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.exceptions.jdbc4.MySQLDataException;

/**
 * 
 * @author Lander
 *
 */
public class EjercicioMysql1 {
	
	public static final String FOR_NAME="com.mysql.jdbc.Driver";
	public static final String CONNECTION="jdbc:mysql://localhost/ejercicio1";
	public static final String USERNAME="root";
	public static final String PASSWORD="erle";

	public static void main(String[] args){
		
		try {
			Class.forName(FOR_NAME);
			Connection conn = (Connection) DriverManager.getConnection(CONNECTION,USERNAME,PASSWORD);
			Statement query = (Statement) conn.createStatement();
			String sql = "select salario, apellido from empleados where salario = (select MAX(salario) from empleados)";
			ResultSet resultado = query.executeQuery(sql);
			
			while (resultado.next()){
				
				System.out.println(resultado.getString(1)+ " "+resultado.getString(2));
			}
			resultado.close();
			query.close();
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Error al conectarse a la BD");
		}catch (ClassNotFoundException ex){
			JOptionPane.showMessageDialog(null, "Error en la clase");
		}
	

	}// main

}// class
