package one_to_one_uni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pancard.dao.PersonDao;
import pancard.dto.Pancard;
import pancard.dto.Person;

public class PanMain {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner scanner = new Scanner(System.in);


		boolean flag = true;
		do {
			System.out.println(
					"1.save pancard \n 2. update pancard \n 3. delete pancard \n 4.get pancard data based on id\n 5.get all pancard data \n 6.exit");
			System.out.println("enter choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				       
		        
				
			}
				break;

			case 2: {
				System.out.println("enter id: ");
				int panid = scanner.nextInt();
				System.out.println("enter the name: ");
				String name = scanner.next();
				Pancard pancard =new Pancard();
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

	}

}
