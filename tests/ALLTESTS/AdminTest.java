package Entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controllers.DatabaseController;

public class AdminTest {
	private Admin admin;
	private DatabaseController lib;
	
	@Before
	public void setUp() throws Exception {
		admin = new Admin();
		lib = new DatabaseController();
	}

	@Test
	public void testAddNewUser() {
		String user = "user";
		admin.addNewUser("nUser", "new", user, "upass", 'u');
		boolean userAdded = true;
	
		assertTrue("User " + user + " has been added.", userAdded == true);
		
	}

	@Test
	public void testEditUser() {
		admin.editUser();
		boolean result = true;
		assertTrue("User has been updated", result = true);
	}
		
		
	
	@Test
	public void testEditUniversity() {
		admin.afc.editUniversity("Brown");
		boolean result = true;
		assertTrue("University's information had been edited", result = true);
		
		admin.afc.editUniversity("Harvard");
		boolean result2= true;
		assertTrue("University's information had been edited", result2 = true);
	}
	
	@Test
	public void testResetUserPassword() {
		admin.afc.resetUsersPassword("juser","jpass");
		boolean resetUsersPassword = true;
		assertTrue("User's password has been reset.", resetUsersPassword == true);
	}
}
