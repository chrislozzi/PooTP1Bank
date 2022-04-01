/**
 * 
 */
package fr.fms.job;

import java.util.Date;

import java.util.Map;

import fr.fms.entities.Accounts;
import fr.fms.entities.Admin;
import fr.fms.entities.CurrentAccount;
import fr.fms.entities.Operations;
import fr.fms.entities.SavingsAccount;
import fr.fms.entities.Users;

/**
 * @author Stagiaires09
 *
 */
public interface IRemoteBank {
	public Users createCustomer(String name, String firstName, String address, String mail, int phone, String pseudo,int password,Map<Integer, Operations> operations);
	public void addUser(Admin admin,  Users user ,Map<Integer, Users> users,Map<Integer, Operations> operations);
	public void removeUser(Admin admin , int newUserId);
	public  Users getUserById(int idUser);
	public CurrentAccount createCurrentAccount(int idUser, String name, Date date, double amount, int overdraft);
	public SavingsAccount createSavingAccount(int idUser, String name, Date date, double amount,int interestRate);
	public void addAccount(Admin admin ,Accounts account,Map<Integer, Accounts> accounts,Map<Integer, Operations> operations);
	public void removeAccount(Admin admin  ,int newAccountId);
	public  Accounts getAccountById(int idAccount);	
	public  void addOperation(int idOperation, Operations  operation);
	public Operations getOperationById(int idOperation);
	public boolean showBalance(int idUser, int idAccount);
	public boolean withdraw(int idAccount, int idUser, double amount);
	public boolean transfert(int idUser,int idAccount1, int idAccount2, double amount);
	public boolean deposit(int idAccount, int idUser, double amount);
	public void getAllUserOperation(int idUser);
	public void getAllUserAccount();
	public void getAllUser();
	public void getAllAccount();
	public void getAllOperations();
	
}
