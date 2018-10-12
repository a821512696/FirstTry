package sch.hunnu.entity;

public class user {

	private int id;
	private String name;
	private String sex;
	private String phone;
	
	
	public user() {
	}


	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + "]";
	}


	public user(int id, String name, String sex, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
