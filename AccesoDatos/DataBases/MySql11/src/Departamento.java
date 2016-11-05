/**
 * 
 * @author Lander
 *
 */
public class Departamento implements Serializable{

	private int dept_no;
	private String dnombre;
	private String localidad;
	
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
