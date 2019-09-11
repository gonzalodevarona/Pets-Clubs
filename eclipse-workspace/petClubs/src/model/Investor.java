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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
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
		
		File file = new File(Club.CLUBSCSV);
	
	
		FileReader reader = new FileReader(file);
		BufferedReader bufferR = new BufferedReader(reader);
		
		String line = bufferR.readLine();
		String[] words = new String[3];
		
		while (line != null) {
			words = line.split(";");
			
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
	
	public void saveClubsCVS() throws FileNotFoundException {
		File file = new File(Club.CLUBSCSV);
		PrintWriter pr = new PrintWriter(file);
		for (int i = 0; i < clubs.size(); i++) {
			Club clubInMatter = clubs.get(i);
			
			String chain = clubInMatter.getId()+";"+clubInMatter.getName()+";"+clubInMatter.date2String();
			pr.println(chain);
		}
		
		pr.close();
		
	}
	
	public void loadPeoplePlainText() throws FileNotFoundException, IOException {
		String filePath = Person.PEOPLECSV;
		File file = new File(filePath);
		
		
		FileReader reader = new FileReader(file);
		BufferedReader bufferR = new BufferedReader(reader);
		
		String line = bufferR.readLine();
		String[] words = new String[5];
		int j = 0;
		
		while (line != null) {
			words = line.split(";");
			
			//System.out.println("'"+words[0].length()+"'");
			int idP = parseInt(words[0]);
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
	
	private static int parseInt(String number) {
		return Integer.parseInt(cleanTextContent(number));
	}
	
	//I copied this method from the internet because my CSVs were having a issue with no printable characters
	//this method is supposed to clean the csv lines in order to read them and cast Strings to int properly
	//any inquieries about this, ask Juan Manuel Reyes, he helped me out with this.
	//| | | |
	//v v v v
	
	private static String cleanTextContent(String text) 
	{
		// strips off all non-ASCII characters
		text = text.replaceAll("[^\\x00-\\x7F]", "");

		// erases all the ASCII control characters
		text = text.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");
		
		// removes non-printable characters from Unicode
		text = text.replaceAll("\\p{C}", "");

		return text.trim();
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
			
			int idP = (parseInt(words[0]));
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
	
	public boolean isThereAClientDoppelganger(int id) {
		boolean stop = false;
		ArrayList<Person> sortedByName = sortByClientsById();
		int begin = 0;
		int end = sortedByName.size() -1;
		
		while (begin <= end && !stop) {
			int medium = (begin+end)/2;
			int id2Evaluate = sortedByName.get(medium).getId();
			if(id2Evaluate==id) {
				stop = true; 
			} else if(id>id2Evaluate) {
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
		name = name.toLowerCase();;
		for (int i = 0; i < clubs.size() && !stop; i++) {
			if (clubs.get(i).getName().toLowerCase().equalsIgnoreCase(name)) {
				club = clubs.get(i);
				stop = true;
			} 
			
		}
		
		
		return club;
	}
	

	public boolean isThereADoppelgangerClub(String id) {
		boolean stop = false;
		for (int i = 0; i < clubs.size() && !stop; i++) {
			if (clubs.get(i).getId() ==id) {
				stop = true;
			}
		}
		
		return stop;
	}
	
	public void removeOneObjectClub(Club club) {
		clubs.remove(club);
	}
	
	public ArrayList<Club> sortClubsById(){
		ArrayList<Club> sorted = getClubs();
		
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compare(sorted.get(j), sorted.get(j-1)) < 0) {
					Club temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		
		return sorted;
	}
	
	public ArrayList<Club> sortClubsByName(){
		ArrayList<Club> sorted = getClubs();
		
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareName(sorted.get(j), sorted.get(j-1)) < 0) {
					Club temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		
		return sorted;
	}
	
	public ArrayList<Club> sortClubsByType(){
		ArrayList<Club> sorted = getClubs();
		
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareType(sorted.get(j), sorted.get(j-1)) < 0) {
					Club temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		
		return sorted;
	}
	
	public ArrayList<Club> sortClubsByDate() {
		ArrayList<Club> sorted = getClubs();
		
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = i; j > 0; j--) {
				
				if (sorted.get(j).compareDate(sorted.get(j), sorted.get(j-1)) < 0) {
					Club temp = sorted.get(j);
					sorted.set(j, sorted.get(j-1)) ;
					sorted.set(j-1, temp) ;
				} 
			}
		}
		
		
		return sorted;
	}
	
	public String convertSortedClubs2String(int i) {
		String bigOne = "\n";
		ArrayList<Club> printThis = null;
		switch (i) {
		case 1:
			printThis = sortClubsById();
			
			break;
		case 2:
			printThis = sortClubsByName();		
			break;
					
		case 3:
			printThis = sortClubsByDate();
			break;
			
		case 4:
			printThis = sortClubsByType();
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
				bigOne += " - "+printThis.get(j).getTypeOfPet()+"\n";
				break;

			default:
				break;
			}
		}
		
		
		return bigOne;
	}
	
	public String convertSortedClients2String(int i, Club club) {
		return club.convertSortedClients2String(i);
	}
	
	
	
	public Club findClubBinary(int i, String thing) {
		
		ArrayList<Club> sorted = null; //- 2 +
		switch (i) {
		case 1:
			sorted = sortClubsById();
			
			break;
		case 2:
			sorted = sortClubsByName();		
			break;
					
		case 3:
			sorted = sortClubsByDate();
			break;
			
		case 4:
			sorted = sortClubsByType();
			break;

		default:
			break;
		}
		
		int begin = 0;
		int end = sorted.size() -1;
		Club stop = null;
		while (begin <= end && stop == null) {
			int medium = (begin+end)/2;
			String evaluation = "";
			switch (i) {
			case 1:
				 evaluation = sorted.get(medium).getId();
				
				break;
			case 2:
				 evaluation = sorted.get(medium).getName();
				 
				break;
						
			case 3:
				evaluation = sorted.get(medium).date2String();
				break;
				
			case 4:
				evaluation = sorted.get(medium).getTypeOfPet();
				break;
			
		

			default:
				break;
			}
			
			System.out.println(evaluation);
			System.out.println(thing);
			if(evaluation.equalsIgnoreCase(thing)) {
				stop = sorted.get(medium); 
				
			} else if(thing.compareTo(evaluation)>0) {
				begin = medium +1;
			} else {
				end = medium -1;
			}
		}
		
		return stop;
	}
	
	
	public String convertSortedPets2String(int i, Club club, Person person) {
		return club.convertSortedPets2String(i, person);
	}
	
	
	

	public String searchPersonByField(Club myClub, int selection, int id, String thing) {
		String big = "ERROR: No client found";
		Person p = null;
		if (selection == 1) {
			p = myClub.findPersonBinary( id);
	
		} else {
			p= myClub.searchPersonByOtherFields(selection, thing);
		}
		
		if (p != null) {
			big = p.toString();
		}
		
		return big;
	}
	
	public String searchPetByField(Club myClub, Person person, int selection, int id, String thing) {
		return myClub.searchPetByField(person, selection, id, thing);
	}
	
	
	

	
	
	
	
	
	
} //end of class