import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Lander
 *
 */

public class EscribirString {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileWriter escritura = new FileWriter(new File ("fichero"));
		
		String [] cav = {"Álava", "Vizcaya", "Guipuzcoa"};
		
		for(int i = 0; i < cav.length; i++){
			
			if ( i == cav.length){
				
				escritura.write(cav[i]);
				
			}else{
				
				escritura.write(cav[i]+" ");
				
				
			}// end if
			
		}// end for
		
		escritura.close();

	}// main

}// class
