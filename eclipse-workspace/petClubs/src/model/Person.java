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
	
	public Pet findPetBinary(String person) {
		Pet stop = null;
		ArrayList<Pet> sortedByID = sortPetsById(); //- 2 +
		int begin = 0;
		int end = sortedByID.size() -1;
		int medium = (begin+end)/2;
		while (begin <= end && stop == null) {
			String id2Evaluate = sortedByID.get(medium).getId();
			if(id2Evaluate.equalsIgnoreCase(person)) {
				stop = sortedByID.get(medium); 
			} else if(id.compareTo(id2Evaluate)>0) {
				begin = medium +1;
			} else {
				end = medium -1;
			}
		}
		
		return stop;
	}
	
	public ArrayList<Pet> sortPetsById(){
		ArrayList<Pet> sorted = getPets();
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compare(sorted.get(j), sorted.get(j-1)) < 0) {
					Pet temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		return sorted;
	}
	
	public Pet findPetBinaryByName(String name) {
		Pet stop = null;
		ArrayList<Pet> sortedByName = sortPetsByName(); //- 2 +
		int begin = 0;
		int end = sortedByName.size() -1;
		int medium = (begin+end)/2;
		while (begin <= end && stop == null) {
			String name2Evaluate = sortedByName.get(medium).getName();
			if(name2Evaluate.equalsIgnoreCase(name)) {
				stop = sortedByName.get(medium); 
			} else if(name.compareTo(name2Evaluate)>0) {
				begin = medium +1;
			} else {
				end = medium -1;
			}
		}
		
		return stop;
	}
	
	public ArrayList<Pet> sortPetsByName(){
		ArrayList<Pet> sorted = getPets();
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareTo( sorted.get(j-1)) < 0) {
					Pet temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		return sorted;
	}
	
	public void removeOneObjectPet(Pet pet) {
		pets.remove(pet);
	}
	
	public void saveChanges() throws FileNotFoundException, IOException {
		File file = new File(getId()+getName());
		
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(pets);
		oos.close();
			
		
	}
	
	public void loadChanges() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File file = new File(getId()+getName());
		
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			pets = (ArrayList<Pet>) ois.readObject();
			ois.close();
		}
	}
	



	public boolean isThereADoppelganger(String nameP, String idp) {
		boolean stop = false;
		for (int i = 0; i < pets.size() && !stop; i++) {
			if (pets.get(i).getName().equalsIgnoreCase(nameP) || pets.get(i).getId().equalsIgnoreCase(idp)) {
				stop = true;
			}
		}
		
		return stop;
	}


	
	
	
	
	
	

} //end of class
