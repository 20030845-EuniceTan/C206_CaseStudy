import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private UserAccount ua1;
	private UserAccount ua2;
	
	private ArrayList<UserAccount> userAccList;

	@Before
	public void setUp() throws Exception {
		
		ua1 = new UserAccount("Candy", "canndy", "Seller", "candy@gmail.com", "dvD567i");
		ua2 = new UserAccount("Ben", "ben123", "Buyer", "ben@yahoo.com", "YH786nh");
		
		userAccList = new ArrayList<UserAccount>();
	}
	
	@Test
	public void testAddUser() {
		
		// Item list is not null, so that can add a new user
		assertNotNull("Test if there is valid User Account arraylist to add to", userAccList);
	
		// Given an empty list, after adding 1 user, the size of the list is 1
		C206_CaseStudy.addUser(userAccList, ua1);
		assertEquals("Test if that UserAccount arraylist size is 1?", 1, userAccList.size());
	
		// The user just added is as same as the first user of the list
		assertSame("Test that User is added same as 1st user of the list?", ua1, userAccList.get(0));
	
		// Add another user. test The size of the list is 2?
		C206_CaseStudy.addUser(userAccList, ua2);
		assertEquals("Test that UserAccount arraylist size is 2?", 2, userAccList.size());
		}
		
	@Test
	public void testViewAllUser() {
		
		// Item list is not null, so that can view all user
		assertNotNull("Test if there is valid User Account arraylist to add to", userAccList);
	
		// test if the list of users retrieved from the CaseStudy is not empty
		C206_CaseStudy.addUser(userAccList, ua1);
		C206_CaseStudy.addUser(userAccList, ua2);
		
		String allUsers = C206_CaseStudy.retrieveAllUser(userAccList);
		
		String testOutput = String.format("%-15s %-15s %-15s %-15s %-15s\n", "Candy", "canndy", "Seller", "candy@gmail.com", "dvD567i");
		testOutput += String.format("%-15s %-15s %-15s %-15s %-15s\n", "Ben", "ben123", "Buyer", "ben@yahoo.com", "YH786nh");
		
		assertEquals("Check that ViewAllUserAcclist", testOutput, allUsers);
		
		// Test after adding 2 items, test if the size of the list is 2
		
		assertEquals("Test if that User Account arraylist size is 2?", 2, userAccList.size());
	

	}
	
	@Test
	public void testDeleteUser() {
        
        
        // Test if user list is not empty, so that can delete user
        assertNotNull("Test if there is valid User to delete to", userAccList);
                        
        //Test if the list with users
        C206_CaseStudy.addUser(userAccList, ua1);
		C206_CaseStudy.addUser(userAccList, ua2);
		assertEquals("Test if the user list is size 2?", 2, userAccList.size());
		
        //test if user is deleted
        Boolean isDelete = C206_CaseStudy.doDeleteUser(userAccList, "ben@yahoo.com");
        assertTrue(isDelete);
    }  

	@After
	public void tearDown() throws Exception {
		ua1 = null;
		ua2 = null;
		userAccList = null;
		
	}

	
	
	
	

}
