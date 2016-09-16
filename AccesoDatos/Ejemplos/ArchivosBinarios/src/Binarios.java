import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author Lander
 *
 */
public class Binarios {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File ficBinario = new File ("archivo");
		FileOutputStream data = new FileOutputStream(ficBinario);
		DataOutputStream escritura = new DataOutputStream(data);
		
		String [] nombres = {"Ana","Luis Miguel","Alicia","Pedro","Manuel"
							+"Andrés","Júlio","Antonio","MarÌa Jesús"};
		
		int [] edades = {10,20,40,18,32,56,89,19,32};
		
		for(int i = 0; i < nombres.length; i++){
			
			escritura.writeUTF(nombres[i]);
			escritura.writeInt(edades[i]);
			
		}// end for
		
		escritura.close();

	}// main

}//class
