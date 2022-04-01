package fr.fms.entities;

import java.util.Date;

public class CurrentAccount  extends Accounts{

	private int overdraft;
	
	public CurrentAccount(int idAccount, int idUser, String name, Date date, double amount, int overdraft) {
		super(idAccount, idUser, name, date, amount);
		
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
		return "SavingsAccount " + super.toString() + " overdraft= " + overdraft + "]";
	}

}
