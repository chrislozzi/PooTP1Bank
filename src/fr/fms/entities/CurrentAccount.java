package fr.fms.entities;

import java.util.Date;

public class CurrentAccount  extends Accounts{

	private int overdraft;
	
	public CurrentAccount(int idUser, String name, Date date, double amount, int overdraft) {
		super(idUser, name, date, amount);
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
		return "CurrentAccount " + super.toString() + " overdraft= " + overdraft + "]";
	}

}
