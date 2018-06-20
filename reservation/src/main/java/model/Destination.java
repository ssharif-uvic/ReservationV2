package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OrderBy;

@Entity
public class Destination implements Serializable {
	 
	private static final long serialVersionUID = -599197515685185927L;
	
	private int destinationId;
	private String country;
	private String city;
	private String airport;
	private Set<Reservation> reservations;

	
	public Destination() {
	}

	public Destination(String country, String city, String airport) {
		this.country = country;
		this.city = city;
		this.airport = airport;
	}
	
	
	@OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
	public Set<Reservation> getReservations() {
	    return reservations;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAirport() {
		return airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}
		
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Destination [destinationId=" + destinationId + ", country=" + country + ", city=" + city + ", airport="
				+ airport + "]";
	}
	
}
