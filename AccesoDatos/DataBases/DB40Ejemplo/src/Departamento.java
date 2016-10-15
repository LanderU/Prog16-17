/**
 * 
 * @author Lander
 *
 */
public class Departamento {
	
	private Integer numDept;
	private String nombre;
	
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
