package core_java.chap_04;

public class DiscountedItem extends Item {

	private double discount;
	
	public DiscountedItem(String desc, double price, double discount) {
		super(desc, price);
		this.discount = discount;
	}
	
	@Override
	public boolean equals(Object otherObj) {
		
		if (!super.equals(otherObj)) 
			return false;
		DiscountedItem other = (DiscountedItem) otherObj;
		return discount == other.discount;
	}

}
