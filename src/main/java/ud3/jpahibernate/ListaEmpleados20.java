package ud3.jpahibernate;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ud3.jpahibernate.clases.Empleados;
import ud3.jpahibernate.clases.HibernateUtil;


public class ListaEmpleados20 {

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);

		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Query <Empleados>q = session.createQuery("from Empleados as e where e.departamentos.deptNo = 20", Empleados.class);
		List<Empleados> lista = q.list();
		
		for(Empleados emp: lista) {		
			System.out.printf("%s, %,9.2f %s%n", emp.getApellido(), emp.getSalario(),
					emp.getDepartamentos().getDnombre());
		}

		session.close();
		sessionFactory.close();
		
	}

}
