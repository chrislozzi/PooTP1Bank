package fr.fms.entities;

public abstract class Users<U> {

	private int id_user;
	private String name  ;
	private String firstName ;
	private  String address ;
	private  String mail; 
	private int phone; 
	private String pseudo; 
	private int password;  
	private int is_admin;
	
	
	public Users(int id_user, String name, String firstName, String address, String mail, int phone, String pseudo,
			int password, int is_admin) {
		super();
		this.id_user = id_user;
		this.name = name;
		this.firstName = firstName;
		this.address = address;
		this.mail = mail;
		this.phone = phone;
		this.pseudo = pseudo;
		this.password = password;
		this.is_admin = is_admin;
	}


	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
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


	public int getIs_admin() {
		return is_admin;
	}


	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}


	@Override
	public String toString() {
		return "Users [id_user= " + id_user + ", name= " + name + ", firstName= " + firstName + ", address= " + address
				+ ", mail= " + mail + ", phone= " + phone + ", pseudo= " + pseudo + ", password= " + password
				+ ", is_admin= " + is_admin + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
