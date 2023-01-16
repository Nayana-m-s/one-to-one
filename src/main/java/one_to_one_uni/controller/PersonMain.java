package one_to_one_uni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_one_uni.dto.AdharCard;
import one_to_one_uni.dto.Person;
import one_to_one_uni_dao.PersonDao;

public class PersonMain {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner scanner = new Scanner(System.in);


		boolean flag = true;
		do {
			System.out.println(
					"1.save person \n 2. update person \n 3. delete person \n 4.get person data based on id\n 5.get all person data \n 6.exit");
			System.out.println("enter choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("enter person id: ");
				int id = scanner.nextInt();
				System.out.println("enter person name: ");
				String name = scanner.next();
				System.out.println("enter person address: ");
				String address = scanner.next();
				System.out.println("enter phone number");
				long phone = scanner.nextLong();
				Person person = new Person();
				person.setId(id);
				person.setName(name);
				person.setAddress(address);
				person.setPhone(phone);
				AdharCard adharcard = new AdharCard();
				person.setAdhar(adharcard);
				System.out.println("enter the aid: ");
				int adharid = scanner.nextInt();
				System.out.println("enter name: ");
				String name1 = scanner.next();
				System.out.println("enter address: ");
				String adharaddress = scanner.next();

				adharcard.setAdharid(adharid);
				adharcard.setName(name1);
				adharcard.setAddress(adharaddress);

				PersonDao dao = new PersonDao();

				dao.savePerson(person);
				System.out.println("saved successfully");

			}
				break;

			case 2: {
				System.out.println("enter id: ");
				int id = scanner.nextInt();
				System.out.println("enter the name: ");
				String name = scanner.next();
				Person person1 = new Person();

				PersonDao dao = new PersonDao();

				dao.updatePerson(id, name);
				System.out.println("updated");

			}
				break;
			case 3: {
				System.out.println("enter id: ");
				int id = scanner.nextInt();
				Person person1 = new Person();
				person1.setId(id);
				PersonDao dao = new PersonDao();
				dao.deletePerson(id);
				System.out.println("deleted");

			}
				break;
			case 4: {
				System.out.println("enter id: ");
				int id = scanner.nextInt();
				Person person1 = new Person();
				person1.setId(id);
				PersonDao dao = new PersonDao();
				System.out.println(dao.getPersonbasedId(id));

			}
				break;
			case 5: {
				PersonDao dao = new PersonDao();
				System.out.println(dao.getAllPerson());
			}
				break;
			case 6: {
				flag = false;
			}
				break;
			}

		} while (flag);

//		AdharCard adharcard=new AdharCard();
//		adharcard.setAdharid(101);
//		adharcard.setName("Nayana");
//		adharcard.setAddress("ckm");
//		
//		Person person=new Person();
//		person.setId(1);
//		person.setName("Nayana");
//		person.setAddress("india");
//		person.setPhone(12345689);
//		person.setAdhar(adharcard);
//
//		entityTransaction.begin();
//		 entityManager.persist(adharcard);
//		 entityManager.persist(person);
//		 entityTransaction.commit();
	}

}
