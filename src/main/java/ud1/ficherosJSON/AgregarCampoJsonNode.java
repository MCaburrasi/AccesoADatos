package ud1.ficherosJSON;
/*
 * Agrega un campo a un JSON a una persona
 */
import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class AgregarCampoJsonNode {

	public static void main(String[] args) throws Exception {
		// Crear ObjectMapper
		ObjectMapper mapper = new ObjectMapper();

		// Leer el archivo JSON como JsonNode
		File jsonFile = new File("persona.json");
		JsonNode rootNode = mapper.readTree(jsonFile);

		// Verificar si es un ObjectNode (para añadir campos)
		if (rootNode.isObject()) {
			ObjectNode objectNode = (ObjectNode) rootNode;

			// Añadir dos nuevos campos al JSON
			objectNode.put("edad", 20);
			objectNode.put("ciudad", "Madrid");
              //si quisieramos eliminar un campo
              //objectNode.remove("ciudad");

			// Guardar los cambios en el archivo
           File jsonFile_salida;
               //si queremos que se modifique el archivo de entrada
		       //jsonFile_salida=jsonFile;
		   //si queremos que la salida sea en otro fichero
		    jsonFile_salida= new File("empleados-modificado-anadirYBorrarCampo.json");


			mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile_salida, objectNode);

			System.out.println("Elemento añadido al JSON.");
			
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode));

		}

	}
}
