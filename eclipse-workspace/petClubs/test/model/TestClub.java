package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

class TestClub {
	
	Club club;
	
	public void setupStage() {
		club = new Club("1", "Germany",new GregorianCalendar(2010, 8, 3) );
		
		
		Person p = new Person(98765, "Zack", "Efron", new GregorianCalendar(1990, 2, 23), "Pirahnas");
		Person p1 = new Person(88765, "Selena", "Porter", new GregorianCalendar(1980, 3, 29), "Bear");
		Person p2 = new Person(78765, "Penny", "Sun", new GregorianCalendar(2000, 4, 2), "Cat");
		Person p3 = new Person(68765, "Richard", "Flyn", new GregorianCalendar(2010, 8, 3), "Fish");
		Person p4 = new Person(58765, "Alex", "Rose", new GregorianCalendar(2001, 9, 2), "Dog");
		club.addClient(p);
		club.addClient(p1);
		club.addClient(p2);
		club.addClient(p3);
		club.addClient(p4);
		
		
	}

	@Test
	void testSortId() {
		setupStage();
		
		boolean done = false;
		ArrayList<Person> a = club.sortClientsById();
		
		if(a.get(0).getId() ==58765) {
			if(a.get(1).getId() ==68765) {
				if(a.get(2).getId() ==78765) {
					if(a.get(3).getId() ==88765) {
						if(a.get(4).getId() ==98765) {
							done = true;
						}
					}
				}
			}
		}
		assertTrue(done);
	}
	
	@Test
	void testSortName() {
		setupStage();
		
		boolean done = false;
		ArrayList<Person> a = club.sortClientsByName();
		
		if(a.get(0).getName().equalsIgnoreCase("Alex")) {
			if(a.get(1).getName().equalsIgnoreCase("Penny")) {
				if(a.get(2).getName().equalsIgnoreCase("Richard")) {
					if(a.get(3).getName().equalsIgnoreCase("Selena")) {
						if(a.get(4).getName().equalsIgnoreCase("Zack")) {
							done = true;
						}
					}
				}
			}
		}
		assertTrue(done);
	}
	
	@Test
	void testSortLastName() {
		setupStage();
		
		boolean done = false;
		ArrayList<Person> a = club.sortClientsByLastName();
		
		if(a.get(0).getLastName().equalsIgnoreCase("Efron")) {
			if(a.get(1).getLastName().equalsIgnoreCase("Flyn")) {
				if(a.get(2).getLastName().equalsIgnoreCase("Porter")) {
					if(a.get(3).getLastName().equalsIgnoreCase("Rose")) {
						if(a.get(4).getLastName().equalsIgnoreCase("Sun")) {
							done = true;
						}
					}
				}
			}
		}
		assertTrue(done);
	}
	
	@Test
	void testSortFavTypeOfPet() {
		setupStage();
		
		boolean done = false;
		ArrayList<Person> a = club.sortClientsByType();
		
		if(a.get(0).getFavTypePet().equalsIgnoreCase("Bear")) {
			if(a.get(1).getFavTypePet().equalsIgnoreCase("Cat")) {
				if(a.get(2).getFavTypePet().equalsIgnoreCase("Dog")) {
					if(a.get(3).getFavTypePet().equalsIgnoreCase("Fish")) {
						if(a.get(4).getFavTypePet().equalsIgnoreCase("Pirahnas")) {
							done = true;
						}
					}
				}
			}
		}
		assertTrue(done);
	}
	
	

} // end of class
