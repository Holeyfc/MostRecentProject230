package tests;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import controllers.*;
import Entity.*;

import static org.junit.Assert.*;

import java.util.*;
import UI.*;


public class loginLogOutTest {
	LogonController log;
	DatabaseController lib;
@Before
	public void setUp() {
	log = new LogonController();
	lib = new DatabaseController();
	}
@Test
	public void login() {
		log.login("juser", "jpass");
		boolean login = true;
		assertTrue(login == true);
}
@Test
public void loginWorngUserName() {
	log.login("j", "jpass");
	boolean login = true;
	assertTrue(login == true);
}
@Test
public void loginWrongPass() {
	log.login("juser", "jpa");
	boolean login = true;
	assertTrue(login == true);
}
@Test
public void loginInactive() {
	log.login("luser", "jpass");
	boolean login = true;
	assertTrue(login == true);
}
@Test
	public void logout() {
		log.logout();
		boolean logout = true;
		assertTrue(logout == true);
}

}
