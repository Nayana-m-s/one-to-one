package one_to_one_uni_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni.dto.AdharCard;
import one_to_one_uni.dto.Person;

public class PersonDao {
	
	public EntityManager getEntity()
	{
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		 return entityManagerFactory.createEntityManager();
	}
	public void savePerson(Person person)
	{
		EntityManager entityManager=getEntity();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		
		  entityTransaction.begin();
		  AdharCard adhar= person.getAdhar();
		  entityManager.persist(adhar);
		  entityManager.persist(person);
		  entityTransaction.commit();
		
	}
	
	public void updatePerson(int id,String name)
	{
		EntityManager entityManager=getEntity();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		Person person=entityManager.find(Person.class, id);
		   person.setName(name);
		  entityTransaction.begin();
		//  AdharCard adhar= person.getAdhar();
		  //entityManager.merge(adhar);
		  entityManager.merge(person);
		  entityTransaction.commit();
	}
	public void deletePerson(int id)
	{
		EntityManager entityManager=getEntity();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		Person person=entityManager.find(Person.class, id);
		entityTransaction.begin();
		entityManager.remove(person);
		entityTransaction.commit();
		if(person!=null)
		{
			entityTransaction.begin();
			AdharCard adhar= person.getAdhar();
			entityManager.remove(adhar);
			entityManager.remove(person);
			
			entityTransaction.commit();
		}
		else
			System.out.println("person not found");
	}
	public Person getPersonbasedId(int id)
	{
		EntityManager entityManager=getEntity();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		Person person=entityManager.find(Person.class, id);
		 return person;
	}
	public List<Person> getAllPerson()
	{
		EntityManager entityManager=getEntity();
		Query  query= entityManager.createQuery("select p from Person p");
		List<Person> list= query.getResultList();
		return list;
	}

}
