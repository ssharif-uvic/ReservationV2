package controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Utilities {

	private static SessionFactory sessionFactory;

	public static SessionFactory createSessionFactory() {
		
	    Configuration configuration = new Configuration();
	    
	    configuration.configure();
	    
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()). buildServiceRegistry();
	    
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
	    return sessionFactory;
	}
}
