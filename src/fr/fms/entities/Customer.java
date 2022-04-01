package fr.fms.entities;

public class Customer extends Users{

	public Customer(int idUser, String name, String firstName, String address, String mail, int phone, String pseudo,
			int password) {
		super(idUser, name, firstName, address, mail, phone, pseudo, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return  "Customer" + super.toString() ;
	}

}
