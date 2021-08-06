/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * saman, 5 Aug 2021 6:26:52 pm
 */


public class Item {

	private String name;
	private String description;
	private double minPrice;
	private String startDate;
	private String endDate;
	private double bidIncrement;
	
	public Item (String name, String description, double minPrice, String startDate, String endDate,double bidIncrement) {
		this.name = name;
		this.description = description;
		this.minPrice = minPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bidIncrement = bidIncrement;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public double getBidIncrement() {
		return bidIncrement;
	}
	
public String toString() {
		
		// Write your codes here
		String itemInfo = String.format("%-20s %-30s %-10.2f %-20s %-20s %-20.2f\n", name, description, minPrice, startDate, endDate, bidIncrement);
		
		return itemInfo;
	}

}
