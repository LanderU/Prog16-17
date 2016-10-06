import javax.swing.JOptionPane;

/**
 * 
 * @author Lander
 *
 */
public class Semaforos2 {

	public static void main(String[] args) {
		
		//int numJugadores = 0;
		//Caja c = new Caja();
		
		//try {
			
			//numJugadores = Integer.parseInt(JOptionPane.showInputDialog("Número de niños"));
			
		//} catch (NumberFormatException e) {
			// TODO: handle exception
		//	JOptionPane.showMessageDialog(null,"No es un número");
		//}
		
		Hilo [] ninos = new Hilo [4];
		
		String [] nombres = {"Fermin", "Eider","Alberto","Lander"};
		
		for (int i = 0; i < nombres.length; i++) {

			
			int nCromos = 0;
			try {
				nCromos = Integer.parseInt(JOptionPane.showInputDialog("Número de cromos"));
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"No es un número");
			}
			ninos[i] = new Hilo(nCromos);
			ninos[i].setName(nombres[i]);
			
		}// end for
		
		for (int i = 0; i < nombres.length; i++) {
			ninos[i].start();
		}
		
	}// main

}// class
