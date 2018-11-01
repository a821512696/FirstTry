package sch.hunnu.entity;

import java.io.Serializable;

//映射user表
public class user implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String acc;
	private String pw;
	private String nick;
	private String pic;
	private String time;
	
	public user() {
	}
	
	public user(String acc, String pw, String nick, String pic, String time) {
		super();
		this.acc = acc;
		this.pw = pw;
		this.nick = nick;
		this.pic = pic;
		this.time = time;
	}
	@Override
	public String toString() {
		return "user [acc=" + acc + ", pw=" + pw + ", nick=" + nick + ", pic=" + pic + ", time=" + time + "]";
	}
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
}
