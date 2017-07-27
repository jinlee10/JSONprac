package com.tacademy.json.vo;

import java.util.Arrays;

public class Student {
	
//private
	private String name;
	private String hakbun;
	private int age;
	private boolean gender;
	private String[] hobby;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", hakbun=" + hakbun + ", age=" + age + ", gender=" + gender + ", hobby="
				+ Arrays.toString(hobby) + "]";
	}
	
	
	
	
}
