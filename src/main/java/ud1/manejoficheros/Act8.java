package ud1.manejoficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Act8 {
    public static void main(String[] args) {
        File out = null;
        Scanner sc = new Scanner(System.in);

        if (args.length >= 1) {
            out = new File(args[0]);
            try (FileWriter os = new FileWriter(out, true)){
                int c;
                os.write("\n" + sc.next());

            } catch (IOException e){
                e.printStackTrace();
            }
        }

        try {
            if (!out.exists()){
                out.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
