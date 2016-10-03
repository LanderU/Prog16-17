import javax.swing.JOptionPane;

/**
 * 
 * @author Lander
 *
 */
public class Semaforos2 {

	public static void main(String[] args) {
		
		int numJugadores = 0;
		
		try {
			
			numJugadores = Integer.parseInt(JOptionPane.showInputDialog("Número de niños"));
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"No es un número");
		}
		
		Hilo [] ninos = new Hilo [numJugadores];
		
		for (int i = 0; i < ninos.length; i++) {
			
			String nombre = JOptionPane.showInputDialog("Nombre del "+(i+1)+" niño");
			
			int nCromos = 0;
			try {
				nCromos = Integer.parseInt(JOptionPane.showInputDialog("Número de cromos"));
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"No es un número");
			}
			
			ninos[i] = new Hilo(nCromos);
			ninos[i].setName(nombre);
			ninos[i].start();
			
		}// end for
		
	}// main

}// class
