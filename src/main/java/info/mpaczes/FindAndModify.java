package info.mpaczes;

import info.mpaczes.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindAndModify {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Employee employee = entityManager.find(Employee.class, 1L);
		System.out.println(employee.getFirstName() + " -- " + employee.getLastName() + " -- " + employee.getSalary());
		
		employee.setSalary(2000.0);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		entityManagerFactory.close();

	}

}
