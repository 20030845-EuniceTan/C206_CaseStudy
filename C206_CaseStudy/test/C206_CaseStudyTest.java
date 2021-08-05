import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private UserAcc uA1;
	private UserAcc uA2;
	
	private ArrayList<UserAcc> userAccList;

	@Before
	public void setUp() throws Exception {
		ua1 = new UserAcc("Ben", "ben@yahoo.com", 40);
		ua2 = new UserAcc("Candy", "candy@gmail.com", 20);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void testAddUserAccount() {
		// Item list is not null, so that can add a new user
		assertNotNull("Test if there is valid User Account arraylist to add to", userAccList);

		// Given an empty list, after adding 1 user, the size of the list is 1
		ResourceCentre.addUserAcc(userAccList, ua1);
		assertEquals("Test if that UserAccount arraylist size is 1?", 1, userAccList.size());

		// The user just added is as same as the first user of the list
		assertSame("Test that UserAccount is added same as 1st item of the list?", cc1, userAccList.get(0));

		// Add another user. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, ua2);
		assertEquals("Test that UserAccount arraylist size is 2?", 2, userAccList.size());
	}

}
