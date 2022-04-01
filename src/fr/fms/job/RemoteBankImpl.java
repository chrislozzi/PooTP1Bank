/**
 * 
 */
package fr.fms.job;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.fms.entities.Accounts;
import fr.fms.entities.Admin;
import fr.fms.entities.CurrentAccount;
import fr.fms.entities.Customer;
import fr.fms.entities.Operations;
import fr.fms.entities.SavingsAccount;
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
	

	public  Admin createCustomer(String name, String firstName, String address, String mail, int phone, String pseudo,int password,Map<Integer, Operations> operations) {
		Admin sarah=new Admin(name,firstName, address,  mail,  phone,  pseudo, password);
		return sarah;
	}
	
	@Override
	public CurrentAccount createCurrentAccount(int idUser, String name, Date date, double amount, int overdraft) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SavingsAccount createSavingAccount(int idUser, String name, Date date, double amount, int interestRate) {
		// TODO Auto-generated method stub
		return null;
	}
	public void addUser(Admin admin, Users user,Map<Integer, Users> users,Map<Integer, Operations> operations) {

		
		  if(users.containsKey(user.getIdUser())) System.out.println("L'utilisateur : "
		  + user.toString() + "est déjà enregistré dans la base"); else {
		  users.put(user.getIdUser(), user); addOperation(newOperationId(), new
		  Operations(users.size(), new Date(),"addUser", admin.getIdUser())); }
		 

	}
	@Override
	public void removeUser(Admin admin, int newUserId) {

		if (users.containsKey(newUserId)) {
			users.remove(newUserId);
			System.out.println("Client supprimé.");
			addOperation(newOperationId(), new Operations(users.size(), new Date(),"remove", admin.getIdUser()));
		} else {
			System.out.println("Client inexistant.");
		}

	}
	@Override
	public Users getUserById(int idUser) {

		return users.get(idUser);
	}
	@Override
	public void addAccount(Admin admin ,Accounts account,Map<Integer, Accounts> accounts,Map<Integer, Operations> operations) {
	}
	@Override
	public void removeAccount(Admin admin , int newAccountId) {
		if (accounts.containsKey(newAccountId)) {
			System.out.println("Compte supprimé.");
			addOperation(newOperationId(), new Operations(newAccountId ,admin.getIdUser() ,new Date(),"removeAccount" ));
			accounts.remove(newAccountId);
		} else {
			System.out.println("Compte inexistant.");
		}


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
	public void getAllUserOperation(int idUser) {

		for(Operations op : operations.values())
			if(op.getIdUser() == idUser && (op.getIdAdmin()== 0 )) System.out.println(op);
	
	}
	@Override
	public void getAllUserAccount() {


	} 
	@Override
	public void getAllUser() {
		System.out.println("Liste des utilisateurs :");
		users.forEach((key,value)->{	
			System.out.println("CustomerKey : "+key+" ---> "+value);

		});

	}
	@Override
	public void getAllAccount() {
		System.out.println("Liste des comptes :");
		accounts.forEach((key,value)->{	
			System.out.println("AccountKey : "+key+" ---> "+value);

		});

	}
	@Override
	public void getAllOperations() {
		System.out.println("Liste des operations :");
		operations.forEach((key,value)->{	
			System.out.println("AOperationKey : "+key+" ---> "+value);

		});

	}

	@Override
	public boolean deposit(int idAccount, int idUser, double amount) {
		if(amount > 0) {			
			getAccountById(idAccount).setAmount(getAccountById(idAccount).getAmount() + amount);
			addOperation(newOperationId(), new Operations(idAccount, amount, idUser, new Date(), "deposit"));
			return true;	
		} else {
			return false;
		}
	}

	@Override
	public boolean showBalance(int idUser, int idAccount) { 
		if(accounts.containsKey(idAccount) &&  getAccountById(idAccount).getIdUser() == idUser) {
			System.out.println("Numéro de compte " + idAccount + " : montant -> " + getAccountById(idAccount).getAmount());
			addOperation(newOperationId(), new Operations(idAccount, idUser, new Date(), "showBalance"));
			return true;
		} else {
			System.out.println("Aucun compte associé.");
			return false;
		}
	}

	@Override
	public boolean withdraw(int idAccount, int idUser, double amount) { //attention au découvert autorisé

		if(accounts.containsKey(idAccount) && amount > 0) {			
			if(amount <= getAccountById(idAccount).getAmount()) {
				getAccountById(idAccount).setAmount(getAccountById(idAccount).getAmount() - amount);
				addOperation(newOperationId(), new Operations(idAccount, amount, idUser, new Date(), "withdraw"));
				return true;
			}
		} 
		return false;
	}

	@Override
	public boolean transfert(int idUser, int idAccount1, int idAccount2, double amount) { //attention au découvert autorisé

		if(accounts.containsKey(idAccount1) && amount > 0) {
			if(amount <= getAccountById(idAccount1).getAmount()) {
				getAccountById(idAccount1).setAmount(getAccountById(idAccount1).getAmount() - amount);
				getAccountById(idAccount2).setAmount(getAccountById(idAccount2).getAmount() + amount);
				addOperation(newOperationId(), new Operations(idAccount1, idAccount2, idUser, amount, new Date(), "transfert"));
				return true;
			}
		}
		return false;
	}

	public Map<Integer, Accounts> getAccounts() {
		return accounts;
	}

	public Map<Integer, Users> getUsers() {
		return users;
	}
	public Map<Integer, Operations> getOperation() {
		return operations;
	}

	

	








}
