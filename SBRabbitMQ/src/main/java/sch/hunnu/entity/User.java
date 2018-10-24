package sch.hunnu.entity;

import java.io.Serializable;

/**
 * SpringBoot 可以直接支持 用rabbitmq来传对象，前提是这个对象要实现序列化接口。
 * @author Hi
 *
 */
public class User implements Serializable{

	private String name;
	private String sex;
	private int age;
	
	public User(String name, String sex, int age) {
	
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}

	public User() {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	 
	
	
	 
	 
}
