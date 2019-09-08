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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class Club implements Comparable<Club>, Comparator<Club> {
	
	public final static String CLUBSCSV = "data/Clubs.csv";
	
	private String id;
	private String name;
	private ArrayList<Person> clients;
	private GregorianCalendar issueDate;
	private String typeOfPet;
	
	
	public Club(String id, String name, GregorianCalendar issueDate) {
		super();
		this.id = id;
		this.name = name;
		this.issueDate = issueDate;
		typeOfPet = "NOTHING";
		clients = new ArrayList<Person>();
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
	public ArrayList<Person> getClients() {
		return clients;
	}
	public void setClients(ArrayList<Person> clients) {
		this.clients = clients;
	}
	public GregorianCalendar getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(GregorianCalendar issueDate) {
		this.issueDate = issueDate;
	}
	
	public void addClient(Person person) {
		clients.add(person);
		assignType4Club();
	}
	public String getTypeOfPet() {
		return typeOfPet;
	}
	public void setTypeOfPet(String typeOfPet) {
		this.typeOfPet = typeOfPet;
	}
	
	public ArrayList<Pet> loadPetsPlainText(ArrayList<Pet> pets) {
		for (int i = 0; i < clients.size() && pets.get(0) != null; i++) {
			
				Pet pet = pets.get(0);
				Person person = clients.get(i);
				if (!(person.isThereADoppelganger(pet.getName(), pet.getId()))) {
					person.addPet(pet);
					pet.setOwner(person);
					
				} else {
					pets.add(pet);	
				}
				
				pets.remove(0);
			
		}
		return pets;
	}
	
	public int howManyPetsInTheClub() {
		int count = 0;
		for (int i = 0; i < clients.size(); i++) {
			count += clients.get(i).howManyPetsDoIOwn();
		}
		
		return count;
	}
	
	public int howManyClientsInTheClub() {
		int count = clients.size();
		return count; 
	}

	
	
	@Override
	public int compareTo(Club club) {
		int x = 0;
		if(howManyClientsInTheClub() > club.howManyClientsInTheClub()) {
			x = 1;
		} if(howManyClientsInTheClub() < club.howManyClientsInTheClub()) {
			x = -1;
		}
		return x;
	} 
	
	public void saveChangesPets() throws FileNotFoundException, IOException {
		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).saveChanges();
			
		}
			
		
	}
	
	public void loadChangesPets() throws FileNotFoundException, IOException, ClassNotFoundException {
		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).loadChanges();
			
		}
		
	}
	
	
	public void saveChanges() throws FileNotFoundException, IOException {
		File file = new File(getId()+getName());
		
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(clients);
		oos.close();
			
		
	}
	
	public void loadChanges() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File file = new File(getId()+getName());
		
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			clients = (ArrayList<Person>) ois.readObject();
			ois.close();
		}
	}

	
	
	public void assignType4Club() {

		int[] arrayNumb = new int[6];
		arrayNumb[0] = 0 ;
		arrayNumb[1] = 0 ;
		arrayNumb[2] = 0 ;
		arrayNumb[3] = 0 ;
		arrayNumb[4] = 0 ;
		arrayNumb[5] = howManyPetsInTheClub() ;
		
		for (int i = 0; i < clients.size(); i++) {
			arrayNumb[0] += clients.get(i).howManyOfEachType(Pet.BIRD);
			arrayNumb[1] += clients.get(i).howManyOfEachType(Pet.DOG);
			arrayNumb[2] += clients.get(i).howManyOfEachType(Pet.CAT);
			arrayNumb[3] += clients.get(i).howManyOfEachType(Pet.FERRET);
			arrayNumb[4] += clients.get(i).howManyOfEachType(Pet.HAMSTER);

		}
		
		arrayNumb[5] = arrayNumb[5] - (arrayNumb[0]+arrayNumb[1]+arrayNumb[2]+arrayNumb[3]+arrayNumb[4]);
		
		int highest = arrayNumb[0];
		String who = "";
		for (int i = 0; i < arrayNumb.length; i++) {
			if (highest<arrayNumb[i]) {
				highest = arrayNumb[i];
			}
			switch (i) {
			case 0: who = Pet.BIRD;
				break;

			case 1: who = Pet.DOG;
				break;
			
			case 2: who = Pet.CAT;
				break;
				
			case 3: who = Pet.FERRET;
				break;
				
			case 4: who = Pet.HAMSTER;
				break;
				
			case 5: who = "Other";
				break;
			}
		}
		
		setTypeOfPet(who);
		
		
	}
	
	public Person findPersonBinary(String person) {
		Person stop = null;
		ArrayList<Person> sortedByID = sortClientsById(); //- 2 +
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
	
	public Person findPersonBinaryName(String person) {
		Person stop = null;
		ArrayList<Person> sortedByName = sortClientsByName(); //- 2 +
		int begin = 0;
		int end = sortedByName.size() -1;
		int medium = (begin+end)/2;
		while (begin <= end && stop == null) {
			String name2Evaluate = sortedByName.get(medium).getName();
			if(name2Evaluate.equalsIgnoreCase(person)) {
				stop = sortedByName.get(medium); 
			} else if(id.compareTo(name2Evaluate)>0) {
				begin = medium +1;
			} else {
				end = medium -1;
			}
		}
		
		return stop;
	}
	
	public ArrayList<Person> sortClientsById(){
		ArrayList<Person> sorted = getClients();
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compare(sorted.get(j), sorted.get(j-1)) < 0) {
					Person temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		return sorted;
	}
	
	public ArrayList<Person> sortClientsByName(){
		ArrayList<Person> sorted = getClients();
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareName(sorted.get(j), sorted.get(j-1)) < 0) {
					Person temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		return sorted;
	}
	
	public ArrayList<Person> sortClientsByDate(){
		ArrayList<Person> sorted = getClients();
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareDate(sorted.get(j), sorted.get(j-1)) < 0) {
					Person temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		return sorted;
	}
	
	public ArrayList<Person> sortClientsByType(){
		ArrayList<Person> sorted = getClients();
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareType(sorted.get(j), sorted.get(j-1)) < 0) {
					Person temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		return sorted;
	}
	
	public void removeOneObjectPerson(Person person) {
		clients.remove(person);
	}


	@Override
	public int compare(Club club1, Club club2) {
		int value = 0;
		String club1ID = club1.getId();
		String club2ID = club2.getId();
    	if(club1ID.compareTo(club2ID) >0){
    		value = 1;
    	}else if(club1ID.compareTo(club2ID) <0){
    		value = -1;
    	} 
        
		return value;
	}
	
	public int compareName(Club club1, Club club2) {
		int value = 0;
		String club1Name = club1.getName();
		String club2Name = club2.getName();
    	if(club1Name.compareTo(club2Name) >0){
    		value = 1;
    	}else if(club1Name.compareTo(club2Name) <0){
    		value = -1;
    	} 
        
		return value;
	}
	
	public int compareType(Club club1, Club club2) {
		int value = 0;
		String club1Type = club1.getTypeOfPet();
		String club2Type = club2.getTypeOfPet();
    	if(club1Type.compareTo(club2Type) >0){
    		value = 1;
    	}else if(club1Type.compareTo(club2Type) <0){
    		value = -1;
    	} 
        
		return value;
	}
	
	public String date2String() {
		
		Calendar date = getIssueDate();
		int month = date.get(Calendar.MONTH) +1;
		int day = date.get(Calendar.DATE);
		int year = date.get(Calendar.YEAR);
		String dates = day+"-"+month+"-"+year;
		
		return dates;
	}


	public int compareDate(Club club1, Club club2) {
		int value = 0;
		GregorianCalendar club1Date = club1.getIssueDate();
		GregorianCalendar club2Date = club2.getIssueDate();
    	if(club1Date.compareTo(club2Date) >0){
    		value = 1;
    	}else if(club1Date.compareTo(club1Date) <0){
    		value = -1;
    	} 
        
		return value;
	}
	
	public String convertSortedClients2String(int i) {
		String bigOne = "\n";
		ArrayList<Person> printThis = null;
		switch (i) {
		case 1:
			printThis = sortClientsById();
			
			break;
		case 2:
			printThis = sortClientsByName();		
			break;
					
		case 3:
			printThis = sortClientsByLastName();
			break;
			
		case 4:
			printThis = sortClientsByDate();
			break;
		case 5:
			printThis = sortClientsByType();
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
				bigOne += " - "+printThis.get(j).getLastName()+"\n";
				break;
				
			case 4:
				bigOne += " - "+printThis.get(j).date2String()+"\n";
				break;
			case 5:
				bigOne += " - "+printThis.get(j).getFavTypePet()+"\n";
				break;

			default:
				break;
			}
		}
		
		
		return bigOne;
	}


	private ArrayList<Person> sortClientsByLastName() {
		ArrayList<Person> sorted = getClients();
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareLastName(sorted.get(j), sorted.get(j-1)) < 0) {
					Person temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		return sorted;
	}

	
	
	


} //end of class
