/*
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
* ID
* UNIVERSIDAD ICESI (CALI-COLOMBIA)
* DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN II
* LAB II
* @AUTHOR: GONZALO DE VARONA <gonzalo.de1@correo.icesi.edu.co>
* @LAST UPDATE DATE: 24 AUGUST 2019
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
*/


package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class Person implements Serializable, Comparable<Person>, Comparator<Person> {
	
	public final static String PEOPLECSV = "data/People.csv";
	
	private String id;
	private String name;
	private String lastName;
	private GregorianCalendar birthDate;
	private ArrayList<Pet> pets;
	private String favTypePet;
	
	
	
	
	
	public Person(String id, String name, String lastName, GregorianCalendar birthDate, String favTypePet) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.favTypePet = favTypePet;
		pets = new ArrayList<Pet>();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public GregorianCalendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}


	public ArrayList<Pet> getPets() {
		return pets;
	}


	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}


	public String getFavTypePet() {
		return favTypePet;
	}


	public void setFavTypePet(String favTypePet) {
		this.favTypePet = favTypePet;
	}
	
	public void addPet(Pet pet) {
		pets.add(pet);
	}
	
	public int howManyPetsDoIOwn() {
		return pets.size();
	}
	

	public int compareTo(Person person) {
		int value = 0;
				 
    	if(howManyPetsDoIOwn() > person.howManyPetsDoIOwn()){
    		value = 1;
    	}else if(howManyPetsDoIOwn() < person.howManyPetsDoIOwn()){
    		value = -1;
    	}
        return value;
		
	}
	
	
	
	public int howManyOfEachType(String type) {
		int numberOf =0;
		for (int i = 0; i < pets.size(); i++) {
			Pet trying = pets.get(i);
			if (trying.getType().equalsIgnoreCase(type)) {
				++numberOf;
			}
		}
		
		return numberOf;
	}
	
	
//	public String deletePet(String chain, int type) {
//		String mssg ="ERROR: Pet not found.";
//		if(type ==1) {
//			int
//		} else {
//			
//		}
//		return mssg;
//	}

	public boolean isThereADoppelganger(String known) {
		boolean stop = false;
		for (int i = 0; i < pets.size() && !stop; i++) {
			if (pets.get(i).getName().equalsIgnoreCase(known)) {
				stop = true;
			}
		}
		
		return stop;
	}


	@Override
	public int compare(Person person1, Person person2) {
			
		int value = 0;
		String person1Name = person1.getId();
		String person2Name = person2.getId();
    	if(person1Name.compareTo(person2Name) >0){
    		value = 1;
    	}else if(person1Name.compareTo(person2Name) <0){
    		value = -1;
    	} 
        
		return value;
			
	 }
	
	
	
	
	

} //end of class
