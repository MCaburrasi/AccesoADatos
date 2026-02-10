package ud3.jpahibernate;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ud3.jpahibernate.clases.Departamentos;
import ud3.jpahibernate.clases.HibernateUtil;


public class ListaDepartamentos {

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);

		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();	
					
		Query<Departamentos> q = session.createQuery("from Departamentos order by deptNo", Departamentos.class);
		List <Departamentos> lista = q.list();
		
		System.out.printf("Numero de registros: %d%n",lista.size());
		for(Departamentos depar: lista)	{
		    System.out.printf("%d, %s%n", depar.getDeptNo(), depar.getDnombre());		   
		}
		session.close();
		sessionFactory.close();	
	}
}
