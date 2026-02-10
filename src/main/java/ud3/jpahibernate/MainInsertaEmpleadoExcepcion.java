package ud3.jpahibernate;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ud3.jpahibernate.clases.Departamentos;
import ud3.jpahibernate.clases.Empleados;
import ud3.jpahibernate.clases.HibernateUtil;

public class MainInsertaEmpleadoExcepcion {

	public static void main(String[] args) {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Inserto un EMPLEADO EN EL DEPARTAMENTO 10.");

		BigDecimal salario = new BigDecimal(1500);// inicializo el salario
		BigDecimal comision = new BigDecimal(10); // inicializo la comisi�n

		Empleados em = new Empleados(); // creo un objeto empleados
		em.setEmpNo((short) 4456); // el numero de empleado es 4455
		em.setApellido("PEPE");
		em.setDir((short) 7499); // el director es el numero de empleado 7499
		em.setOficio("VENDEDOR");
		em.setSalario(salario);
		em.setComision(comision);

		Departamentos d = new Departamentos(); // creo un objeto Departamentos
		d.setDeptNo((byte) 10); // el numero de dep es 10
		em.setDepartamentos(d);

		// fecha de alta
		java.util.Date hoy = new java.util.Date();
		java.sql.Date fecha = new java.sql.Date(hoy.getTime());
		em.setFechaAlt(fecha);

		session.persist(em);

		try {
			tx.commit();
			System.out.println("Empleado Insertado");
			
		} catch (org.hibernate.exception.ConstraintViolationException ex1) {			
			System.out.println("EL EMPLEADO YA EXISTE");			
		} catch (org.hibernate.exception.GenericJDBCException ex2) {
			System.out.println("ERROR EN LOS DATOS...");
			System.out.printf(ex2.getMessage());			
		} catch (java.lang.IllegalStateException ex3) {
			System.out.println("EL DEPARTAMENTO NO EXISTE.....");

		} catch (Exception e) {
			System.out.printf("HA OCURRIDO UN ERROR: %s%n", e.getMessage());
			e.printStackTrace();
		}

		session.close();		
		sessionFactory.close();
		
	}
}
