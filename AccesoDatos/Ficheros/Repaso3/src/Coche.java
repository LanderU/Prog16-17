import java.io.Serializable;

/**
 * 
 * @author Lander
 *
 */
public class Coche implements Serializable{
	
	private String matricula;
	private Double deposito;
	private String modelo;
	
	public Coche(String matricula, Double deposito, String modelo){
		
		this.matricula = matricula;
		this.deposito = deposito;
		this.modelo = modelo;
		
	}// end Constructor
	
	// Getters & Setters

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Double getDeposito() {
		return deposito;
	}

	public void setDeposito(Double deposito) {
		this.deposito = deposito;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
}// end class
