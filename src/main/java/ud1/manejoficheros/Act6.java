package ud1.manejoficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Act6 {
    public static void main(String[] args) {
        boolean append = false;
        File in;
        File out = null;

        if (args.length == 3 && args[2].equals("-a"))
            append = true;

        if (args.length >= 2) {
            in = new File(args[0]);
            out = new File(args[1]);
            try (FileInputStream is = new FileInputStream(in);
                 FileOutputStream os = new FileOutputStream(out, append)){

                int c;
                while ((c = is.read()) != -1){
                    os.write(c);
                }

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
