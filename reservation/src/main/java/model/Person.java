package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OrderBy;

@Entity
public class Person implements Serializable {
	
	private static final long serialVersionUID = 261353591996535867L;

	private int personId;
	private String firstName;
	private String lastname;
	
	@Column(name="UserType") 
	@Enumerated(EnumType.STRING) 
	private UserType userType;
	
	private Set<Reservation> reservations;
	
	
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	public Set<Reservation> getReservations() {
	    return reservations;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int userId) {
		this.personId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public Person() {
	}
	
	public Person(String firstName, String lastname, UserType userType) {
		this.firstName = firstName;
		this.lastname = lastname;
		this.userType = userType;
	}
	
	
	
}