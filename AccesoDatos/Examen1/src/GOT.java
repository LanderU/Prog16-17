import java.io.Serializable;

/**
 * 
 * @author Lander
 *
 */
public class GOT implements Serializable{
	
	private int numReino;
	private String nombre;
	private String emblema;
	private String lema;
	
	public GOT(int reino, String nom, String emb, String lem){
		
		this.numReino = reino;
		this.nombre = nom;
		this.emblema = emb;
		this.lema = lem;
		
	}// end constructor
	
	
	// Getter && Setters

	public int getNumReino() {
		return numReino;
	}

	public void setNumReino(int numReino) {
		this.numReino = numReino;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmblema() {
		return emblema;
	}

	public void setEmblema(String emblema) {
		this.emblema = emblema;
	}

	public String getLema() {
		return lema;
	}

	public void setLema(String lema) {
		this.lema = lema;
	}
	
	
	

}// class
