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

		Admin sarah =new Admin(1,"Pelle","Sarah","221B av du Pied","saralune@yahoo.fr",666548,"sarahlune",372425);
		Customer christoof=new Customer(2,"Ouille","Christoof","45 av du Lampion","cricri73@gmail.com",555547,"krispol",452875);

		CurrentAccount CA1=new CurrentAccount(2,"Current account",new Date(),125.36,400);
		SavingsAccount SA1=new SavingsAccount(2,"Saving account",new Date(),125.36,20);



		bankRoot.addUser(sarah, christoof);
		bankRoot.addAccount(sarah, SA1);
		bankRoot.deposit(11, 2, 1263.60);
		bankRoot.showBalance(2,11);
		bankRoot.addUser(sarah, christoof);
		bankRoot.showBalance(christoof.getIdUser(),12);
		for (int i = 0; i <bankRoot.getOperationSize() ; i++) {
			System.out.println(bankRoot.getOperationById(i));

		}
		System.out.println("--------------------");
		// liste des utilisateurs
		bankRoot.getAllUser();

		// liste des comptes
		bankRoot.getAllAccount();


		// suppression d'un cleint en fonction de la clé
		//bankRoot.removeUser(1);
		//bankRoot.getAllUser();


		// suppression d'un compte en fonction de la clé
		//bankRoot.removeAccount(1);
		//bankRoot.getAllAccount();










	}

}
