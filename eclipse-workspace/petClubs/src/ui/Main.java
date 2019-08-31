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
import java.io.IOException;
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
		System.out.println("3. Add a pet to an existing client.");
		System.out.println("4. Erase a club.");
		System.out.println("5. Erase a client from a club.");
		System.out.println("6. Erase a pet from a client.");
		System.out.println("7. QUIT PROGRAM");
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
		System.out.println("M    .d  .dMMM `88888P' dP `88888P' `88888P' dP  dP  dP `88888P'   ");
		System.out.println("MMMMMMMMMMMMMM                                                     ");
		System.out.println("                                                                   ");                                                      
	

		while (userInput != 4){

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
						addPet(); 
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
	
					default:
						System.out.println();
						System.out.println("Please type a number between 1 and 7");
						System.out.println();
						break;
					
				}
			} catch(InputMismatchException e){
				System.out.println();
				System.out.print("ERROR: Invalid option");
				reader.nextLine();
				System.out.println();
			}

		}
		
	}
		
		private void eraseAPet() {
		// TODO Auto-generated method stub
		
	}

		private void eraseAClient() {
		// TODO Auto-generated method stub
		
		}

		private void eraseAClub() {
		// TODO Auto-generated method stub
		
		}

		private void addPet() {
		// TODO Auto-generated method stub
		
		}

		private void registerANewClient() {
		// TODO Auto-generated method stub
		
		}

		 private void registerANewClub() {
		// TODO Auto-generated method stub
		
		 }

		

		public void theGoodbye() {
			System.out.print("\033[H\033[2J");  
			System.out.flush(); 
			System.out.println("");
			System.out.println("THANK YOU FOR USING MY LIL PET SOFTWARE");
			System.out.println("");
		}
		
	

}//end of class
