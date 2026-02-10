package ud3.jpahibernate;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ud3.jpahibernate.clases.Departamentos;
import ud3.jpahibernate.clases.Empleados;
import ud3.jpahibernate.clases.HibernateUtil;

public class ListadoDep10 {

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);

		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		System.out.println("==============================");
		System.out.println("DATOS DEL DEPARTAMENTO 10.");

		Departamentos dep = session.get(Departamentos.class,(byte) 10);

		//Departamentos dep = (Departamentos) session.get("clases.Departamentos", (byte) 10);

		if (dep == null) {
			System.out.println("El departamento no existe");
		} else {
			System.out.println("Identificador de la entidad: " + session.getIdentifier(dep));

			System.out.println("Nombre Dep:" + dep.getDnombre());
			System.out.println("Localidad:" + dep.getLoc());

			System.out.println("==============================");
			System.out.println("EMPLEADOS DEL DEPARTAMENTO 10.");

			// obtenemos empleados
			Set<Empleados> listaemple = dep.getEmpleadoses();

			System.out.printf("Número de empleados: %d %n", listaemple.size());
			for (Empleados emple : listaemple) {
				System.out.printf("%s * %,9.2f %n", emple.getApellido(), emple.getSalario());
			}
			System.out.println("==============================");

		}
		session.close();
		sessionFactory.close();
	}
}