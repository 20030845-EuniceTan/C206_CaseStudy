import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<Category> categoryList = new ArrayList<Category>();
		
		categoryList.add(new Category("Stationery"));
		categoryList.add(new Category("Laptop"));

		int option = 0;

		while (option != 4) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// add item
				Category cat = inputCategory();
				C206_CaseStudy.addCategory(categoryList, cat);

			} else if (option == 2) {
				// view all item
				C206_CaseStudy.viewAllCategory(categoryList);

			} else if (option == 3) {
				// delete an item
				C206_CaseStudy.deleteCategory(categoryList);

			} else if (option == 4) {
				System.out.println("Bye!");

			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("CAMPUS ONLINE AUCTION SHOP");
		System.out.println("1. Add Category");
		System.out.println("2. View All Categories");
		System.out.println("3. Delete Category");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static Category inputCategory() {
		
		Helper.line(50, "=");
		System.out.println("ADD CATEGORY");
		Helper.line(50, "=");

		String newName = Helper.readString("Enter new category name > ");
		Category cat = new Category(newName); 
		
		return cat; 
	}
	
	public static void addCategory(ArrayList<Category> categoryList, Category cat) {
		
		boolean isSame = false; 
		
		for (int i = 0; i < categoryList.size(); i++) {
			if (categoryList.get(i).getName().equalsIgnoreCase(cat.getName())) { 
				isSame = true; 
				System.out.println("This category already exists!"); 
			}
		}
		
		if (isSame == false) { 
			categoryList.add(cat);
			System.out.println("New Category Added");
		}
	}
	
	public static String retrieveAllCategory(ArrayList<Category> categoryList) {
		
		String output = "";

		for (int i = 0; i < categoryList.size(); i++) {

			output += String.format("%s\n", categoryList.get(i).getName());
		}
		
		return output;
	}

	public static void viewAllCategory(ArrayList<Category> categoryList) {
		
		Helper.line(50, "=");
		C206_CaseStudy.setHeader("VIEW ALL CATEGORIES");
		Helper.line(50, "=");
		
		String output = String.format("%s\n", "CATEGORIES AVAILABLE"); 
		output += retrieveAllCategory(categoryList);
			
		System.out.println(output);
		
	}
	
	public static void deleteCategory(ArrayList<Category> categoryList) {
		
		Helper.line(50, "=");
		C206_CaseStudy.setHeader("DELETE CATEGORY");
		Helper.line(50, "=");
		
		String removeCat = Helper.readString("Enter category to delete > "); 
		Boolean isDelete = doDeleteCategory(categoryList, removeCat);
		
		if (isDelete == false) {
			System.out.println("Invalid category");
			
		} else {
			System.out.println(removeCat + " is removed");
		}
	}

	public static boolean doDeleteCategory(ArrayList<Category> categoryList, String removeCat){
		
		boolean isDelete = false;
		
		for (int i = 0; i < categoryList.size(); i++) { 
			if (categoryList.get(i).getName().equalsIgnoreCase(removeCat)) { 
				categoryList.remove(i); 
				isDelete = true;
				
			}
		}
		
		return isDelete;
	}
	
}

