package fr.fms.entities;

import java.util.Date;

public abstract class Operations {

	private long transactionId;
	private long idAccountSource ;
	private long idAccountTarget ;
	private double amount;
	private Date date  ;


	/**
	 * 
	 * @param transactionId
	 * @param idAccountSource
	 * @param idAccountTarget
	 * @param amount
	 * @param date
	 */
	public Operations(long transactionId,long  idAccountSource, long idAccountTarget, double amount, Date date) {			

		setTransactionId(transactionId);
		setIdAccountSource(idAccountSource);
		setIdAccountTarget(idAccountTarget);
		setAmount(amount);
		setDate(date);
	}


	

	public long getIdAccountSource() {
		return idAccountSource;
	}


	public void setIdAccountSource(long idAccountSource) {
		this.idAccountSource = idAccountSource;
	}


	public long getIdAccountTarget() {
		return idAccountTarget;
	}


	public void setIdAccountTarget(long idAccountTarget) {
		this.idAccountTarget = idAccountTarget;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	/**
	 * @return the transactionId
	 */
	public long getTransactionId() {
		return transactionId;
	}


	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public String toString() {
		return "Operations [transactionId=" + transactionId + ", idAccountSource=" + idAccountSource
				+ ", idAccountTarget=" + idAccountTarget + ", amount=" + amount + ", date=" + date 
				+ "]";
	}

}
