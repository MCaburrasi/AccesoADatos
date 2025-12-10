package ud1.manejoficheros;

import java.io.*;

public class Act7 {
    public static void main(String[] args) {
        File in = null;
        File out = null;

        if (args.length >= 2) {
            in = new File(args[0]);
            out = new File(args[1]);
            try (FileReader is = new FileReader(in);
                 FileWriter os = new FileWriter(out)){

                int c;
                while ((c = is.read()) != -1){
                    os.write(Character.toUpperCase(c));
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
