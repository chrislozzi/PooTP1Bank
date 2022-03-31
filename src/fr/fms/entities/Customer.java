package fr.fms.entities;

public class Customer<U> extends Users<U>{

	public Customer(int id_user, String name, String firstName, String address, String mail, int phone, String pseudo,
			int password, int is_admin) {
		super(id_user, name, firstName, address, mail, phone, pseudo, password, is_admin);
		// TODO Auto-generated constructor stub
	}

}
