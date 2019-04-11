package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdminTest.class, loginLogOutTest.class, SearchOthersSavedSchoolsTest.class, testAddNewUniversity.class,
		TestDeactivateUser.class, TestDeleteSchool.class, TestDeleteUser.class, testSaveUniversity.class,
		ViewListOfUniversityTest_BBT.class, ViewProfileTest_BBT.class, ViewSavedUniversityTest_BBT.class })
public class AllTests {

}
