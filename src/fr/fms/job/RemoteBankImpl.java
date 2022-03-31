/**
 * 
 */
package fr.fms.job;

import java.util.Map;

import fr.fms.entities.Accounts;
import fr.fms.entities.Operations;
import fr.fms.entities.Users;

/**
 * @author Stagiaires09
 *
 */
public class RemoteBankImpl <T,U,V> implements IRemoteBank<T,U,V>{
	private Map<Integer, Accounts<T>> accounts;
	private Map<Integer, Users<U>> users;
	private Map<Integer, Operations <V>> operations;
	@Override
	public void addUser(int idUser, Users<U> user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeUser(int idUser) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Users<U> getUserById(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addAccount(int idAccount, Accounts<T> account) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeAccount(int idAccount) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Accounts<T> getAccountById(int idAccount) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addOperation(int idOperation, Operations<V> operation) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Operations<V> getOperationById(int idOperation) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void getAllUserOperation() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getAllUserAccount() {
		// TODO Auto-generated method stub
		
	} 
	
	@Override
	public boolean deposit(int idAccount, int idUser, double amount) {
		if(amount > 0 && users.containsKey(idUser)) {
			Accounts<T> getAccount = accounts.get(idAccount);
			getAccount.setAmount(getAccount.getAmount() + amount);
			return true;	
		} else {
			return false;
		}
	}
	
	@Override
	public boolean showBalance(int idUser, int idAccount) { 
		if(accounts.containsKey(idAccount) &&  accounts.get(idAccount).getId_user() == idUser) {
			//voir la méthode toString à compléter ??
			//toString();
			System.out.println("Numéro de compte " + idAccount + " : montant -> " + accounts.get(idAccount).getAmount());
			return true;
		} else {
			System.out.println("Aucun compte associé.");
			return false;
		}
	}
	
	@Override
	public boolean withdraw(int idAccount, int idUser, double amount) { //attention au découvert autorisé
		
		if(accounts.containsKey(idAccount) && amount > 0) {
			Accounts<T> getAccount = accounts.get(idAccount);
			if(amount <= getAccount.getAmount()) {
				getAccount.setAmount(getAccount.getAmount() - amount);
				return true;
			}
		} 
		return false;
	}
	
	@Override
	public boolean transfert(int idUser, int idAccount1, int idAccount2, double amount) { //attention au découvert autorisé
		
		if(accounts.containsKey(idAccount1) && amount > 0) {
			Accounts<T> getAccount1 = accounts.get(idAccount1);
			Accounts<T> getAccount2 = accounts.get(idAccount2);
			
			if(amount <= getAccount1.getAmount()) {
				getAccount1.setAmount(getAccount1.getAmount() - amount);
				getAccount2.setAmount(getAccount2.getAmount() + amount);
				return true;
			}
		}
		return false;
	}
	
}
