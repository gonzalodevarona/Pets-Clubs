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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Club;
import model.Investor;
import model.Person;
import model.Pet;

public class Main {
	
	private Scanner reader;
	private Investor investor;
	
	public Main() {
		
		investor = new Investor();
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
		
		
		try {
			investor.loadClubsPlainText();
			investor.loadPeoplePlainText();
			investor.loadPetsPlainText();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		System.out.println("");
		System.out.println("");

		//WELCOME 	
		System.out.println("M''MMM''MMM''M          dP                                         "); 
		System.out.println("M  MMM  MMM  M          88                                         ");
		System.out.println("M  MMP  MMP  M .d8888b. 88 .d8888b. .d8888b. 88d8b.d8b. .d8888b.   ");
		System.out.println("M  MM'  MM' .M 88ooood8 88 88'    ` 88'  `88 88'`88'`88 88ooood8");
		System.out.println("M  `' . '' .MM 88.  ... 88 88.  ... 88.  .88 88  88  88 88.  ...   ");
		System.out.println("M    .d  .dMMM `88888P' dP `88888P' `88888P' dP  dP  dP `88888P'   TO CLUBS4PETS");
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
	
					//SHOW CLIENTS SORTED BY NUMBER OF PETS (HIGHEST-LOWEST) 
					case 7: 
						clientsSortedByNumberOfPetsHILO();
						break;
						
					//SHOW CLUBS SORTED BY NUMBER OF CLIENTS (HIGHEST-LOWEST) 
					case 8: 
						clubsSortedByNumberOfClientsHILO();
						break;
						
					//SORT CLUBS BY A FIELD
					case 9: 
						sortClubsByField();
						break;
					
					//SORT CLIENTS IN A CLUB BY A FIELD
					case 10: 
						sortClientsByField();
						break;
						
					//SORT A CLIENTS PETS FROM A CLUB BY A FIELD
					case 11: 
						sortPetsByField();
						break;
					
					//SEARCH A CLUB BY A GIVEN FIELD
					case 12: 
						searchClubByField();
						break;
						
					//SEARCH A CLIENT IN A CLUB BY A GIVEN FIELD
					case 13: 
						sortClientsByField();
						break;
						
					//SEARCH A PET FROM A CLIENT IN A CLUB BY A GIVEN FIELD
					case 14: 
						sortClientsByField();
						break;
						
					//QUIT PROGRAM
					case 15: 
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
		
	
	

	public void searchClubByField() {
		System.out.println("Please select a field in order to search a club by it:");
		System.out.println("1. ID");
		System.out.println("2. Name");
		System.out.println("3. Issue date (newest to oldest)");
		System.out.println("4. Type of pet");
		System.out.println();
		
		int selection = reader.nextInt(); reader.nextLine();
		
		
		if (selection>= 1 && selection<=4 ) {
			if (selection== 3) {
				System.out.print("Please type the issue date with - between numbers(dd-mm-yyyy)"); String date = reader.nextLine();	
				long first = System.nanoTime();
				
				Club c = investor.findClubBinary(selection, date);
				System.out.println(c.toString());
				long second = System.nanoTime();
				long finalT = second - first;
				System.out.println("Time for binary search in nanoseconds: "+finalT);
					
			}else {
			System.out.println("Please type the ID/Name/Type of pet: "); String stuff = reader.nextLine();
			long first = System.nanoTime();
			
			Club c = investor.findClubBinary(selection, stuff);
			if (c != null) {
				System.out.println(c.toString());
				long second = System.nanoTime();
				long finalT = second - first;
				System.out.println("Time for binary search in nanoseconds: "+finalT);
				
			} else {
				System.out.println("");
				System.out.println("ERROR: Club not found");
				System.out.println("");
				}
			
			}
		} else {
			System.out.println("");
			System.out.println("ERROR: Invalid selection");
			System.out.println("");
			}
		
		
	}
	
	public void sortPetsByField() {
		System.out.print("Please type the club's ID in order to sort its clients: "); String id = reader.nextLine();
		System.out.println("");
		Club myClub = investor.findClub(id);
		if (myClub != null) {
			
			
			System.out.print("Please type the owner's ID:"); String idOwner = reader.nextLine();
			Person p = myClub.findPersonBinary(idOwner);
			if (p != null) {
				
				System.out.println("Please select a field in order to sort all pets by it:");
				System.out.println("1. ID");
				System.out.println("2. Name");
				System.out.println("3. Birth date (youngest to oldest)");
				System.out.println("4. Gender");
				System.out.println("5. Type of pet");
				System.out.println("note: every field is sorted upwards except issue date");
				System.out.println();
				
				int selection = reader.nextInt(); reader.nextLine();
				
				
				if (selection>= 1 && selection<=5 ) {
					System.out.println(investor.convertSortedPets2String( selection,  myClub, p));
					System.out.println();
					
				} else {
					System.out.println("");
					System.out.println("ERROR: Invalid selection");
					System.out.println("");
					}
				
				
			} else {
				System.out.println("");
				System.out.println("ERROR: Client not found.");
				System.out.println("");
			}
			 	
			
		} else {
			System.out.println("");
			System.out.println("ERROR: Club not found");
			System.out.println("");
			}	
	}
	
	
	

	public void sortClientsByField() {
		System.out.print("Please type the club's ID in order to sort its clients: "); String id = reader.nextLine();
		System.out.println("");
		Club myClub = investor.findClub(id);
		if (myClub != null) {
			
		
			System.out.println("Please select a field in order to sort all clients by it:");
			System.out.println("1. ID");
			System.out.println("2. Name");
			System.out.println("3. Last name");
			System.out.println("4. Birth date (youngest to oldest)");
			System.out.println("5. Favorite type of pet");
			System.out.println("note: every field is sorted upwards except issue date");
			System.out.println();
			
			int selection = reader.nextInt(); reader.nextLine();
			
			
			if (selection>= 1 && selection<=5 ) {
				System.out.println(investor.convertSortedClients2String(selection, myClub));
				System.out.println();
				
			} else {
				System.out.println("");
				System.out.println("ERROR: Invalid selection");
				System.out.println("");
				}
	} else {
		System.out.println("");
		System.out.println("ERROR: Club not found");
		System.out.println("");
		}
		
		
	}

	public void sortClubsByField() {
		System.out.println("Please select a field in order to sort all clubs by it:");
		System.out.println("1. ID");
		System.out.println("2. Name");
		System.out.println("3. Issue date (newest to oldest)");
		System.out.println("4. Type of pet");
		System.out.println("note: every field is sorted upwards except issue date");
		System.out.println();
		
		int selection = reader.nextInt(); reader.nextLine();
		
		
		if (selection>= 1 && selection<=4 ) {
			System.out.println(investor.convertSortedClubs2String(selection));
			System.out.println();
			
		} else {
			System.out.println("");
			System.out.println("ERROR: Invalid selection");
			System.out.println("");
			}
		
		
	}

	public void clientsSortedByNumberOfPetsHILO() {
		System.out.println("CLIENTS SORTED BY NUMBER OF PETS (HIGH-LOW)");
		System.out.println("");
		ArrayList<Person> people = investor.sortByClientsNumberOfPets();
		
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i).getName()+" - "+people.get(i).howManyPetsDoIOwn());
		}
	}
	
	public void clubsSortedByNumberOfClientsHILO() {
		System.out.println("CLUBS SORTED BY NUMBER OF CLIENTS (HIGH-LOW)");
		System.out.println("");
		ArrayList<Club> clubs = investor.sortByNumberOfClients();
		
		for (int i = 0; i < clubs.size(); i++) {
			System.out.println(clubs.get(i).getName()+" - "+clubs.get(i).howManyClientsInTheClub());
		}
	}

	public void eraseAPet() {
		try {
			
			
			System.out.print("Please type the club's ID of the pet's owner to delete: "); String id = reader.nextLine();
			System.out.println("");
			Club myClub = investor.findClub(id);
					
					
				if (myClub != null) {
					
							System.out.print("Please type the client's ID: "); String idP = reader.nextLine();
							Person person = myClub.findPersonBinary(idP);
						
							
						if (person != null) {
							System.out.println("");
							System.out.println("Find the pet to delete by ID or name:");
							System.out.println("1. ID.");
							System.out.println("2. Name.");
							System.out.println("");
							int selection = reader.nextInt(); reader.nextLine();
							Pet pet = null;
							
							if (selection ==1 || selection ==2 ) {
								if (selection ==1) {
									System.out.print("Please type the pet's ID: "); String idp = reader.nextLine();
									pet = person.findPetBinary(idp);
									
								} else {
									System.out.print("Please type the pet's name: "); String name = reader.nextLine();
									pet = person.findPetBinaryByName(name);
									}
								if (pet != null) {
									person.removeOneObjectPet(pet);
									System.out.println("");
									System.out.println(pet.getName()+" was deleted from owner: "+ person.getId());
									System.out.println("");
								}else {
									System.out.println("");
									System.out.println("ERROR: Pet not found");
									System.out.println("");
									}
								
								
							} else {
								System.out.println("");
								System.out.println("ERROR: Invalid selection");
								System.out.println("");
								}
							
							
						} else {
							System.out.println("");
							System.out.println("ERROR: Person not found");
							System.out.println("");
							}
					
					
				} else {
					System.out.println("");
					System.out.println("ERROR: Club not found");
					System.out.println("");
					}
			 
			
		} catch (InputMismatchException e) {
			System.out.println("ERROR: Wrong data type.");
		}
	
	}


		
	public void eraseAClient() {
			try {
				
				
				System.out.print("Please type the club's ID of the client to delete: "); String id = reader.nextLine();
				System.out.println("");
				Club myClub = investor.findClub(id);
						
						
					if (myClub != null) {
						System.out.println("");
						System.out.println("Find the client to delete by ID or name:");
						System.out.println("1. ID.");
						System.out.println("2. Name.");
						System.out.println("");
						int selection = reader.nextInt(); reader.nextLine();
						
						Person person = null;
						
						
						
						if (selection ==1 || selection ==2 ) {
							if (selection ==1) {
								System.out.print("Please type the client's ID: "); String idP = reader.nextLine();
								person = myClub.findPersonBinary(idP);
								if (person != null) {
									myClub.removeOneObjectPerson(person);
									System.out.println("");
									System.out.println(person.getName()+" was deleted from club:"+ myClub.getId());
									System.out.println("");
								} else {
									System.out.println("");
									System.out.println("ERROR: Person not found");
									System.out.println("");
									}
							} else {
								System.out.print("Please type the client's name: "); String name = reader.nextLine();
								person = myClub.findPersonBinaryName(name);
								
								if(person == null) {
									System.out.println("");
									System.out.println("ERROR: Person not found");
									System.out.println("");
									}
								while (person != null) {
									myClub.removeOneObjectPerson(person);
									System.out.println("");
									System.out.println(person.getName()+" was deleted from club: "+ myClub.getId());
									System.out.println("");
									person = myClub.findPersonBinaryName(name);
								}
								
							}
							
							
							
						} else {
							System.out.println("");
							System.out.println("ERROR: Invalid selection");
							System.out.println("");
							}
						
						
					} else {
						System.out.println("");
						System.out.println("ERROR: Club not found");
						System.out.println("");
						}
				 
				
			} catch (InputMismatchException e) {
				System.out.println("ERROR: Wrong data type.");
			}
		
		}
		
	public void eraseAClub() {
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

	public void addPet(Person person) {
			try {
				System.out.println("REGISTER PET (every client must have at least one pet to be in a club)");
				System.out.println("");
				System.out.println("");
				System.out.print("Please type the pet's ID: "); String idp = reader.nextLine();
				System.out.print("Please type the pet's name: "); String nameP = reader.nextLine();
			
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
					monthP = monthP -1;
					GregorianCalendar now = new GregorianCalendar();
					GregorianCalendar birthDateP = new GregorianCalendar(yearP, monthP, dayP);
					System.out.println("");
					
					if(birthDateP.compareTo(now) <= 0 && yearP>=1970) {
						if (person != null) {
							
							if (person.isThereADoppelganger(nameP, idp) == false) {
								Pet pet = new Pet(idp, nameP, birthDateP, gender, typeP, person);
								person.addPet(pet);
								System.out.println("Sucessfully added "+pet.getName()+" to "+person.getName());
							} else {
								System.out.println("ERROR: This client already has a pet with this name or ID.");
							}
							
						} else {
							System.out.print("Please type the club's ID where the owner of the pet is:");
							String idClub = reader.nextLine();
							Club mainC = investor.findClub(idClub);
							if (mainC != null) {
								System.out.print("Please type the owner's ID:"); String idOwner = reader.nextLine();
								Person p = mainC.findPersonBinary(idOwner);
								if (p != null) {
									if (p.isThereADoppelganger(nameP, idp) == false) {
										Pet pet = new Pet(idp, nameP, birthDateP, gender, typeP, p);
										p.addPet(pet);
										System.out.println("Sucessfully added "+pet.getName()+" to "+p.getName());
									} else {
										System.out.println("ERROR: This client already has a pet with this name or ID.");
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
			
			
		
		

	public void registerANewClient() {
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
						month = month -1;
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
			
		
		

	public void registerANewClub() {
			try {
			 	System.out.println("");
				System.out.print("Please type the club's name: "); String name = reader.nextLine();
				System.out.print("Please type the club's ID: "); String id = reader.nextLine();
				System.out.println("");
				System.out.print("Please type the club's issue day: "); int day = reader.nextInt(); reader.nextLine();
				System.out.print("Please type the club's issue month: "); int month = reader.nextInt(); reader.nextLine();
				System.out.print("Please type the club's issue year: "); int year = reader.nextInt(); reader.nextLine();
				month = month -1;
				GregorianCalendar now = new GregorianCalendar();
				GregorianCalendar issueDate = new GregorianCalendar(year, month, day);
				System.out.println("");
				
				if(issueDate.compareTo(now) <= 0 && year >=1970) {
					if(!(name.equals("")) && !(id.equals(""))){
						if (investor.isThereADoppelgangerClub(id) == false) {
							Club theNew = new Club( id, name, issueDate);
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
			try {
				investor.saveClubsCVS();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("THANK YOU FOR USING CLUBS4PETS SOFTWARE");
			System.out.println("");
		}
		
		
		
	

}//end of class
