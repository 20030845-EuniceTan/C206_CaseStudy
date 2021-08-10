import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Bid> bidList = new ArrayList<Bid>();
					
		bidList.add(new Bid(123,"Antique","sally@gmail.com","bob@gmail.com",9.00));
		bidList.add(new Bid(223,"AntiqueShop","sallyTay@gmail.com","bobNg@gmail.com",11.00));
		
		int option = 0;

		while (option != 4) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// add item
				Bid bid = inputBids();
				C206_CaseStudy.addBids(bidList, bid);

			} else if (option == 2) {
				// view all item
				C206_CaseStudy.viewAllBids(bidList);

			} else if (option == 3) {
				// delete an item
				C206_CaseStudy.deleteBids(bidList);

			} else if (option == 4) {
				System.out.println("Bye!");

			} else {
				System.out.println("Invalid option");
			}

		}
	
}
	public static void menu() {
		C206_CaseStudy.setHeader("CAMPUS ONLINE AUCTION SHOP");
		System.out.println("1. Add Bid");
		System.out.println("2. View All Bid");
		System.out.println("3. Delete Bid");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	
	//Creating
	
	public static String retrieveAllBids(ArrayList<Bid> bidList) {
		String output = "";

		for (int i = 0; i < bidList.size(); i++) {

			output += String.format("%-80s\n", bidList.get(i).toString());
		}
		return output;
	}
	public static void viewAllBids(ArrayList<Bid> bidList) {
		Helper.line(50, "=");
		C206_CaseStudy.setHeader("VIEW ALL BIDS");
		Helper.line(50, "=");
		
		
		String output = String.format("%-7s %-15s %-20s %-15s %-25s\n", "ID", "ITEM NAME",
				"SELLER EMAIL", "BUYER EMAIL","BID PRICE");
		 output += retrieveAllBids(bidList);	
		System.out.println(output);
	}
	
	//Adding
	
	public static Bid inputBids() {
		Helper.line(50, "=");
		System.out.println("ADD BID");
		Helper.line(50, "=");

		int bidID = Helper.readInt("Enter bid ID: ");
		String iN = Helper.readString("Enter item name: ");
		String sE = Helper.readString("Enter seller email: ");
		
		if(!sE.contains(".") && !sE.contains("@")) {
			System.out.println("Invalid email");
		} 
		
		String bE = Helper.readString("Enter buyer email: ");
		
		if(!bE.contains(".") && !bE.contains("@")) {
			System.out.println("Invalid email");
		}
		
		
		double price = Helper.readDouble("Enter bid price: ");

		Bid bid = new Bid(bidID, iN, sE, bE, price);
		return bid;
		
	}
	
	public static void addBids(ArrayList<Bid> bidList, Bid bid) {
		boolean isSame = false; 
		
		for (int i = 0; i < bidList.size(); i++) {
			if (bidList.get(i).getBidID() == bid.getBidID()) { 
				isSame = true; 
				System.out.println("This bid already exists!"); 
			}
		}
		
		if (isSame == false) { 
			bidList.add(bid);
			System.out.println("New Bid Added");
		}
	}
	
	
	
	//Delete
	
	public static boolean doDeleteBids(ArrayList<Bid> bidList, int removeID) {
		Helper.line(50, "=");
		C206_CaseStudy.setHeader("DELETE BID");
		Helper.line(50, "=");
		
		boolean isDelete = false;
		
		
		for(int i = 0; i < bidList.size(); i++) {
			if(bidList.get(i).getBidID() == removeID) {
				bidList.remove(i);
				isDelete = true;
				
			} 
			
		}
		return isDelete;

		
	}
	
	public static void deleteBids(ArrayList<Bid> bidList) {
		int removeID = Helper.readInt("Enter bid ID to delete: ");
		Boolean isDelete = doDeleteBids(bidList, removeID);
		
		if(isDelete == false) {
			System.out.println("Invalid bid ID");
		} else {
			System.out.println("Bid deleted!");
		}
		
	}
	
	
}
	
