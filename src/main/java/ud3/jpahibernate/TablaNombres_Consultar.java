package ud3.jpahibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;

import ud3.jpahibernate.clases.HibernateUtil;
import ud3.jpahibernate.clases.Nombres;


public class TablaNombres_Consultar {

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		
		Query<Nombres> q = session.createQuery("from Nombres order by nombre", Nombres.class);
		List <Nombres> lista = q.list();
		
		System.out.printf("Numero de registros: %d%n",lista.size());
		for(Nombres nom: lista)	{
		    System.out.printf("%d, %s  %s%n", nom.getId(), nom.getNombre(), nom.getFechac());		   
		}
		
		// Cerrar la sesión
		session.close();
		sessionFactory.close();
		
	}

}
