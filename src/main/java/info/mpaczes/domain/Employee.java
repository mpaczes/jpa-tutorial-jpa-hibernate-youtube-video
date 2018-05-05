package info.mpaczes.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Pracownik")				// nazwa encji w JPQL (w JPQL wazna jest wielkosc liter)
@Table(name = "PRACOWNICY")				// nazwa tabeli w bazie danych
public class Employee {

	@Id
	@GeneratedValue					// automatyczne generowanie identyfikatora
	private long id;

	@Column(name = "IMIE", nullable = false, length = 10)
	private String firstName;

	@Column(name = "NAZWISKO", columnDefinition = "VARCHAR(30) NOT NULL")
	private String lastName;

	@Column(name = "PENSJA")
	private double salary;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal salary2;
	
//	@Embedded
	@OneToOne
	@JoinColumn(name = "addressId")				// taka kolumna zostanie w tej tabeli utworzona i bedzie wskazywala identyfikator adresu (jest to klucz glowny adresu)
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public BigDecimal getSalary2() {
		return salary2;
	}

	public void setSalary2(BigDecimal salary) {
		this.salary2 = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
