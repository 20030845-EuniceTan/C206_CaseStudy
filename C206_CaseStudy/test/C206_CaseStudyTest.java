import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private UserAcc ua1;
	private UserAcc ua2;
	
	private ArrayList<UserAcc> userAccList;

	@Before
	public void setUp() throws Exception {
		ua1 = new UserAcc("Ben", "ben@yahoo.com", "YH786nh", null);
		ua2 = new UserAcc("Candy", "candy@gmail.com", "dvD567i",null);
	}
	@Test
	public void testAddUserAccount() {
		// Item list is not null, so that can add a new user
		assertNotNull("Test if there is valid User Account arraylist to add to", userAccList);
	
		// Given an empty list, after adding 1 user, the size of the list is 1
		C206_CaseStudy.addUserAcc(userAccList, ua1);
		assertEquals("Test if that UserAccount arraylist size is 1?", 1, userAccList.size());
	
		// The user just added is as same as the first user of the list
		assertSame("Test that UserAccount is added same as 1st item of the list?", ua1, userAccList.get(0));
	
		// Add another user. test The size of the list is 2?
		C206_CaseStudy.addUserAcc(userAccList, ua2);
		assertEquals("Test that UserAccount arraylist size is 2?", 2, userAccList.size());
		}
		
	@Test
	public void testRetrieveAllUser() {
		// Item list is not null, so that can add a new user
		assertNotNull("Test if there is valid User Account arraylist to add to", userAccList);
	
		// test if the list of users retrieved from the SourceCentre is empty
		String allUsers = C206_CaseStudy.retrieveAllUserAcc(userAccList);
		String testOutput = "";
		assertEquals("Check that ViewAllUserAcclist", testOutput, allUsers);
		// Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addUserAcc(userAccList, ua1);
		C206_CaseStudy.addUserAcc(userAccList, ua2);
		assertEquals("Test if that User Account arraylist size is 2?", 2, userAccList.size());
	
		// test if the expected output string same as the list of users retrieved
		// from the SourceCentre
		allUsers = C206_CaseStudy.retrieveAllUserAcc(userAccList);
	
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n", "Ben", "ben@yahoo.com", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n", "Candy", "candy@gmail.com", "Yes", "", 20);
	
		assertEquals("Check that ViewAllUserAcclist", testOutput, allUsers);

	}
	
	@Test
	public void testDoReturnCamcorder() {
		//fail("Not yet implemented");
        
        
        // Test if Item list is not empty, so that can loan a item
        assertNull("Test if there is valid Camcorder to return to", userAccList);
                        
        //Given an empty list, after adding 2 items, test if the size of the list is 2
        C206_CaseStudy.addUserAcc(userAccList, ua1);
		C206_CaseStudy.addUserAcc(userAccList, ua1);
        assertEquals("Test if that Camcorder arraylist size is 2?", 2, userAccList.size());
                
        //test if the expected output string same as the list of users retrieved from the SourceCentre
        String allChromebook = C206_CaseStudy.retrieveAllUserAcc(userAccList);

 

        String testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "","Mac OS");
        testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "","Win 10");
            
		assertEquals("Check that ViewAllUserAcclist", testOutput, allUsers);
         
    }  

	@After
	public void tearDown() throws Exception {
		ua1 = null;
		ua2 = null;
		userAccList = null;
		
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	
	

}
