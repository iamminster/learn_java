package core_java.chap_02;

import java.util.ArrayList;

public class Invoice {

	private ArrayList<Item> items = new ArrayList<>();

	public Invoice() {
		// TODO Auto-generated constructor stub
	}

	public static class Item {
		private String description;
		private int quantity;
		private double price;

		public Item(String description, int quantity, double unitPrice) {
			this.description = description;
			this.quantity = quantity;
			this.price = unitPrice;
		}

		public double price() {
			return price * quantity;
		}
	}

	public void addItem(String description, int quantity, double unitPrice) {
		Item newItem = new Item(description, quantity, unitPrice);
		System.out.println(newItem.price());
	}
	
	public void add(Item item) {
		items.add(item);
	}

}
