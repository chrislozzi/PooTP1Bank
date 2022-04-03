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
	public CurrentAccount createCurrentAccounts(int idUser, String name, Date date, double amount, int overdraft);
	public SavingsAccount createSavingAccounts(int idUser, String name, Date date, double amount,int interestRate);
	public void addCurrentAccounts(Admin admin ,CurrentAccount account,Map<Integer, CurrentAccount>currentAccounts,Map<Integer, Operations> operations);
	public void addSavingAccounts(Admin admin ,SavingsAccount account,Map<Integer, SavingsAccount> savingsAccounts,Map<Integer, Operations> operations);
	public void removeAccounts(Admin admin  ,int newAccountId);
	public  CurrentAccount getCurrentAccountById(int idAccount);
	public  SavingsAccount getSavingsAccountById(int idAccount);	
	public  void addOperation(int idOperation, Operations  operation);
	public Operations getOperationById(int idOperation);
	public void showBalanceCurrentAccounts(int idUser, int idAccount,Map<Integer, CurrentAccount>currentAccounts,Map<Integer, Operations> operations);
	public void showBalanceSavingsAccounts(int idUser, int idAccount,Map<Integer, SavingsAccount> savingsAccounts,Map<Integer, Operations> operations);
	public void withdraw(int idUser, int idAccount, double amount,Map<Integer, SavingsAccount> savingsAccounts,Map<Integer, Operations> operations);
	public void transfert(int idUser, int idAccount1, int idAccount2, double amount,Map<Integer, CurrentAccount>currentAccounts,
			Map<Integer, SavingsAccount> savingsAccounts,Map<Integer, Operations> operations);
	public void depositCurrentAccounts(int idUser, int idAccount, double amount,Map<Integer, CurrentAccount>currentAccounts,Map<Integer, Operations> operations);
	public void depositSavingsAccounts(int idUser, int idAccount, double amount,Map<Integer, SavingsAccount> savingsAccounts,Map<Integer, Operations> operations);
	public void getAllUserAccount();
	public void getAllUsers(Map<Integer, Users> users);
	public void getAllCurrentAccounts(Map<Integer, CurrentAccount>currentAccounts);
	public void getAllSavingsAccounts(Map<Integer, SavingsAccount> savingsAccounts);
	public void getAllOperations(Map<Integer, Operations> operations);
	
}
