package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

class TestPerson {
Person person;
	
	public void setupStage() {
		Club club = new Club("1", "Germany",new GregorianCalendar(2010, 8, 3) );
		
		
		person = new Person(98765, "Zack", "Efron", new GregorianCalendar(1990, 2, 23), "Pirahnas");
		
		club.addClient(person);
		

		
		Pet x = new Pet(1, "Jason", new GregorianCalendar(2008, 2, 23),Pet.MALE, "Ant", person);
		Pet x1 = new Pet(2, "Ossa",  new GregorianCalendar(2015, 3, 29), Pet.FEMALE,"Fish", person);
		Pet x2 = new Pet(3, "Barrios", new GregorianCalendar(2018, 4, 2),Pet.MALE, "Lion", person);
		Pet x3 = new Pet(4, "Joe",  new GregorianCalendar(2015, 8, 3), Pet.FEMALE, "Cat", person);
		Pet x4 = new Pet(5, "Ivansito",  new GregorianCalendar(2019, 5, 2),Pet.FEMALE, "Owl", person);
		person.addPet(x);
		person.addPet(x1);
		person.addPet(x2);
		person.addPet(x3);
		person.addPet(x4);
		
	}

	@Test
	void testSortId() {
		setupStage();
		
		boolean done = false;
		ArrayList<Pet> a = person.sortPetsById();
		
		if(a.get(0).getId() ==1) {
			if(a.get(1).getId() ==2) {
				if(a.get(2).getId() ==3) {
					if(a.get(3).getId() ==4) {
						if(a.get(4).getId() ==5) {
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
		ArrayList<Pet> a = person.sortPetsByName();
		
		if(a.get(0).getName().equalsIgnoreCase("Barrios")) {
			if(a.get(1).getName().equalsIgnoreCase("Ivansito")) {
				if(a.get(2).getName().equalsIgnoreCase("Jason")) {
					if(a.get(3).getName().equalsIgnoreCase("Joe")) {
						if(a.get(4).getName().equalsIgnoreCase("Ossa")) {
							done = true;
						}
					}
				}
			}
		}
		assertTrue(done);
	}
	
	@Test
	void testSortGender() {
		setupStage();
		
		boolean done = false;
		ArrayList<Pet> a = person.sortPetsByGender();
		
		if(a.get(0).getGender()==Pet.FEMALE) {
			if(a.get(1).getGender()==Pet.FEMALE) {
				if(a.get(2).getGender()==Pet.FEMALE) {
					if(a.get(3).getGender()==Pet.MALE) {
						if(a.get(4).getGender()==Pet.MALE) {
							done = true;
						}
					}
				}
			}
		}
		assertTrue(done);
	}
	
	@Test
	void testSortTypeOfPet() {
		setupStage();
		
		boolean done = false;
		ArrayList<Pet> a = person.sortPetsByType();
		
		if(a.get(0).getType().equalsIgnoreCase("Ant")) {
			if(a.get(1).getType().equalsIgnoreCase("Cat")) {
				if(a.get(2).getType().equalsIgnoreCase("Fish")) {
					if(a.get(3).getType().equalsIgnoreCase("Lion")) {
						if(a.get(4).getType().equalsIgnoreCase("Owl")) {
							done = true;
						}
					}
				}
			}
		}
		assertTrue(done);
	}
	
	

} // end of class



