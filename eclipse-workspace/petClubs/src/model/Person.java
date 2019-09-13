/*
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
* ID
* UNIVERSIDAD ICESI (CALI-COLOMBIA)
* DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN II
* LAB II
* @AUTHOR: GONZALO DE VARONA <gonzalo.de1@correo.icesi.edu.co>
* @LAST UPDATE DATE: 11 SEPTEMBER 2019
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
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class Person implements Serializable, Comparable<Person>, Comparator<Person> {
	
	public final static String PEOPLECSV = "dataTest/People.csv";
	
	private int id;
	private String name;
	private String lastName;
	private GregorianCalendar birthDate;
	private ArrayList<Pet> pets;
	private String favTypePet;
	
	
	
	
	
	public Person(int id, String name, String lastName, GregorianCalendar birthDate, String favTypePet) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.favTypePet = favTypePet;
		pets = new ArrayList<Pet>();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		int person1ID = person1.getId();
		int person2ID = person2.getId();
    	if(person1ID>person2ID){
    		value = 1;
    	}else if(person1ID<person2ID){
    		value = -1;
    	} 
        
		return value;
			
	 }
	
	
	public int compareName(Person person1, Person person2) {
		
		int value = 0;
		String person1Name = person1.getName();
		String person2Name = person2.getName();
    	if(person1Name.compareTo(person2Name) >0){
    		value = 1;
    	}else if(person1Name.compareTo(person2Name) <0){
    		value = -1;
    	} 
        
		return value;
			
	 }
	
public int compareLastName(Person person1, Person person2) {
		
		int value = 0;
		String person1LastName = person1.getLastName();
		String person2LastName = person2.getLastName();
    	if(person1LastName.compareTo(person2LastName) >0){
    		value = 1;
    	}else if(person1LastName.compareTo(person2LastName) <0){
    		value = -1;
    	} 
        
		return value;
			
	 }
	
	public Pet findPetBinary(int person) {
		Pet stop = null;
		ArrayList<Pet> sortedByID = sortPetsById(); //- 2 +
		int begin = 0;
		int end = sortedByID.size() -1;
		long first = System.nanoTime();
		
		while (begin <= end && stop == null) {
			int medium = (begin+end)/2;
			int id2Evaluate = sortedByID.get(medium).getId();
			if(id2Evaluate==person) {
				stop = sortedByID.get(medium); 
			} else if(id > id2Evaluate) {
				begin = medium +1;
			} else {
				end = medium -1;
			}
		}
		
		long second = System.nanoTime();
		long finalT = second - first;
		System.out.println("Time for binary search in nanoseconds: "+finalT);
		
		
		return stop;
	}
	
	public ArrayList<Pet> sortPetsByGender(){
		ArrayList<Pet> sorted = getPets();
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareGender(sorted.get(j), sorted.get(j-1)) < 0) {
					Pet temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		return sorted;
	}
	
	
	public ArrayList<Pet> sortPetsByType(){
		ArrayList<Pet> sorted = getPets();
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareType(sorted.get(j), sorted.get(j-1)) < 0) {
					Pet temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		return sorted;
	}
	
	//ONLY SORTING METHOD BY SELECTION, IT IS GOOD ENOUGH, VICTOR TOLD ME THIS PROGRAM HAD TO HAVE AT LEAST ONE OF EACH SORTING METHODS
	public ArrayList<Pet> sortPetsById(){
		ArrayList<Pet> sorted = getPets();
		for (int i = 0; i < sorted.size()-1; i++) {
			Pet lowest = sorted.get(i);
			int position =i;
			for (int j=i +1; j < sorted.size(); j++) {
				
				if (sorted.get(j).compare(sorted.get(j), lowest) < 0) {
					lowest = sorted.get(j);
					position = j;
					
				} 
				Pet temp = sorted.get(i);
				sorted.set(i, lowest) ;
				sorted.set(position, temp) ;
			}
		}
		
		return sorted;
	}
	
	public Pet findPetBinaryByName(String name) {
		Pet stop = null;
		ArrayList<Pet> sortedByName = sortPetsByName(); //- 2 +
		int begin = 0;
		int end = sortedByName.size() -1;
		long first = System.nanoTime();
		while (begin <= end && stop == null) {
			int medium = (begin+end)/2;
			String name2Evaluate = sortedByName.get(medium).getName();
			if(name2Evaluate.equalsIgnoreCase(name)) {
				stop = sortedByName.get(medium); 
			} else if(name.compareTo(name2Evaluate)>0) {
				begin = medium +1;
			} else {
				end = medium -1;
			}
		}
		
		long second = System.nanoTime();
		long finalT = second - first;
		System.out.println("Time for binary search in nanoseconds: "+finalT);
		
		
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



	public boolean isThereADoppelganger(String nameP, int idp) {
		boolean stop = false;
		for (int i = 0; i < pets.size() && !stop; i++) {
			if (pets.get(i).getName().equalsIgnoreCase(nameP) || pets.get(i).getId()==idp) {
				stop = true;
			}
		}
		
		return stop;
	}

	public int compareDate(Person person1, Person person2) {
		int value = 0;
		GregorianCalendar person1Date = person1.getBirthDate();
		
		GregorianCalendar person2Date = person2.getBirthDate();
		
    	if(person1Date.compareTo(person2Date)>0){
    		value = 1;
    	}else if(person1Date.compareTo(person2Date)<0){
    		value = -1;
    	} 
        
		return value;
	}


	public String date2String() {
		Calendar date = getBirthDate();
		int month = date.get(Calendar.MONTH) +1;
		int day = date.get(Calendar.DATE);
		int year = date.get(Calendar.YEAR);
		String dates = day+"-"+month+"-"+year;
		
		return dates;
	}


	public int compareType(Person person1, Person person2) {
		int value = 0;
		String person1Type = person1.getFavTypePet();
		String person2Type = person2.getFavTypePet();
    	if(person1Type.compareTo(person2Type) >0){
    		value = 1;
    	}else if(person1Type.compareTo(person2Type) <0){
    		value = -1;
    	} 
        
		return value;
	}
	
	public String toString() {
		String me = "\n";
		me += "ID: "+getId()+"\n";
		me += "Name: "+getName()+"\n";
		me += "Last name: "+getLastName()+"\n";
		me += "Birth date: "+date2String()+"\n";
		me += "Type of pet: "+getFavTypePet()+"\n";
		me += "\n";
		return me;
	}
	
	public String convertSortedPets2String(int i) {
		String bigOne = "\n";
		ArrayList<Pet> printThis = getPets();
		switch (i) {
		case 1:
			printThis = sortPetsById();
			
			break;
		case 2:
			printThis = sortPetsByName();		
			break;
					
		case 3:
			printThis = sortPetsByDate();	
			break;
			
		case 4:
			printThis = sortPetsByGender();
			break;
		case 5:
			printThis = sortPetsByType();
			break;
		
	

		default:
			break;
		}
		
		for (int j = 0; j < printThis.size(); j++) {
			bigOne += printThis.get(j).getName();
			switch (i) {
			case 1:
				bigOne += " - "+printThis.get(j).getId()+"\n";
				break;
			
			case 2:
				bigOne += "\n";
				break;
			
			case 3:
				bigOne += " - "+printThis.get(j).date2String()+"\n";
				break;
				
			case 4:
				bigOne += " - "+printThis.get(j).getGender()+"\n";
				break;
			case 5:
				bigOne += " - "+printThis.get(j).getType()+"\n";
				break;

			default:
				break;
			}
		}
		
		
		return bigOne;
	}

	

	public ArrayList<Pet> sortPetsByDate() {
		
		ArrayList<Pet> sorted = getPets();
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareDate(sorted.get(j), sorted.get(j-1)) < 0) {
					Pet temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		return sorted;
	
	}


	public Pet searchPetByOtherFields(int selection, String thing) {
		Pet p = null;
		switch (selection) {

		case 2:
			p = findPetBinaryByName(thing);		
			break;
					
		case 3:
			
			p = findPetBinaryGender(thing);
			break;
			
		case 4:
			p = findPersonBinaryDate(thing);
			break;
		case 5:
			p = findPetBinaryType(thing);
			break;
		
		default:
			break;
		}
		return p;
	}


	public Pet findPetBinaryGender(String thing) {
		Pet stop = null;
		ArrayList<Pet> sortedByGender = sortPetsByGender(); //- 2 +
		int begin = 0;
		int end = sortedByGender.size() -1;
		thing = thing.toUpperCase();
		char real = thing.charAt(0);
		
		long first = System.nanoTime();
		while (begin <= end && stop == null) {
			
			int medium = (begin+end)/2;
			char gender2Evaluate = sortedByGender.get(medium).getGender();
			if(gender2Evaluate==real) {
				stop = sortedByGender.get(medium); 
			} else if(real>gender2Evaluate) {
				begin = medium +1;
			} else {
				end = medium -1;
			}
		}
		
		long second = System.nanoTime();
		long finalT = second - first;
		System.out.println("Time for binary search in nanoseconds: "+finalT);
		
		
		
		return stop;
	}


	public Pet findPersonBinaryDate(String thing) {
		Pet stop = null;
		ArrayList<Pet> sortedByDate = sortPetsByDate(); //- 2 +
		long first = System.nanoTime();
		int begin = 0;
		int end = sortedByDate.size() -1;
		thing = thing.toLowerCase();
		while (begin <= end && stop == null) {
			int medium = (begin+end)/2;
			String date2Evaluate = sortedByDate.get(medium).date2String().toLowerCase();
			if(date2Evaluate.equalsIgnoreCase(thing)) {
				stop = sortedByDate.get(medium); 
			} else if(thing.compareTo(date2Evaluate)>0) {
				begin = medium +1;
			} else {
				end = medium -1;
			}
		}
		long second = System.nanoTime();
		long finalT = second - first;
		System.out.println("Time for binary search in nanoseconds: "+finalT);
		
		
		return stop;
	}


	public Pet findPetBinaryType(String thing) {
		Pet stop = null;
		ArrayList<Pet> sortedByType = sortPetsByType(); //- 2 +
		int begin = 0;
		int end = sortedByType.size() -1;
		thing = thing.toLowerCase();
		long first = System.nanoTime();
		while (begin <= end && stop == null) {
			int medium = (begin+end)/2;
			String type2Evaluate = sortedByType.get(medium).getType().toLowerCase();
			if(type2Evaluate.equalsIgnoreCase(thing)) {
				stop = sortedByType.get(medium); 
			} else if(thing.compareTo(type2Evaluate)>0) {
				begin = medium +1;
			} else {
				end = medium -1;
			}
		}
		
		long second = System.nanoTime();
		long finalT = second - first;
		System.out.println("Time for binary search in nanoseconds: "+finalT);
		
		
		return stop;
	}


	public Pet findPetSequence(int selection, int i, String thing) {
		Pet p = null;
		switch (selection) {
		
		case 1:
			p = findPetId(i);		
			break;

		case 2:
			p = findPetName(thing);		
			break;
					
		case 3:
			p = findPetGender(thing);
			break;
			
		case 4:
			p = findPersonBinaryDate(thing); 
			//MISSING
			//MISSING
			//MISSING
			//MISSING
			break;
		case 5:
			p = findPetType(thing);
			break;
		
		default:
			break;
		}
		return p;
	}


	public Pet findPetGender(String thing) {
		Pet p = null;
		
		thing = thing.toUpperCase();
		char realT = thing.charAt(0);
		for (int j = 0; j < pets.size() && p == null; j++) {
			if (pets.get(j).getGender() == realT) {
				p = pets.get(j);
				
			} 
			
		}
		
		
		return p;
	}


	public Pet findPetId(int i) {
		Pet p = null;
		
		for (int j = 0; j < pets.size() && p == null; j++) {
			if (pets.get(j).getId()==i) {
				p = pets.get(j);
				
			} 
			
		}
		
		
		return p;
	}
	
	public Pet findPetType(String thing) {
		Pet p = null;
		
		thing = thing.toUpperCase();
		for (int j = 0; j < pets.size() && p == null; j++) {
			if (pets.get(j).getType().toUpperCase().equalsIgnoreCase(thing)) {
				p = pets.get(j);
				
			} 
			
		}
		
		
		return p;
	}
	
	public Pet findPetName(String thing) {
		Pet p = null;
		
		thing = thing.toUpperCase();
		for (int j = 0; j < pets.size() && p == null; j++) {
			if (pets.get(j).getName().toUpperCase().equalsIgnoreCase(thing)) {
				p = pets.get(j);
				
			} 
			
		}
		
		
		return p;
	}

	
	
	
	
	
	

} //end of class
