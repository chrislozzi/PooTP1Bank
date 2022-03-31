/**
 * 
 */
package fr.fms.job;

import java.util.Map;

import fr.fms.entities.Accounts;
import fr.fms.entities.Operations;
import fr.fms.entities.Users;

/**
 * @author Stagiaires09
 *
 */
public class RemoteBankImpl <T,U,V> implements IRemoteBank<T,U,V>{
	private Map<Integer, Accounts<T>> accounts;
	private Map<Integer, Users<U>> users;
	private Map<Integer, Operations <V>> operations;
	
	public RemoteBankImpl() {
		super();
	}
	@Override
	public void addUser(int idUser, Users<U> user) {
	//	if(!users.isEmpty() && !users.containsKey());		
	//		users.put(users.size()+1, user);
		
	}
	@Override
	public void removeUser(int idUser) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Users<U> getUserById(int idUser) {
		// TODO Auto-generated method stub
		return users.get(idUser);
	}
	@Override
	public void addAccount(int idAccount, Accounts<T> account) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeAccount(int idAccount) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Accounts<T> getAccountById(int idAccount) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addOperation(int idOperation, Operations<V> operation) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Operations<V> getOperationById(int idOperation) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void getAllUserOperation() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getAllUserAccount() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showBalance(int idAccount) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean withdraw(int idAccount, int idUser, double amount) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean transfert(int idUser, int idAccount1, int idAccount2, double amount) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deposit(int idAccount, int idUser, double amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
