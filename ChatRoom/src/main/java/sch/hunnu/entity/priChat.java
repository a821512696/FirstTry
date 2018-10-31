package sch.hunnu.entity;

public class priChat {

	private String sender;
	private String content;
	private String senderNick;
	private String time;
	
	public priChat() {
	}

	@Override
	public String toString() {
		return "priChat [sender=" + sender + ", content=" + content + ", senderNick=" + senderNick + ", time=" + time
				+ "]";
	}

	public priChat(String sender, String content, String senderNick, String time) {
		super();
		this.sender = sender;
		this.content = content;
		this.senderNick = senderNick;
		this.time = time;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSenderNick() {
		return senderNick;
	}

	public void setSenderNick(String senderNick) {
		this.senderNick = senderNick;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	
}
