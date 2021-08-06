import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<Category> categoryList = new ArrayList<Category>();
		ArrayList<UserInfo> userAccList = new ArrayList<UserInfo>();
		
		categoryList.add(new Category("Stationery"));
		categoryList.add(new Category("Laptop"));
		
		userAccList.add(new UserInfo("Ben","ben123", "Buyer", "ben@yahoo.com", "YH786nh"));
		userAccList.add(new UserInfo("Candy", "canndy","Seller" ,"candy@gmail.com", "dvD567i"));

		int option = 0;
		
		
		mainMenu();

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
			mainMenu();
		}

	}
	
	private static void mainMenu() {
		
		//Write code here for the mainMenu method.
		
		Helper.line(60, "-");
		System.out.println("CAMPUS ONLINE AUCTION SHOP"); 
		Helper.line(60, "-");
		System.out.println("1. Sign Up");
		System.out.println("2. Log in");
		System.out.println("4. Quit");
		
		int option = 0;
		while (option != 4) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				addUser(userAccList);

			} else if (option == 2) {
				


			} else {
				System.out.println("Invalid option");
			}
			mainMenu();
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
	
	
	public static void addUser(ArrayList<UserInfo> userAccList, UserInfo ua) {
		
		Helper.line(50, "-");
		System.out.println("Sign Up");
		Helper.line(50, "-");
		
		String newName = Helper.readString("Enter name > ");
		String newUsername = Helper.readString("Enter username > ");
		String newRole = Helper.readString("Enter role > ");
		String newEmail = Helper.readString("Enter email > ");
		String newPassword = Helper.readString("Enter password > ");
		
		boolean isSame = false;
		
		for (int i=0; i < userAccList.size(); i++) {
			if(newUsername.equalsIgnoreCase(userAccList.get(i).getUsername())) {
				isSame = true;
				System.out.println("Username exist!");
			}
		}
			if (isSame == false) {
				userAccList.add(new UserInfo( newName,newUsername,newRole, newEmail, newPassword));
			}
	}

	
	public static String viewAllUser(ArrayList<UserInfo> userAccList) {
		
		Helper.line(50, "-");
		System.out.println("View All User");
		Helper.line(50, "-");
		
			if (userAccList.isEmpty() == false) { 
			
				String output = String.format("%s\n", "ALL USERS"); 
			
			for (int i = 0; i < userAccList.size(); i++) {

				output += String.format("%s\n", userAccList.get(i).getName(), userAccList.get(i).getEmail(), userAccList.get(i).getRole());
		}
			
			System.out.println(output);
		}
	}

	

	public static void deleteUser(ArrayList<UserInfo> userAccList) {
		
		Helper.line(50, "-");
		System.out.println("Delete User");
		Helper.line(50, "-");
		
		String delUserEmail = Helper.readString("Enter email to delete user");
		
		if (delUserEmail.contains("@")) {
			
		}
		
	}
	
	
}

