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
		Admin admin =bankRoot.createCustomer("Pelle","Sarah","221B av du Pied","saralune@yahoo.fr",666548,"sarahlune",372425,bankRoot.getOperations());	
		bankRoot.addUser(admin, admin, bankRoot.getUsers(),bankRoot.getOperations());


		// l'admin creé un client et l'ajoute à la base.
		Customer gogohugo=admin.createCustomer("Gogo","Hugo","5 rue de la pente","badadi@gfree.fr",555547,"petitjean",0745624,bankRoot.getOperations());
		admin.addUser(admin, gogohugo,bankRoot.getUsers(),bankRoot.getOperations());
		Customer christoof  = admin.createCustomer("Ouille","Christoof","45 av du Lampion","cricri73@gmail.com",555547,"krispol",452875,bankRoot.getOperations());
		admin.addUser(admin, christoof,bankRoot.getUsers(),bankRoot.getOperations());
		Customer jcduce=admin.createCustomer("Duce","Jean Claude","1 av des Champs Elysee","plantedbaton73@hotmail.com",555547,"bronzee",10423400,bankRoot.getOperations());
		admin.addUser(admin, jcduce,bankRoot.getUsers(),bankRoot.getOperations());


		// l'admin crée les comptes des client et les ajoute à la base.
		SavingsAccount sa1=admin.createSavingAccounts(gogohugo.getIdUser(), "Saving account",new Date(), 1456.35, 23);
		admin.addSavingsAccounts(admin, sa1, bankRoot.getSavingsAccounts(), bankRoot.getOperations());

		CurrentAccount ca1=admin.createCurrentAccounts(christoof.getIdUser(),"Current account",new Date(),12995.36,400);
		admin.addCurrentAccounts(admin, ca1, bankRoot.getCurrentAccounts(), bankRoot.getOperations());

		SavingsAccount sa2=admin.createSavingAccounts(christoof.getIdUser(),"Saving account",new Date(),12855.36,20);
		admin.addSavingsAccounts(admin, sa2, bankRoot.getSavingsAccounts(), bankRoot.getOperations());

		CurrentAccount ca2=admin.createCurrentAccounts(admin.getIdUser(),"Current account",new Date(),12995.36,400);
		admin.addCurrentAccounts(admin, ca2, bankRoot.getCurrentAccounts(), bankRoot.getOperations());

		SavingsAccount pplm2=admin.createSavingAccounts(admin.getIdUser(),"Saving account",new Date(),1000000.36,20);
		admin.addSavingsAccounts(admin, pplm2, bankRoot.getSavingsAccounts(), bankRoot.getOperations());

		System.out.println("--------------------");


		// opération d'un client ***********************


		// un client ajoute un montant
		christoof.depositCurrentAccounts(christoof.getIdUser(),1, 1263.60,bankRoot.getCurrentAccounts(), bankRoot.getOperations());
		System.out.println("--------------------");

		// le client fait un retrait sur son compte courant
		christoof.withdraw(christoof.getIdUser(),1, 1426 , bankRoot.getCurrentAccounts(), bankRoot.getOperations());
		System.out.println("--------------------");

		// le client fait un transfert de son compte courant vers son compte épargne
		christoof.transfert(christoof.getIdUser(), 1, 2, 832.960, bankRoot.getCurrentAccounts(), bankRoot.getSavingsAccounts(), 		bankRoot.getOperations());
		System.out.println("--------------------");

		//le client ajoute un montant sur son compte épargne
		christoof.depositSavingsAccounts(christoof.getIdUser(), 2, 478.3, bankRoot.getSavingsAccounts(), bankRoot.getOperations());
		System.out.println("--------------------");

		// l'admin affiche son compte courant et les opérations qui en découlent
		christoof.showBalanceCurrentAccounts(christoof.getIdUser(),1,bankRoot.getCurrentAccounts(), bankRoot.getOperations());
		System.out.println("--------------------");

		// l'admin affiche son compte épargne et les opérations qui en découlent
		christoof.showBalanceSavingsAccounts(christoof.getIdUser(), 2, bankRoot.getSavingsAccounts(), bankRoot.getOperations());
		System.out.println("--------------------");



		// opération de l'admin ***********************

		// l'admin ajoute un montant 
		//admin.depositCurrentAccounts(admin.getIdUser(),2, 1263.60,bankRoot.getCurrentAccounts(), bankRoot.getOperations());
		System.out.println("--------------------");

		// l'admin fait un retrait sur son compte courant
		//admin.withdraw(admin.getIdUser(),2, 1426 , bankRoot.getCurrentAccounts(), bankRoot.getOperations());
		System.out.println("--------------------");

		// l'admin fait un transfert de son compte courant vers son compte épargne
		//admin.transfert(admin.getIdUser(), 2, 3, 832.960, bankRoot.getCurrentAccounts(), bankRoot.getSavingsAccounts(), bankRoot.getOperations());
		System.out.println("--------------------");

		//l'admin ajoute un montant sur son compte épargne
		//admin.depositSavingsAccounts(admin.getIdUser(), 3, 478.3, bankRoot.getSavingsAccounts(), bankRoot.getOperations());
		System.out.println("--------------------");

		// l'admin affiche son compte courant et les opérations qui en découlent
		//admin.showBalanceCurrentAccounts(admin.getIdUser(),2,bankRoot.getCurrentAccounts(), bankRoot.getOperations());
		System.out.println("--------------------");

		// l'admin affiche son compte épargne et les opérations qui en découlent
		//admin.showBalanceSavingsAccounts(admin.getIdUser(), 3, bankRoot.getSavingsAccounts(), bankRoot.getOperations());
		System.out.println("--------------------");




		//**************************ADMINISTRATION******************************///


		System.out.println("-----------------------------------------------------------------");
		System.out.println("-----------------------ADMINISTRATION----------------------------");
		System.out.println("-----------------------------------------------------------------");

		//l'admin liste les utilisateurs
		System.out.println("--------------------");
		//admin.getAllUsers(bankRoot.getUsers());


		//l'admin liste les comptes
		System.out.println("--------------------");
		//admin.getAllCurrentAccounts(bankRoot.getCurrentAccounts());
		//admin.getAllSavingsAccounts(bankRoot.getSavingsAccounts());


		//l'admin liste les opérations
		System.out.println("--------------------");
		//admin.getAllOperations(bankRoot.getOperations());
	}

}
