package ud1.manejoficheros;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class act11 {
    public static boolean exit = false;
    public static String idAtribute = "id";

    public static void AddEmployee(Document document, Scanner sc){
        int id = sc.nextInt();
        String name = sc.next();
        String lastName = sc.next();
        String department = sc.next();
        double salary = sc.nextDouble();
        Date date = parseDate(sc.next());

        Element elem = document.createElement("Empleado");
        elem.setAttribute("id", Integer.toString(id));
        elem.setIdAttribute(idAtribute, true);
        document.getDocumentElement().appendChild(elem);

        CreateElement(document, elem, "id", Integer.toString(id));
        CreateElement(document, elem, "name", name);
        CreateElement(document, elem, "lastName", lastName);
        CreateElement(document, elem, "department", department);
        CreateElement(document, elem, "salary", Double.toString(salary));
        CreateElement(document, elem, "date", String.valueOf(date.getDate()));
    }

    private static void CreateElement(Document doc, Element root, String name, String textVal){
        Element e = doc.createElement(name);
        Text text = doc.createTextNode(textVal);
        root.appendChild(e);
        e.appendChild(text);
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static void DeleteEmployee(Document doc, int id){
        Element e = doc.getElementById(Integer.toString(id));
        doc.getDocumentElement().removeChild(e);
    }

    public static void PrintEmployee(Document doc, int id){
        Element e = doc.getElementById(Integer.toString(id));
        NodeList n = e.getChildNodes();
        for (int i = 0; i < 6; i++) {
            System.out.println(n.item(i).getTextContent());
        }
    }

    public static void EditEmployee(Document doc, int id, Scanner sc){
        System.out.println("¿Que quieres editar?");
        System.out.println("--- name");
        System.out.println("--- lastname");
        System.out.println("--- department");
        System.out.println("--- salary");
        System.out.println("--- date");
        String tag = sc.next();
        System.out.println("¿Con que desea cambiarlo?");
        String s = sc.next();

        Element e = doc.getElementById(Integer.toString(id));
        NodeList n = e.getChildNodes();
        Node node;
        Element element;
        for (int i = 0; i < n.getLength(); i++) {
            if ((node = n.item(i)).getNodeName().equals(tag)) {
                element = (Element) node;
                element.removeChild(element.getFirstChild());
                Text t = doc.createTextNode(s);
                element.appendChild(t);
            }
        }
    }

    public static void Control(Document doc){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que desea hacer?");
        System.out.println("1 --- Alta");
        System.out.println("2 --- Baja");
        System.out.println("3 --- Consulta");
        System.out.println("4 --- Editar");
        System.out.println("5 --- Salir");
        String option = sc.next();

        switch (option){
            case "1" -> AddEmployee(doc, sc);

            case "2" -> {
                System.out.println("¿A quien desea dar de baja?");
                int s = sc.nextInt();
                DeleteEmployee(doc, s);
            }

            case "3" -> {
                System.out.println("¿A quien quieres consultar?");
                int id = sc.nextInt();
                PrintEmployee(doc, id);
            }

            case "4" -> {
                System.out.println("¿A quien quieres editar?");
                int id = sc.nextInt();
                EditEmployee(doc, id, sc);
            }

            case "5" ->
                exit = true;
        }

    }

    public static void MakeIDs(Document doc){
        Element e = doc.getDocumentElement();
        NodeList n = e.getChildNodes();

        for (int i = 0; i < n.getLength(); i++) {
            Element el = (Element) n.item(i);
            el.setIdAttribute(idAtribute, true);
        }
    }

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        File xml = new File("files/xml/empleados.xml");

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xml);

            MakeIDs(document);

            while (!exit) {
                Control(document);
                System.out.println();

                Source source = new DOMSource(document);
                Result result = new StreamResult(xml);
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.transform(source, result);
            }

        } catch (ParserConfigurationException e) {} catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }

    }
}
