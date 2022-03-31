package fr.fms.entities;

import java.util.Date;

public abstract class  Accounts<T>{
	
	private int id_account;
	private int id_user ;
	private String name ;
	private Date date ;
	private double amount;
	private Boolean type;
	
	
	public Accounts(int id_account, int id_user, String name, Date date, double amount, Boolean type) {
		super();
		this.id_account = id_account;
		this.id_user = id_user;
		this.name = name;
		this.date = date;
		this.amount = amount;
		this.type = type;
	}


	public int getId_account() {
		return id_account;
	}


	public void setId_account(int id_account) {
		this.id_account = id_account;
	}


	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Boolean getType() {
		return type;
	}


	public void setType(Boolean type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Accounts [id_account=" + id_account + ", id_user=" + id_user + ", name=" + name + ", date=" + date
				+ ", amount=" + amount + ", type=" + type + "]";
	}
	
	
	
	
}
