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
		
		//Création d'un compte admin
		Admin sarah_admin =new Admin("Pelle","Sarah","221B av du Bon Pied, bonneuil sur marne","saralune@yahoo.fr",666548,"sarahlune",3729425);
		bankRoot.addUser(sarah_admin, sarah_admin);
		
		//Créations, puis ajouts (par un admin) d'utilisateurs -> users<idUser customer> 
		//et enregistrement des opérations -> opérations<idOpération,opération>
		Customer jcduce=new Customer("Duce","Jean Charles","1 av des Champs Elysee, Berque","plantedbaton73@hotmail.com",555547,"lebronzee",10423400);
		bankRoot.addUser(sarah_admin, jcduce);
		Customer christoof  = new Customer("Ouille","Christoof","45 rte des barbottins, Jarnac","cricri73@gmail.com",555547,"krispol",452875);		
		bankRoot.addUser(sarah_admin, christoof);	
		Customer gogohugo=new Customer("Gogo","Hugo","5 rue de la Pie qui boie, Saint-Malo","badadi@gfree.fr",5545447,"petitjean",0745624);
		bankRoot.addUser(sarah_admin,gogohugo);
			
		
		//Créations, puis ajouts (par un admin) de comptes -> acounts<idAccount,currentAccount ou savingsAccount> 
		//et enregistrement des opérations -> opérations<idOpération,opération>
		CurrentAccount jcduceCa1=new CurrentAccount(jcduce.getIdUser(),"Current account",new Date(),1255.00,400);
		bankRoot.addAccount(sarah_admin,jcduceCa1);
		CurrentAccount christoofCa2=new CurrentAccount(christoof.getIdUser(),"Current account",new Date(),2100.00,400);
		bankRoot.addAccount(sarah_admin, christoofCa2);		
		CurrentAccount gogohugoCa2=new CurrentAccount(gogohugo.getIdUser(),"Current account",new Date(),1000.00,1000);
		bankRoot.addAccount(sarah_admin, gogohugoCa2);
		SavingsAccount gogohugoSa2=new SavingsAccount(gogohugo.getIdUser(),"Saving account",new Date(),100.00,20);		
		bankRoot.addAccount(sarah_admin, gogohugoSa2);	
				
		// liste des utilisateurs
		bankRoot.getAllUser();
		System.out.println("--------------------");
		
		// liste des comptes
		bankRoot.getAllAccount();
		System.out.println("--------------------");
		
		//Affiche le solde
		bankRoot.showBalance(jcduce.getIdUser(),jcduceCa1.getIdAccount());	
		bankRoot.showBalance(christoof.getIdUser(),christoofCa2.getIdAccount());			
		bankRoot.showBalance(gogohugo.getIdUser(),gogohugoCa2.getIdAccount());	
		bankRoot.showBalance(gogohugo.getIdUser(),gogohugoSa2.getIdAccount());
		System.out.println("--------------------");			
		
		//Retrait
		System.out.println("Retrait 1200€");
		bankRoot.showBalance(christoof.getIdUser(),christoofCa2.getIdAccount());	
		bankRoot.withdraw(christoofCa2.getIdAccount(), christoof.getIdUser(), 1200.0);
		bankRoot.showBalance(christoof.getIdUser(),christoofCa2.getIdAccount());
		System.out.println("--------------------");
		
		//depot
		System.out.println("Dépot 2000€");
		bankRoot.showBalance(jcduce.getIdUser(),jcduceCa1.getIdAccount());
		bankRoot.deposit(jcduceCa1.getIdAccount(),jcduce.getIdUser(),2000.00);
		bankRoot.showBalance(jcduce.getIdUser(),jcduceCa1.getIdAccount());
		System.out.println("--------------------");
		
		//transfert
		System.out.println("Transfert de 500");			
		bankRoot.showBalance(gogohugo.getIdUser(),gogohugoCa2.getIdAccount());	
		bankRoot.showBalance(gogohugo.getIdUser(),gogohugoSa2.getIdAccount());
		bankRoot.transfert(gogohugo.getIdUser(),gogohugoCa2.getIdAccount(),gogohugoSa2.getIdAccount(), 500.00);
		bankRoot.showBalance(gogohugo.getIdUser(),gogohugoCa2.getIdAccount());	
		bankRoot.showBalance(gogohugo.getIdUser(),gogohugoSa2.getIdAccount());
		System.out.println("--------------------");
		
		//retrait dépassant le plafond autorisé
		System.out.println("Retrait, dépassant le plafond autorisé 1200€");
		bankRoot.showBalance(gogohugo.getIdUser(),gogohugoCa2.getIdAccount());
		bankRoot.withdraw(gogohugoCa2.getIdAccount(), gogohugo.getIdUser(), 1200.0);
		bankRoot.showBalance(gogohugo.getIdUser(),gogohugoCa2.getIdAccount());	
		System.out.println("--------------------");
		
		//transfert dépassant le plafond autorisé 
		System.out.println("Transfert dépassant le plafond autorisé de 2000");
		bankRoot.showBalance(gogohugo.getIdUser(),gogohugoSa2.getIdAccount());	
		bankRoot.showBalance(gogohugo.getIdUser(),gogohugoCa2.getIdAccount());
		bankRoot.transfert(gogohugo.getIdUser(),gogohugoCa2.getIdAccount(),gogohugoSa2.getIdAccount(), 2000.00);
		bankRoot.showBalance(gogohugo.getIdUser(),gogohugoSa2.getIdAccount());	
		bankRoot.showBalance(gogohugo.getIdUser(),gogohugoCa2.getIdAccount());	
		System.out.println("--------------------");
		
		//affiche les opérations d'un utilisateur	
		bankRoot.getAllUserOperation(gogohugo.getIdUser());
		System.out.println("--------------------");	
		bankRoot.getAllUserOperation(jcduce.getIdUser());
		System.out.println("--------------------");
		bankRoot.getAllUserOperation(christoof.getIdUser());
		System.out.println("--------------------");
		
		
		
		
		// suppression d'un client en fonction de la clé
		//bankRoot.removeUser(1);
		//bankRoot.getAllUser();


		// suppression d'un compte en fonction de la clé
		//bankRoot.removeAccount(1);
		//bankRoot.getAllAccount();


	}

}
