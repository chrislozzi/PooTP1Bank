package fr.fms.entities;

import java.util.Date;

public class CurrentAccount <T> extends Accounts<T>{

	private int overdraft;
	
	public CurrentAccount(int id_account, int id_user, String name, Date date, double amount, Boolean type,int overdraft) {
		super(id_account, id_user, name, date, amount, type);
		
		setOverdraft( overdraft);
	}

	public int getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(int overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public String toString() {
		return "SavingsAccount [overdraft=" + overdraft + "]";
	}

}
