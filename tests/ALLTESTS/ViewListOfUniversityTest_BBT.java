import Entity.*;
import controllers.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class ViewListOfUniversityTest_BBT {
private DatabaseController lib;
private Admin ad;
	@Before
	public void setUp() throws Exception {
		ad = new Admin();
		lib = new DatabaseController();
	}

	@Test
	public void test() {
		ad.viewUniversities();
		String[][] schools = this.lib.getUsernamesWithSavedSchools();
		boolean list = false; 
	    for(int i = 0; i < schools.length; i++)
	    {
	      for(int j = 0; j < schools[i].length; j++)
	      {
	        list = true;
	      }
	    }
	    assertTrue(list == true);
	}

}
