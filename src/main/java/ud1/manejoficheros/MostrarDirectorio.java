package ud1.manejoficheros;

import ud1.manejoficheros.exceptions.LineaComandosException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class MostrarDirectorio {
    private static void showHelp(){
        System.out.println("Forma de ejecución del programa: MostrarDirectorio(String directorio)");
        System.out.println("Donde directorio es la ubicación absoluta o relativa del directorio que quieres comprobar");
        System.out.println("Este programa te devuelve una lista de aquellos archivos hay en esta ubicación");
    }

    public static void main(String[] args) throws FileNotFoundException, LineaComandosException{
        if (args.length != 1){
            throw new LineaComandosException("Numero de argumentos incorrecto, debe introducir 1 solo argumento");
        } else if (args[0].equals("-h")){
            showHelp();
        } else {
            File f = new File(args[0]);
            if (!f.exists())
                throw new FileNotFoundException("Directorio no encontrado");

            if (f.isDirectory()){
                String[] fileList = f.list();
                Arrays.sort(fileList); //Actividad 3

                System.out.println("Los ficheros del directorio actual son:");
                for (int i=0;i< fileList.length;i++){
                    System.out.println(fileList[i]);
                }
            } else {
                System.out.println(f.getName());
            }

        }
    }
}
