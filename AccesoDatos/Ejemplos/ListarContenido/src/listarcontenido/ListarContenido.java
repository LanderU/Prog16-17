import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Lander
 *
 */

public class main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Escriba la ruta a auditar: ");
        
        String ruta = br.readLine();
        
        File directorio = new File (ruta);
        
        if (!directorio.exists()){
            
            System.out.println("La ruta indicada no existe, salimos...");
            Thread.sleep(1000); 
            System.exit(0);
        }else{
            File [] contenido = directorio.listFiles();
            
            for (int i = 0; i < contenido.length; i++){
                if(contenido[i].isDirectory()){
                    System.out.println(contenido[i].toString()+" Es un directorio");
                    if(contenido[i].canRead()){
                        System.out.println("Además se puede leer");
                        
                        if (contenido[i].canWrite()){
                            
                            System.out.println("Y escribir");
                        }// end if
                        
                    }// end if
                
                    System.out.println(contenido[i].getAbsolutePath()+" Es su ruta absoluta");
                    System.out.println("El tamaño del archivo es: "+contenido[i].length());
                }else{
                    System.out.println(contenido[i].toString()+"Es un archivo");
                    if(contenido[i].canRead()){
                        System.out.println("Además se puede leer");
                        
                        if (contenido[i].canWrite()){
                            
                            System.out.println("Y escribir");
                        }// end if
                        
                    }// end if
                
                    System.out.println(contenido[i].getAbsolutePath()+" Es su ruta absoluta");
                    System.out.println("El tamaño del archivo es: "+contenido[i].length());
                }
                
            }// end for
            
        }// end if
        
    }// main

}// class