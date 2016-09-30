import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Lander
 *
 */
public class ListaPersonas {
	
	private List<Persona> listado = new ArrayList<Persona>();
	
	public ListaPersonas (){

	}// end constructor
	
	public void addPersona(Persona p){
		
		listado.add(p);
		
	}// end addPersona
	
	// Método de lectura
	public List<Persona> listado (){
		
		return listado;
	}
	

}// class
