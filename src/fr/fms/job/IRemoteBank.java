/**
 * 
 */
package fr.fms.job;

import java.util.ArrayList;

import fr.fms.entities.Accounts;
import fr.fms.entities.Operations;
import fr.fms.entities.Users;


/**
 * @author Stagiaires09
 *
 */
public interface IRemoteBank {
																				// adduser en option... array dans impl pour lister les users...
	public void addAccount(Accounts account);									//ajoute un compte associé à un client à notre banque
	public void showBalance(int idUser, int idAccount);
	public boolean withdraw(long idAccount, double amount);						//faire un retrait sur un compte
	public void transfert(long idAccount1, long idAccount2, double amount);		//faire un virement d'un compte source vers destination
	public void deposit(long idAccount, double amount);							//faire un versement sur un compte 
	public Accounts consultAccount(long accountId);								//renvoi le compte correspondant à l'id 
	public ArrayList<Operations> listOperations(long accountId); 

							
	
					
				
		
	
}
