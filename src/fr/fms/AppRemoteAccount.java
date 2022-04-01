package fr.fms;

import java.rmi.server.Operation;
import java.util.Date;

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
		
		Users sarah =new Admin(1,"Pelle","Sarah","221B av du Pied","saralune@yahoo.fr",666548,"sarahlune",372425);
		Users christoof=new Customer(2,"Ouille","Christoof","45 av du Lampion","cricri73@gmail.com",555547,"krispol",452875);
		
		CurrentAccount CA1=new CurrentAccount(11,2,"Current account",new Date(),125.36,400);
		SavingsAccount SA1=new SavingsAccount(21,2,"Saving account",new Date(),125.36,20);
				
//		System.out.println(sarah);
//		System.out.println(christoof);
//		System.out.println(CA1);
//		System.out.println(SA1);
		
		bankRoot.addUser(2, christoof);
		bankRoot.addAccount(11, SA1);
		
		System.out.println("showbalance :"); 
		System.out.println(bankRoot.showBalance(2,11));	
		
		//manque le contenue de l'opération dans l'objet opération ...
		bankRoot.addOperation(bankRoot.newOperationId() , new Operations( 2, 11, new Date(), "showbalance"));
		System.out.println(bankRoot.getUserById(2));
		//deposit
		bankRoot.deposit(11, 2, 1263.60);
		//addoperation
		
		bankRoot.addOperation(bankRoot.newOperationId() , new Operations(bankRoot.newOperationId(), 11, 2, new Date(), "deposit"));
		bankRoot.addOperation(bankRoot.newOperationId() , new Operations(bankRoot.newOperationId(), 11, 2, new Date(), "deposit"));
		bankRoot.addUser(1, christoof);
		System.out.println(bankRoot.getOperationById(1).toString());
//		System.out.println(sarah);
//		System.out.println(christoof);
//		System.out.println(CA1);
//		System.out.println(SA1);
		
		System.out.println(bankRoot.showBalance(2,11));
		
		//System.out.println(bankRoot.addOperation(bankRoot.operations., null));

	}

}
