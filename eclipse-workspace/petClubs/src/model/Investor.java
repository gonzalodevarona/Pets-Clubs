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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Investor {
	
	private String name;
	private ArrayList<Club> clubs;

	public Investor() {
		super();
		name = "Gonzalo De Varona";
		clubs = new ArrayList<Club>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Club> getClubs() {
		return clubs;
	}

	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}
	
	public void addClub(Club club) {
		clubs.add(club);
	}
	
	public void loadClubsPlainText() throws FileNotFoundException, IOException{
		String filePath = Club.CLUBSCSV;
		File file = new File(filePath);
	
	
		FileReader reader = new FileReader(file);
		BufferedReader bufferR = new BufferedReader(reader);
		
		String line = bufferR.readLine();
		String[] words = new String[3];
		
		while (line != null) {
			words = line.split(",");
			
			String idC = words[0];
			String nameC = words[1];
			
			String[] dateArray = words[2].split("-");
			
			int day = Integer.parseInt(dateArray[0]);
			int month = ((Integer.parseInt(dateArray[1])) - 1);
			int year = Integer.parseInt(dateArray[2]);
			
			GregorianCalendar issueDateC = new GregorianCalendar(year, month, day);
	
			
			Club club = new Club(idC, nameC, issueDateC);
			addClub(club);
			line = bufferR.readLine();
		}
	
	
	bufferR.close();
	reader.close();
		
	}
	
	public void loadPeoplePlainText() throws FileNotFoundException, IOException {
		String filePath = Person.PEOPLECSV;
		File file = new File(filePath);
		
		
		FileReader reader = new FileReader(file);
		BufferedReader bufferR = new BufferedReader(reader);
		
		String line = bufferR.readLine();
		String[] words = new String[5];
		int j = 0;
		for (int i = 0;line != null; i ++) {
			words = line.split(";");
			
			String idP = words[0];
			String nameP = words[1];
			String lastNameP = words[2];
			String favTypePetP = words[4];
			
			
			String[] dateArray = words[3].split("/");
			
			int day = Integer.parseInt(dateArray[1]);
			int month = ((Integer.parseInt(dateArray[0])) - 1);
			int year = Integer.parseInt(dateArray[2]);
			
			GregorianCalendar birthDateP = new GregorianCalendar(year, month, day);

			
			Person person = new Person(idP, nameP, lastNameP, birthDateP, favTypePetP);
			if(j >= clubs.size()) {
				j = 0;
			}
				
			clubs.get(j).addClient(person);
			j++;
			
			line = bufferR.readLine();
		}
		
		
		bufferR.close();
		reader.close();
			
		
		
	}
	
	public ArrayList<Pet> convertPetsPlainText2ArrayList() throws FileNotFoundException, IOException {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		
		String filePath = Pet.PETSCSV;
		File file = new File(filePath);
		
		
		FileReader reader = new FileReader(file);
		BufferedReader bufferR = new BufferedReader(reader);
		
		String line = bufferR.readLine();
		String[] words = new String[5];
		
		while (line != null) {
			words = line.split(";");
			
			String idP = words[0];
			String nameP = words[1];
			char gender = words[3].charAt(0);
			String type = words[4];
			
			String[] dateArray = words[2].split("/");
			
			int day = Integer.parseInt(dateArray[1]);
			int month = ((Integer.parseInt(dateArray[0])) - 1);
			int year = Integer.parseInt(dateArray[2]);
			
			GregorianCalendar birthDate = new GregorianCalendar(year, month, day);
	
			
			Pet pet = new Pet(idP, nameP,birthDate, gender, type, null);
			pets.add(pet);
			line = bufferR.readLine();
		}
		
		
		bufferR.close();
		reader.close();
			
		return pets;
		
	}
	
	public void loadPetsPlainText() throws FileNotFoundException, IOException {
		ArrayList<Pet> pets = convertPetsPlainText2ArrayList();
		int i = 0;
		while ( i <= clubs.size() && pets.size() != 0) {
			
			if (i>=clubs.size()) {
				i = 0;
			}
			pets = clubs.get(i).loadPetsPlainText(pets);
			i++;
		}
		
	}
	
	public ArrayList<Club> sortByNumberOfClients(){
		ArrayList<Club> sorted = getClubs();
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareTo(sorted.get(j-1)) > 0) {
					Club temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		return sorted;
	}
	
	public ArrayList<Person> getAllClients(){
		ArrayList<Person> everybody = new ArrayList<Person> ();
		for (int i = 0; i < clubs.size(); i++) {
			ArrayList<Person> each = clubs.get(i).getClients();
			
			for (int j = 0; j < each.size(); j++) {
				everybody.add(each.get(j));
			}
		}
		return everybody;
	}
	
	public boolean isThereAClientDoppelganger(String id) {
		boolean stop = false;
		ArrayList<Person> sortedByName = sortByClientsById();
		int begin = 0;
		int end = sortedByName.size() -1;
		int medium = (begin+end)/2;
		while (begin <= end && !stop) {
			String id2Evaluate = sortedByName.get(medium).getId();
			if(id2Evaluate.equalsIgnoreCase(id)) {
				stop = true; 
			} else if(id.compareTo(id2Evaluate)>0) {
				begin = medium +1;
			} else {
				end = medium -1;
			}
		}
		
		return stop;
	}
	
	public ArrayList<Person> sortByClientsNumberOfPets(){
		ArrayList<Person> sorted = getAllClients();
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareTo(sorted.get(j-1)) > 0) {
					Person temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		return sorted;
	}
	
	public ArrayList<Person> sortByClientsById(){
		ArrayList<Person> sorted = getAllClients();
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
	
	public Club findClub(String id) {
		Club club = null;
		boolean stop = false;
		for (int i = 0; i < clubs.size() && !stop; i++) {
			if (clubs.get(i).getId().equalsIgnoreCase(id)) {
				club = clubs.get(i);
				stop = true;
			} 
			
		}
		
		
		return club;
	}
	
	public Club findClubByName(String name) {
		Club club = null;
		boolean stop = false;
		for (int i = 0; i < clubs.size() && !stop; i++) {
			if (clubs.get(i).getName().equalsIgnoreCase(name)) {
				club = clubs.get(i);
				stop = true;
			} 
			
		}
		
		
		return club;
	}
	

	public boolean isThereADoppelgangerClub(String id) {
		boolean stop = false;
		for (int i = 0; i < clubs.size() && !stop; i++) {
			if (clubs.get(i).getId().equalsIgnoreCase(id)) {
				stop = true;
			}
		}
		
		return stop;
	}
	
	public void removeOneObjectClub(Club club) {
		clubs.remove(club);
	}
	
	
	
	
	
	
} //end of class