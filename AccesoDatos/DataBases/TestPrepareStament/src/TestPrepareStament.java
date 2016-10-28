import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * @author Lander
 *
 */

public class TestPrepareStament {
	
	public static final String FOR_NAME="com.mysql.jdbc.Driver";
	public static final String CONNECTION="jdbc:mysql://localhost/ejercicio1";
	public static final String USERNAME="root";
	public static final String PASSWORD="erle";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName(FOR_NAME);
		Connection conn = DriverManager.getConnection(CONNECTION,USERNAME,PASSWORD);
		
		String sql = "INSERT into empleados values (7112,'Usategui','director',7112,'2016-10-28',140.0,?)";
		PreparedStatement sentencia = conn.prepareStatement(sql);
		int dept_no = 10;
		sentencia.setInt(1,dept_no);
		int total = sentencia.executeUpdate();
		
		if (total > 0){
			System.out.println("Bien");
		}else{
			System.out.println("Mal");
		}
		sentencia.close();
		conn.close();
		
	}// main

}// class
