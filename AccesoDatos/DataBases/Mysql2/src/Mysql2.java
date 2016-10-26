import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import java.util.Calendar;

public class Mysql2 {
	
	public static final String FOR_NAME="com.mysql.jdbc.Driver";
	public static final String CONNECTION="jdbc:mysql://localhost/ejercicio1";
	public static final String USERNAME="root";
	public static final String PASSWORD="erle";
	
	public static boolean CheckSize(String cadena){
		
		if (cadena.length() == 0){
			return false;
		}else{
			return true;
		}
		
	}// end CheckSize

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		Class.forName(FOR_NAME);
		Connection conn = DriverManager.getConnection(CONNECTION,USERNAME,PASSWORD);
		int numEmp = 0;
		String apellido = "";
		String oficio = "";
		int jefe = 0;
		double salario = 0.0;
		int departamento = 0;
		try {
			numEmp = Integer.parseInt(JOptionPane.showInputDialog("Número de empleado"));
			Statement checkEmp = conn.createStatement();
			ResultSet numEmpleado = checkEmp.executeQuery("SELECT emp_no FROM empleados where emp_no = "+numEmp);
			if (numEmpleado.next()){
				JOptionPane.showMessageDialog(null, "Error ese número de empleado ya está");
				System.exit(0);
			}else{
				apellido = JOptionPane.showInputDialog("Apellido del empleado");
				if(!CheckSize(apellido)){
					JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
					System.exit(0);
				}else{
					oficio = JOptionPane.showInputDialog("Introduzca el oficio");
					if (!CheckSize(oficio)){
						JOptionPane.showMessageDialog(null, "El campo no puede ser vacio");
						System.exit(0);
					}else {
						try {
							jefe = Integer.parseInt(JOptionPane.showInputDialog("Número de jefe para el empleado"));
							Statement checkJefe = conn.createStatement();
							ResultSet numJefe = checkJefe.executeQuery("SELECT emp_no FROM empleados where emp_no ="+jefe);
							if(numJefe.next()){
								Calendar fecha = Calendar.getInstance();
								int ano = fecha.get(Calendar.YEAR);
								int mes = fecha.get(Calendar.MONTH);
								int dia = fecha.get(Calendar.DAY_OF_MONTH);
								String fechaString = new String(ano+"-"+mes+"-"+dia);
								try {
									salario = Double.parseDouble(JOptionPane.showInputDialog("Salario mensual del empleado"));
									if (salario <= 0.0){
										JOptionPane.showMessageDialog(null, "Salario no válido");
										System.exit(0);
									}else{
										try {
											departamento = Integer.parseInt(JOptionPane.showInputDialog("Número de departamento al que pertenece"));
											Statement checkDepart = conn.createStatement();
											ResultSet findDepart = checkDepart.executeQuery("SELECT dept_no FROM departamentos where dept_no ="+departamento);
											if (findDepart.next()){
												// estamos listos para insertar los datos
												Statement insertar = conn.createStatement();
												// orden num_emp,apellido,oficio,jefe,fecha_alta,salario,departamento
												int tuplas = insertar.executeUpdate("INSERT INTO empleados VALUES ("+numEmp+",'"+apellido.toUpperCase()+"','"+oficio.toUpperCase()+"',"+jefe+",'"+fechaString+"',"+salario+","+departamento+")");
												if(tuplas > 0){
													JOptionPane.showMessageDialog(null, "Empleado guardado!!");
													System.exit(0);
												}else{
													JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
													System.exit(0);
												}
											}else{
												JOptionPane.showMessageDialog(null, "Departamento no válido");
												System.exit(0);
											}// end if
										} catch (NumberFormatException e) {
											JOptionPane.showMessageDialog(null, "Número no válido");
											System.exit(0);
										}
									}// end if
								} catch (NumberFormatException e) {
									JOptionPane.showMessageDialog(null, "Número no válido");
									System.exit(0);
								}
							}else{
								JOptionPane.showMessageDialog(null, "El jefe tiene que ser un empleado");
								System.exit(0);
							}// end if
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Número no válido");
							System.exit(0);
						}
					}// end if
				}// end if
			}//end if
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Número no válido");
			System.exit(0);
		}
	}// main

}// class
