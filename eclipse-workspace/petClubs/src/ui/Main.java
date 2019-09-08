/*
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
* ID
* UNIVERSIDAD ICESI (CALI-COLOMBIA)
* DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN II
* LAB II
* @AUTHOR: GONZALO DE VARONA <gonzalo.de1@correo.icesi.edu.co>
* @LAST UPDATE DATE: 17 AUGUST 2019
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
*/


package ui;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import model.*;

public class Main {
	
	private Scanner reader;
	private Investor investor;
	
	public Main() {
		reader = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		Main execute = new Main();
		execute.menu();
		
		
		
		
	}
	
	public void showMenuOptions(){
		System.out.println("");
		System.out.println("1. Register a new club.");
		System.out.println("2. Register a new client.");
		System.out.println("3. Add a pet to an existing client in a club.");
		System.out.println("4. Erase a club.");
		System.out.println("5. Erase a client from a club.");
		System.out.println("6. Erase a pet from a client.");
		System.out.println("7. Show clients sorted by number of pets (highest-lowest) ");
		System.out.println("8. Show clubs sorted by number of clients (highest-lowest) ");
		System.out.println("9. Sort clubs by a field.");
		System.out.println("10.Sort clients in a club by a field.");
		System.out.println("11.Sort pets from a client in a club by a field.");
		System.out.println("12.Search a club by a given field.");
		System.out.println("13.Search a client in a club by a given field.");
		System.out.println("14.Search a pet from a client in a club by a given field.");
		System.out.println("15.QUIT PROGRAM");
		
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("");
	}
	
	public void menu(){
		int userInput = 0;
		
		//DEPENDENCE
		investor = new Investor();
		
		System.out.println("");
		System.out.println("");

		//WELCOME 	
		System.out.println("M''MMM''MMM''M          dP                                         "); 
		System.out.println("M  MMM  MMM  M          88                                         ");
		System.out.println("M  MMP  MMP  M .d8888b. 88 .d8888b. .d8888b. 88d8b.d8b. .d8888b.   ");
		System.out.println("M  MM'  MM' .M 88ooood8 88 88'    ` 88'  `88 88'`88'`88 88ooood8");
		System.out.println("M  `' . '' .MM 88.  ... 88 88.  ... 88.  .88 88  88  88 88.  ...   ");
		System.out.println("M    .d  .dMMM `88888P' dP `88888P' `88888P' dP  dP  dP `88888P'   JSON");
		System.out.println("MMMMMMMMMMMMMM                                                     ");
		System.out.println("                                                                   ");                                                      
	

		while (userInput != 15){

			showMenuOptions();

			System.out.println("--------------------------------------");
			System.out.print("| Type the number of your selection: ");
			try {
				userInput = reader.nextInt();
				reader.nextLine();
				System.out.println("--------------------------------------");
	
				switch (userInput) {
	
					//REGISTER A NEW CLUB
					case 1: 
						registerANewClub();
						break;
	
					//REGISTER A NEW CLIENT
					case 2: 
						registerANewClient();
						break; 
	
	
					//ADD A PET TO AN EXISTING CLIENT
					case 3: 
						addPet(null); 
						break;
						
					//ERASE A CLUB FROM THE PROGRAM
					case 4: 
						eraseAClub(); 
						break;
						
					//ERASE A CLIENT FROM THE PROGRAM
					case 5: 
						eraseAClient(); 
						break;
						
					//ERASE A PET FROM THE PROGRAM
					case 6: 
						eraseAPet(); 
						break;
	
					//QUIT PROGRAM
					case 7: 
						theGoodbye();
						break;
						
					//QUIT PROGRAM
					case 8: 
						theGoodbye();
						break;
						
					//QUIT PROGRAM
					case 9: 
						theGoodbye();
						break;
						
						//QUIT PROGRAM
					case 10: 
						theGoodbye();
						break;
						
					//QUIT PROGRAM
					case 11: 
						theGoodbye();
						break;
	
					default:
						System.out.println();
						System.out.println("Please type a number between 1 and 15");
						System.out.println();
						break;
					
				}
			} catch(InputMismatchException e){
				System.out.println();
				System.out.print("ERROR: Wrong data type.");
				reader.nextLine();
				System.out.println();
			}

		}
		
	}
		
		private void eraseAPet() {
		// TODO Auto-generated method stub
		
		}


		private void eraseAClient() {
			try {
				System.out.println("");
				System.out.print("Please type the club's ID to find the client to delete: "); String id = reader.nextLine();
				System.out.println("");
				Club myClub = investor.findClub(id);
				if (myClub != null) {
					
					
					
					
					
				} else {
					System.out.println("ERROR: Club not found.");
					} 
				
			} catch (InputMismatchException e) {
				System.out.println("ERROR: Wrong data type.");
			}
		
		}
		
		private void eraseAClub() {
			try {
				
				System.out.println("");
				System.out.println("Find club to delete by ID or name:");
				System.out.println("1. ID.");
				System.out.println("2. Name.");
				System.out.println("");
				int selection = reader.nextInt(); reader.nextLine();
				
				Club myClub = null;
				if (selection ==1 || selection ==2 ) {
					if (selection ==1) {
						System.out.print("Please type the club's ID to delete it: "); String id = reader.nextLine();
						System.out.println("");
						 myClub = investor.findClub(id);
						
						} else {
							System.out.print("Please type the club's name to delete it: "); String name = reader.nextLine();
							System.out.println("");
							 myClub = investor.findClubByName(name);
							} 
					if (myClub != null) {
						System.out.println("* WARNING * Are you sure you want to delete the club? Every client and pet contained to this club will be deleted as well.");
						System.out.println("1. Yes.");
						System.out.println("2. No.");
						int desition = reader.nextInt(); reader.nextLine();
						if (desition == 1) {
							investor.removeOneObjectClub(myClub);
							System.out.println("");
							System.out.println("Club successfully deleted");
							System.out.println("");
						} else {
							System.out.println("");
							System.out.println("Club was not deleted");
							System.out.println("");
							}
						
					} else {
						System.out.println("");
						System.out.println("ERROR: Club not found");
						System.out.println("");
						}
				} else {
					System.out.println("");
					System.out.println("ERROR: Invalid selection.");
					System.out.println("");
					}
				
				
			} catch (InputMismatchException e) {
				System.out.println("ERROR: Wrong data type.");
			}
		
		}

		private void addPet(Person person) {
			try {
				System.out.println("REGISTER PET (every client must have at least one pet to be in a club)");
				System.out.println("");
				System.out.print("Please type the pet's ID: "); String idp = reader.nextLine();
				System.out.print("Please type the pet's name: "); String nameP = reader.nextLine();
				System.out.println("");
			
			
				System.out.print("Please write the pet's type: "); String typeP = reader.nextLine();
				System.out.println("Please select the pet's gender: ");
				System.out.println("1. Male.");
				System.out.println("2. Female.");
				int selection = reader.nextInt(); reader.nextLine();
				char gender = Pet.MALE;
				
				if (selection ==1 || selection ==2 ) {
					if (selection ==2) {
						gender = Pet.FEMALE;
					}
					System.out.println("");
					System.out.print("Please type the pet's birth day: "); int dayP = reader.nextInt(); reader.nextLine();
					System.out.print("Please type the pet's birth month: "); int monthP = reader.nextInt(); reader.nextLine();
					System.out.print("Please type the pet's birth year: "); int yearP = reader.nextInt(); reader.nextLine();
					System.out.println("");
					
					GregorianCalendar now = new GregorianCalendar();
					GregorianCalendar birthDateP = new GregorianCalendar(yearP, monthP, dayP);
					System.out.println("");
					
					if(birthDateP.compareTo(now) <= 0 && yearP>=1970) {
						if (person != null) {
							if (person.isThereADoppelganger(nameP) == false) {
								Pet pet = new Pet(idp, nameP, birthDateP, gender, typeP, person);
								person.addPet(pet);
							} else {
								System.out.println("ERROR: This client already has a pet with this name.");
							}
							
						} else {
							System.out.print("Please type the club's ID where the owner of the pet is:");
							String idClub = reader.nextLine();
							Club mainC = investor.findClub(idClub);
							if (mainC != null) {
								System.out.print("Please type the owner's ID:"); String idOwner = reader.nextLine();
								Person p = mainC.findPersonBinary(idOwner);
								if (p != null) {
									if (p.isThereADoppelganger(nameP) == false) {
										Pet pet = new Pet(idp, nameP, birthDateP, gender, typeP, p);
										p.addPet(pet);
									} else {
										System.out.println("ERROR: This client already has a pet with this name.");
									}
									
								} else {
									System.out.println("");
									System.out.println("ERROR: Client not found.");
									System.out.println("");
								}
							} else {
								System.out.println("");
								System.out.println("ERROR: Club not found.");
								System.out.println("");
						}
					} }else {
						System.out.println("");
						System.out.println("ERROR: Invalid date.");
						System.out.println("");
					} 
				
			} else {
				System.out.println("");
				System.out.println("ERROR: Invalid selection.");
				System.out.println("");
				} 
				
					
			} catch (InputMismatchException e) {
				System.out.println("ERROR: Wrong data type.");
			}
				
				
				
		} 
			
			
		
		

		private void registerANewClient() {
			try {
				System.out.println("");
				System.out.print("Please type the club's ID where the new client will be added: "); String id = reader.nextLine();
				System.out.println("");
				Club myClub = investor.findClub(id);
				if (myClub != null) {
					System.out.print("Please type the new client's ID: "); String idP = reader.nextLine();
					
					if(investor.isThereAClientDoppelganger(idP) == false) {
						System.out.print("Please type the new client's name: "); String name = reader.nextLine();
						System.out.print("Please type the new client's last name: "); String lastName = reader.nextLine();
						System.out.println("");
						System.out.print("Please type the new client's birth day: "); int day = reader.nextInt(); reader.nextLine();
						System.out.print("Please type the new client's birth month: "); int month = reader.nextInt(); reader.nextLine();
						System.out.print("Please type the new client's birth year: "); int year = reader.nextInt(); reader.nextLine();
						System.out.println("");
						System.out.print("Please type the new client's favorite type of pet: "); String favType = reader.nextLine();
						GregorianCalendar now = new GregorianCalendar();
						GregorianCalendar birthDate = new GregorianCalendar(year, month, day);
						System.out.println("");
						
						if(birthDate.compareTo(now) <= 0 && year>=1970) {
							if(!(name.equals("")) && !(lastName.equals("")) && !(id.equals(""))){
								
									Person theNew = new Person(idP, name, lastName, birthDate, favType);
									myClub.addClient(theNew);
									addPet(theNew);
									System.out.println("*******************************************\n");
									System.out.println("* New client has been successfully added! *\n");
									System.out.println("*******************************************\n");
										
									}				
								
								
								
										
						} else {
							System.out.println("ERROR: Invalid birth date.");
							
											}
					} else {
						System.out.println("ERROR: One client cannot be in two clubs.");
		
						}
				} else {
					System.out.println("ERROR: Club not found.");
					} 
				
			} catch (InputMismatchException e) {
				System.out.println("ERROR: Wrong data type.");
			}
		}
			
		
		

		 private void registerANewClub() {
			try {
			 	System.out.println("");
				System.out.print("Please type the club's name: "); String name = reader.nextLine();
				System.out.print("Please type the club's ID: "); String id = reader.nextLine();
				System.out.println("");
				System.out.print("Please type the club's issue day: "); int day = reader.nextInt(); reader.nextLine();
				System.out.print("Please type the club's issue month: "); int month = reader.nextInt(); reader.nextLine();
				System.out.print("Please type the club's issue year: "); int year = reader.nextInt(); reader.nextLine();
	
				GregorianCalendar now = new GregorianCalendar();
				GregorianCalendar issueDate = new GregorianCalendar(year, month, day);
				System.out.println("");
				
				if(issueDate.compareTo(now) <= 0 && year >=1970) {
					if(!(name.equals("")) && !(id.equals(""))){
						if (investor.isThereADoppelgangerClub(id) == false) {
							Club theNew = new Club(name, id, issueDate);
							investor.addClub(theNew);
							System.out.println("*****************************************\n");
							System.out.println("* New club has been successfully added! *\n");
						 	System.out.println("*****************************************\n");
								
						} else { System.out.println("");
				  		System.out.println("ERROR: Invalid ID.");
				  		System.out.println("");
						}
						
					} else { System.out.println("");
					  		System.out.println("ERROR: Invalid credentials.");
					  		System.out.println("");
					}
								
				} else{ System.out.println("");
				  		System.out.println("ERROR: Invalid date.");
				  		System.out.println("");
				}
			} catch (InputMismatchException e) {
				System.out.println("ERROR: Wrong data type.");
			}
		 }

		

		public void theGoodbye() {
			System.out.print("\033[H\033[2J");  
			System.out.flush(); 
			System.out.println("");
			System.out.println("THANK YOU FOR USING MY LIL PET SOFTWARE");
			System.out.println("");
		}
		
		
		
	

}//end of class
