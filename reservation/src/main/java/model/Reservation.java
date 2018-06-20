package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation implements Serializable {

	private static final long serialVersionUID = 9110795956814807672L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationId;

    @ManyToOne
    @JoinColumn(name="destinationId", nullable=false)
    private Destination destination;
    
    @ManyToOne
    @JoinColumn(name="personId", nullable=false)
    private Person person;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date travelDate;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date reservationDate;
	
/*	@PrePersist
	@CreationTimestamp*/
	protected void onCreate() {
		reservationDate = new Date();
	}
	  
	@Column(name="ReservationStatus") 
	@Enumerated(EnumType.STRING) 
	private ReservationStatus reservationStatus;
	
	public Reservation() {
	}

	public Reservation(Person person, Destination destination, Date travelDate, ReservationStatus reservationStatus) {
		super();
		this.person = person;
		this.destination = destination;
		this.travelDate = travelDate;
		this.reservationDate = new Date();
		this.reservationStatus = reservationStatus;
	}
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		reservationId = reservationId;
	}

	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	
	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Reservation [ReservationId=" + reservationId + ", destination=" + destination + ", person=" + person
				+ ", travelDate=" + travelDate + ", reservationDate=" + reservationDate + ", reservationStatus="
				+ reservationStatus + "]";
	}
	
}
