import java.util.ArrayList;

public class ItemsMain {

	public static void main(String[] args) {
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		itemList.add(new Item("Table Lamp", "Table Lamp for study table",6.00,"3/5/2022","13/5/2022",1.00));
		
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
				ItemsMain.viewAllItems(itemList);
			}else if (option == 3) {
				//delete items
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
		System.out.println("2. View the items based on name");
		System.out.println("3. Delete item");
		System.out.println("3. Quit");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
	
	public static Item inputItem() {
		String name = Helper.readString("Enter your name > ");
		String description = Helper.readString("Enter description > ");
		double minBidPrice = Helper.readDouble("Enter minimum bid price > ");
		String auctionStart = Helper.readString("Enter your auction start date > ");
		String auctionEnd = Helper.readString("Enter your auction end date > ");
		double bidIncrement = Helper.readDouble("Enter Bid Increment > ");

		Item i = new Item(name, description, minBidPrice,auctionStart,auctionEnd,bidIncrement);
		return i;
		
	}

	public static void addItem(ArrayList<Item> itemList,Item i) {
		itemList.add(i);
		System.out.println("Item added");
		
		
		
	}
	public static String retrieveAllItems(ArrayList<Item> itemList) {
		String output = "";

		for (int i = 0; i < itemList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-10s %-20d\n", itemList.get(i).getName(),
					itemList.get(i).getDescription(), 
					itemList.get(i).getMinPrice(), 
					itemList.get(i).getStartDate(), 
					itemList.get(i).getEndDate(), 
					itemList.get(i).getBidIncrement());
		}
		return output;
	}
	public static void viewAllItems(ArrayList<Item> itemList) {
		ItemsMain.setHeader("ITEMS LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-10s %-20s\n", "NAME", "DESCRIPTION",
				"MINIMUM PRICE", "AUCTION START DATE","AUCTION END DATE", "BID INCREMENT");
		 output += retrieveAllItems(itemList);	
		System.out.println(output);
		
	}
	
	public static void deleteItem(ArrayList<Item> itemList) {
		String name = Helper.readString("Enter name to delete > ");
		
		boolean isDeleted = false;
		for (int i = 0; i < itemList.size(); i++) {
			if (name == itemList.get(i).getName()) {
				itemList.remove(i);
				isDeleted = true;
				System.out.println("Item deleted");
				
			}
		}
		if (isDeleted == false) {
			System.out.println("no item deleted");
		}
	}
}
