package fr.fms.entities;

import java.util.Date;
import java.util.Map;

public abstract class Users {

	private int idUser;
	private String name  ;
	private String firstName ;
	private  String address ;
	private  String mail; 
	private int phone; 
	private String pseudo; 
	private int password;  
	public static int idUserCount = 0;


	public Users( String name, String firstName, String address, String mail, int phone, String pseudo,int password) {	
		idUserCount ++;
		setIdUser(idUserCount);	
		setName(name);		
		setFirstName(firstName);		
		setAddress(address);		
		setMail(mail);		
		setPhone(phone);	
		setPseudo(pseudo);		
		setPassword(password);			
	}


	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}


	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public int getPassword() {
		return password;
	}


	public void setPassword(int password) {
		this.password = password;
	}

	// méthodes

	public int newOperationId(Map<Integer, Operations> operations) {
		return operations.size() + 1;

	}

	public CurrentAccount getCurrentAccountById(int idAccount) {
		// TODO Auto-generated method stub
		return null;
	}


	public SavingsAccount getSavingsAccountById(int idAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deposit(int idUser, int idAccount, double amount,Map<Integer, CurrentAccount>currentAccounts,Map<Integer, Operations> operations) {
		if(amount > 0) {			
			currentAccounts.get(idAccount).setAmount(currentAccounts.get(idAccount).getAmount() + amount);
			operations.put(newOperationId(operations), new Operations(idAccount, amount, idUser, new Date(), "deposit"));
			System.out.println("Le montant de "+amount+ " a bien été ajouté.");
		} else if(amount ==0 || amount<0){
			System.out.println("Veuillez entrer un montant minimal de 1.");
		}
	}

	public void withdraw(int idUser, int idAccount, double amount,Map<Integer, CurrentAccount>currentAccounts,Map<Integer, Operations> operations) { //attention au découvert autorisé

		if(currentAccounts.containsKey(idAccount) && amount > 0) {

			// test en fonction du découvert autorisé
			if(amount <= currentAccounts.get(idAccount).getAmount()+currentAccounts.get(idAccount).getOverdraft()) {
				currentAccounts.get(idAccount).setAmount(currentAccounts.get(idAccount).getAmount() - amount);
				System.out.println("Le montant de "+amount+ " a bien été retiré.");
				System.out.println("Votre nouveau solde est de :"+ currentAccounts.get(idAccount).getAmount());
				operations.put(newOperationId(operations), new Operations(idAccount, amount, idUser, new Date(), "withdraw"));

			}else{
				System.out.println("Votre solde ne permet pas l'opération, saisir un montant moindre.");
			}

		} else if(amount ==0 || amount<0){
			System.out.println("Veuillez entrer un montant minimal de 1.");
		}

	}
	public void showBalance(int idUser, int idAccount,Map<Integer, CurrentAccount>currentAccounts,Map<Integer, Operations> operations) { 
		if(currentAccounts.containsKey(idAccount) &&  currentAccounts.get(idAccount).getIdUser() == idUser) {
			System.out.println("Numéro de compte " + idAccount + " : montant -> " + currentAccounts.get(idAccount).getAmount());
			operations.put(newOperationId(operations), new Operations(idAccount, idUser, new Date(), "showBalance"));
			// liste des opératrions sur le compte
			for(Operations op : operations.values())
				if(op.getIdUser() == idUser && (op.getIdAdmin()== 0 )) System.out.println(op);
		} else {
			System.out.println("Aucun compte associé.");

		}
	}
	public void transfert(int idUser, int idAccount1, int idAccount2, double amount,Map<Integer, CurrentAccount>currentAccounts,
			Map<Integer, SavingsAccount> savingsAccounts,Map<Integer, Operations> operations) { //attention au découvert autorisé


		if(currentAccounts.containsKey(idAccount1) && savingsAccounts.containsKey(idAccount2) && amount > 0) { 
			if(amount <= currentAccounts.get(idAccount1).getAmount()) { 

				currentAccounts.get(idAccount1).setAmount(currentAccounts.get(idAccount1).getAmount() -amount);
						
				savingsAccounts.get(idAccount2).setAmount(savingsAccounts.get(idAccount2).getAmount() +amount); 
				System.out.println("Le montant de "+amount+ " a bien été viré.");
				System.out.println("Le nouveau solde de votre compte épargne est de :"+ savingsAccounts.get(idAccount2).getAmount());	
				operations.put(newOperationId(operations), new Operations(idAccount1, idAccount2, idUser, amount, new Date(), "transfert"));

			}
			else{
				System.out.println("Votre solde ne permet pas l'opération, saisir un montant moindre.");
			}
		}else if(amount ==0 || amount<0){
			System.out.println("Veuillez entrer un montant minimal de 1.");
		}


	}


	@Override
	public String toString() {
		return " [idUser= " + idUser + ", name= " + name + ", firstName= " + firstName + ", address= " + address
				+ ", mail= " + mail + ", phone= " + phone + ", pseudo= " + pseudo + "]";
	}






}
