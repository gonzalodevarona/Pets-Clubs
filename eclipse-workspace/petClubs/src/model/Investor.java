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
			
			int day = Integer.parseInt(dateArray[2]);
			int month = ((Integer.parseInt(dateArray[1])) - 1);
			int year = Integer.parseInt(dateArray[0]);
			
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
		
		for (int i = 0;line != null; i ++) {
			words = line.split(",");
			
			String idP = words[0];
			String nameP = words[1];
			String lastNameP = words[2];
			String favTypePetP = words[4];
			
			
			String[] dateArray = words[3].split("-");
			
			int day = Integer.parseInt(dateArray[2]);
			int month = ((Integer.parseInt(dateArray[1])) - 1);
			int year = Integer.parseInt(dateArray[0]);
			
			GregorianCalendar birthDateP = new GregorianCalendar(year, month, day);

			
			Person person = new Person(idP, nameP, lastNameP, birthDateP, favTypePetP);
			
			if(i>clubs.size()) {
				int myRandom = (int)Math.random()*(clubs.size()-1);
				clubs.get(myRandom).addClient(person);
				
			}else {clubs.get(i).addClient(person);}
			
			
			line = bufferR.readLine();
		}
		
		
		bufferR.close();
		reader.close();
			
		
		
	}
	
	public ArrayList<Pet> convertPlainText2ArrayList() throws FileNotFoundException, IOException {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		
		String filePath = Pet.PETSCSV;
		File file = new File(filePath);
		
		
		FileReader reader = new FileReader(file);
		BufferedReader bufferR = new BufferedReader(reader);
		
		String line = bufferR.readLine();
		String[] words = new String[5];
		
		while (line != null) {
			words = line.split(",");
			
			String idP = words[0];
			String nameP = words[1];
			char gender = words[3].charAt(0);
			String type = words[4];
			
			String[] dateArray = words[2].split("-");
			
			int day = Integer.parseInt(dateArray[2]);
			int month = ((Integer.parseInt(dateArray[1])) - 1);
			int year = Integer.parseInt(dateArray[0]);
			
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
		ArrayList<Pet> pets = convertPlainText2ArrayList();
		
		for (int i = 0; i < clubs.size(); i++) {
			pets = clubs.get(i).loadPetsPlainText(pets);
		}
		
		if(pets.size() !=0) {
			for (int i = 0; i < clubs.size(); i++) {
				pets = clubs.get(i).loadPetsPlainText(pets);
			}
		}
		
	}
	
	
} //end of class