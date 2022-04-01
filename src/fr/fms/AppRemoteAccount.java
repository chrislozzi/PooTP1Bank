package fr.fms;

import java.rmi.server.Operation;
import java.util.Date;
import java.util.Iterator;

import fr.fms.entities.Accounts;
import fr.fms.entities.Admin;
import fr.fms.entities.CurrentAccount;
import fr.fms.entities.Customer;
import fr.fms.entities.Operations;
import fr.fms.entities.SavingsAccount;
import fr.fms.entities.Users;
import fr.fms.job.RemoteBankImpl;

public class AppRemoteAccount {
		
	public static void main(String[] args) {
		
		RemoteBankImpl bankRoot = new RemoteBankImpl();
		
		Admin sarah =new Admin(1,"Pelle","Sarah","221B av du Pied","saralune@yahoo.fr",666548,"sarahlune",372425);
		Customer christoof=new Customer(2,"Ouille","Christoof","45 av du Lampion","cricri73@gmail.com",555547,"krispol",452875);
		
		CurrentAccount CA1=new CurrentAccount(2,"Current account",new Date(),125.36,400);
		SavingsAccount SA1=new SavingsAccount(2,"Saving account",new Date(),125.36,20);
				

		
		bankRoot.addUser(sarah, christoof);
		bankRoot.addAccount(sarah, SA1);
		System.out.println(christoof.getIdUser());
		bankRoot.deposit(1, christoof.getIdUser(), 1263.60);
		bankRoot.showBalance(christoof.getIdUser(),1);
		bankRoot.withdraw(1, christoof.getIdUser(), 100);
		bankRoot.showBalance(christoof.getIdUser(),1);
		//bankRoot.transfert(christoof.getIdUser(), 1, 1, 200);
		//bankRoot.showBalance(christoof.getIdUser(),1);

		//bankRoot.addUser(sarah, christoof);
		//bankRoot.showBalance(christoof.getIdUser(),12);
		for (int i = 1; i < bankRoot.getOperationSize() + 1 ; i++) {
			System.out.println(bankRoot.getOperationById(i));
		}
		
		
	
		
		
		
		
		
	

		
	

	}

}
