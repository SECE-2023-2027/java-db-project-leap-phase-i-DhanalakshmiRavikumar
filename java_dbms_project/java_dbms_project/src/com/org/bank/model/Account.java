package com.org.bank.model;

public class Account {
 private int account_id;
 private String accountholder;
 private String accountType;
 private double balance;
 private String address;
 private String contactNumber;
public int getAccount_id() {
	return account_id;
}
public Account(int account_id, String accountholder, String accountType, double balance, String address,
		String contactNumber) {
	this.account_id = account_id;
	this.accountholder = accountholder;
	this.accountType = accountType;
	this.balance = balance;
	this.address = address;
	this.contactNumber = contactNumber;
}
@Override
public String toString() {
	return "Account [account_id=" + account_id + ", accountholder=" + accountholder + ", accountType=" + accountType
			+ ", balance=" + balance + ", address=" + address + ", contactNumber=" + contactNumber + "]";
}
public void setAccount_id(int account_id) {
	this.account_id = account_id;
}
public String getAccountholder() {
	return accountholder;
}
public void setAccountholder(String accountholder) {
	this.accountholder = accountholder;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}
}