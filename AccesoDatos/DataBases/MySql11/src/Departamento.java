import java.io.Serializable;

/**
 * 
 * @author Lander
 *
 */
public class Departamento implements Serializable{
	
	
	private int dept_no;
	private String dnombre;
	private String localidad;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dept_no;
		result = prime * result + ((dnombre == null) ? 0 : dnombre.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
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
		if (dept_no != other.dept_no)
			return false;
		if (dnombre == null) {
			if (other.dnombre != null)
				return false;
		} else if (!dnombre.equals(other.dnombre))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		return true;
	}

	
	public Departamento(int dep, String nom, String loc){
		this.dept_no = dep;
		this.dnombre = nom;
		this.localidad = loc;
	}// end constructor
	
	

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public String getDnombre() {
		return dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
}// class
