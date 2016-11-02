import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import javax.sound.midi.Soundbank;
import javax.swing.JOptionPane;

/**
 * 
 * @author Lander
 *
 */
public class MySql10 {
	
	public static final String FOR_NAME="com.mysql.jdbc.Driver";
	public static final String CONNECTION="jdbc:mysql://localhost/ejercicio1?noAccessToProcedureBodies=true";
	public static final String USERNAME="root";
	public static final String PASSWORD="erle";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName(FOR_NAME);
		Connection conn = DriverManager.getConnection(CONNECTION,USERNAME,PASSWORD);
		int numDept = 0;
		
		try {
			numDept = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de departamento"));
			String sql = "{call AuditarEmpleados(?,?,?)}";
			CallableStatement llamadaProcedimiento = conn.prepareCall(sql);
			llamadaProcedimiento.setInt(1,numDept);
			llamadaProcedimiento.registerOutParameter(2, Types.FLOAT);
			llamadaProcedimiento.registerOutParameter(3, Types.FLOAT);
			llamadaProcedimiento.executeUpdate();
			System.out.println("Salario medio de los empleados: "+llamadaProcedimiento.getFloat(2)+"\n Cantidad de empleados: "+(int)llamadaProcedimiento.getFloat(3));
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Número inválido");
		}
	}// main

}// class
