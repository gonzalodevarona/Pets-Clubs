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
import java.util.GregorianCalendar;

public class Club implements Comparable<Club> {
	
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
		typeOfPet = "";
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
				if (!(person.isThereADoppelganger(pet.getName()))) {
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
	
	public void saveChanges() throws FileNotFoundException, IOException {
		File file = new File(id);
		
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(clients);
		oos.close();
			
		
	}
	
	public void loadChanges() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File file = new File(id);
		
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			clients = (ArrayList<Person>)ois.readObject();
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
	
	
	


} //end of class
