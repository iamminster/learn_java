package core_java.chap_04;

import java.util.ArrayList;
import java.util.Objects;

public final class Message implements Cloneable {

	private String sender;
	private ArrayList<String> recipients;
	private String[] recipientArr;
	private String text;

	public Message(String sender, String text) {
		this.sender = sender;
		this.text = text;
		recipients = new ArrayList<>();
		recipientArr = new String[0];
	}

	public void addRecipients(String recipient) {
		if (Objects.isNull(recipients)) {
			recipients = new ArrayList<>();
		}
		recipients.add(recipient);
	}

	@Override
	public Message clone() {
		try {
//		Message cloned = new Message(sender, text);
//		cloned.recipients = new ArrayList<>(recipients);
//		cloned.recipientArr = recipientArr.clone();
			Message cloned = (Message) super.clone();
			@SuppressWarnings("unchecked")
			ArrayList<String> clonedRecipients = (ArrayList<String>) recipients.clone();
			cloned.recipients = clonedRecipients;
			cloned.recipientArr = recipientArr.clone();
			return cloned;
		} catch (CloneNotSupportedException ex) {
			return null;
		}
	}

}
