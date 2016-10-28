import java.awt.Window.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 
 * @author Lander
 *
 */
public class ProcedimientosAlmacenados {

	public static final String FOR_NAME="com.mysql.jdbc.Driver";
	public static final String CONNECTION="jdbc:mysql://localhost/ejercicio1?noAccessToProcedureBodies=true";
	public static final String USERNAME="root";
	public static final String PASSWORD="erle";
		
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName(FOR_NAME);
		Connection conn = DriverManager.getConnection(CONNECTION,USERNAME,PASSWORD);
		
		String sql = "{? = call findDepartamentoName(?)}";
		
		CallableStatement exec = conn.prepareCall(sql);
		exec.setInt(2, 10);
		exec.registerOutParameter(1,Types.VARCHAR);
		exec.executeUpdate();
		
		System.out.println(exec.getString(1));
		exec.close();
		conn.close();
		
		
	}// main

}// class
