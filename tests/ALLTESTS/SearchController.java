package controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.University;
import controllers.SearchController;

public class SearchControllerTest {

	private DatabaseController database;
	private SearchController sc;
	private University uni;
	
	
	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		database = new DatabaseController();
	}

	@Before
	public void setUp() throws Exception {
		sc = new SearchController();
		uni = new University("AUBURN", "ALABAMA", "SMALL-CITY", "STATE", 35000,
				21, 480, 545, 12468, 50, 5500, 90, 60, 2, 4, 4);
		database.addUniversity(uni);
	}

	//"AUBURN", "ALABAMA", "SMALL-CITY", "STATE",
	//35000, 21, 480, 545, 12468, 50, 5500, 90, 60, 2, 4, 4
	
	@After
	public void tearDown() throws Exception {
		uni = new University("AUBURN", "ALABAMA", "SMALL-CITY", "STATE", 35000,
				21, 480, 545, 12468, 50, 5500, 90, 60, 2, 4, 4);
		database.editUniversity(uni);
		database.deleteUniversity(uni.getName());
	}

	@Test
	public void testFoundUniMatch() {
		assertTrue("University matches given fields", sc.searchUniversities(uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	

	@Test
	public void testSearchUnfoundName() {
		uni.setName("BIBBIDY UNIVERSITY");
		assertFalse("No school matches BIBBIDY", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundState() {
		uni.setState("Zimbabwe");
		assertFalse("No school in the database is in Zimbabwe", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundLocation() {
		uni.setLocation("COUNTRY");
		assertFalse("No school is in the country in the database", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundControl() {
		uni.setControl("NATIONAL");
		assertFalse("No school has a control of NATIONAL in the database", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundEnrollment() {
		uni.setPerEnrolled(0);
		assertFalse("No school has 0 percent enrolled", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	
	@Test
	public void testSearchFoundEnrollmentNegative() {
		uni.setPerEnrolled(-1);
		assertTrue("A uni of -1 percent enrolled should be found", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundPercFemale() {
		uni.setPercentFemale(0);
		assertFalse("No school should ever have 0 percent females", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}

	
	@Test
	public void testSearchFoundPercFemaleNegative() {
		uni.setPercentFemale(-1);
		assertTrue("School with -1 percent female should be found", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundSATVerbal() {
		uni.setSatVerbal(0);
		assertFalse("No school should have a 0 min Sat Verbal", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}

	
	@Test
	public void testSearchFoundSATVerbalNegative() {
		uni.setPercentFemale(-1);
		assertTrue("School with -1 Sat Verbal should be found", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundSATMath() {
		uni.setSatMath(0);
		assertFalse("No school should have 0 min for Sat Math", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	
	@Test
	public void testSearchFoundSATMathNegative() {
		uni.setSatMath(-1);
		assertTrue("School with -1 min Sat Math should be found", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundExpenses() {
		uni.setExpenses(0);
		assertFalse("No school in database has 0 for expenses", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchFoundExpensesNegative() {
		uni.setExpenses(-1);
		assertTrue("School with -1 expenses should be found", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundPercFinAid() {
		uni.setFinAid(0);
		assertFalse("No scholl should have 0 percent financial aid", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}

	
	@Test
	public void testSearchFoundPercFinAidNegative() {
		uni.setFinAid(-1);
		assertTrue("School with -1 percent financial aid should be found", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundNumApplicants() {
		uni.setNumApplicants(0);
		assertFalse("No school should have 0 applicants", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}

	@Test
	public void testSearchFoundNumApplicantsNegative() {
		uni.setNumApplicants(-1);
		assertTrue("School with -1 number of applicants should be found", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundPercAdmitted() {
		uni.setPerAdmitted(0);
		assertFalse("No school should have 0 percent admitted", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearcFoundhPercAdmittedNegative() {
		uni.setPerAdmitted(-1);
		assertTrue("School with -1 percent admitted should be found", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundPercEnrolled() {
		uni.setPerEnrolled(0);
		assertFalse("No school should have 0 percent enrolled", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	
	@Test
	public void testSearchFoundPercEnrolledNegative() {
		uni.setPerEnrolled(-1);
		assertTrue("School with -1 percent enrolled should be found", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundAcademScale() {
		uni.setAcademicScale(0);
		assertFalse("No school should have a 0 min academic scale", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchFoundAcademScaleNegative() {
		uni.setAcademicScale(-1);
		assertTrue("School with -1 academic scale should be found", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundSocScale() {
		uni.setSocialScale(0);
		assertFalse("No school should have 0 for social scale", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchFoundSocScaleNegative() {
		uni.setSocialScale(-1);
		assertTrue("School with -1 social scale should be found", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	@Test
	public void testSearchUnfoundQualOfLifeScale() {
		uni.setLifeScale(0);
		assertFalse("No school should have a 0 for life scale", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	
	
	@Test
	public void testSearchFoundQualOfLifeScaleNegative() {
		uni.setLifeScale(-1);
		assertTrue("School with -1 life scale should be found", sc.searchUniversities(	uni.getName(), uni.getState(), uni.getLocation(),
				uni.getControl(), uni.getNumOfStudents(), uni.getPercentFemale(),
				uni.getSatVerbal(), uni.getSatVerbal(), uni.getExpenses(),
				uni.getFinAid(), uni.getNumApplicants(), uni.getPerAdmitted(),
				uni.getPerEnrolled(), uni.getAcademicScale(), uni.getSocialScale(),
				uni.getLifeScale()));
	}
	

}
