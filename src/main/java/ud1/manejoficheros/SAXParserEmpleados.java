package ud1.manejoficheros;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Use SAX Parser to display all employees: id, apellido, dep, salario
 */
public class SAXParserEmpleados {
    private String currentElement;
    private int bookCount = 1;
    private static EmployeeColection employees;

    // Constructor
    public SAXParserEmpleados() {
        try {
            employees = new EmployeeColection();
            MyHandler handler = new MyHandler();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File("files/xml/empleados.xml"), handler);

            for (Employee e : handler.getEmployees()){
                employees.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getEmployees() {
        return employees.getEmployeeList();
    }

    public static void AddEmployee(Scanner sc){
        System.out.println("¿Who would you like to add?");
        System.out.print("ID: ");
        String id = sc.next();

        System.out.print("Apellido: ");
        String lastName = sc.next();

        System.out.print("Departamento: ");
        String dep = sc.next();

        System.out.print("Salario: ");
        String salary = sc.next();

        employees.add(new Employee(id, lastName, dep, salary));
    }

    public static void RemoveEmployee(Scanner sc){
        System.out.println("¿Who do you want to remove?");

    }

    public static void ViewEmployee(Scanner sc){

    }

    public static void EditEmployee(Scanner sc){

    }

    // Entry main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        SAXParserEmpleados sax = new SAXParserEmpleados();

        while (true){
            System.out.println("¿Que desea hacer?: ");
            System.out.println("1 --- Alta");
            System.out.println("2 --- Baja");
            System.out.println("3 --- Consulta");
            System.out.println("4 --- Edición");

            int option = sc.nextInt();

            switch (option){
                case 1 -> AddEmployee(sc);
                case 2 -> RemoveEmployee(sc);
                case 3 -> ViewEmployee(sc);
                case 4 -> EditEmployee(sc);
                default -> {
                    break;
                }
            }
        }
    }

    /*
     * Inner class for the Callback Handlers.
     */
    class MyHandler extends DefaultHandler {
        private List<Employee> employees = new LinkedList<>();
        private String id;
        private String apellido;
        private String departamento;
        private String salario;

        public List<Employee> getEmployees() {
            return employees;
        }

        // Callback to handle element start tag
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;

            if (currentElement.equals("empleado")) {
                id = attributes.getValue("id");
            }
        }

        // Callback to handle element end tag
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = "";
        }

        // Callback to handle the character text data inside an element
        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (currentElement.equals("apellido")) {
                apellido = new String(chars, start, length);
            }else if (currentElement.equals("dep")) {
                departamento = new String(chars, start, length);
            }else if (currentElement.equals("salario")) {
                salario = new String(chars, start, length);
                employees.add(new Employee(id, apellido, departamento, salario));
            }
        }
    }

    static class Employee {
        private int bookNumber;
        private String id;
        private String apellido;
        private String departamento;
        private String salario;

        public Employee(String id, String apellido, String departamento, String salario) {
            this.id = id;
            this.apellido = apellido;
            this.departamento = departamento;
            this.salario = salario;
        }

        @Override
        public String toString() {
            return "Employee" + id + "[" + "id=" + id + ", apellido=" + apellido + ", departamento=" + departamento + ", salario=" + salario + ']';
        }
    }

    private class EmployeeColection{
        private List<Employee> employeeList;

        public EmployeeColection() {
            this.employeeList = new LinkedList<>();
        }

        public List<Employee> getEmployeeList() {
            return employeeList;
        }

        public void add(Employee employee) {
            employeeList.add(employee);
        }

        public void remove(String id){

        }
    }
}

