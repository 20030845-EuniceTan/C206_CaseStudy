import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Category cat1;
	private Category cat2; 
	
	private ArrayList<Category> categoryList;

	@Before
	public void setUp() throws Exception {
		
		cat1 = new Category("Laptop");
		cat2 = new Category("Stationery");
		
		categoryList = new ArrayList<Category>();
	}
	
	@Test
	public void testAddCategory() {
		
		// Test category list is not null, so that can add a new category
		assertNotNull("Test if there is valid Category arraylist to add to", categoryList);
		
		// Given an empty list, after adding 1 category, the size of the list is 1
		C206_CaseStudy.addCategory(categoryList, cat1);	
		assertEquals("Test if that Category arraylist size is 1?", 1, categoryList.size());
				
		// Test the category added is not the same as the first category in the list 
		assertSame("Test that Category added is not the same as the first category in the list", cat1, categoryList.get(0));
				
	}
	
	@Test
	public void testViewAllCategory() {
		
		// Test category list is not null but empty, so that it can be viewed
		assertNotNull("Test if there is valid Category arraylist to add to", categoryList);
		
		// Test if the list of categories retrieved from the CaseStudy is not empty
		C206_CaseStudy.addCategory(categoryList, cat1);	
		C206_CaseStudy.addCategory(categoryList, cat2); 	
		
		String allCategory = C206_CaseStudy.retrieveAllCategory(categoryList);
		
		String testOutput = String.format("%s\n", "Laptop");
		testOutput += String.format("%s\n", "Stationery");
		
		assertEquals("Check that ViewAllCategory", testOutput, allCategory);
				
		// Test after adding 2 category, the size of the list is 2
		assertEquals("Test if that Category arraylist size is 2?", 2, categoryList.size());
				
	}
	
	@Test
	public void testDeleteCategory() {
		
		//test if the list is not empty 
		assertNotNull("Test if the list is empty but not null", categoryList);
				
		//test if the list have categories
		C206_CaseStudy.addCategory(categoryList, cat1);
		C206_CaseStudy.addCategory(categoryList, cat2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, categoryList.size());
				
		//test if one of the category is delete
		Boolean isDelete = C206_CaseStudy.doDeleteCategory(categoryList, "Laptop"); 
		assertTrue(isDelete); 
				
	}
	
	@After
	public void tearDown() throws Exception {
 
		categoryList = null; 
		cat1 = null;
		cat2 = null;
		

	}

}
