package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import controllers.*;
import Entity.*;
import UI.*;

public class testSaveUniversity {
	
	DatabaseController lib;
	Account2 acc;
	
	
	@Before
	
	public void setUp()
	{
		lib = new DatabaseController();
		acc = new Account2();
	}
	
	
	
	@Test
	public void testSavedUniversity() {
		
		
		lib.saveSchool("luser", "BROWN");
	    String schools[][] = lib.getUsernamesWithSavedSchools();
		boolean found = false;
		System.out.println("something");
		for(int i = 0; i < schools.length; i++)
		{
			System.out.println(schools[i][0]);
			if (schools[i][0].equals("luser"))
			{
				for(int j = 0; j < schools[i].length; j++)
				{
					if (schools[i][j].equals("BROWN"))
					{ 
						found = true;
					}
				}
			}
		}
		assertTrue(found == true);
	}

}
