package ud1.manejoficheros;

import java.io.File;

public class MostrarDirectorioActual {
    public static void main(String[] args) {
        File f = new File(".");
        String[] fileList = f.list();

        System.out.println("Los ficheros del directorio actual son:");

        for (int i=0;i< fileList.length;i++){
            System.out.println(fileList[i]);
        }
    }
}
