package tests;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import controllers.*;
import Entity.*;
import UI.*;
import java.util.*;

public class testAddNewUniversity {
	
	DatabaseController lib;
	Account2 acc;
	
	
	@Before
	
	public void setUp()
	{
		lib = new DatabaseController();
		acc = new Account2();
	}
	
	
	
	@Test
	public void testAddNewUniversityCase() {
		University uni = new University("x", "x", "x", "x", 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		lib.addUniversity(uni);
		ArrayList<University> unis = lib.getListOfUniversities();
		boolean found = false;
		for(int i = 0 ; i < unis.size(); i++)
		{
		  if(unis.get(i).getName().equals("x"))
		  {
		   found = true;
		  }
		}
		assertTrue(found == true);
	}
		
		

}
