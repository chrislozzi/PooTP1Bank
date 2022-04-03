package fr.fms.entities;

import java.util.Date;

public class Operations {
	
	
	private int idAccountSource ;
	private int idAccountTarget ;
	private double amount;
	private int idUser ;
	private int idAdmin = 0;
	private Date date  ;
	private String type ;
	
	/**
	 * 
	 * @param idAccountSource
	 * @param idAccountTarget
	 * @param idUser
	 * @param amount
	 * @param date
	 * @param type
	 */
	public Operations(int idAccountSource, int idAccountTarget,int idUser, double amount, Date date, String type) {			
				
		setIdAccountSource(idAccountSource);		
		setIdAccountTarget(idAccountTarget);		
		setIdUser(idUser);		
		setAmount(amount);
		setDate(new Date());	
		setType(type);
	}
	
	

	/**
	 * @param idAccountSource
	 * @param amount
	 * @param idUser
	 * @param date
	 * @param type
	 */
	public Operations(int idAccountSource, double amount, int idUser, Date date, String type) {
		setIdAccountSource(idAccountSource);				
		setIdUser(idUser);		
		setAmount(amount);
		setDate(new Date());	
		setType(type);
	}



	/**
	 * @param idAccountSource
	 * @param idUser
	 * @param date
	 * @param type
	 */
	public Operations(int idAccountSource, int idUser, Date date, String type) {
		setIdAccountSource(idAccountSource);				
		setIdUser(idUser);				
		setDate(new Date());	
		setType(type);
	}
	


	/**
	 * 
	 * @param idUser
	 * @param date
	 * @param type
	 * @param idAdmin
	 */
	public Operations(int idUser, Date date, String type ,int idAdmin) {					
		setIdUser(idUser);		
		setIdAdmin(idAdmin);
		setDate(new Date());	
		setType(type);
	}



	/**
	 * @return the idAdmin
	 */
	public int getIdAdmin() {
		return idAdmin;
	}



	/**
	 * @param idAdmin the idAdmin to set
	 */
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}



	/**
	 * @return the idAccountSource
	 */
	public int getIdAccountSource() {
		return idAccountSource;
	}
	/**
	 * @param idAccountSource the idAccountSource to set
	 */
	public void setIdAccountSource(int idAccountSource) {
		this.idAccountSource = idAccountSource;
	}
	/**
	 * @return the idAccountTarget
	 */
	public int getIdAccountTarget() {
		return idAccountTarget;
	}
	/**
	 * @param idAccountTarget the idAccountTarget to set
	 */
	public void setIdAccountTarget(int idAccountTarget) {
		this.idAccountTarget = idAccountTarget;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
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
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	public static void showOperation() {
		
	}


	@Override
	public String toString() {
		return "Operations [type=" + type +  ", idAccountSource=" + idAccountSource + ", idAccountTarget=" + idAccountTarget + ", amount="
				+ amount + ", idUser=" + idUser + ", idAdmin=" + idAdmin + ", date=" + date +"]";
	}



	
}
