package fr.fms.entities;

import java.util.Date;

public class SavingsAccount extends Accounts{

	private int interestRate = 2;
	
	public SavingsAccount(int idUser, String name, Date date, double amount,int interestRate) {
		super( idUser, name, date, amount);
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
		return "Saving Account " + super.toString() + " " + "interestRate= " + interestRate + "]";
	}

}
