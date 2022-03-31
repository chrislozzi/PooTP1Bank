package fr.fms.entities;

import java.util.Date;

public abstract class Operations<V> {
	
	private int id_operation ;
	private int id_account ;
	private int id_user ;
	private Date date  ;
	private String type ;
	
	public Operations(int id_operation, int id_account, int id_user, Date date, String type) {
		super();
		this.id_operation = id_operation;
		this.id_account = id_account;
		this.id_user = id_user;
		this.date = date;
		this.type = type;
	}

	public int getId_operation() {
		return id_operation;
	}

	public void setId_operation(int id_operation) {
		this.id_operation = id_operation;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Operations [id_operation=" + id_operation + ", id_account=" + id_account + ", id_user=" + id_user
				+ ", date=" + date + ", type=" + type + "]";
	}

	
}
