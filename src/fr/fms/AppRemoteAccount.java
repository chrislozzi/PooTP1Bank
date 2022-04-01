package fr.fms;

import java.util.Date;

import fr.fms.entities.Admin;
import fr.fms.entities.CurrentAccount;
import fr.fms.entities.Customer;
import fr.fms.entities.SavingsAccount;
import fr.fms.job.RemoteBankImpl;

public class AppRemoteAccount {

	public static void main(String[] args) {

		RemoteBankImpl bankRoot = new RemoteBankImpl();

		//admin creer par la matrice
		Admin admin =bankRoot.createCustomer("Pelle","Sarah","221B av du Pied","saralune@yahoo.fr",666548,"sarahlune",372425,bankRoot.getOperation());	
		bankRoot.addUser(admin, admin, bankRoot.getUsers(),bankRoot.getOperation());
		
		// l'admin creé les client
		Customer gogohugo=admin.createCustomer("Gogo","Hugo","5 rue de la pente","badadi@gfree.fr",555547,"petitjean",0745624,bankRoot.getOperation());
		Customer christoof  = admin.createCustomer("Ouille","Christoof","45 av du Lampion","cricri73@gmail.com",555547,"krispol",452875,bankRoot.getOperation());
		
		Customer jcduce=admin.createCustomer("Duce","Jean Claude","1 av des Champs Elysee","plantedbaton73@hotmail.com",555547,"bronzee",10423400,bankRoot.getOperation());

		admin.addUser(admin, jcduce,bankRoot.getUsers(),bankRoot.getOperation());
		admin.addUser(admin, gogohugo,bankRoot.getUsers(),bankRoot.getOperation());
		admin.addUser(admin, christoof,bankRoot.getUsers(),bankRoot.getOperation());
		System.out.println("--------------");
		
	    // puis les comptes
		SavingsAccount sa1=admin.createSavingAccount(gogohugo.getIdUser(), "Saving account",new Date(), 1456.35, 23);
		CurrentAccount ca1=admin.createCurrentAccount(christoof.getIdUser(),"Current account",new Date(),12995.36,400);
		SavingsAccount sa2=admin.createSavingAccount(jcduce.getIdUser(),"Saving account",new Date(),12855.36,20);	  
		SavingsAccount pplm=admin.createSavingAccount(gogohugo.getIdUser(),"Saving account",new Date(),1000000.36,20);
		
		admin.addAccount(admin, sa1, bankRoot.getAccounts(), bankRoot.getOperation());
		admin.addAccount(admin, ca1, bankRoot.getAccounts(), bankRoot.getOperation());
		admin.addAccount(admin, sa2, bankRoot.getAccounts(), bankRoot.getOperation());
		admin.addAccount(admin, pplm, bankRoot.getAccounts(), bankRoot.getOperation());
		
		// liste des utilisateurs
		System.out.println("--------------------");
		bankRoot.getAllUser();

		// liste des comptes
		System.out.println("--------------------");
		bankRoot.getAllAccount();

		//liste des opérations
		System.out.println("--------------------");
		bankRoot.getAllOperations();
		
		
		//bankRoot.deposit(, 2, 1263.60);
		//bankRoot.showBalance(jcduce.getIdUser(),2);

		//bankRoot.showBalance(christoof.getIdUser(),1);
		//
		//bankRoot.getAllUserOperation(jcduce.getIdUser());








		// suppression d'un cleint en fonction de la clé
		//bankRoot.removeUser(1);
		//bankRoot.getAllUser();


		// suppression d'un compte en fonction de la clé
		//bankRoot.removeAccount(1);
		//bankRoot.getAllAccount();


	}

}
