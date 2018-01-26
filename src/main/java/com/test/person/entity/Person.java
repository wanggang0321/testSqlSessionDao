package com.test.person.entity;

public class Person {

	//姓名
	private String name;
	//身份证号
	private String idCardNumber;
	//性别
	private String sex;
	//年龄
	private int age;
	//地址
	private String address;
	//手机号
	private String cellphone;
	//归属地
	private String phonePlace;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCardNumber() {
		return idCardNumber;
	}
	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getPhonePlace() {
		return phonePlace;
	}
	public void setPhonePlace(String phonePlace) {
		this.phonePlace = phonePlace;
	}
	
}
