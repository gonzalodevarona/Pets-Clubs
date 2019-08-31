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

public class Club {
	
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
	}
	
	public ArrayList<Pet> loadPetsPlainText(ArrayList<Pet> pets) {
		for (int i = 0; i < clients.size(); i++) {
			Pet pet = pets.get(0);
			clients.get(i).addPet(pet);
			pet.setOwner(clients.get(i));
			pets.remove(0);
			
		}
		return pets;
	}
	
	public int howManyPetsInTheClub() {
		return 0;
	} 
	
	
	


} //end of class
