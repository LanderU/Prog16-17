import java.io.Serializable;

/**
 * 
 * @author Lander
 *
 */

public class Persona implements Serializable{
	
	// Variables
	private String nombre;
	private int edad;
	
	// Constructor
	public Persona(String nombre, int edad){
		
		this.nombre = nombre;
		this.edad = edad;
		
	}// end contructor
	
	// Métodos
	public void setNombre(String nom){
		nombre = nom;
	}//end setNombre
	
	public void setEdad(int ed){
		edad = ed;
	}// end setEdad
	
	public String getNombre() {
		return nombre;
	}//end getNombre
	
	public int getEdad(){
		return edad;
	}//end getEdad
	

}// class
