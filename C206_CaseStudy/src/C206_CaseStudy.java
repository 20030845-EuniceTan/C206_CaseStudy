import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {


		ArrayList<UserAccount> userAccList = new ArrayList<UserAccount>();
		
		
		userAccList.add(new UserAccount("Ben","ben123", "Buyer", "ben@yahoo.com", "YH786nh"));
		userAccList.add(new UserAccount("Candy", "canndy","Seller" ,"candy@gmail.com", "dvD567i"));

		int option = 0;
		

		while (option != 4) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// add item
				UserAccount user = inputUser(); 
				C206_CaseStudy.addUser(userAccList, user);

			} else if (option == 2) {
				// view all item
				C206_CaseStudy.viewAllUser(userAccList);

			} else if (option == 3) {
				// delete an item
				C206_CaseStudy.deleteUser(userAccList);

			} else if (option == 4) {
				System.out.println("Bye!");

			} else {
				System.out.println("Invalid option");
			}
			
		}

	}
	

		
	public static void menu() {
		C206_CaseStudy.setHeader("CAMPUS ONLINE AUCTION SHOP");
		System.out.println("1. Add User");
		System.out.println("2. View All User");
		System.out.println("3. Delete User");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static UserAccount inputUser() {
		
		Helper.line(50, "-");
		System.out.println("Add User");
		Helper.line(50, "-");
		
		String newName = Helper.readString("Enter name > ");
		String newUsername = Helper.readString("Enter username > ");
		String newRole = Helper.readString("Enter role > ");
		String newEmail = Helper.readString("Enter email > ");
		String newPassword = Helper.readString("Enter password > ");
		
		UserAccount user = new UserAccount(newName, newUsername, newRole, newEmail, newPassword);
		
		return user;
	}
	
	
	public static void addUser(ArrayList<UserAccount> userAccList, UserAccount user) {
		
		boolean isSame = false;
		
		for (int i=0; i < userAccList.size(); i++) {
			if(userAccList.get(i).getUsername().equalsIgnoreCase(user.getUsername())) {
				isSame = true;
				System.out.println("Username already exist!");
			}
		}
			if (isSame == false) {
				userAccList.add(user);
				System.out.println("Username added!");
			}
	}

	//retrieve method
	public static String retrieveAllUser(ArrayList<UserAccount> userAccList) {
		
		String output = ""; 
		 
		for (int i = 0; i < userAccList.size(); i++) {

			output += String.format("%-15s %-15s %-15s %-15s %-15s\n", userAccList.get(i).getName(), userAccList.get(i).getUsername(), userAccList.get(i).getRole(), userAccList.get(i).getEmail(), userAccList.get(i).getPassword());
	}
	 return output; 
	}
	
	public static void viewAllUser(ArrayList<UserAccount> userAccList) {
		
		Helper.line(50, "-");
		System.out.println("View All User");
		Helper.line(50, "-");
		
		String output = String.format("%-15s %-15s %-15s %-15s %-15s\n", "NAME", "USER NAME", "ROLE", "EMAIL", "PASSWORD"); 
			
		output += retrieveAllUser(userAccList); 
			
		System.out.println(output);
		
	}

	

	public static void deleteUser(ArrayList<UserAccount> userAccList) {
		
		Helper.line(50, "-");
		System.out.println("Delete User");
		Helper.line(50, "-");
		
		String delUserEmail = Helper.readString("Enter email to delete user >");
		Boolean delUser = doDeleteUser(userAccList, delUserEmail);
		
		if (delUser == false) {
			System.out.println("Invalid category");
			
		} else {
			System.out.println(delUserEmail + " is removed");
		}
	}
		

	public static boolean doDeleteUser(ArrayList<UserAccount> userAccList, String delUserEmail) {
		
		boolean delUser = false;
		
		for (int i = 0; i< userAccList.size(); i++) {
			if (userAccList.get(i).getEmail().equalsIgnoreCase(delUserEmail)) {
				userAccList.remove(i);
				delUser = true;
			}
		}
		return delUser;
	}
	
	
}

