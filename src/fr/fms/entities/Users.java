package fr.fms.entities;

public abstract class Users {

	private int idUser;
	private String name  ;
	private String firstName ;
	private  String address ;
	private  String mail; 
	private int phone; 
	private String pseudo; 
	private int password;  
	
	public Users(int idUser, String name, String firstName, String address, String mail, int phone, String pseudo,
			int password) {	
		setIdUser(idUser);	
		setName(name);		
		setFirstName(firstName);		
		setAddress(address);		
		setMail(mail);		
		setPhone(phone);	
		setPseudo(pseudo);		
		setPassword(password);			
	}





	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}





	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}





	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public int getPassword() {
		return password;
	}


	public void setPassword(int password) {
		this.password = password;
	}





	@Override
	public String toString() {
		return " [idUser= " + idUser + ", name= " + name + ", firstName= " + firstName + ", address= " + address
				+ ", mail= " + mail + ", phone= " + phone + ", pseudo= " + pseudo + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
