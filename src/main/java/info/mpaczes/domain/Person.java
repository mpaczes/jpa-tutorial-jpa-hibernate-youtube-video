package info.mpaczes.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)			// mamy jedna tabele 'Person'
// @Inheritance(strategy = InheritanceType.JOINED)				// mamy trzy tabele : 'Person', 'Professor', i 'Student'
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)		// mamy trzy tabele : 'Professor', 'Student' i 'hibernate_sequences'
// @DiscriminatorColumn(name = "typ_rekordu")
public abstract class Person {
	
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.TABLE)			// dla dziedziczenia 'TABLE_PER_CLASS'
	private long id;
	
	private String firstName;
	
	private String lastName;

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

}
