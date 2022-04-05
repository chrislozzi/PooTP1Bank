package fr.fms.entities;

import java.util.ArrayList;

import java.util.Date;

public abstract class  Accounts{
	
	private long idAccount;private int idUser ;
	private Date date;
	private double amount;
	private Users user;
	public  ArrayList <Operations>accountdOperations;
	
	/**
	 * 
	 * @param idAccount
	 * @param name
	 * @param date
	 * @param amount
	 * @param user
	 */
 Accounts(long idAccount, Date date, double amount,Users user) {
	setIdAccount(idAccount);
		setDate(new Date());	
		setAmount(amount);
		setUser(user);
		this.accountdOperations=new ArrayList <Operations>();
		
	}
 
	@Override
	public String toString() {
		return "Accounts [idAccount=" + idAccount + ", idUser=" + idUser + ", date=" + date + ", amount=" + amount
				+ ", user=" + user + ", accountdOperations=" + accountdOperations + "]";
	}

	public long getIdAccount() {
		return idAccount;
	}


	public void setIdAccount(long idAccount) {
		this.idAccount = idAccount;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public ArrayList<Operations> getAccountdOperations() {
		return accountdOperations;
	}

	public void setAccountdOperations(ArrayList<Operations> accountdOperations) {
		this.accountdOperations = accountdOperations;
	}



}
