package fr.fms.entities;

import java.util.Date;

public class SavingsAccount extends Accounts{

	private int interestRate;
	
	public SavingsAccount(int idAccount, int idUser, String name, Date date, double amount,int interestRate) {
		super(idAccount, idUser, name, date, amount);
		setInterestRate(interestRate);
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
	@Override
	public String toString() {
		return super.toString() + " " + "interestRate= " + interestRate + "]";
	}

}
