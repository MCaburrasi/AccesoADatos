package ud1.manejoficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

// Hacer en vez de con 2 clases diferentes, con un sólo programa que tenga un menú con las 2 opciones para elegir

// Codigo de alumno
// NOmbre de alumno
// FLoat ocn nota del alumno


public class Ej15 {
    public static void main(String[] args) {
        
        try {
            RandomAccessFile raf = new RandomAccessFile(new File("alumnos.dat"), "r");

            int numAlumno = Integer.parseInt(args[0]);

            raf.seek((numAlumno-1)*106);    // Son 104 bytes con los 100 de nombre + 4 del int + 2 que crea propios con la longitud que tiene el registro. Esto lo comprobamos con raf.length para cada registro
            int num = raf.readInt();
            String nombre = raf.readUTF();
            System.out.println(num);
            System.out.println(nombre);

            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

    }
}
