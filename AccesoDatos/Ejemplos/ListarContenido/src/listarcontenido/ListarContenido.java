/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listarcontenido;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author lander
 */
public class ListarContenido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        
        /*
            Realiza un programa que liste los ficheros de un directorio, El nombre del directorio se pedirá por consola.
        
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String carpeta = "";
        
        System.out.print("Escriba el ruta+nombre de la carpeta que desea listar: ");
        carpeta = br.readLine();
        
        File directorio = new File(carpeta);
        
        if (!directorio.exists()){
        
            System.out.println("El directorio, "+carpeta+ " no existe.");
            System.out.println("Salimos...");
            Thread.sleep(1000);
            System.exit((0));
        }else{
            
            String [] archivos = directorio.list();
            
            if (archivos.length == 0){
                System.out.println("No hay ningún archivo en el directorio, "+ carpeta);
                System.out.println("Salimos...");
                Thread.sleep(1000);
                System.exit(0);
            }else {
                
                System.out.print("El directorio, "+carpeta+" contiene los siguientes archivos/directorios: ");
                    
                for (int i = 0; i < archivos.length; i++) {
                    
                    System.out.println(archivos[i]);
                        
                }//end for
            
            }//end if
        
        }//end if
        
        
    }//main

}//class
