package com.cqjtu.vo;

public class Fixer {
	private String fixerName;
	private String passWord;
	private String fixerPhone;
	private String identification;
	private String fixerAddress;

	public String getFixerName() {
		return fixerName;
	}

	public void setFixerName(String fixerName) {
		this.fixerName = fixerName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFixerPhone() {
		return fixerPhone;
	}

	public void setFixerPhone(String fixerPhone) {
		this.fixerPhone = fixerPhone;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getFixerAddress() {
		return fixerAddress;
	}

	public void setFixerAddress(String fixerAddress) {
		this.fixerAddress = fixerAddress;
	}

	public Fixer() {
	}

	public Fixer(String name, String word, String phone) {
		fixerName = name;
		passWord = word;
		fixerPhone = phone;
	}

	public Fixer(String name, String word, String phone, String id,
			String address) {
		fixerName = name;
		passWord = word;
		fixerPhone = phone;
		identification = id;
		fixerAddress = address;
	}
}
