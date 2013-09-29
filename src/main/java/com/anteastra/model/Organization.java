package com.anteastra.model;

public class Organization {

	private String name;
	private Account account;
	private Warehouse warehouse;
	
	
	public Organization(String name, Account acc, Warehouse wh){
		this.name = name;
		this.account = acc;
		this.warehouse = wh;
	}
	
	public String getName(){
		return name;
	}
	
	public Account getAccount(){
		return account;
	}
	
	public Warehouse getWarehouse(){
		return warehouse;
	}	
}
