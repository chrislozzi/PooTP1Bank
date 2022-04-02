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

		
		// l'admin creé un client et l'ajoute à la base.
		Customer gogohugo=admin.createCustomer("Gogo","Hugo","5 rue de la pente","badadi@gfree.fr",555547,"petitjean",0745624,bankRoot.getOperation());
		admin.addUser(admin, gogohugo,bankRoot.getUsers(),bankRoot.getOperation());
		Customer christoof  = admin.createCustomer("Ouille","Christoof","45 av du Lampion","cricri73@gmail.com",555547,"krispol",452875,bankRoot.getOperation());
		admin.addUser(admin, christoof,bankRoot.getUsers(),bankRoot.getOperation());
		Customer jcduce=admin.createCustomer("Duce","Jean Claude","1 av des Champs Elysee","plantedbaton73@hotmail.com",555547,"bronzee",10423400,bankRoot.getOperation());
		admin.addUser(admin, jcduce,bankRoot.getUsers(),bankRoot.getOperation());

		
		// l'admin crée les comptes des client et les ajoute à la base.
		SavingsAccount sa1=admin.createSavingAccount(gogohugo.getIdUser(), "Saving account",new Date(), 1456.35, 23);
		admin.addSavingsAccount(admin, sa1, bankRoot.getSavingsAccounts(), bankRoot.getOperation());
		
		CurrentAccount ca1=admin.createCurrentAccount(christoof.getIdUser(),"Current account",new Date(),12995.36,400);
		admin.addCurrentAccount(admin, ca1, bankRoot.getCurrentAccounts(), bankRoot.getOperation());
		
		SavingsAccount sa2=admin.createSavingAccount(jcduce.getIdUser(),"Saving account",new Date(),12855.36,20);
		admin.addSavingsAccount(admin, sa2, bankRoot.getSavingsAccounts(), bankRoot.getOperation());
		
		SavingsAccount pplm=admin.createSavingAccount(gogohugo.getIdUser(),"Saving account",new Date(),1000000.36,20);
		admin.addSavingsAccount(admin, pplm, bankRoot.getSavingsAccounts(), bankRoot.getOperation());
		
		CurrentAccount ca2=admin.createCurrentAccount(admin.getIdUser(),"Current account",new Date(),12995.36,400);
		admin.addCurrentAccount(admin, ca2, bankRoot.getCurrentAccounts(), bankRoot.getOperation());
		
		SavingsAccount pplm2=admin.createSavingAccount(admin.getIdUser(),"Saving account",new Date(),1000000.36,20);
		admin.addSavingsAccount(admin, pplm2, bankRoot.getSavingsAccounts(), bankRoot.getOperation());
		
		// liste des utilisateurs
		System.out.println("--------------------");
		//admin.getAllUser(bankRoot.getUsers());

		
		// liste des comptes
		System.out.println("--------------------");
		admin.getAllCurrentAccounts(bankRoot.getCurrentAccounts());
		admin.getAllSavingsAccounts(bankRoot.getSavingsAccounts());
		
		
		//liste des opérations
		System.out.println("--------------------");
		//admin.getAllOperations(bankRoot.getOperation());
		
		
		System.out.println("--------------------");
		
		// l'admin ajoute un montant et consulte son compte courant
		admin.deposit(admin.getIdUser(),2, 1263.60,bankRoot.getCurrentAccounts(), bankRoot.getOperation());
		System.out.println("--------------------");
		
		// l'admin fait un retrait sur son compte courant
		admin.withdraw(admin.getIdUser(),2, 1426 , bankRoot.getCurrentAccounts(), bankRoot.getOperation());
		System.out.println("--------------------");
		
		// l'admin fait un transfert de son compte courant vers son compte épargne
		admin.transfert(admin.getIdUser(), 2, 4, 832.960, bankRoot.getCurrentAccounts(), bankRoot.getSavingsAccounts(), bankRoot.getOperation());
		System.out.println("--------------------");
		
		// l'admin affiche son compte courant et les opérations qui en découlent
		admin.showBalance(admin.getIdUser(),2,bankRoot.getCurrentAccounts(), bankRoot.getOperation());
		
		
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
