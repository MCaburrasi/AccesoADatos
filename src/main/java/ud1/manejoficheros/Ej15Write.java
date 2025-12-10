package ud1.manejoficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ej15Write {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        try {
            RandomAccessFile raf = new RandomAccessFile(new File("alumnos.dat"), "rw");

            while (true) {
                System.out.println("Número de alumno:");
                int numAlumno = sc.nextInt();
                if (numAlumno == 0)
                    break;
                sc.nextLine();
                System.out.println("Nombre de alumno:");
                String nombreAlumno = sc.nextLine();

                while (nombreAlumno.length() < 100)
                    nombreAlumno += " ";
                
                raf.writeInt(numAlumno);
                raf.writeUTF(nombreAlumno);

                System.out.println(raf.length());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

    }
}
