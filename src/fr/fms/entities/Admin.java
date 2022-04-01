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
	public int newAccountId(Map<Integer, Accounts> accounts) {
		return accounts.size() + 1;

	}
	public  Customer createCustomer(String name, String firstName, String address, String mail, int phone, String pseudo,int password,Map<Integer, Operations> operations) {
		Customer customer=new Customer(name,firstName, address,  mail,  phone,  pseudo, password);
		
		return customer;
	}
	
	
	public CurrentAccount createCurrentAccount(int idUser, String name, Date date, double amount, int overdraft) {
		CurrentAccount ca=new CurrentAccount( idUser,  name,  date,  amount, overdraft);
		return ca;
	}
	
	public SavingsAccount createSavingAccount(int idUser, String name, Date date, double amount, int interestRate) {
		SavingsAccount sa=new SavingsAccount( idUser,  name, date,  amount, interestRate);
		return sa;
	}
	public void addUser(Admin admin, Users user,Map<Integer, Users> users,Map<Integer, Operations> operations) {

		if(users.containsKey(user.getIdUser()))	
			System.out.println("L'utilisateur : " + user.toString() + "est déjà enregistré dans la base");
		else {
			users.put(user.getIdUser(), user);
			operations.put(newOperationId(operations), new Operations(users.size(), new Date(),"addUser", admin.getIdUser()));
		}	

	}
	
	public void addAccount(Admin admin ,Accounts account,Map<Integer, Accounts> accounts,Map<Integer, Operations> operations) {

		if(accounts.containsValue(account))	
			System.out.println("Le compte : " + account.toString() + "est déjà enregistré dans la base");
		else {
			operations.put(newOperationId(operations), new Operations(account.getIdUser(),new Date(),"addAccount", admin.getIdUser()));
			accounts.put(newAccountId(accounts), account);
		}

	}
	@Override
	public String toString() {
		return  "Admin" + super.toString() ;
	}

}
