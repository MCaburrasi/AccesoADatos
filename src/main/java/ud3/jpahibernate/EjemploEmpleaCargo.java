package ud3.jpahibernate;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ud3.jpahibernate.clases.Empleados;
import ud3.jpahibernate.clases.HibernateUtil;

public class EjemploEmpleaCargo {

	public static void main(String[] args) {
		// 
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
			
		String hql = "from Empleados as emp right join emp.empleacargo order by emp.empNo";
		Query<Object[]> q = session.createQuery(hql, Object[].class);
		List <Object[]> lista = q.list();
		
		for(Object[] emple: lista) {			
			Empleados dir = (Empleados) emple[0];//director
			Empleados em = (Empleados) emple[1]; //empleado
			if(dir!=null)				
			System.out.printf("Empleado: %d, %s, DIRECTOR: %d, %s %n",					
					em.getEmpNo(), em.getApellido(), 
					dir.getEmpNo(), dir.getApellido());
			else
				System.out.printf("Empleado %d, %s, SIN DIRECTOR.%n",					
						em.getEmpNo(), em.getApellido());					
		}
		
		session.close();
		sessionFactory.close();
		
	}

}
