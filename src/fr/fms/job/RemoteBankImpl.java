/**
 * 
 */
package fr.fms.job;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.fms.entities.Accounts;
import fr.fms.entities.CurrentAccount;
import fr.fms.entities.Operations;
import fr.fms.entities.Users;

/**
 * @author Stagiaires09
 *
 */
public class RemoteBankImpl  implements IRemoteBank{	
	private int idAccount = 1;
	private int isOperation = 1;
	private int idUser = 1;
	private Map<Integer, Accounts> accounts;
	private Map<Integer, Users> users;

	public RemoteBankImpl() {
		accounts =new HashMap<>();
		users =new HashMap<>();
	}
	@Override
	public void addUser(int idUser, Users user) {

		if(users.containsKey(user.getIdUser()))	
			System.out.println("L'utilisateur : " + user.toString() + "est déjà enregistré dans la base");
		else {
			users.put(user.getIdUser(), user);
			addOperation(newOperationId(), new Operations(users.size(), new Date(),"addUser", admin.getIdUser()));
		}	

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
	public Accounts getAccountById(int idAccount) {
		// TODO Auto-generated method stub
		return accounts.get(idAccount);
	}

	@Override
	public void getAllUser() {
		System.out.println("Liste des utilisateurs :");
		users.forEach((key,value)->{	
			System.out.println("CustomerKey : "+key+" ---> "+value);

		});

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
	@Override
	public void showAccount(int idAccount) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addAccount(int userId, Accounts account) {
		// TODO Auto-generated method stub
		
	}
}
