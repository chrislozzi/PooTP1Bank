/**
 * 
 */
package fr.fms.job;

import fr.fms.entities.Accounts;
import fr.fms.entities.Admin;
import fr.fms.entities.Operations;
import fr.fms.entities.Users;

/**
 * @author Stagiaires09
 *
 */
public interface IRemoteBank {
	public void addUser(Admin admin, Users user);
	public void removeUser(Admin admin , int newUserId);
	public  Users getUserById(int idUser);
	public void addAccount(Admin admin,Accounts account);
	public void removeAccount(Admin admin  ,int newAccountId);
	public  Accounts getAccountById(int idAccount);	
	public  void addOperation(int idOperation, Operations  operation);
	public Operations getOperationById(int idOperation);
	public boolean showBalance(int idUser, int idAccount);
	public boolean withdraw(int idAccount, int idUser, double amount);
	public boolean transfert(int idUser,int idAccount1, int idAccount2, double amount);
	public boolean deposit(int idAccount, int idUser, double amount);
	public void getAllUserOperation(int idUser);
	public void getAllUserAccount(int idUser);
	public void getAllUser();
	public void getAllAccount();
}
