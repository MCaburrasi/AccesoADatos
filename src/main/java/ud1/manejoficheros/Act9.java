package ud1.manejoficheros;

import ud1.manejoficheros.exceptions.LineaComandosException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Act9 {
    public static String FormatLine(String s){
        String[] stringArray = s.split("\\.");
        String formated = "";
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i].strip();
            if (stringArray[i].isEmpty())
                continue;
            else if (i != 0 && (stringArray[i].charAt(0) >= 97 && stringArray[i].charAt(0) <= 122))
                stringArray[i] = Character.toUpperCase(stringArray[i].charAt(0)) + stringArray[i].substring(1);

            formated += stringArray[i] + ". ";
        }

        return formated;
    }

    public static void main(String[] args) throws LineaComandosException {
        File fout;
        File fin;

        if (args.length == 1){
            fout = new File(args[0]);
            fin = new File(args[0] + "-formateado");
        } else if (args.length == 2){
            fout = new File(args[0]);
            fin = new File(args[1]);
        } else {
            throw new LineaComandosException("La linea de comandos debe tener 1 o 2 argumentos");
        }

        try(BufferedReader br = new BufferedReader(new FileReader(fout));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fin)))
        {
            String s;
            while ((s = br.readLine()) != null){
                bw.write(FormatLine(s));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
