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
	private Map<Integer, CurrentAccount> currentAccounts;
	private Map<Integer, SavingsAccount> savingsAccounts;
	private Map<Integer, Users> users;
	private Map<Integer, Operations> operations;

	public RemoteBankImpl() {
		currentAccounts =new HashMap<>();
		savingsAccounts =new HashMap<>();
		users =new HashMap<>();
		operations =new HashMap<>();
	}

	public int newOperationId() {
		return operations.size() + 1;

	}
	@Override
	public void addOperation(int idOperation, Operations operation) {

		operations.put(idOperation,operation);
	}

	public  Admin createCustomer(String name, String firstName, String address, String mail, int phone, String pseudo,int password,Map<Integer, Operations> operations) {
		Admin sarah=new Admin(name,firstName, address,  mail,  phone,  pseudo, password);
		return sarah;
	}
		public void addUser(Admin admin, Users user,Map<Integer, Users> users,Map<Integer, Operations> operations) {

		if(users.containsKey(user.getIdUser())) System.out.println("L'utilisateur : "
				+ user.toString() + "est déjà enregistré dans la base"); else {
					users.put(user.getIdUser(), user); addOperation(newOperationId(), new
							Operations( new Date(),"addUser", admin.getIdUser())); }

	}

	

	@Override
	public CurrentAccount createCurrentAccounts(int idUser, String name, Date date, double amount, int overdraft) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SavingsAccount createSavingAccounts(int idUser, String name, Date date, double amount, int interestRate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getUserById(int idUser) {

		return null;
	}
	@Override
	public void addCurrentAccounts(Admin admin ,CurrentAccount account,Map<Integer, CurrentAccount>currentAccounts,Map<Integer, Operations> operations) {
	}
	@Override
	public void addSavingAccounts(Admin admin, SavingsAccount account, Map<Integer, SavingsAccount> savingsAccounts,
			Map<Integer, Operations> operations) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Operations getOperationById(int idOperation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAllUserAccount() {

	}
	@Override
	public void removeUser(Admin admin, int newUserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAccounts(Admin admin, int newAccountId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CurrentAccount getCurrentAccountById(int idAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SavingsAccount getSavingsAccountById(int idAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	public void getAllUsers(Map<Integer, Users> users) {

	}

	public void getAllCurrentAccounts(Map<Integer, CurrentAccount> currentAccounts) {
		// TODO Auto-generated method stub
		
	}

	public void getAllSavingsAccounts(Map<Integer, SavingsAccount> savingsAccounts) {
		// TODO Auto-generated method stub
		
	}

	public void getAllOperations(Map<Integer, Operations> operations) {

	}

	public void depositCurrentAccounts(int idUser, int idAccount, double amount,Map<Integer, CurrentAccount>currentAccounts,Map<Integer, Operations> operations) {

	}

	public void depositSavingsAccounts(int idUser, int idAccount, double amount,
			Map<Integer, SavingsAccount> savingsAccounts, Map<Integer, Operations> operations) {
		
	}

	public void showBalanceCurrentAccounts(int idUser, int idAccount, Map<Integer, CurrentAccount> currentAccounts,
			Map<Integer, Operations> operations) {
		
	}
	public void showBalanceSavingsAccounts(int idUser, int idAccount,Map<Integer, SavingsAccount> savingsAccounts,Map<Integer, Operations> operations) { 

	}

	public void withdraw(int idUser, int idAccount, double amount,Map<Integer, SavingsAccount> savingsAccounts,Map<Integer, Operations> operations) { //attention au découvert autorisé

	}

	
	public void transfert(int idUser, int idAccount1, int idAccount2, double amount,Map<Integer, CurrentAccount>currentAccounts,
			Map<Integer, SavingsAccount> savingsAccounts,Map<Integer, Operations> operations) { //attention au découvert autorisé

		
	}
	
	/// getteurs des maps
	/**
	 * 
	 * @return
	 */
	public Map<Integer, CurrentAccount> getCurrentAccounts() {
		return currentAccounts;
	}
	/**
	 * 
	 * @return
	 */
	public Map<Integer, SavingsAccount> getSavingsAccounts() {
		return savingsAccounts;
	}
	/**
	 * 
	 * @return
	 */
	public Map<Integer, Users> getUsers() {
		return users;
	}
	/**
	 * 
	 * @return
	 */
	public Map<Integer, Operations> getOperations() {
		return operations;
	}

}
