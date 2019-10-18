package core_java.chap_02;

import core_java.chap_02.Invoice.Item;
import core_java.chap_02.Network.Member;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Invoice invoice = new Invoice();
		Invoice.Item shampoo = new Item("shampoo", 1, 10.5d);
		System.out.println(shampoo.price());
		invoice.add(shampoo);
		
		Network myFace = new Network();
		Network myClover = new Network();
		Member minh = myFace.enroll("Minh");
		Member dung =  myClover.new Member("Dung");
		
		
		System.out.println(myFace.size());
		System.out.println(minh.belongsTo(myFace));
		minh.deactivate();
		System.out.println(myFace.size());
		System.out.println(dung.belongsTo(myFace));
		System.out.println(dung.belongsTo(myClover));
	}

}
