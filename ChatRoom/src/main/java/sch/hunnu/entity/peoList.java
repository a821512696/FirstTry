package sch.hunnu.entity;

import java.io.Serializable;

//用来保存聊天列表的账号
public class peoList  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String acc;

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}
	
}
