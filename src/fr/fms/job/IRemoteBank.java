/**
 * 
 */
package fr.fms.job;

import fr.fms.entities.Accounts;
import fr.fms.entities.Operations;
import fr.fms.entities.Users;

/**
 * @author Stagiaires09
 *
 */
public interface IRemoteBank<T,U,V> {
	public void addUser(int idUser, Users<U> user);
	public void removeUser(int idUser);
	public  Users<U> getUserById(int idUser);
	public void addAccount(int idAccount, Accounts<T> account);
	public void removeAccount(int idAccount);
	public  Accounts<T> getAccountById(int idAccount);	
	public  void addOperation(int idOperation, Operations <V> operation);
	public Operations<V> getOperationById(int idOperation);
	public void getAllUserOperation();
	public void getAllUserAccount();
		
}
