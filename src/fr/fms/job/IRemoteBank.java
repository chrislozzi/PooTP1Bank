/**
 * 
 */
package fr.fms.job;

import java.util.ArrayList;
import java.util.Date;

import fr.fms.entities.Accounts;
import fr.fms.entities.Operations;
import fr.fms.entities.Users;

/**
 * @author Stagiaires09
 *
 */
public interface IRemoteBank {
	public static ArrayList<Integer> operations = new ArrayList<Integer>();
	public void addUser(int userId, Users user);	
	public void addAccount(int userId,Accounts account);	
	public boolean withdraw(int idAccount, int idUser, double amount);
	public boolean transfert(int idUser,int idAccount1, int idAccount2, double amount);
	public void showAccount(int idAccount);
	

}
