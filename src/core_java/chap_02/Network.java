package core_java.chap_02;

import java.util.ArrayList;

public class Network {

	private ArrayList<Member> members = new ArrayList<>();
	
	public Network() {
		// TODO Auto-generated constructor stub
	}
	
	public class Member {
		private String name;
		private ArrayList<Member> friends;
		
		public Member(String name) {
			this.name = name;
			friends = new ArrayList<>();
			Network.this.enroll(this);
		}

		public void deactivate() {
			Network.this.unenroll(this);
		}
		
		public boolean belongsTo(Network network) {
			return Network.this == network && Network.this.members.contains(this);
		}
		
	}
	
	public Member enroll(String name) {
		Member newMember = new Member(name);
		members.add(newMember);
		return newMember;
	}
	
	public Member enroll(Member newMember) {
		members.add(newMember);
		return newMember;
	}
	
	public void unenroll(Member member) {
		members.remove(member);
	}
	
	public int size() {
		return members.size();
	}

}
