package fr.fms.entities;

import java.util.Date;

public class CurrentAccount  extends Accounts{

	private int overdraft;
	
	
	public CurrentAccount(long idAccount, Date date, double amount, Users user) {
		super(idAccount, date, amount, user);
		setOverdraft(overdraft);
	}

	public int getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(int overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public String toString() {
		return "CurrentAccount " + super.toString() + " overdraft= " + overdraft + "]";
	}

}
