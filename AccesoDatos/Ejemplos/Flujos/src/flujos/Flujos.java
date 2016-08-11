/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flujos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author lander
 */
public class Flujos {

    /**
     * @param args the command line arguments
     */
    
   // Path del archivo.
    static final File ARCHIVO = new File("/home/lander/github/Prog16-17/AccesoDatos/Ejemplos/Flujos/nombres");
    
    public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        if(!ARCHIVO.exists()){
            
            System.out.println("El archivo no se puede abrir");
            System.out.println("Salimos...");
            Thread.sleep(2000);
            System.exit(0);
        
        }else{
        
                FileReader lectura = new FileReader(ARCHIVO);
                
                int i;
                
                while ((i = lectura.read()) != -1){
                
                    System.out.print((char) i);
                }
        
        }//end if
        
        
    }//main

}//class
