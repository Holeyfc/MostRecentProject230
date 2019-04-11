import controllers.*;
import Entity.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class ViewSavedUniversityTest_BBT {
private DatabaseController lib;
private Admin ad;
	@Before
	public void setUp() throws Exception {
		ad = new Admin();
		lib = new DatabaseController();
	}

	@Test
	public void test() {
		ad.viewSavedUniversities();
		boolean view = false;
		String[][] schools = this.lib.getUsernamesWithSavedSchools();
	    for(int i = 0; i < schools.length; i++)
	    {
	      for(int j = 0; j < schools[i].length; j++)
	      {
	        view = true; 
	      }
	    }
	    assertTrue(view == true);
	}
}