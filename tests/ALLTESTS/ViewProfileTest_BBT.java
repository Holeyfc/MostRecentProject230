import Entity.*;
import controllers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class ViewProfileTest_BBT {
private Admin ad;
private DatabaseController lib;
	@Before
	public void setUp() throws Exception {
		ad = new Admin();
		lib = new DatabaseController();
	}

	@Test
	public void test() {
		ad.viewProfile();
		boolean view = false; 
	    String[][] users = this.lib.getUsers();
	    for(int i = 0; i < users.length; i++)
	    {
	      for(int j = 0; j < users[i].length; j++)
	      {
	        view = true; 
	      }
	    }
	    assertTrue(view == true);
	  }
	 
	}
