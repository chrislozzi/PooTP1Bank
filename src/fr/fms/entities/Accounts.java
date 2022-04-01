package fr.fms.entities;

import java.util.Date;

public abstract class  Accounts{
	

	private int idUser ;
	private String name ;
	private Date date ;
	private double amount;

	
	/**
	 * 
	 * @param idUser
	 * @param name
	 * @param date
	 * @param amount
	 */
	public Accounts(int idUser, String name, Date date, double amount) {
		setIdUser(idUser);		
		setName(name);		
		setDate(new Date());	
		setAmount(amount);		
		
	}


	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}





	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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




	@Override
	public String toString() {
		return "[id_user=" + idUser + ", name=" + name + ", date=" + date
				+ ", amount=" + amount + "]";
	}
	
	
	
	
}
