package ud3.jpahibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ud3.jpahibernate.clases.Empleados;
import ud3.jpahibernate.clases.HibernateUtil;

public class EjemploEmpleaCargo2 {
	public static void main(String[] args) {
		//
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		String hql = "from Empleados ";
		Query<Empleados> q = session.createQuery(hql, Empleados.class);
		
		List<Empleados> lista = q.list();
	
		System.out.println("========================================");
		for(Empleados emple: lista) {		
			if (emple != null) {
				Set<Empleados> empleaCargo = emple.getEmpleacargo(); //empleados a cargo

				if (empleaCargo.size() == 0) {// no son directores
					System.out.printf("EMPLEADO: %d, %s %n", emple.getEmpNo(), emple.getApellido());
					System.out.println("========================================");
				} else {
					System.out.printf("DIRECTOR: %d, %s %n", 
							 emple.getEmpNo(), emple.getApellido());
					System.out.println("Empleados a cargo: " + empleaCargo.size());					
					
					for(Empleados em: empleaCargo ) {				
						System.out.printf("\t %d, %s %n", 
								em.getEmpNo(), em.getApellido());
					}
					System.out.println("========================================");
				}
			}
		}//

		session.close();
		sessionFactory.close();

	}

}
