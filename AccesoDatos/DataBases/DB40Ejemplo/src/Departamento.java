/**
 * 
 * @author Lander
 *
 */
public class Departamento {
	
	private Integer numDept;
	private String nombre;
	
	// Test
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numDept == null) ? 0 : numDept.hashCode());
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
		Departamento other = (Departamento) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numDept == null) {
			if (other.numDept != null)
				return false;
		} else if (!numDept.equals(other.numDept))
			return false;
		return true;
	}

	public Departamento(int dep, String nom){
		this.numDept = dep;
		this.nombre = nom;
		
	}// end constructor
	
	public Departamento(){
		
		this.numDept = null;
		this.nombre = null;
	}
	
	
	public int getNumDept() {
		return numDept;
	}
	public void setNumDept(int numDept) {
		this.numDept = numDept;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}// class
