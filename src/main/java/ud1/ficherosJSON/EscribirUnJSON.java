package ud1.ficherosJSON;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EscribirUnJSON {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		// Instanciar ObjectMapper
		ObjectMapper mapper = new ObjectMapper();

		// Crear un mapa con datos
		Map<String, Object> empleado = new HashMap<>();
		empleado.put("id", 33);
		empleado.put("apellido", "FRAILE");
		empleado.put("dep", 30);
		empleado.put("salario", 3000.34);

		// Escribir datos en un fichero JSON
		//1-Salida normal (en una línea)
		File jsonFile = new File("salida.json");
		mapper.writeValue(jsonFile, empleado);

		//2-Salida 'bonita' (en varias líneas)
		File jsonFile_bonito = new File("salida-bonita.json");
		mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile_bonito,empleado);

		System.out.println("Ficheros creados.");
	}
}
