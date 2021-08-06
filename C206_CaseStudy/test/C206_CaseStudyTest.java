import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Bid b1;
	private Bid b2;
	
	private ArrayList<Bid> bidList;

	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
//		b1 = new Bid(123,"Antique","sajini@gmail.com","lol@gmail.com",9.00);
		b2 = new Bid(223, "AntiqueShop", "sallyTay@gmail.com", "bobNg@gmail.com", 11.00);
//		b2 = new Bid(456,"Ancient","lmao@gmail.com","test@gmail.com",10.00);
		b1 = new Bid(123, "Antique", "sally@gmail.com", "bob@gmail.com", 9.00);
		
		bidList= new ArrayList<Bid>();
	}

	
	@Test
	public void addBidsTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Bid arraylist to add to", bidList);
		
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addBids(bidList, b1);
		assertEquals("Check that Bid arraylist size is 1", 1, bidList.size());
	
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addBids(bidList, b2);
		assertEquals("Check that Bid arraylist size is 2", 2, bidList.size());
	
	}
	
	@Test
	public void retrieveAllBidsTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Bid arraylist to retrieve item", bidList);
		
		//test if the expected output string same as the list of bids retrieved from the CaseStudy	
		C206_CaseStudy.addBids(bidList, b1);
		C206_CaseStudy.addBids(bidList, b2);
		
		String allBids = C206_CaseStudy.retrieveAllBids(bidList);
		
	//	String testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n",223,"AntiqueShop","sallyTay@gmail.com","bobNg@gmail.com",11.00);
		String testOutput = String.format("%-7d %-15s %-20s %-15s %-25.2f\n", 123, "Antique","sally@gmail.com","bob@gmail.com",9.00);
		testOutput += String.format("%-7d %-15s %-20s %-15s %-25.2f\n",223,"AntiqueShop","sallyTay@gmail.com","bobNg@gmail.com",11.00);
			
		assertEquals("Test that ViewAllBidslist", testOutput, allBids);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		assertEquals("Test that Bids arraylist size is 2", 2, bidList.size());

		
		
	}


	@Test
	public void deleteBidsTest() {
		//boundary
		assertNotNull("test if there is valid Bid arraylist to loan from", bidList);
		
		C206_CaseStudy.addBids(bidList, b1);
		C206_CaseStudy.addBids(bidList, b2);
		assertEquals("Test if the Bid arraylist size is 2?",2,bidList.size());
		
		boolean isDelete = C206_CaseStudy.doDeleteBids(bidList,123);
		assertTrue(isDelete);
		
	}
	

	
	@After
	public void tearDown() throws Exception {
		b1 = null;
		b2 = null;
		bidList = null;

	}

}
