package fr.fms.entities;

import java.util.Date;

public class SavingsAccount extends Accounts{

	private int interestRate;


	public SavingsAccount(long idAccount, Date date, double amount, Users user) {
		super(idAccount, date, amount, user);
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
