/**
 * 
 */
package fr.fms.job;

import fr.fms.entities.Accounts;
import fr.fms.entities.Operations;
import fr.fms.entities.Users;

/**
 * @author Stagiaires09
 *
 */
public interface IRemoteBank<T,U,V> {
	public void addUser(int idUser, Users<U> user);

	public void removeUser(int idUser);
	public  Users<U> getUserById(int idUser);
	public void addAccount(int idAccount, Accounts<T> account);
	
	public void removeAccount(int idAccount);
	public  Accounts<T> getAccountById(int idAccount);	
	public  void addOperation(int idOperation, Operations <V> operation);
	public Operations<V> getOperationById(int idOperation);
	public void showBalance(int idAccount);
	public boolean withdraw(int idAccount, int idUser, double amount);
	public boolean transfert(int idUser,int idAccount1, int idAccount2, double amount);
	public boolean deposit(int idAccount, int idUser, double amount);
	public void getAllUserOperation();
	public void getAllUserAccount();
		
	//public boolean showBalance(int idAccount);
	public boolean showBalance(int idUser, int idAccount);
	public boolean withdraw(int idAccount, int idUser, double amount);
	public boolean transfert(int idUser, int idAccount1, int idAccount2, double amount);
	
	public boolean deposit(int idAccount, int idUser, double amount);

	 
}
