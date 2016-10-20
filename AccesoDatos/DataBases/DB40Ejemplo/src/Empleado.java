/**
 * 
 * @author Lander
 *
 */
public class Empleado {
	
	private Integer idEmpleado;
	private String nomEmpleado;
	private Integer departamento;
	
	// Test
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEmpleado == null) ? 0 : idEmpleado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (idEmpleado == null) {
			if (other.idEmpleado != null)
				return false;
		} else if (!idEmpleado.equals(other.idEmpleado))
			return false;
		return true;
	}
	
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
