package core_java.chap_04;

import java.util.Objects;

public class Item {

	private String description;
	private double price;

	public Item(String desc, double price) {
		this.description = desc;
		this.price = price;
	}

	@Override
	public boolean equals(Object otherObj) {
//		System.out.println("this: " + getClass());
//		System.out.println("other: " + otherObj.getClass());
		// return true if objects are identical
		if (this == otherObj)
			return true;

		if (otherObj == null)
			return false;
		
		// return false if otherObj is not Item
		if (getClass() != otherObj.getClass())
			return false;

		// return true if instances variables have identical values
		Item other = (Item) otherObj;
		if (Objects.equals(description, other.description) && Objects.equals(price, other.price)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, price);
	}

}
