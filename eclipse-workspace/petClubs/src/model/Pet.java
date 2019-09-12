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


import java.io.Serializable;
import java.util.Calendar;
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
	private int id;
	private String name;
	private GregorianCalendar birthDate;
	private char gender;
	private String type;
	
	//RELATIONSHIPS
	private Person owner;
	
	
	
	public Pet(int id, String name, GregorianCalendar birthDate, char gender, String type, Person owner) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.type = type;
		this.owner = owner;
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
		int pet1ID = pet1.getId();
		int pet2ID = pet2.getId();
    	if(pet1ID>pet2ID){ 
    		value = 1;
    	}else if(pet1ID<pet2ID){
    		value = -1;
    	} 
        
		return value;
			
	 }
	
	public int compareType(Pet pet1, Pet pet2) {
		
		int value = 0;
		String pet1Type = pet1.getType();
		String pet2Type = pet2.getType();
    	if(pet1Type.compareTo(pet2Type) >0){
    		value = 1;
    	}else if(pet1Type.compareTo(pet2Type) <0){
    		value = -1;
    	} 
        
		return value;
			
	 }
	
	public int compareGender(Pet pet1, Pet pet2) {
		
		int value = 0;
		char pet1Gender = pet1.getGender();
		char pet2Gender = pet2.getGender();
    	if(pet1Gender > pet2Gender) {
    		value = 1;
    	}else if(pet1Gender < pet2Gender){
    		value = -1;
    	} 
        
		return value;
			
	 }
	
	
	public int compareDate(Pet pet1, Pet pet2) {
		int value = 0;
		GregorianCalendar pet1Date = pet1.getBirthDate();
		GregorianCalendar pet2Date = pet2.getBirthDate();
    	if(pet1Date.compareTo(pet2Date) > 0){
    		value = 1;
    	}else if(pet1Date.compareTo(pet2Date) < 0){
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
	
	public String date2String() {
		Calendar date = getBirthDate();
		int month = date.get(Calendar.MONTH) +1;
		int day = date.get(Calendar.DATE);
		int year = date.get(Calendar.YEAR);
		String dates = day+"-"+month+"-"+year;
		
		return dates;
	}
	
	public String toString() {
		String me = "\n";
		me += "ID: "+getId()+"\n";
		me += "Name: "+getName()+"\n";
		me += "Birth date: "+date2String()+"\n";
		me += "Type of pet: "+getType()+"\n";
		me += "Gender: "+getGender()+"\n";
		me += "Owner's name: "+getOwner().getName()+"\n";
		me += "\n";
		return me;
	}

	
	
	
	
	
	

} //end of class
