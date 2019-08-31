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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Person implements Serializable, Comparable<Person> {
	
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
	
	public void saveChanges() throws FileNotFoundException, IOException {
		File file = new File(Pet.PETSCSV);
		
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(pets);
		oos.close();
			
		
	}
	
	public void loadChanges() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File file = new File(Pet.PETSCSV);
		
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			pets = (ArrayList<Pet>)ois.readObject();
			ois.close();
		}
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
	
	
	

} //end of class
