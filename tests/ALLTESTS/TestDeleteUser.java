package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import controllers.*;
import Entity.*;
import UI.*;
import java.util.*;


public class TestDeleteUser {
	Admin ad;
	DatabaseController lib;

	
	@Before
	public void setUp() {
		ad = new Admin();
		lib = new DatabaseController();
	}
	
	@Test
	public void test() {
		ad.deleteUser();
		boolean deleted = true;
		String[][] users = lib.getUsers();
		for(int i = 0; i < users.length; i++)
		{
		  if(users[i][2].equals("x"))
				  {
			 deleted = false;
				  }
		}
		assertTrue(deleted == true);
		
	}

}
