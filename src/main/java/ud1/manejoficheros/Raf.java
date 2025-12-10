package ud1.manejoficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Raf {
    public static void main(String[] args) {
        File raftest = new File("files/raftest");
        try (RandomAccessFile raf = new RandomAccessFile(raftest, "rw");
             Scanner sc = new Scanner(System.in)){
            Map<Integer, Integer> map = new HashMap<>();

            while (true){
                System.out.println("What do you want to do? (R)ead / (W)rite / (E)xit");
                String option = sc.next();
                raf.seek(0);

                switch (option){
                    case "w":{
                        System.out.println("Who do you want to add?");
                        int studentNum = sc.nextInt();
                        String studentName = sc.nextLine();

                        raf.seek((studentNum - 1) * 100L);
                        while (studentName.length() < 100)
                            studentName += " ";

                        raf.writeUTF(studentName);
                    }

                    case "r":{
                        System.out.println("Who do you want to see?");
                        int num = sc.nextInt();
                        raf.seek((num - 1) * 100L);
                        byte[] b = new byte[100];
                        raf.read(b);
                        System.out.println(new String(b).substring(3));
                    }

                    default: {
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
