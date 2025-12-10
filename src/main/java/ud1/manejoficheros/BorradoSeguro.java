package ud1.manejoficheros;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BorradoSeguro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File papelera = new File("C:/Users/Marcos/Desktop/Papelera/");
        Map<File, Integer> papeleraIn = new HashMap<>();

        try {
            if (!papelera.exists()){
                papelera.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (sc.hasNext()) {
            String file = sc.next();
            File f = new File(file);
            if (!papeleraIn.containsKey(f)) {
                papeleraIn.put(f, 1);
            } else {
                papeleraIn.replace(f, papeleraIn.get(f) + 1);
            }

            if (f.exists()){
                String fileNumber = "";
                int num;
                if ((num = papeleraIn.get(f)) != 1)
                    fileNumber = Integer.toString(num);
                String fileName = f.getName() + fileNumber;
                boolean can = f.renameTo(new File("C:/Users/Marcos/Desktop/Papelera/" + fileName));
                System.out.println(can);
            }
        }



        for (int i = 0; i < papeleraIn.size(); i++) {

        }

    }
}
