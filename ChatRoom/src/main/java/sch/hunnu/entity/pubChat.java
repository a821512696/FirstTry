package sch.hunnu.entity;

import java.io.Serializable;

public class pubChat implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String groupId;
	private String acc;
	private String nick;
	private String pic;
	private String content;
	private String time;
	
	 public pubChat() {
	}

	@Override
	public String toString() {
		return "pubChat [groupId=" + groupId + ", acc=" + acc + ", nick=" + nick + ", pic=" + pic + ", content="
				+ content + ", time=" + time + "]";
	}

	public pubChat(String groupId, String acc, String nick, String pic, String content, String time) {
		super();
		this.groupId = groupId;
		this.acc = acc;
		this.nick = nick;
		this.pic = pic;
		this.content = content;
		this.time = time;
	}

	public String getGroupId() {
		return groupId;
	}

	public String getAcc() {
		return acc;
	}

	public String getNick() {
		return nick;
	}

	public String getPic() {
		return pic;
	}

	public String getContent() {
		return content;
	}

	public String getTime() {
		return time;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	 
}
