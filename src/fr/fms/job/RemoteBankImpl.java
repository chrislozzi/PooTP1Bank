/**
 * 
 */
package fr.fms.job;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.fms.entities.Account;
import fr.fms.entities.Accounts;
import fr.fms.entities.CurrentAccount;
import fr.fms.entities.Operations;
import fr.fms.entities.Transaction;
import fr.fms.entities.Transfert;
import fr.fms.entities.Users;

/**
 * @author Stagiaires09
 *
 */
public class RemoteBankImpl  implements IRemoteBank{	
	
	
	private Map<Long, Accounts> accounts;
	private Map<Long, Users> users;

	private long numOperation;
	
	public RemoteBankImpl() {
		accounts =new HashMap<>();
		users =new HashMap<>();
		numOperation = 1;
	}
	
	
	@Override
	public Accounts consultAccount(long accountId) {
		Accounts account = accounts.get(accountId);
		if(account == null)	System.out.println("Vous demandez un compte inexistant !");
		return account;
	}
	@Override
	public void addAccount(Accounts account) {

		if(accounts.containsValue(account))	
			System.out.println("Le compte : " + account.toString() + "est déjà enregistré dans la base");
		else {
			addOperation(newOperationId(), new Operations(account.getIdUser(),new Date(),"addAccount", admin.getIdUser()));
			accounts.put(account.getIdAccount(), account);
		}

	}
	
	


	@Override
	public boolean withdraw(long idAccount, double amount) { 
		if(accounts.containsKey(idAccount) && amount > 0) {	
			if(getAccountById(idAccount) instanceof CurrentAccount) {	
				if( 0 <= (getAccountById(idAccount).getAmount() - amount + ((CurrentAccount) getAccountById(idAccount)).getOverdraft())) {
					getAccountById(idAccount).setAmount(getAccountById(idAccount).getAmount() - amount);
					
					addOperation(newOperationId(), new Operations(idAccount, amount, idUser, new Date(), "withdraw"));
					return true;
				}		
			}		
		}
		return false;
	}

	@Override
	public void transfert(long idAccount1, long idAccount2, double amount) {

		if(accounts.containsKey(idAccountSource) && amount > 0) {
			if(getAccountById(idAccountSource) instanceof CurrentAccount) {
				if( 0 <= (getAccountById(idAccountSource).getAmount() - amount + ((CurrentAccount) getAccountById(idAccountSource)).getOverdraft())) {
					getAccountById(idAccountSource).setAmount(getAccountById(idAccountSource).getAmount() - amount);
					getAccountById(idAccountTarget).setAmount(getAccountById(idAccountTarget).getAmount() + amount);
					
					addOperation(newOperationId(), new Operations(idAccountSource, idAccountTarget, idUser, amount, new Date(), "transfert"));
					

			}else if(0 <= (getAccountById(idAccountSource).getAmount() - amount)) {
				getAccountById(idAccountSource).setAmount(getAccountById(idAccountSource).getAmount() - amount);
				getAccountById(idAccountTarget).setAmount(getAccountById(idAccountTarget).getAmount() + amount);
				
				addOperation(newOperationId(), new Operations(idAccount1, idAccount2, amount, new Date(), "transfert"));
				
			}

		}
		
	}
		}

	@Override
	public void showBalance(int idUser, int idAccount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit(long idAccount, double amount) {
		
		
	}
	public void pay(long accountId, double amount) {				// versement
		Accounts account = consultAccount(accountId);
		if(account != null)	{
			account.setBalance(account.getBalance() + amount);
			Operations trans = new Transfert(numTransactions++,new Date(),amount,accountId);
			account.getListTransactions().add(trans);				// création + ajout d'une opération de versement
		}
	}
	
	@Override
	public ArrayList<Operations> listOperations(long accountId) {
		return consultAccount(accountId).getAccountdOperations();
		
	}



}
