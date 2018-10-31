package sch.hunnu.entity;

public class priSend {

	private String sender;
	private String receiver;
	private String senderNick;
	private String content;
	private String time;
	
	public priSend() {
	}

	@Override
	public String toString() {
		return "priSend [sender=" + sender + ", receiver=" + receiver + ", senderNick=" + senderNick + ", content="
				+ content + ", time=" + time + "]";
	}
	
	public priSend(String sender, String receiver, String senderNick, String content, String time) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.senderNick = senderNick;
		this.content = content;
		this.time = time;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSenderNick() {
		return senderNick;
	}

	public void setSenderNick(String senderNick) {
		this.senderNick = senderNick;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
}
