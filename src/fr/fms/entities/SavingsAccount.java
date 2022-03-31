package fr.fms.entities;

import java.util.Date;

public class SavingsAccount<T> extends Accounts<T>{

	private int interest_rate;
	
	public SavingsAccount(int id_account, int id_user, String name, Date date, double amount, Boolean type,int interest_rate) {
		super(id_account, id_user, name, date, amount, type);
		setInterest_rate(interest_rate);
	}

	public int getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(int interest_rate) {
		this.interest_rate = interest_rate;
	}
	@Override
	public String toString() {
		return "CurrentAccount [interest_rate=" + interest_rate + "]";
	}

}
