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
import java.util.Comparator;
import java.util.GregorianCalendar;



public class Pet implements Serializable, Comparable<Pet>, Comparator<Pet> {
	
	//CONSTANTS

	public final static String DOG = "Dog";
	public final static String CAT = "Cat";
	public final static String BIRD = "Bird";
	public final static String HAMSTER = "Hamster";
	public final static String FERRET = "Ferret";
	public final static char MALE = 'M';
	public final static char FEMALE = 'F';
	public final static String PETSCSV = "data/Pets.csv";
	
	
	//ATTRIBUTES
	private String id;
	private String name;
	private GregorianCalendar birthDate;
	private char gender;
	private String type;
	
	//RELATIONSHIPS
	private Person owner;
	
	
	
	public Pet(String id, String name, GregorianCalendar birthDate, char gender, String type, Person owner) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.type = type;
		this.owner = owner;
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
	public GregorianCalendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	@Override
	public int compare(Pet pet1, Pet pet2) {
			
		int value = 0;
		String pet1ID = pet1.getId();
		String pet2ID = pet2.getId();
    	if(pet1ID.compareTo(pet2ID) >0){
    		value = 1;
    	}else if(pet1ID.compareTo(pet2ID) <0){
    		value = -1;
    	} 
        
		return value;
			
	 }

	public int compareTo(Pet pet) {
		int value = 0;
		 
    	if(getName().compareTo(pet.getName()) >0){
    		value = 1;
    	}else if(getName().compareTo(pet.getName()) <0){
    		value = -1;
    	}
        return value;
		
	}

	
	
	
	
	
	

} //end of class
