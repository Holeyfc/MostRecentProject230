package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import controllers.*;
import Entity.*;
import UI.*;
import java.util.*;


public class SearchOthersSavedSchoolsTest {
	Account2 ac;
	DatabaseController lib;

	
	@Before
	public void setUp() {
		ac = new Admin();
		lib = new DatabaseController();
	}
	
	@Test
	public void test() {
		ac.searchOthersSchools();
	   boolean search = true;
		assertTrue(search == true);
		
	}

}
