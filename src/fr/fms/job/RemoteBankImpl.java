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
	@Override
	public void addUser(Admin admin, Users user) {

		if(users.containsKey(user.getIdUser()))	
			System.out.println("L'utilisateur : " + user.toString() + "est déjà enregistré dans la base");
		else {
			users.put(user.getIdUser(), user);
			addOperation(newOperationId(), new Operations(users.size(), new Date(),"addUser", admin.getIdUser()));
		}	

	}
	@Override
	public void removeUser(Admin admin, int userId) {

		if (users.containsKey(userId)) {
			users.remove(userId);
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
	public void addAccount(Admin admin ,Accounts account) {

		if(accounts.containsValue(account))	
			System.out.println("Le compte : " + account.toString() + "est déjà enregistré dans la base");
		else {
			addOperation(newOperationId(), new Operations(account.getIdUser(),new Date(),"addAccount", admin.getIdUser()));
			accounts.put(account.getIdAccount(), account);
		}

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
		System.out.println("Liste des opérations de " + getUserById(idUser).getName() + " " + getUserById(idUser).getFirstName() + " :");
		for(Operations userOperation : operations.values())
			if(userOperation.getIdUser() == idUser && (userOperation.getIdAdmin()== 0 )) System.out.println(userOperation);

	}
	@Override
	public void getAllUserAccount(int idUser) {
		System.out.println("Liste des comptes de l'utilisateur" + getUserById(idUser) +" :");
		accounts.forEach((key,value)->{	
			System.out.println("AccountKey : "+key+" ---> "+value);		
		});
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
	public boolean withdraw(int idAccount, int idUser, double amount) { 
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
	public boolean transfert(int idUser, int idAccountSource, int idAccountTarget, double amount) {

		if(accounts.containsKey(idAccountSource) && amount > 0) {
			if(getAccountById(idAccountSource) instanceof CurrentAccount) {
				if( 0 <= (getAccountById(idAccountSource).getAmount() - amount + ((CurrentAccount) getAccountById(idAccountSource)).getOverdraft())) {
					getAccountById(idAccountSource).setAmount(getAccountById(idAccountSource).getAmount() - amount);
					getAccountById(idAccountTarget).setAmount(getAccountById(idAccountTarget).getAmount() + amount);
					
					addOperation(newOperationId(), new Operations(idAccountSource, idAccountTarget, idUser, amount, new Date(), "transfert"));
					return true;}

			}else if(0 <= (getAccountById(idAccountSource).getAmount() - amount)) {
				getAccountById(idAccountSource).setAmount(getAccountById(idAccountSource).getAmount() - amount);
				getAccountById(idAccountTarget).setAmount(getAccountById(idAccountTarget).getAmount() + amount);
				
				addOperation(newOperationId(), new Operations(idAccountSource, idAccountTarget, idUser, amount, new Date(), "transfert"));
				return true;
			}

		}
		return false;
	}
}
