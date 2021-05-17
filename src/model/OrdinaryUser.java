package model;

public class OrdinaryUser extends User{
	
	public OrdinaryUser(String name, String address, String ccNum, String email) {
		super(name, address, ccNum, email);
	}
	
	public String toString() {
		
		return String.format("%s \t %s \t %s \t %s \t %s", this.getName(),this.getAddress(), this.getCreditCardNumber(), this.getEmail(), this.getUserType()); 
		
	}
}
