package maintest;

import junit.framework.TestCase;
import model.Destination;
import model.Person;
import model.Reservation;
import model.ReservationStatus;
import model.UserType;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestConnection /*extends TestCase*/ {
	private static SessionFactory sessionFactory;

	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()). buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}

	public void testApp() {
		SessionFactory sessionFactory = createSessionFactory();
		Session session = sessionFactory.openSession();

		Destination destination = new Destination("ccc123", "gggg123", "eeeee123");
		Person person = new Person("aaa", "bbb", UserType.CUSTOMER);
		Reservation reservation = new Reservation(person,destination, new Date(), ReservationStatus.NEW);
		
	    Transaction tx = null;
	    try {
	        tx = session.beginTransaction();
	        session.save(person);
	        session.save(destination);
	        session.save(reservation);
			session.flush();
	        tx.commit(); // Flush happens automatically
	    }
	    catch (RuntimeException e) {
	        tx.rollback();
	        //throw e; // or display error message
	        e.printStackTrace();
	    }
	    finally {
	        session.close();
	    }
	}


}