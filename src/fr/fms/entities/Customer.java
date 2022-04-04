package fr.fms.entities;

public class Customer extends Users{

	public Customer(String name, String firstName, String address, String mail, int phone, String pseudo,
			int password) {
		super(name, firstName, address, mail, phone, pseudo, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return  "Customer" + super.toString() ;
	}

}
