package ud3.pruebalistado;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ud3.pruebalistado.clases.Departamentos;
import ud3.pruebalistado.clases.HibernateUtil;

public class PruebaListado {

	public static void main(String[] args) {

		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();

		Query<Departamentos> q = session.createQuery("from Departamentos", Departamentos.class);

		List<Departamentos> lista = q.list();

		System.out.printf("Número de registros: %d%n", lista.size());

		// Usamos for each para recorrer la lista.
		for (Departamentos depar : lista) {
			System.out.printf("%d, %s%n", depar.getDeptNo(), depar.getDnombre());
		}
		session.close();
		
	}
}
