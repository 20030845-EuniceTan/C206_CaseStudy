/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Sajini Sangale
 * Student ID: 20022543
 * Class: E37C
 * Date/Time created: Saturday 31-07-2021 17:48
 */

public class Bid extends C206_CaseStudy{
	private int bidID;
	private String itemName;
	private String sellerEmail;
	private String buyerEmail;
	private double bidPrice;
	
	public Bid(int bidID, String itemName, String sellerEmail, String buyerEmail, double bidPrice) {
		super();
		this.bidID = bidID;
		this.itemName = itemName;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.bidPrice = bidPrice;
	}

	public int getBidID() {
		return bidID;
	}


	public String getItemName() {
		return itemName;
	}


	public String getSellerEmail() {
		return sellerEmail;
	}


	public String getBuyerEmail() {
		return buyerEmail;
	}


	public double getBidPrice() {
		return bidPrice;
	}
	
	public String toString() {
		
		// Write your codes here
		return String.format("%-15s %-35s %-15s %-15s", getBidID(),
				getItemName(),getSellerEmail(),getBuyerEmail(),getBidPrice());

	}
	
	

}
