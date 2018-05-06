package info.mpaczes.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name = "Pracownik")				// nazwa encji w JPQL (w JPQL wazna jest wielkosc liter)
@Table(name = "PRACOWNICY")				// nazwa tabeli w bazie danych
public class Employee {

	@Id
	// @GeneratedValue					// automatyczne generowanie identyfikatora
	@TableGenerator(
			name = "mojGenerator",						// nazwa generatora do ktorej pozniej mozna sie odwolac
			table = "tabela_z_identyfikatorami",		// jaka nazwe przyjmie tabela; domyslnie bylo to 'hibernate_sequences'	
			pkColumnName = "nazwa_sekwencji",			// kolumna z nazwa sekwencji
			valueColumnName = "wartosc_identyfikatora",	// kolumna z wartoscia sekwencji (ostatnio przydzielone wartosci pomnozone przez allocation size)
			pkColumnValue = "id_pracownika",			// nazwa wiersza dla generatora (nazwa sekwencji)
			initialValue = 10,							// inicjalna wartosc od ktorej zacznie sie numerowanie (trzeba dodoac property w pliku 'persistence.xml')
			allocationSize = 15							// ile identyfikatorow hibernate ma zarezerwowac
			)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "mojGenerator")
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

	@OneToMany(mappedBy = "employee")
	// @JoinColumn(name = "owner_id")
	private List<Phone> phones;
	
	@ManyToMany(mappedBy = "employees")
	private List<Project> projects;
	
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

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
