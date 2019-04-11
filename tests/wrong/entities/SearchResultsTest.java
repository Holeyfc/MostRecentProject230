package entities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SearchResultsTest {

	private SearchResults search;
	

	@Before
	public void setUp() throws Exception {
		search = new SearchResults("AUBURN", "ALABAMA", "SMALL-CITY", "STATE", 35000,
				21, 480, 545, 12468, 50, 5500, 90, 60, 2, 4, 4);
	}

	@After
	public void tearDown() throws Exception {
		search = null;
	}
	

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetState() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetControl() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEnrollmentHigh() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSetEnrollmentLow() {
		fail("Not yet implemented");
	}
	@Test
	public void testSetPercFemaleHigh() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercFemaleLow() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSetSATVerbalHigh() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSATVerbalLow() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSATMathHigh() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSATMathLow() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetExpensesHigh() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetExpensesLow() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercFinancAidHigh() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercFinancAidLow() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetApplicantsHigh() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetApplicantsLow() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercAdmittedHigh() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercAdmittedLow() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSetPercEnrolledHigh() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercEnrolledLow() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAcademScaleHigh() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAcademScaleLow() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSocialScaleHigh() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSocialScaleLow() {
		fail("Not yet implemented");
	}
}
