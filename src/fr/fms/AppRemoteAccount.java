package fr.fms;

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
		
		Admin sarah =new Admin(1,"Pelle","Sarah","221B av du Pied","saralune@yahoo.fr",666548,"sarahlune",372425,1);
		Customer christoof=new Customer(2,"Ouille","Christoof","45 av du Lampion","cricri73@gmail.com",555547,"krispol",452875,0);
		CurrentAccount CA1=new CurrentAccount(11,2,"Current account",new Date(),125.36,true,400);
		SavingsAccount SA1=new SavingsAccount(21,2,"Saving account",new Date(),125.36,false,20);
		
		System.out.println(sarah);
		System.out.println(christoof);
		System.out.println(CA1);
		System.out.println(SA1);

	}

}
