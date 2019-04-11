package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import controllers.*;
import Entity.*;
import UI.*;
import java.util.*;

public class TestDeleteSchool {
	Admin ad;
	DatabaseController lib;

	@Before
	public void setUp() {
		ad = new Admin();
		lib = new DatabaseController();
	}

	
	@Test
	public void test() {
		ad.deleteSchool();
		boolean delete = true;
		ArrayList<University> unis = lib.getListOfUniversities();
		for (int i = 0; i < unis.size(); i++) {
			if (unis.get(i).getName().equals("x")) {
				delete = false;
			}
			assertTrue(delete == true);

		}
	}
}
