package fr.fms.entities;

import java.util.ArrayList;
import java.util.Date;

public class Users {
	private int idUser;
	private String name  ;
	private String firstName ;
	private  String address ;
	private  String mail; 
	private int phone; 
	private String pseudo; 
	private Date date;
	private ArrayList<Integer> userAccounts;

	public static int idUserCount = 0;
	//public ArrayList <Integer>userIdAccounts;
	
	public Users( String name, String firstName, String address, String mail, int phone, String pseudo) {	
		setIdUser(idUserCount);	
		setName(name);		
		setFirstName(firstName);		
		setAddress(address);		
		setMail(mail);		
		setPhone(phone);	
		setPseudo(pseudo);	
		
	}


	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
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
	 * @return the userAccounts
	 */
	public ArrayList<Integer> getUserAccounts() {
		return userAccounts;
	}


	/**
	 * @param userAccounts the userAccounts to set
	 */
	public void setUserAccounts(ArrayList<Integer> userAccounts) {
		this.userAccounts = userAccounts;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Override
	public String toString() {
		return " [idUser= " + idUser + ", name= " + name + ", firstName= " + firstName + ", address= " + address
				+ ", mail= " + mail + ", phone= " + phone + ", pseudo= " + pseudo + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
