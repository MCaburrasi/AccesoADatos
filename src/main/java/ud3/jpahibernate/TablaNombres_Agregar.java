package ud3.jpahibernate;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ud3.jpahibernate.clases.HibernateUtil;
import ud3.jpahibernate.clases.Nombres;

public class TablaNombres_Agregar {

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);

		SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		// Crear varios nombres
		Nombres nombre1 = new Nombres(1, "Ana", LocalDate.of(2020, 5, 4));
		Nombres nombre2 = new Nombres(2, "Juan", LocalDate.of(2019, 11, 20));
		Nombres nombre3 = new Nombres(3, "Jose", LocalDate.of(2024, 12, 1));

		// Guardar en la BD
		session.persist(nombre1);
		session.persist(nombre2);
		session.persist(nombre3);
		try {
			transaction.commit();
			System.out.println("Nombres guardados.");
		} catch (Exception e) {
			System.out.println("Datos duplicados.");
		}
		
		//CONSULTAR DATOS
		System.out.println("LISTADO:");
		Query<Nombres> q = session.createQuery("from Nombres order by nombre", Nombres.class);
		List<Nombres> lista = q.list();

		System.out.printf("Numero de registros: %d%n", lista.size());
		for (Nombres nom : lista) {
			System.out.printf("%d, %s  %s%n", nom.getId(), nom.getNombre(), nom.getFechac());
		}

		// Cerrar la sesión
		session.close();
		sessionFactory.close();

	}

}
