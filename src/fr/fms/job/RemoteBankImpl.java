/**
 * 
 */
package fr.fms.job;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.fms.entities.Accounts;
import fr.fms.entities.Operations;
import fr.fms.entities.Users;

/**
 * @author Stagiaires09
 *
 */
public class RemoteBankImpl  implements IRemoteBank{
	private Map<Integer, Accounts> accounts;
	private Map<Integer, Users> users;
	private Map<Integer, Operations> operations;

	public RemoteBankImpl() {
		accounts =new HashMap<>();
		users =new HashMap<>();
		operations =new HashMap<>();
	}
	public int newOperationId() {
		return operations.size() + 1;
		
	}
	public int newUserId() {
		return users.size() + 1;
		
	}
	public int newAccountId() {
		return accounts.size() + 1;
		
	}
	@Override
	public void addUser(int idAdmin, Users user) {
		
		if(users.containsValue(users))	
			System.out.println("L'utilisateur : " + users.toString() + "est d�j� enregistr� dans la base");
		else users.put(idAdmin, user);
			
	}
	@Override
	public void removeUser(int idUser) {
		// TODO Auto-generated method stub

	}
	@Override
	public Users getUserById(int idUser) {
		
		return users.get(idUser);
	}
	@Override
	public void addAccount(int idAccount, Accounts account) {
	
		accounts.put(idAccount, account);
	}
	@Override
	public void removeAccount(int idAccount) {
		// TODO Auto-generated method stub

	}
	@Override
	public Accounts getAccountById(int idAccount) {
		// TODO Auto-generated method stub
		return accounts.get(idAccount);
	}
	@Override
	public void addOperation(int idOperation, Operations operation) {
		
		operations.put(idOperation,operation);
	}
	@Override
	public Operations getOperationById(int idOperation) {
		// TODO Auto-generated method stub
		return operations.get(idOperation);
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
			Accounts getAccount = accounts.get(idAccount);
			getAccount.setAmount(getAccount.getAmount() + amount);
			return true;	
		} else {
			return false;
		}
	}

	@Override
	public boolean showBalance(int idUser, int idAccount) { 
		if(accounts.containsKey(idAccount) &&  accounts.get(idAccount).getIdUser() == idUser) {
			//voir la m�thode toString � compl�ter ??
			//toString();
			System.out.println("Num�ro de compte " + idAccount + " : montant -> " + accounts.get(idAccount).getAmount());
			return true;
		} else {
			System.out.println("Aucun compte associ�.");
			return false;
		}
	}

	@Override
	public boolean withdraw(int idAccount, int idUser, double amount) { //attention au d�couvert autoris�

		if(accounts.containsKey(idAccount) && amount > 0) {
			Accounts getAccount = accounts.get(idAccount);
			if(amount <= getAccount.getAmount()) {
				getAccount.setAmount(getAccount.getAmount() - amount);
				return true;
			}
		} 
		return false;
	}

	@Override
	public boolean transfert(int idUser, int idAccount1, int idAccount2, double amount) { //attention au d�couvert autoris�

		if(accounts.containsKey(idAccount1) && amount > 0) {
			Accounts getAccount1 = accounts.get(idAccount1);
			Accounts getAccount2 = accounts.get(idAccount2);

			if(amount <= getAccount1.getAmount()) {
				getAccount1.setAmount(getAccount1.getAmount() - amount);
				getAccount2.setAmount(getAccount2.getAmount() + amount);
				return true;
			}
		}
		return false;
	}



}
