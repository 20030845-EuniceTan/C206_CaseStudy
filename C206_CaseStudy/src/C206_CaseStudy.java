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
				addCategory(categoryList);

			} else if (option == 2) {
				// view all item
				viewAllCategory(categoryList);

			} else if (option == 3) {
				// delete an item
				deleteCategory(categoryList);

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

	public static void addCategory(ArrayList<Category> categoryList) {
		
		Helper.line(50, "-");
		System.out.println("ADD CATEGORY");
		Helper.line(50, "-");

		String newName = Helper.readString("Enter new category name > ");
		
		boolean isSame = false; 
		
		for (int i = 0; i < categoryList.size(); i++) {
			if(newName.equalsIgnoreCase(categoryList.get(i).getName())) { 
				isSame = true; 
				System.out.println("This category already exists!"); 
			}
		}
		
		if (isSame == false) { 
			
			categoryList.add(new Category(newName));
			System.out.println("New Category Added");
				
		}
	}

	public static void viewAllCategory(ArrayList<Category> categoryList) {
		
		Helper.line(50, "-");
		System.out.println("VIEW ALL CATEGORIES");
		Helper.line(50, "-");
		
		if (categoryList.isEmpty() == false) { 
			
			String output = String.format("%s\n", "CATEGORIES AVAILABLE"); 
			
			for (int i = 0; i < categoryList.size(); i++) {

				output += String.format("%s\n", categoryList.get(i).getName());
		}
			
			System.out.println(output);
		}
	}

	public static void deleteCategory(ArrayList<Category> categoryList) {
		
		Helper.line(50, "-");
		System.out.println("DELETE CATEGORY");
		Helper.line(50, "-");
		
		String removeCat = Helper.readString("Enter category to delete > "); 
		
		for (int i = 0; i < categoryList.size(); i++) { 
			if (categoryList.get(i).getName().equalsIgnoreCase(removeCat)) { 
				categoryList.remove(i); 
				break;
			}
		}
		
		System.out.println(removeCat + " is removed"); 

	}
}

