package com.cqjtu.vo;

public class User {
	private String userName;
	private String passWord;
	private String userPhone;
	private String userAddress;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public User() {
	}

	public User(String name, String word) {
		userName = name;
		passWord = word;
	}
	public User(String name, String word, String phone) {
		userName = name;
		passWord = word;
		userPhone = phone;
	}

	public User(String name, String word, String phone, String address) {
		userName = name;
		passWord = word;
		userPhone = phone;
		userAddress = address;
	}
}
