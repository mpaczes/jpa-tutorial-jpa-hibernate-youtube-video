package info.mpaczes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.mpaczes.domain.Cat;
import info.mpaczes.domain.Employee;
import info.mpaczes.domain.Owner;
import info.mpaczes.domain.Phone;
import info.mpaczes.domain.Project;

public class Main {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("test");
		
		entityManager = entityManagerFactory.createEntityManager();
		
//		Employee employee = new Employee();
//		// employee.setId(1L);
//		employee.setFirstName("Jan");
//		employee.setLastName("Nowak");
//		employee.setSalary(3333.3);
//		employee.setSalary2(new BigDecimal(12345.3));
		
		
//		Employee employee2 = new Employee();
//		// employee.setId(1L);
//		employee2.setFirstName("Robert");
//		employee2.setLastName("Bednarek");
//		employee2.setSalary(4444.4);
		
//		Employee employee = new Employee();
//		Address address = new Address();
//		employee.setAddress(address);
		
//		employee.setFirstName("Jan");
//		employee.setLastName("Nowak");
//		employee.setSalary(3333.3);
		
//		address.setLocality("Warszawa");
//		address.setZipCode("33-432");
//		address.setStreet("Koszykowa");
//		address.setStreetNumber(222);
		
//		entityManager.getTransaction().begin();
		
//		entityManager.persist(employee);
		
//		entityManager.persist(employee2);
		
//		// musimy w wypadku relacji jeden do jednego zapisac w bazie obydwa obiekty :
//		entityManager.persist(employee);
//		entityManager.persist(address);
		
//		addEmployees();
		
		// jezyk JPQL (czyli Java Persistence Query Language)
		// pobieramy dane z encji :
//		TypedQuery<Employee> query = entityManager.createQuery(" select e from Employee e where e.lastName = 'Mateusiak' order by e.salary ", Employee.class);
//		Employee employee = query.getSingleResult();				// tylko jeden obiekt zwraca
//		
//		System.out.println(employee.getFirstName() + " -- " + employee.getLastName() + " -- " + employee.getSalary());
		
//		List<Employee> employees = query.getResultList();				// zwraca kilka wierszy
//		
//		for (Employee employee : employees) {
//			System.out.println(employee.getFirstName() + " -- " + employee.getLastName() + " -- " + employee.getSalary());
//		}
		
		// zlozone zapytanie w JPQL :
//		Query query = entityManager.createQuery(" select concat(e.firstName, ' ', e.lastName), e.salary * 0.2 from Employee e ");
//		
//		Iterator<?> iterator = query.getResultList().iterator();
//		while (iterator.hasNext()) {
//			
//			Object[] item = (Object[]) iterator.next();					// wiersz z zapytania
//			
//			String name = (String) item[0];
//			Double tax = (Double) item[1];
//			
//			System.out.println(name + " name has to pay " + tax);
//			
//		}
		
		// parametry JPQL nazwane :
//		TypedQuery<Employee> query = entityManager.createQuery(" select e from Pracownik e where e.salary > :minSalary order by e.salary ", Employee.class);
//		
//		query.setParameter("minSalary", 3000.0);
		
		// parametry JPQL przekazywane przez indeks :
		
//		TypedQuery<Employee> query = entityManager.createQuery(" select e from Pracownik e where e.salary > ?1 and e.salary < ?2 order by e.salary ", Employee.class);
//		
//		query.setParameter(1, 2000.0);
//		query.setParameter(2, 6000.0);
		
		// lista dla JPQL :
		
//		TypedQuery<Employee> query = entityManager.createQuery(" select e from Pracownik e where e.lastName in :names order by e.salary ", Employee.class);
//		
//		List<String> names = new ArrayList<String>();
//		names.add("Mateusiak");
//		names.add("Bednarek");
//		
//		query.setParameter("names", names);
//		
//		for (Employee employee : query.getResultList()) {
//		
//			System.out.println(employee.getFirstName() + " -- " + employee.getLastName() + " -- " + employee.getSalary());
//		
//		}
		
		// JQPL -- funkcje agregujace :
//		Query query = entityManager
//				.createQuery(" select avg(e.salary), min(e.salary), max(e.salary), sum(e.salary), count(e) from Pracownik e ");
//		
//		Object[] result = (Object[]) query.getSingleResult();
//		
//		System.out.println("srednia -- " + result[0] + " , najnizsza -- " + result[1] + " , najwyzsza -- " + result[2] + " , suma -- " + result[3] + " , pracownikow -- " + result[4]);
		
		// JPQL -- funkcje na stringach :
		
//		Query query = entityManager.createQuery(" select substring(e.firstName, 1, 3), trim(e.lastName), lower(e.firstName), upper(e.firstName), length(e.firstName) from Pracownik e where e.firstName = 'Karol' ");
//		
//		Object[] result = (Object[]) query.getSingleResult();
//		
//		System.out.println("piersze trzy litery imeinia -- " + result[0]);
//		System.out.println("nazwisko bez spacji -- |" + result[1] + "|");
//		System.out.println("imie malymi literami -- " + result[2]);
//		System.out.println("imie duzymi literami -- " + result[3]);
//		System.out.println("dlugosc imienia -- " + result[4]);
		
//		entityManager.getTransaction().commit();
		
//		// usuwanie pracownika :
//		entityManager.getTransaction().begin();
//		
//		entityManager.remove(employee);				// uchwyt do pracownika
//		
//		entityManager.getTransaction().commit();
		
		// relacje :
		// jeden do jednego (dwukierunkowa -- biderictional) :
//		Cat cat = new Cat();
//		Owner owner = new Owner();
//		
//		cat.setName("Bonifacy");
//		
//		owner.setFirstName("Jan");
//		owner.setLastName("Nowak");
//		
//		owner.setCat(cat);
		
		entityManager.getTransaction().begin();
//		entityManager.persist(owner);
//		entityManager.persist(cat);
		// relacja jeden do wielu :
		Employee employee = new Employee();
		
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(3333.3);
		
//		Phone phone1 = new Phone();
//		Phone phone2 = new Phone();
//		
//		phone1.setType("mobile");
//		phone1.setNumber("4321");
//		phone1.setEmployee(employee);
//		phone2.setType("home");
//		phone2.setNumber("7890");
//		phone2.setEmployee(employee);
//		
//		List<Phone> phones = new ArrayList<Phone>();
//		phones.add(phone1);
//		phones.add(phone2);
//		
//		employee.setPhones(phones);
//		
//		entityManager.persist(phone1);
//		entityManager.persist(phone2);
		
		Project project1 = new Project();
		project1.setName("Projekt 1");
		Project project2 = new Project();
		project2.setName("Projekt 2");
		
		List<Project> projects = new ArrayList<Project>();
		projects.add(project1);
		projects.add(project2);
		
		employee.setProjects(projects);
		
		entityManager.persist(employee);
		entityManager.persist(project1);
		entityManager.persist(project2);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		entityManagerFactory.close();
		
	}
	
	private static void addEmployees() {
		
		addEmployee("Karol", "    Mateusiak  ", 2633);
		
		addEmployee("Marika", "Bednarek", 1000);
		
		addEmployee("Kamil", "Stepien", 7346);
		
		addEmployee("Jan", "Mateusiak", 5433);
		
	}

	private static void addEmployee(String firstName, String lastName, double salary) {
		
		Employee employee = new Employee();

		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(employee);
		
		entityManager.getTransaction().commit();
		
	}
	
}
