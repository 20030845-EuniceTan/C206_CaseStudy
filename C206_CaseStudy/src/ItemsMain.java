import java.util.ArrayList;

public class ItemsMain {

	public static void main(String[] args) {
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		itemList.add(new Item("Table Lamp", "For study table",6.00,"3/5/2022","13/5/2022",1.00));
		itemList.add(new Item("Books","Programming books",10.00,"3/5/2022","13/5/2022",2.00));
		
		int option = 0;
		
		while (option != 4) {
			menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				//Add items
				Item i = inputItem();
				ItemsMain.addItem(itemList, i);
			} else if (option == 2) {
				//view items based on name
//				retrieveAllItems(itemList);
				ItemsMain.viewAllItems(itemList);
			}else if (option == 3) {
				//delete items
//				deleteItem(itemList);
				ItemsMain.deleteItem(itemList);
			} else if (option == 4) {
				System.out.println("Thank you and Bye!");
			}
			else {
				System.out.println("Invalid option");
			}
		}

	}
	
	public static void menu() {
		ItemsMain.setHeader("Campus Online Auction Shop ");
		System.out.println("1. add the item");
		System.out.println("2. View the items");
		System.out.println("3. Delete item based on name");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	 	
	public static Item inputItem() {
		String ItemName = Helper.readString("Enter item name > ");
		String description = Helper.readString("Enter description > ");
		double minBidPrice = Helper.readDouble("Enter minimum bid price > ");
		String auctionStart = Helper.readString("Enter your auction start date > ");
		String auctionEnd = Helper.readString("Enter your auction end date > ");
		double bidIncrement = Helper.readDouble("Enter Bid Increment > ");

		Item it = new Item(ItemName, description, minBidPrice,auctionStart,auctionEnd,bidIncrement);
		
		return it;
		
	}

	public static void addItem(ArrayList<Item> itemList,Item it) {
		boolean isSame = false;
		
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getName().equalsIgnoreCase(it.getName())) {
				isSame = true;
				System.out.println("Item is already exists.");
			}
		}
		if (isSame == false) {
			itemList.add(it);
			System.out.println("Item added");
		}
		
	}
	public static String retrieveAllItems(ArrayList<Item> itemList) {
		String output = "";

		for (int i = 0; i < itemList.size(); i++) {

			output += String.format("%s", itemList.get(i).toString());
		}
		return output;
	}
	public static void viewAllItems(ArrayList<Item> itemList) {
		
		ItemsMain.setHeader("VIEW ITEMS");
		
		String output = String.format("%-20s %-30s %-10s %-20s %-20s %-20s\n", "NAME", "DESCRIPTION", "MINIMUM PRICE", "AUCTION START DATE", "AUCTION END DATE", "BID INCREMENT");
		output += retrieveAllItems(itemList);
		System.out.println(output);
	
	}
	
	public static void deleteItem(ArrayList<Item> itemList) {
		ItemsMain.setHeader("DELETE ITEM");
		
		String RemoveName = Helper.readString("Enter name to delete > ");
		
		boolean isDeleted = doDeleteItem(itemList, RemoveName);
		
		if (isDeleted == false) {
			System.out.println("Item not deleted");
			
		}else {
			System.out.println(RemoveName + " deleted");
		}
		
	}
	public static boolean doDeleteItem(ArrayList<Item> itemList,String RemoveName) {
		boolean isDeleted = false;
		
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getName().equalsIgnoreCase(RemoveName)) {
				itemList.remove(i);
				isDeleted = true;
			}
		}
	
		return isDeleted;
	}
}
