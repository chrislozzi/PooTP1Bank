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

		Admin sarah =new Admin("Pelle","Sarah","221B av du Pied","saralune@yahoo.fr",666548,"sarahlune",372425);		
		Customer jcduce=new Customer("Duce","Jean Claude","1 av des Champs Elysee","plantedbaton73@hotmail.com",555547,"bronzee",10423400);
		Customer gogohugo=new Customer("Gogo","Hugo","5 rue de la pente","badadi@gfree.fr",555547,"petitjean",0745624);
		Customer christoof  = new Customer("Ouille","Christoof","45 av du Lampion","cricri73@gmail.com",555547,"krispol",452875);
	
		bankRoot.addUser(sarah, sarah);

		bankRoot.addUser(sarah, christoof);
		bankRoot.addUser(sarah,gogohugo);
		bankRoot.addUser(sarah, jcduce);
		
		
		CurrentAccount ca1=new CurrentAccount(christoof.getIdUser(),"Current account",new Date(),12995.36,400);
		SavingsAccount sa1=new SavingsAccount(jcduce.getIdUser(),"Saving account",new Date(),12855.36,20);
		SavingsAccount pplm=new SavingsAccount(gogohugo.getIdUser(),"Saving account",new Date(),1000000.36,20);
		bankRoot.addAccount(sarah, ca1);
		bankRoot.addAccount(sarah,sa1);
		bankRoot.addAccount(sarah, pplm);
		
		System.out.println(ca1);

		System.out.println("--------------------");
		// liste des utilisateurs
		bankRoot.getAllUser();

		// liste des comptes
		bankRoot.getAllAccount();

		//bankRoot.deposit(, 2, 1263.60);
		bankRoot.showBalance(jcduce.getIdUser(),2);
		
		bankRoot.showBalance(christoof.getIdUser(),1);
		//
		bankRoot.getAllUserOperation(jcduce.getIdUser());
		
			
		

		
		


		// suppression d'un cleint en fonction de la clé
		//bankRoot.removeUser(1);
		//bankRoot.getAllUser();


		// suppression d'un compte en fonction de la clé
		//bankRoot.removeAccount(1);
		//bankRoot.getAllAccount();


	}

}
