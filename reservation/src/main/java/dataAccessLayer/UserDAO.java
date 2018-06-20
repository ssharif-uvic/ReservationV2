package dataAccessLayer;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import controller.Utilities;
import model.Reservation;
import model.ReservationStatus;

public class UserDAO {

	public void addReservation(Reservation reservation) {
		Session session = null;
		try {
			//Configuration configuration = new Configuration().configure();

			SessionFactory sessionFactory = Utilities.createSessionFactory();//configuration.buildSessionFactory();

			session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(reservation.getDestination());
			session.save(reservation.getPerson());
			session.save(reservation);
			transaction.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			if (session != null) {
				session.close();
			}
		}
		
	}
	
	public void updateReservation(Reservation reservation) {
		Session session = null;
		try {
			//Configuration configuration = new Configuration().configure();

			SessionFactory sessionFactory = Utilities.createSessionFactory();//configuration.buildSessionFactory();

			session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();

			session.merge(reservation.getDestination());
			session.merge(reservation.getPerson());
			session.merge(reservation);
			transaction.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			if (session != null) {
				session.close();
			}
		}
		
	}
	
	public List<Reservation> getReservations(){
		SessionFactory sessionFactory = Utilities.createSessionFactory();
		Session session = sessionFactory.openSession();
		List<Reservation> reservations = session.createCriteria(Reservation.class).
				add(Restrictions.eq("reservationStatus", ReservationStatus.NEW)).addOrder(Order.asc("reservationDate")).list();
		return reservations;
	}
 
}
