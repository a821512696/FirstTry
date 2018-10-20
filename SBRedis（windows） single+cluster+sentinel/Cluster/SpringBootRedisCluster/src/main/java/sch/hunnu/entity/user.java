package sch.hunnu.entity;

public class user {
	
	private String name;
	private int age;
	private String sex;
	private String phone;
	
	public user() {
	}

	public user(String name, int age, String sex, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
