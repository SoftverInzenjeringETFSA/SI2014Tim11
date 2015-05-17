package ba.unsa.etf.si.Tim11.Projekat_Tim11.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {

		try {
		    Configuration configuration = new Configuration();
		    configuration.configure();
		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable ex) {

			System.err.println("Initial SessionFactory creation failed." + ex);

			throw new ExceptionInInitializerError(ex);

		}

	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}
}