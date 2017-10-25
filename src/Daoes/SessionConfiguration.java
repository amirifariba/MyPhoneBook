package Daoes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionConfiguration {

	private static SessionConfiguration instance = new SessionConfiguration();
	private SessionFactory sessionFactory;

	public static SessionConfiguration getInstance() {
		return instance;
	}

	private SessionConfiguration() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		sessionFactory = configuration.buildSessionFactory();
	}

	public static Session getSession() {
		Session session = getInstance().sessionFactory.openSession();
		return session;
	}
}
