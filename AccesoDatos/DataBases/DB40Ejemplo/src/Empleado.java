/**
 * 
 * @author Lander
 *
 */
public class Empleado {
	
	private Integer idEmpleado;
	private String nomEmpleado;
	private Integer departamento;
	
	// Constructores
	
	public Empleado(Integer id, String nom, Integer dep){
		this.idEmpleado = id;
		this.nomEmpleado = nom;
		this.departamento = dep;
	}// end constructor
	
	public Empleado(){
		this.idEmpleado = null;
		this.nomEmpleado = null;
		this.departamento = null;
	}// end constructor

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNomEmpleado() {
		return nomEmpleado;
	}

	public void setNomEmpleado(String nomEmpleado) {
		this.nomEmpleado = nomEmpleado;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
	
	

}// class
