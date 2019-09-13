package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

class TestInvestor {

Investor investor;
	
	public void setupStage() {
		investor = new Investor();
		
		
		Club p = new Club("5", "Germany",new GregorianCalendar(2010, 8, 3) );
		Club p1 = new Club("4", "London",new GregorianCalendar(2015, 8, 3) );
		Club p2 = new Club("3", "Belgium",new GregorianCalendar(2012, 8, 3) );
		Club p3 = new Club("2", "Havana",new GregorianCalendar(2007, 8, 3) );
		Club p4 = new Club("1", "Bagdad",new GregorianCalendar(2005, 8, 3) );
		investor.addClub(p);
		investor.addClub(p1);
		investor.addClub(p2);
		investor.addClub(p3);
		investor.addClub(p4);
		
		
	}

	@Test
	void testSortId() {
		setupStage();
		
		boolean done = false;
		ArrayList<Club> a = investor.sortClubsById();
		
		if(a.get(0).getId().equalsIgnoreCase("1")) {
			if(a.get(1).getId().equalsIgnoreCase("2")) {
				if(a.get(2).getId().equalsIgnoreCase("3")) {
					if(a.get(3).getId().equalsIgnoreCase("4")) {
						if(a.get(4).getId().equalsIgnoreCase("5")) {
							done = true;
						}
					}
				}
			}
		}
		assertTrue(done);
	}
	
	@Test
	void testSortName() {
		setupStage();
		
		boolean done = false;
		ArrayList<Club> a = investor.sortClubsByName();
		
		if(a.get(0).getName().equalsIgnoreCase("Bagdad")) {
			if(a.get(1).getName().equalsIgnoreCase("Belgium")) {
				if(a.get(2).getName().equalsIgnoreCase("Germany")) {
					if(a.get(3).getName().equalsIgnoreCase("Havana")) {
						if(a.get(4).getName().equalsIgnoreCase("London")) {
							done = true;
						}
					}
				}
			}
		}
		assertTrue(done);
	}
	
	

	

}
