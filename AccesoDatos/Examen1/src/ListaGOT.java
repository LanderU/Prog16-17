import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Lander
 *
 */
public class ListaGOT {
	
	private List <GOT> listaReinos = new ArrayList<GOT>();
	
	public void anadir (GOT r){
		
		listaReinos.add(r);
	}//end anadir
	
	
	
	public List<GOT> getListaReinos() {
		return listaReinos;
	}
	

}// class
