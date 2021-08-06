import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Item i1;
	private Item i2;
	
	private ArrayList<Item> itemList;
	
	@Before
	public void setUp() throws Exception {
		
		i1 = new Item("Books","Programming books",10.00,"3/5/2022","13/5/2022",2.00);
		i2 = new Item("Table Lamp","For study table",6.00,"3/5/2022","13/5/2022",1.00);
		
		itemList = new ArrayList<Item>();
	}

	@Test
	public void testAddItem() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid item arraylist to add to", itemList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ItemsMain.addItem(itemList,i1);		
		assertEquals("Test if that item arraylist size is 1?", 1, itemList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that item is added same as 1st item of the list?", i1, itemList.get(0));
		
		//Add another item. test The size of the list is 2?
		ItemsMain.addItem(itemList,i2);
		assertEquals("Test that item arraylist size is 2?", 2, itemList.size());
	}
	
	@Test
	public void testViewAllItems() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid item arraylist to view", itemList);
		
		//test if the list of items retrieved from the Case Study is not empty
		ItemsMain.addItem(itemList, i1);
		ItemsMain.addItem(itemList, i2);
		
		String allitems = ItemsMain.retrieveAllItems(itemList);
		
		String testOutput = String.format("%-20s %-30s %-10.2f %-20s %-20s %-20.2f\n","Books","Programming books",10.00,"3/5/2022","13/5/2022",2.00);
		testOutput += String.format("%-20s %-30s %-10.2f %-20s %-20s %-20.2f\n","Table Lamp","For study table",6.00,"3/5/2022","13/5/2022",1.00);
		
		assertEquals("Check that ViewAllItems list", testOutput, allitems);
		
		// Test that after adding 2 items, the size of the list is 2
		assertEquals("Test if that item arraylist size is 2?", 2, itemList.size());
		
	}
	
	@Test
	public void testDeleteItem() {
		//Test if the Item is not null before deleting a item
		assertNotNull("Test if there is valid item arraylist to add to", itemList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ItemsMain.addItem(itemList,i1);
		ItemsMain.addItem(itemList,i2);
		assertEquals("Test if that item arraylist size is 1?", 2, itemList.size());
		
		itemList.remove(0);
		assertEquals("Test if that item arraylist size is 1?", 1, itemList.size());
		
		//remove another item, then list is empty
		itemList.remove(0);
		assertEquals("Test if that item arraylist size is 1?", 0, itemList.size());
		assertTrue(itemList.isEmpty());
	}
	
	@After
	public void tearDown() throws Exception {
		i1 = null;
		i2 = null;
		itemList = null;
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
