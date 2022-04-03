package fr.fms.entities;

import java.util.Date;
import java.util.Map;

public class Admin extends Users {

	public Admin(String name, String firstName, String address, String mail, int phone, String pseudo,
			int password) {
		super(name, firstName, address, mail, phone, pseudo, password);
		// TODO Auto-generated constructor stub
	}
	
	//méthode
	public int newOperationId(Map<Integer, Operations> operations) {
		return operations.size() + 1;

	}
	public int newSavingsAccountId(Map<Integer, SavingsAccount> savingsAccounts) {
		return savingsAccounts.size() + 1;

	}
	public int newCurrentAccountId(Map<Integer, CurrentAccount>currentAccounts) {
		return currentAccounts.size() + 1;

	}
	public  Customer createCustomer(String name, String firstName, String address, String mail, int phone, String pseudo,int password,Map<Integer, Operations> operations) {
		Customer customer=new Customer(name,firstName, address,  mail,  phone,  pseudo, password);
		
		return customer;
	}
	
	
	public CurrentAccount createCurrentAccounts(int idUser, String name, Date date, double amount, int overdraft) {
		CurrentAccount ca=new CurrentAccount( idUser,  name,  date,  amount, overdraft);
		return ca;
	}
	
	public SavingsAccount createSavingAccounts(int idUser, String name, Date date, double amount, int interestRate) {
		SavingsAccount sa=new SavingsAccount( idUser,  name, date,  amount, interestRate);
		return sa;
	}
	public void addUser(Admin admin, Users user,Map<Integer, Users> users,Map<Integer, Operations> operations) {

		if(users.containsKey(user.getIdUser()))	
			System.out.println("L'utilisateur : " + user.toString() + "est déjà enregistré dans la base");
		else {
			users.put(user.getIdUser(), user);
			operations.put(newOperationId(operations), new Operations( new Date(),"addUser", admin.getIdUser()));
		}	

	}
	
	public void addCurrentAccounts(Admin admin ,CurrentAccount account,Map<Integer, CurrentAccount>currentAccounts,Map<Integer, Operations> operations) {

		if(currentAccounts.containsValue(account))	
			System.out.println("Le compte : " + account.toString() + "est déjà enregistré dans la base");
		else {
			operations.put(newOperationId(operations), new Operations(new Date(),"addAccount", admin.getIdUser()));
			currentAccounts.put(newCurrentAccountId(currentAccounts), account);
		}

	}
	public void addSavingsAccounts(Admin admin ,SavingsAccount account,Map<Integer, SavingsAccount> savingsAccounts,Map<Integer, Operations> operations) {

		if(savingsAccounts.containsValue(account))	
			System.out.println("Le compte : " + account.toString() + "est déjà enregistré dans la base");
		else {
			operations.put(newOperationId(operations), new Operations(new Date(),"addAccount", admin.getIdUser()));
			savingsAccounts.put(newSavingsAccountId(savingsAccounts), account);
		}

	}
	

	public void getAllUsers(Map<Integer, Users> users) {
		System.out.println("Liste des utilisateurs :");
		users.forEach((key,value)->{	
			System.out.println("CustomerKey : "+key+" ---> "+value);

		});

	}
	
	public void getAllCurrentAccounts(Map<Integer, CurrentAccount>currentAccounts) {
		System.out.println("Liste des comptes courant :");
		currentAccounts.forEach((key,value)->{	
			System.out.println("AccountKey : "+key+" ---> "+value);

		});

	}
	public void getAllSavingsAccounts(Map<Integer, SavingsAccount> savingsAccounts) {
		System.out.println("Liste des comptes épargnes :");
		savingsAccounts.forEach((key,value)->{	
			System.out.println("AccountKey : "+key+" ---> "+value);

		});

	}
	public void getAllOperations(Map<Integer, Operations> operations) {
		System.out.println("Liste des operations :");
		operations.forEach((key,value)->{	
			System.out.println("AOperationKey : "+key+" ---> "+value);

		});

	}
	
	@Override
	public String toString() {
		return  "Admin" + super.toString() ;
	}

}
